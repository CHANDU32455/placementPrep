import java.util.Random;
import java.util.Scanner;

// gen a rand 6 dig code..
class DefaultCodeGenerator {
    private final Random rand = new Random();
    public int generate() {
        return 100000 + rand.nextInt(900000);
    }
}
// top‑level, named interface.
// defines behavior that every auth mode should implement...
interface AuthMode {
    void sendCode(int code);
    String getName(); // gets name of auth mode... console/email/sms
}

// console mode module...
class ConsoleAuthMode implements AuthMode {
    @Override
    public void sendCode(int code) {
        System.out.println("\nConsole Mode: Your Current Code: " + code);
    }
    @Override
    public String getName() {
        return "Console";
    }
}

// email mode module..
class EmailAuthMode implements AuthMode {
    @Override
    public void sendCode(int code) {
        System.out.println("\nEmail sent with code: " + code);
    }
    @Override
    public String getName() {
        return "Email";
    }
}

// sms simulation module..
class SmsAuthMode implements AuthMode {
    @Override
    public void sendCode(int code) {
        System.out.println("\nSMS sent with code: " + code);
    }
    @Override
    public String getName() {
        return "SMS";
    }
}

// custom exception to handle case of useee entering wrong code...
class InvalidCodeException extends Exception {
    public InvalidCodeException(String message) {
        super(message);
    }
}

// main authenticator logic for authentication...
class Authenticator {
    private int current = 0, prev = 0;
    private final DefaultCodeGenerator generator = new DefaultCodeGenerator(); // gen a new code
    private final AuthMode defaultMode; // console mode
    private AuthMode currentMode; // can be console, email, sms...

    // constructr..
    //AuthMode is an interface, not a primitive data type like int or double.
    // But in Java, you can use an interface as a type, because you can pass any object that implements that interface.
    public Authenticator(AuthMode defaultMode) {
        this.defaultMode = defaultMode;
        this.currentMode = defaultMode;
    }

    // syncronized ensures security in threading..
    // i mean when multiple threads ineract with it,.. 
    public synchronized void generateAndSendCode() {
        prev = current;
        current = generator.generate();
        defaultMode.sendCode(current);
    }

    public synchronized int getCurrentCode() {
        return current;
    }

    public synchronized boolean validate(int code) {
        return code == current || code == prev;
    }

    public synchronized void sendCodeVia(AuthMode mode) {
        if (currentMode.getClass() == mode.getClass()) {
            System.out.println("\nYou're already in this mode (" + currentMode.getName() + "). Try switching to a different one.");
        } else {
            mode.sendCode(current);
            System.out.println("\nSwitched temporarily to " + mode.getName() + " mode. Now back to default: " + defaultMode.getName());
            currentMode = defaultMode; // return to default
        }
    }
}

// main method comes here.. 
public class PStuffAuthenticator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ConsoleAuthMode defaultMode = new ConsoleAuthMode();
            Authenticator auth = new Authenticator(defaultMode);
            
            System.out.println("   Available authentication modes:");
            System.out.println("1. Console");
            System.out.println("2. Email");
            System.out.println("3. SMS");
            System.out.println("\n Default mode: Console\n");
            // ananymous class -- thread to refresh code..
            Thread refresher = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    auth.generateAndSendCode();
                    try {
                        // for production use..
                        // ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                        // scheduler.scheduleAtFixedRate(() -> generateNewCode(), 0, 10, TimeUnit.SECONDS);
                        Thread.sleep(10000); // fine for current usecase..
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            refresher.start();
            
            // using while to make sure it keeps endless except interrupts loop...
            while (true) {
                System.out.print("\n Enter code or choose mode (1-Console, 2-Email, 3-SMS): ");
                String input = sc.nextLine().trim();
                
                if (input.matches("[1-3]")) {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1 -> auth.sendCodeVia(new ConsoleAuthMode());
                        case 2 -> auth.sendCodeVia(new EmailAuthMode());
                        case 3 -> auth.sendCodeVia(new SmsAuthMode());
                    }
                    continue;
                }
                
                if (input.matches("\\d{6}")) {
                    try {
                        int code = Integer.parseInt(input);
                        if (auth.validate(code)) {
                            System.out.println("\nWe got you bro...  Authentication Successful.");
                            refresher.interrupt(); // breaking point....
                            break;
                        } else {
                            throw new InvalidCodeException("Invalid code. Try again...");
                        }
                    } catch (InvalidCodeException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input. Enter 6-digit OTP or choose mode (1-3).");
                }
            }
        }
    }
}


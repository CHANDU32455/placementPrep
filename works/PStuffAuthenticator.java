import java.util.Random;
import java.util.Scanner;

class DefaultCodeGenerator {
    private final Random rand = new Random();
    public int generate() {
        return 100000 + rand.nextInt(900000);
    }
}

interface AuthMode {
    void sendCode(int code);
    String getName();
}

class ConsoleAuthMode implements AuthMode {
    public void sendCode(int code) {
        System.out.println("\nConsole Mode: Your Current Code: " + code);
    }
    public String getName() {
        return "Console";
    }
}

class EmailAuthMode implements AuthMode {
    public void sendCode(int code) {
        System.out.println("\nEmail sent with code: " + code);
    }
    public String getName() {
        return "Email";
    }
}

class SmsAuthMode implements AuthMode {
    public void sendCode(int code) {
        System.out.println("\nSMS sent with code: " + code);
    }
    public String getName() {
        return "SMS";
    }
}

class InvalidCodeException extends Exception {
    public InvalidCodeException(String message) {
        super(message);
    }
}

class Authenticator {
    private int current = 0, prev = 0;
    private final DefaultCodeGenerator generator = new DefaultCodeGenerator();
    private final AuthMode defaultMode;
    private AuthMode currentMode;

    public Authenticator(AuthMode defaultMode) {
        this.defaultMode = defaultMode;
        this.currentMode = defaultMode;
    }

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

public class PStuffAuthenticator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConsoleAuthMode defaultMode = new ConsoleAuthMode();
        Authenticator auth = new Authenticator(defaultMode);

        System.out.println("   Available authentication modes:");
        System.out.println("1. Console");
        System.out.println("2. Email");
        System.out.println("3. SMS");
        System.out.println("\n Default mode: Console\n");

        Thread refresher = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                auth.generateAndSendCode();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        refresher.start();

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
                        refresher.interrupt();
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

        sc.close();
    }
}

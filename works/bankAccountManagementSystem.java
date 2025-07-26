
class BankAccount {

    final private int accNo;
    private double bal;

    public int getAccountNumber() {
        return this.accNo;
    }

    public BankAccount(int accNo, double initialBalance) {
        this.accNo = accNo;
        this.bal = Math.max(0, initialBalance); // avoid negative balances
    }

    public double setBal(double balance) {
        this.bal = balance;
        return this.bal;
    }

    public double getBal() {
        return this.bal;
    }

    public double deposit(double amt) {
        if (amt > 0) {
            this.bal += amt;
        }
        return this.bal;
    }

    public double withdraw(double amt) {
        if (amt <= 0 || amt > bal) {
            return bal;
        }
        this.bal -= amt;
        return this.bal;
    }

    public String displayBalance() {
        return "Account No: " + accNo + ", Balance: ₹" + String.format("%.2f", bal);
    }

}

class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(int accNo, double initialBalance, double interestRate) {
        super(accNo, initialBalance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public double addInterest() {
        double balance = getBal();
        double interest = (balance * this.interestRate) / 100.0;
        balance += interest;
        setBal(balance);
        return balance;
    }
}

class CheckingAccount extends BankAccount {

    double overDraftLimit;

    public CheckingAccount(int accNo, double initialBalance, double overDraftLimit) {
        super(accNo, initialBalance);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public double withdraw(double amt) {
        double currentBal = getBal();
        if (amt > 0 && amt <= currentBal + overDraftLimit) {
            setBal(currentBal - amt); 
            // reflect overdraft
            double overdraftusednow = Math.max(0, amt-currentBal);
            return overdraftusednow;
            
        }
        return 0.0;
    }
}

class FDAccount extends BankAccount {

    final private int termInYears;
    final private double fdInterestRate;

    public FDAccount(int accNo, double initialBalance, int termInYears, double fdInterestRate) {
        super(accNo, initialBalance);
        this.termInYears = termInYears;
        this.fdInterestRate = fdInterestRate;
    }

    double calculateMaturityAmount() {
        double balance = getBal();
        double maturity = balance + (balance * fdInterestRate * termInYears / 100.0);
        return maturity;
    }
}

public class bankAccountManagementSystem {

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(101, 1000.0, 5);      // 2.5% interest
        CheckingAccount ca = new CheckingAccount(102, 2000.0, 1000.0); // ₹1000 overdraft
        FDAccount fda = new FDAccount(103, 5000.0, 2, 6);
        // depositing money, withdrawing money, adding interest(for savings account)
        // calculating maturity amt for(fd account)
        // displaying bal after each operation

        // Savings Account operations
        System.out.println("Adding interest rate of 5%...");
        sa.addInterest();
        System.out.println("Bal in savings account: " + sa.displayBalance());
        System.out.println();

        // Checking Account operations
        System.out.println("bal: "+ ca.getBal());
        System.out.println("Withdrawing 2500 rs..");
        System.out.println("Overdraft used:"+ ca.withdraw(2500));
        System.out.println();

        // FD Account operations
        System.out.println("Balance:"+ fda.displayBalance());
        double maturity = fda.calculateMaturityAmount();
        System.out.println("FD Account Maturity for 2 years at 6%: ₹" + String.format("%.2f", maturity));
    }
}

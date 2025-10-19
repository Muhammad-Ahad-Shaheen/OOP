class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest); 
        System.out.println("Interest applied: " + interest);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Prob4 {
    public static void main(String[] args) {
        Account account = new Account("A12345", 1000);
        account.deposit(200);
        account.withdraw(150);
        account.display();
        
        System.out.println();

        SavingsAccount savingsAccount = new SavingsAccount("S67890", 2000, 5);
        savingsAccount.deposit(500);
        savingsAccount.applyInterest();
        savingsAccount.withdraw(300);
        savingsAccount.display();
    }
}
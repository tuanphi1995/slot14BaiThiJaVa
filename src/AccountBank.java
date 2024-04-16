public class AccountBank {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBank(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance < 0 ? 0 : balance; // Ensure balance is not negative
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance < 0 ? 0 : balance; // Ensure balance is not negative
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder Name: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Withdrawal amount is invalid or exceeds balance.");
            return false;
        }
    }

    public boolean transfer(AccountBank destinationAccount, double amount) {
        if (this.withdraw(amount)) {
            destinationAccount.deposit(amount);
            System.out.println("Amount transferred: " + amount);
            return true;
        }
        return false;
    }
}

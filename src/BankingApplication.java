import java.util.Scanner;

public class BankingApplication {
    private Scanner scanner;
    private AccountBank account;

    public BankingApplication() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Bank!");

        // Gather initial account information
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accHolder = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        account = new AccountBank(accNum, accHolder, balance);
        account.displayAccountInfo();

        // Operations
        String action;
        do {
            System.out.print("\nChoose an action (Deposit/Withdraw/Transfer/Exit): ");
            action = scanner.nextLine();

            switch (action.toLowerCase()) {
                case "deposit":
                    performDeposit();
                    break;
                case "withdraw":
                    performWithdrawal();
                    break;
                case "transfer":
                    performTransfer();
                    break;
                case "exit":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid action! Please choose again.");
                    break;
            }
        } while (!action.equalsIgnoreCase("exit"));

        scanner.close();
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline
        account.deposit(amount);
        account.displayAccountInfo();
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline
        account.withdraw(amount);
        account.displayAccountInfo();
    }

    private void performTransfer() {
        System.out.print("Enter the account number to transfer to: ");
        String destAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        // Dummy account for transfer - in a real scenario, you'd look up an existing account
        AccountBank destinationAccount = new AccountBank(destAccountNumber, "Dummy Account", 0);

        if (account.transfer(destinationAccount, amount)) {
            System.out.println("Transferred " + amount + " to account " + destAccountNumber);
        }
        account.displayAccountInfo();
        destinationAccount.displayAccountInfo();
    }
}

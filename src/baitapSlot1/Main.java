package baitapSlot1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseHelper dbHelper = new DatabaseHelper();
        dbHelper.createTable();

        while (true) {
            System.out.println("1. Add Customer\n2. Update Customer\n3. Delete Customer\n4. Find Customer by ID\n5. Display All Customers\n6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    dbHelper.addCustomer(new Customer(0, name, email));
                    break;
                case 2:
                    System.out.print("Enter customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    dbHelper.updateCustomer(new Customer(updateId, newName, newEmail));
                    break;
                case 3:
                    System.out.print("Enter customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    dbHelper.deleteCustomer(deleteId);
                    break;
                case 4:
                    System.out.print("Enter customer ID to find: ");
                    int findId = scanner.nextInt();
                    Customer customer = dbHelper.findCustomerById(findId);
                    if (customer != null) {
                        System.out.println("Customer found: " + customer);
                    } else {
                        System.out.println("No customer found with ID: " + findId);
                    }
                    break;
                case 5:
                    System.out.println("All customers:");
                    for (Customer c : dbHelper.getAllCustomers()) {
                        System.out.println(c);
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}

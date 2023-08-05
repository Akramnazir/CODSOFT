import java.util.Scanner;

public class AddressBookApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1:
                    addContact();
                    break;

                case 2:
                    searchContact();
                    break;

                case 3:
                    displayAllContacts();
                    break;

                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=== Address Book Menu ===");
        System.out.println("1. Add Contact");
        System.out.println("2. Search Contact");
        System.out.println("3. Display All Contacts");
        System.out.println("4. Exit");
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        if (name.isEmpty() || phoneNumber.isEmpty() || emailAddress.isEmpty()) {
            System.out.println("Please provide all required fields.");
        } else {
            Contact contact = new Contact(name, phoneNumber, emailAddress);
            addressBook.addContact(contact);
            System.out.println("Contact added successfully.");
        }
    }

    private static void searchContact() {
        System.out.print("Enter the name to search: ");
        String name = scanner.nextLine();

        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayAllContacts() {
        System.out.println("All Contacts:");
        addressBook.displayAllContacts();
    }
}

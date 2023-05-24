import java.util.Scanner;

public class restaurentBURGER{
    public static void main(String[] args) {
        Scanner field = new Scanner(System.in);

        System.out.println("Welcome to Brampton Hamburgers!");

        double totalBillingAmount = 0;

        for (int customer = 1; customer <= 5; customer++) {
            System.out.println("\nCustomer " + customer + ":");
            double ORDERAMOUNT = 0;

            while (true) {
                printMenu();
                System.out.print("Enter your choice (1-8): ");
                int choice = field.nextInt();
                field.nextLine(); // Consume the newline character

                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid choice! Please select a valid option.");
                    continue;
                }

                if (choice == 8) {
                    break;
                }

                System.out.print("Enter the quantity: ");
                int quantity = field.nextInt();
                field.nextLine(); // Consume the newline character

                double price = getPrice(choice);
                ORDERAMOUNT += price * quantity;
            }

            double BillAMOUNT = calculateBillAmount(ORDERAMOUNT);
            totalBillingAmount += BillAMOUNT;

            System.out.println("Billing Amount for Customer " + customer + ": $" + BillAMOUNT);
        }

        System.out.println("\nTotal Billing Amount for all customers: $" + totalBillingAmount);
    }

    private static void printMenu() {
        System.out.println("\nMenu for Brampton Hamburgers:");
        System.out.println("Type of Burger\t\tPrice");
        System.out.println("1. Veggie Burger\t$5.95");
        System.out.println("2. Deluxe Veggie Burger\t$7.95");
        System.out.println("3. Chicken Burger\t$6.45");
        System.out.println("4. Cheese Chicken Burger\t$8.50");
        System.out.println("5. Cheese Bacon Burger\t$9.25");
        System.out.println("6. Deluxe Bacon Burger\t$10.95");
        System.out.println("7. Healthy Organic Burger\t$12.45");
        System.out.println("8. Quit");
    }

    private static double getPrice(int choice) {
        switch (choice) {
            case 1:
                return 5.95;
            case 2:
                return 7.95;
            case 3:
                return 6.45;
            case 4:
                return 8.50;
            case 5:
                return 9.25;
            case 6:
                return 10.95;
            case 7:
                return 12.45;
            default:
                return 0;
        }
    }

    private static double calculateBillAmount(double orderAmount) {
        double billAmount = orderAmount;
        billAmount += billAmount * 0.13; // Add 13% tax

        if (billAmount > 50 && billAmount <= 100) {
            billAmount -= billAmount * 0.05; // Apply 5% discount
        } else if (billAmount > 100) {
            billAmount -= billAmount * 0.10; // Apply 10% discount
        }

        return billAmount;
    }
}

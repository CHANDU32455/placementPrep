import java.util.Scanner;

class FoodItem {
    String itemId;
    String itemName;
    double unitPrice;
    int quantity;

    double subtotal;
    double gst;
    double discount;
    double totalBill;

    FoodItem(String itemId, String itemName, double unitPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    double calculateBill() {
        subtotal = unitPrice * quantity;
        gst = subtotal * 0.05;
        discount = (subtotal + gst) > 1000 ? (subtotal + gst) * 0.10 : 0.0;
        totalBill = subtotal + gst - discount;
        return totalBill;
    }

    void displayDetails() {
        System.out.println("\nFood Item Record");
        System.out.println("ID " + itemId);
        System.out.println("Name " + itemName);
        System.out.println("Unit Price " + unitPrice);
        System.out.println("Quantity " + quantity);
        System.out.println("Subtotal " + subtotal);
        System.out.println("GST " + gst);
        System.out.println("Discount " + discount);
        System.out.println("Total Bill " + totalBill);
    }
}

class DineIn extends FoodItem {
    double serviceCharge;

    DineIn(String itemId, String itemName, double unitPrice, int quantity, double serviceCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.serviceCharge = serviceCharge;
    }

    @Override
    double calculateBill() {
        subtotal = unitPrice * quantity;
        subtotal += serviceCharge;
        gst = subtotal * 0.05;
        discount = (subtotal + gst) > 1000 ? (subtotal + gst) * 0.10 : 0.0;
        totalBill = subtotal + gst - discount;
        return totalBill;
    }

    @Override
    void displayDetails() {
        calculateBill();
        System.out.println("\nFood Item Record");
        System.out.println("ID " + itemId);
        System.out.println("Name " + itemName);
        System.out.println("Unit Price " + unitPrice);
        System.out.println("Quantity " + quantity);
        System.out.println("Service Charge " + serviceCharge);
        System.out.println("Subtotal " + (unitPrice * quantity));
        System.out.println("GST " + gst);
        System.out.println("Discount " + discount);
        System.out.println("Total Bill " + totalBill);
    }
}

class Takeaway extends FoodItem {
    double packingCharge;

    Takeaway(String itemId, String itemName, double unitPrice, int quantity, double packingCharge) {
        super(itemId, itemName, unitPrice, quantity);
        this.packingCharge = packingCharge;
    }

    @Override
    double calculateBill() {
        subtotal = unitPrice * quantity;
        subtotal += packingCharge;
        gst = subtotal * 0.05;
        discount = (subtotal + gst) > 1000 ? (subtotal + gst) * 0.10 : 0.0;
        totalBill = subtotal + gst - discount;
        return totalBill;
    }

    @Override
    void displayDetails() {
        calculateBill();
        System.out.println("\nFood Item Record");
        System.out.println("ID " + itemId);
        System.out.println("Name " + itemName);
        System.out.println("Unit Price " + unitPrice);
        System.out.println("Quantity " + quantity);
        System.out.println("Packing Charge " + packingCharge);
        System.out.println("Subtotal " + (unitPrice * quantity));
        System.out.println("GST " + gst);
        System.out.println("Discount " + discount);
        System.out.println("Total Bill " + totalBill);
    }
}

class Delivery extends FoodItem {
    double deliveryFee;

    Delivery(String itemId, String itemName, double unitPrice, int quantity, double deliveryFee) {
        super(itemId, itemName, unitPrice, quantity);
        this.deliveryFee = deliveryFee;
    }

    @Override
    double calculateBill() {
        subtotal = unitPrice * quantity;
        subtotal += deliveryFee;
        gst = subtotal * 0.05;
        discount = (subtotal + gst) > 1000 ? (subtotal + gst) * 0.10 : 0.0;
        totalBill = subtotal + gst - discount;
        return totalBill;
    }

    @Override
    void displayDetails() {
        calculateBill();
        System.out.println("\nFood Item Record");
        System.out.println("ID " + itemId);
        System.out.println("Name " + itemName);
        System.out.println("Unit Price " + unitPrice);
        System.out.println("Quantity " + quantity);
        System.out.println("Delivery Fee " + deliveryFee);
        System.out.println("Subtotal " + (unitPrice * quantity));
        System.out.println("GST " + gst);
        System.out.println("Discount " + discount);
        System.out.println("Total Bill " + totalBill);
    }
}

public class Resturant_Billing {
    public static void main(String[] args) {
        FoodItem[] items = new FoodItem[3];
        items[0] = new DineIn("F101", "Paneer Butter Masala", 250.0, 4, 50.0);
        items[1] = new Takeaway("F102", "Veg Biryani", 180.0, 2, 20.0);
        items[2] = new Delivery("F103", "Chicken Pizza", 300.0, 4, 40.0);

        Scanner sc = new Scanner(System.in);
        

        int choice;
        do {
            System.out.println("\n====== Restaurant Billing Menu ======");
            System.out.println("1. Display Dine-In Bill");
            System.out.println("2. Display Takeaway Bill");
            System.out.println("3. Display Delivery Bill");
            System.out.println("4. Display All Bills");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    items[0].displayDetails();
                    break;
                case 2:
                    items[1].displayDetails();
                    break;
                case 3:
                    items[2].displayDetails();
                    break;
                case 4:
                    for (FoodItem item : items) {
                        item.displayDetails();
                    }
                    break;
                case 5:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

    

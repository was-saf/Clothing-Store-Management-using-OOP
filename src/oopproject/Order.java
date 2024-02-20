package oopproject;

import java.util.Date;

public class Order {
    private static int lastOrderID = 0;
    private int orderID;
    private Date orderDateTime;

    public Order(int orderID, Date orderDateTime) {
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
    }

    public int getOrderID() {
        return orderID;
    }
    
    public static int generateOrderID() {
        lastOrderID++;
        return lastOrderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Date orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

//    public void addToOrder(int orderID, int customerID, int garmentID, int quantity) {
//        try {
//            // Deduct stock from the database
//            String updateQuery = "UPDATE MaleGarments SET garmentUnit = quantity - ? WHERE garmentID = ?";
//            DatabaseConnector db = new DatabaseConnector();
//            db.runDML(updateQuery, quantity, garmentID);
//            
//            // Check if stock deduction was successful
//            if (db.getRowsAffected() > 0) {
//                // Stock deduction successful, add order to cart assigned to customer
//                Order order = new Order(orderID, new Date());
//                Customer user = null;
//                user = user.getUserByID(customerID);
//                
//                if (user != null) {
//                    user.getCustomerCart().addToCart(order);
//                    System.out.println("Order added to cart and stock deducted successfully.");
//                } else {
//                    System.out.println("Failed to find user with the specified ID. Order not added to cart.");
//                }
//            } else {
//                System.out.println("Failed to deduct stock from the database. Order not added to cart.");
//            }
//        } catch (NullPointerException e) {
//            System.out.println("NullPointerException thrown!");
//            System.out.println(e);
//        }
//    }
}
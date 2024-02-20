package oopproject;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Customer extends User implements IUser{

    private int customerID;
    private Cart customerCart;

    public Customer(int customerID, int customerCartID, String userName, String userEmail, String userAddress, String userPassword, int userAge, int userContactNo) {
        super(userName, userEmail, userAddress, userPassword, userAge, userContactNo);
        this.customerID = customerID;
        this.customerCart = new Cart(customerCartID);
    }
    
    public Customer(String userName, String userEmail, String userAddress, String userPassword, int userAge, int userContactNo){
        super(userName, userEmail, userAddress, userPassword, userAge, userContactNo);
    }        

    public Customer(String userName , String userPassword)
    {
        super(userName, userPassword);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Cart getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(Cart customerCart) {
        this.customerCart = customerCart;
    }
    
    
    public boolean login() {
             try{
            String query = "select * from Customer where userName='" + this.getUserName() + "' and userPassword='" + this.getUserPassword() +"'";
            DatabaseConnector db = new DatabaseConnector();
            ResultSet rs= db.runSelect(query);
            if(rs.next()){
                return true;
            }else{
             return false;
            } 
        }catch(SQLException e){
                System.out.println("An Error Occured while logging in.");
                System.out.println(e);
        }    
        return false;
    }
    
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        try {
            String query = "SELECT * FROM Customer WHERE userName='" + username + "' AND userPassword='" + password + "'";
            DatabaseConnector db = new DatabaseConnector();
            ResultSet rs = db.runSelect(query);
            if (rs.next()) {
                int customerID = rs.getInt("customerID");
                int customerCartID = rs.getInt("customerCartID");
                String userName = rs.getString("userName");
                String userEmail = rs.getString("userEmail");
                String userAddress = rs.getString("userAddress");
                String userPassword = rs.getString("userPassword");
                int userAge = rs.getInt("userAge");
                int userContactNo = rs.getInt("userContactNo");

                return new Customer(customerID, customerCartID, userName, userEmail, userAddress, userPassword, userAge, userContactNo);
            }
        } catch (SQLException e) {
            System.out.println("An Error Occurred while retrieving the customer.");
            System.out.println(e);
        }

        return null; // Return null if the customer is not found
    }

//    public void signup() {
//        try{
//            String query = "insert into Customer(customerID, customerCart, userName, userEmail, userAddress, userPassword, userAge, userContactNo) values('"+this.customerID+"','"+this.customerCart+"','"+this.getUserName()+"','"+this.getUserEmail()+"','"+this.getUserAddress()+"','"+this.getUserPassword()+"','"+this.getUserAge()+"','"+this.getUserContactNo()+"')";
//            DatabaseConnector db = new DatabaseConnector();
//            db.runDML(query);
//            System.out.println("Data Inserted");
//        } catch(Exception e){
//            System.out.println(e + "Error While Saving Record in Database!");
//        }    
//    }    
    public void signup() {
        try  {
            DatabaseConnector db = new DatabaseConnector();
            String query = "INSERT INTO Customer (userName, userPassword, userAge, userAddress) VALUES ('" + this.getUserName() + "', '" + this.getUserPassword() + "', " + this.getUserAge() + ", '" + this.getUserAddress() + "')";

            db.runDML(query);

            System.out.println("Data Inserted");
        } catch (Exception e) {
            System.out.println("Error While Connecting to Database: " + e.getMessage());
        }
    }
    
    public int getTotalCustomers() {
        int totalCustomers = 0;

        try {
            String query = "SELECT COUNT(*) AS total FROM customer";
            DatabaseConnector db = new DatabaseConnector();
            ResultSet resultSet = db.runSelect(query);

            if (resultSet.next()) {
                totalCustomers = resultSet.getInt("total");
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving the total number of customers.");
            System.out.println(e);
        }

        return totalCustomers;
    }
    
    public Customer getUserByID(int userID) {
        try {
            String query = "SELECT * FROM customer WHERE customerID='" + userID + "'";
            DatabaseConnector db = new DatabaseConnector();
            ResultSet resultSet = db.runSelect(query);

            if (resultSet.next()) {
                int customerID = resultSet.getInt("customerID");
                int customerCartID = resultSet.getInt("customerCartID");
                String userName = resultSet.getString("userName");
                String userEmail = resultSet.getString("userEmail");
                String userAddress = resultSet.getString("userAddress");
                String userPassword = resultSet.getString("userPassword");
                int userAge = resultSet.getInt("userAge");
                int userContactNo = resultSet.getInt("userContactNo");

                // Create a new Customer object
                Customer customer = new Customer(customerID, customerCartID, userName, userEmail, userAddress, userPassword, userAge, userContactNo);
                return customer;
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving the customer from the database.");
            System.out.println(e);
        }

        return null; // Return null if the customer is not found or an error occurs
    }
    
}

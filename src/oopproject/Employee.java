package oopproject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee extends User implements IUser{
    
    private int employeeID;
    private double employeeIncome;
    private String employeeRole;
    
    public Employee(int employeeID, double employeeIncome, String employeeRole, String userName, String userEmail, String userAddress, String userPassword, int userAge, int userContactNo) {
        super(userName, userEmail, userAddress, userPassword, userAge, userContactNo);
        this.employeeID = employeeID;
        this.employeeIncome = employeeIncome;
        this.employeeRole = employeeRole;
    }
    
    public Employee(String userName , String userPassword)
    {
        super(userName, userPassword);
    }    

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getEmployeeIncome() {
        return employeeIncome;
    }

    public void setEmployeeIncome(double employeeIncome) {
        this.employeeIncome = employeeIncome;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }
    
    public void manageInventory(){};
    
    public boolean login() {
        try{
            String query = "select * from Employee where userName='" + this.getUserName() + "' and userPassword='" + this.getUserPassword() +"'";
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
    
    public Employee getEmployeeByUsernameAndPassword(String username, String password) {
        try {
            String query = "SELECT * FROM Employee WHERE userName='" + username + "' AND userPassword='" + password + "'";
            DatabaseConnector db = new DatabaseConnector();
            ResultSet rs = db.runSelect(query);
            if (rs.next()) {
                int employeeID = rs.getInt("employeeID");
                double employeeIncome = rs.getDouble("employeeIncome");
                String employeeRole = rs.getString("employeeRole");
                String userName = rs.getString("userName");
                String userEmail = rs.getString("userEmail");
                String userAddress = rs.getString("userAddress");
                String userPassword = rs.getString("userPassword");
                int userAge = rs.getInt("userAge");
                int userContactNo = rs.getInt("userContactNo");

                return new Employee(employeeID, employeeIncome, employeeRole, userName, userEmail, userAddress, userPassword, userAge, userContactNo);
            }
        } catch (SQLException e) {
            System.out.println("An Error Occurred while retrieving the employee.");
            System.out.println(e);
        }

        return null; // Return null if the employee is not found
    }

//    public void signup() {
//        try{
//            String query = "insert into Employee(employeeID, userName, userEmail, userAddress, userPassword, userAge, userContactNo, employeeRole, employeeIncome) values('"+this.employeeID+"','"+this.getUserName()+"','"+this.getUserEmail()+"','"+this.getUserAddress()+"','"+this.getUserPassword()+"','"+this.getUserAge()+"','"+this.getUserContactNo()+"','"+this.getEmployeeRole()+"','"+this.getEmployeeIncome()+"')";
//            DatabaseConnector db = new DatabaseConnector();
//            db.runDML(query);
//            System.out.println("Data Inserted");
//        } catch(Exception e){
//            System.out.println(e + "Error While Saving Record in Database!");
//        }       
//    }

    @Override
    public void signup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

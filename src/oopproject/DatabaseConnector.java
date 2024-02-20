
package oopproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String dbLoc = "jdbc:ucanaccess://Database.accdb";
    private Connection conn;
    private PreparedStatement prepState;
    private ResultSet rSet;
    
    public DatabaseConnector(){
        try{
            conn = DriverManager.getConnection(dbLoc);
            System.out.println("Connection Established.");
        }catch (SQLException e) {
            System.out.println(e);
            System.out.println("Connection NOT Established");
        }
    }
    public ResultSet runSelect(String query){
        try{
            prepState = conn.prepareStatement(query);
            rSet = prepState.executeQuery();   
        }catch(SQLException e){
            System.out.println(e);
        }
        return rSet;
    }
    public void runDML(String query){
        try{
            prepState = conn.prepareStatement(query);
            prepState.executeUpdate();
            System.out.println("Record Updated Successfully");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public int getRowsAffected() {
        try {
            if (prepState != null) {
                return prepState.getUpdateCount();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public void runDML(String query, Object... params) {
        try {
            prepState = conn.prepareStatement(query);

            // Set the parameter values
            for (int i = 0; i < params.length; i++) {
                prepState.setObject(i + 1, params[i]);
            }

            prepState.executeUpdate();
            System.out.println("Record Updated Successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet runSelect(String query, Object... params) {
        try {
            prepState = conn.prepareStatement(query);

            // Set the parameter values
            for (int i = 0; i < params.length; i++) {
                prepState.setObject(i + 1, params[i]);
            }

            rSet = prepState.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rSet;
    }  
    
    public PreparedStatement prepareStatement(String query) throws SQLException {
        return conn.prepareStatement(query);
    }
    
    public void close() {
        try {
            if (rSet != null) {
                rSet.close();
            }
            if (prepState != null) {
                prepState.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("Connection Closed Successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}

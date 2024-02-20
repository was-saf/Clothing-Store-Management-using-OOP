package oopproject;

public class User {
    private String userName, userEmail, userAddress, userPassword;
    private int userAge, userContactNo;

    public User(String userName, String userEmail, String userAddress, String userPassword, int userAge, int userContactNo) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userContactNo = userContactNo;
    }
    
    public User(String userName,String userPassword ){
        this.userName = userName;
        this.userPassword = userPassword;        
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserContactNo() {
        return userContactNo;
    }

    public void setUserContactNo(int userContactNo) {
        this.userContactNo = userContactNo;
    }

}

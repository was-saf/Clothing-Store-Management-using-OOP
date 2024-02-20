package oopproject;

public class Cart {

    public Cart(int customerCartID) {
        this.customerCartID = customerCartID;
    }
    private int customerCartID;

    public int getCustomerCartID() {
        return customerCartID;
    }

    public void setCustomerCartID(int customerCartID) {
        this.customerCartID = customerCartID;
    }
    
}

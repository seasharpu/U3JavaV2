package model;

public class Pizza extends Food{

    private String toppingOne;
    private String toppingTwo;

    public Pizza(int productCost, String productName, Ingredients ingredients, String toppingOne, String toppingTwo) {
        super(productCost, productName, ingredients);
        this.toppingOne = toppingOne;
        this.toppingTwo = toppingTwo;
    }

    //@return
    public String getToppingOne() {
        return toppingOne;
    }

    public void setToppingOne(String toppingOne) {
        this.toppingOne = toppingOne;
    }
    
    //@return
    public String getToppingTwo() {
        return toppingTwo;
    }

    public void setToppingTwo(String toppingTwo) {
        this.toppingTwo = toppingTwo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Toppings: " + toppingOne + ", " + toppingTwo;
    }

}

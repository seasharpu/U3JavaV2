package model;

public class Pizza extends Food{

    private Ingredients ingredient1;
    private Ingredients ingredient2;

    public Pizza(int productCost, String productName, FoodType foodType, Ingredients ingredient1, Ingredients ingredient2) {
        super(productCost, productName, foodType);
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
    }

    //@return
    @Override
    public String productOrigin() {
        return "Sweden";
    }

    @Override
    public String toString() {
        return super.toString() + ", Toppings: " + ingredient1 + ", " + ingredient2 + ", Origin: " + productOrigin();
    }

}

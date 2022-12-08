package model;

public abstract class Food extends Menu{

    private FoodType foodType;

    public Food(int productCost, String productName, FoodType foodType) {
        super(productCost, productName);
        this.foodType = foodType;
    }

    //@return
    @Override
    public String toString() {
        return super.toString() + ", Food: " + foodType;
    }

}

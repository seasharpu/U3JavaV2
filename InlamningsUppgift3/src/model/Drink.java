package model;

public class Drink extends Menu{

    private DrinkType drinkType;  

    public Drink(int productCost, String productName, DrinkType drinkType) {
        super(productCost, productName);
        this.drinkType = drinkType;
    }

    //@return
    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    //@return
    @Override
    public String toString() {
        return super.toString() + ", Type: " + drinkType;
    }
}

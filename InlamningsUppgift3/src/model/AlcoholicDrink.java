package model;

public class AlcoholicDrink extends Drink{
    
    private double alcoholPercent;

    public AlcoholicDrink(int productCost, String productName, DrinkType drinkType, double alcoholPercent) {
        super(productCost, productName, drinkType);
        this.alcoholPercent = alcoholPercent;
    }

    //@return
    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    //@return
   @Override
   public String toString() {
       return super.toString() + ", Percent of Alcohol: " + alcoholPercent;
   }
}

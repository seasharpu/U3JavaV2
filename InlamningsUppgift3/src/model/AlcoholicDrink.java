package model;

/** Represents an alcoholic drink.
 * @author Alexander, Mehmet
 */
public class AlcoholicDrink extends Drink{
    
    private double alcoholPercent;

    public AlcoholicDrink(int productCost, String productName, DrinkType drinkType, double alcoholPercent) {
        super(productCost, productName, drinkType);
        this.alcoholPercent = alcoholPercent;
    }

    /** Returns percent of an alcoholic drink
     * @return alcoholPercent
     * @author Alexander
     */
    //@return
    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    /** Returns strings of instance variables in this class and superclass instance variables, as well as a string.
     * @return super.toString() + ", Percent of Alcohol: " + alcoholPercent;
     * @author Alexander
     */
    //@return
   @Override
   public String toString() {
       return super.toString() + ", Percent of Alcohol: " + alcoholPercent;
   }
}

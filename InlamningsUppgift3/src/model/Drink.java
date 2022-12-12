package model;

/** Represents a non-alcoholic drink. Acts as superclass for alcoholic drink.
 * @author Alexander, Mehmet
 */
public class Drink extends Menu{

    private DrinkType drinkType;  

    public Drink(int productCost, String productName, DrinkType drinkType) {
        super(productCost, productName);
        this.drinkType = drinkType;
    }

    /** Returns a type of drink from enum DrinkType
     * @return drinkType
     * @author Alexander
     */
    //@return
    public DrinkType getDrinkType() {
        return drinkType;
    }

    /** Sets a value to instance variable drinkType
     * @param drinkType - Contains a type of drink from enum TypeDrink to set to the instance variable
     * @author Alexander
     */
    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    /** Generates a string with information about product origin. In this case its overriden to produce Germany as country of origin.
     * @return String
     */
    @Override
    public String productOrigin() {
        return "Germany";
    }

    /** Returns instance variables of the current class and superclasses and a string
     * @return return super.toString() + ", Type: " + drinkType + " Origin: " + productOrigin();
     */
    @Override
    public String toString() {
        return super.toString() + ", Type: " + drinkType + " Origin: " + productOrigin();
    }
}

package model;

/** Represents a pizza
 * @author Alexander, Mehmet
 */
public class Pizza extends Food{

    private Ingredients ingredient1;
    private Ingredients ingredient2;

    public Pizza(int productCost, String productName, FoodType foodType, Ingredients ingredient1, Ingredients ingredient2) {
        super(productCost, productName, foodType);
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
    }

    /** Generates a string with information about product origin. In this case its overriden to produce Sweden as country of origin.
     * @return String
     */
    @Override
    public String productOrigin() {
        return "Sweden";
    }

    /** Returns instance variables of the current class and superclasses and a string
     * @return return super.toString() + ", Type: " + drinkType + " Origin: " + productOrigin();
     */
    @Override
    public String toString() {
        return super.toString() + ", Toppings: " + ingredient1 + ", " + ingredient2 + ", Origin: " + productOrigin();
    }

}

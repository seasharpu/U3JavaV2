package model;

/** Abstract superclass for food items
 * @author Alexander, Mehmet
 */
public abstract class Food extends Menu{

    private FoodType foodType;

    public Food(int productCost, String productName, FoodType foodType) {
        super(productCost, productName);
        this.foodType = foodType;
    }

    /** Returns instance variables of the current class and superclasses and a string
     * @return return return super.toString() + ", Food: " + foodType;;
     */
    @Override
    public String toString() {
        return super.toString() + ", Food: " + foodType;
    }

}

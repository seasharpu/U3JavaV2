package model;

/** Menu superclass that food and drink subclasses inherits common variables from like name and cost of products.
 * @author Alexander, Mehmet
 */
public class Menu implements IMenu{
    private int productCost;
    private String productName;

    private Food[] foods = new Food[10];
    private Drink[] drinks = new Drink[10];

    
    public Menu(){}

    public Menu(int productCost, String productName) {
        this.productCost = productCost;
        this.productName = productName;
    }

    /** Gets the cost of food inside foods array based on the index provided.
     * @param index - index to search for food object in foods array.
     * @return foods[index].getProductCost()
     */
    //@return
    public int getFoodCost(int index) {
        return foods[index].getProductCost();
    }

    /** Gets the cost of drinks inside drinks array based on the index provided.
     * @param index - index to search for drink object in foods array.
     * @return drinks[index].getProductCost()
     */
    //@return
    public int getDrinkCost(int index) {
        return drinks[index].getProductCost();
    }

    /** Gets the cost of a product.
     * @return productCost
     */
    //@return
    public int getProductCost() {
        return productCost;
    }

    /** Adds a pizza object to the array of foods.
     * @param costOfPizza The cost of a pizza
     * @param pizzaName The name of a pizza
     * @param foodType The type of food
     * @param ingredient1 First ingredient on food
     * @param ingredient2 Second ingredient on food
     * @author Mehmet
     */
    public void addPizza(int costOfPizza, String pizzaName, FoodType foodType, Ingredients ingredient1, Ingredients ingredient2){
        for (int i = 0; i < foods.length; i++) {
            if(foods[i] == null){
                foods[i] = new Pizza(costOfPizza, pizzaName, foodType, ingredient1, ingredient2);
                break;
            }
        }
    }


    /** Adds a drink object to the drinks array
     * @param cost Cost of a drink
     * @param drinkName Name of a drink
     * @param drinkType Type of drink(alcoholic, non-alcoholic)
     * @author Mehmet
     */
    public void addDrink(int cost, String drinkName, DrinkType drinkType){
        for (int i = 0; i < drinks.length; i++) {
            if(drinks[i] == null){
                drinks[i] = new Drink(cost, drinkName, drinkType);
                break;
            }
        }
    }

    /** Adds an alholic drink to the drink array
     * @param cost Cost of an alcoholic drink
     * @param drinkName Name of an alcoholic drink
     * @param drinkType Type of drink
     * @param alcoholPercent The alcohol percentage
     * @author Mehmet
     */
    public void addAlcoholicDrink(int cost, String drinkName, DrinkType drinkType, double alcoholPercent){
        for (int i = 0; i < drinks.length; i++) {
            if(drinks[i] == null){
                drinks[i] = new AlcoholicDrink(cost, drinkName, drinkType, alcoholPercent);
                break;
            }
        }
    }

    /** Creates a string version of foods array. First checks the amount of food objects inside the foods array.
     * @return foodsStrings
     */
    //@return
    public String[] getFoods() {
        //Calculates the amount of foods currently stored in foods array
        int amountOfFoods = 0;

        for (int i=0; i<foods.length; i++){
          if(foods[i] != null){
            amountOfFoods++;
          }
        }
        
        String[] foodStrings = new String[amountOfFoods];
    
        for (int i=0; i<amountOfFoods; i++){
          if (foods[i] != null){
            foodStrings[i] = foods[i].toString();
          }
        }
        
        return foodStrings;
    }

    /** Creates a string version of drinks array. First checks the amount of drink objects inside the drinks array.
     * @return drinkStrings
     */
    public String[] getDrinks() {
        //Calculates the amount of drinks currently stored in drink array
        int amountOfDrinks = 0;

        for (int i=0; i<drinks.length; i++){
          if(drinks[i] != null){
            amountOfDrinks++;
          }
        }
        
        String[] drinkStrings = new String[amountOfDrinks];
    
        for (int i=0; i<amountOfDrinks; i++){
          if (drinks[i] != null){
            drinkStrings[i] = drinks[i].toString();
          }
        }

        return drinkStrings;
    }
    /** Generates a string with information about product origin.
     * @return null
     */
    @Override
    public String productOrigin() {
        return null;
    }

    /** Gets the type of drink located in the drinks array.
     * @param selectionIndex - Index provided to use for the drinks array
     * @return drinks[selectionIndex].getDrinkType();
     */
    public DrinkType getTypeOfDrink(int selectionIndex) {
        return drinks[selectionIndex].getDrinkType();
    }

    /** Returns instance variables and a String.
     * @return return productName + ", Costs: " + productCost;
     */
    //@return
    @Override
    public String toString() {
        return productName + ", Costs: " + productCost;
    }

}

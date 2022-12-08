package model;

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
   
    //@return
    public int getFoodCost(int index) {
        return foods[index].getProductCost();
    }

    //@return
    public int getDrinkCost(int index) {
        return drinks[index].getProductCost();
    }
  
    //@return
    public int getProductCost() {
        return productCost;
    }
   
    public void addPizza(int costOfPizza, String pizzaName, FoodType foodType, Ingredients ingredient1, Ingredients ingredient2){
        for (int i = 0; i < foods.length; i++) {
            if(foods[i] == null){
                foods[i] = new Pizza(costOfPizza, pizzaName, foodType, ingredient1, ingredient2);
                break;
            }
        }
    }

    public void addDrink(int cost, String drinkName, DrinkType drinkType){
        for (int i = 0; i < drinks.length; i++) {
            if(drinks[i] == null){
                drinks[i] = new Drink(cost, drinkName, drinkType);
                break;
            }
        }
    }

    public void addAlcoholicDrink(int cost, String drinkName, DrinkType drinkType, double alcoholPercent){
        for (int i = 0; i < drinks.length; i++) {
            if(drinks[i] == null){
                drinks[i] = new AlcoholicDrink(cost, drinkName, drinkType, alcoholPercent);
                break;
            }
        }
    }

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
    
    //@return
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

    @Override
    public String productOrigin() {
        return null;
    }

    //@return
    public DrinkType getTypeOfDrink(int selectionIndex) {
        return drinks[selectionIndex].getDrinkType();
    }

    //@return
    @Override
    public String toString() {
        return productName + ", Costs: " + productCost;
    }

}

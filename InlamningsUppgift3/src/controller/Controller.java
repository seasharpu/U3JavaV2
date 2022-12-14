package controller;

//only imports what is strictly necessary from view-package
import view.CustomPizzaFrame;
import view.MainFrame;

import javax.swing.JOptionPane;

import model.DrinkType;
import model.FoodType;
import model.Ingredients;
import model.Menu;
import model.Order;
import view.ButtonType;

public class Controller {
    private MainFrame view;
    
    private ButtonType currentLeftMenu = ButtonType.NoChoice; // for test purposes - delete if not used in final solution

    private Menu menu = new Menu();
    private CustomPizzaFrame newPizzaType;

    private String [] currentOrderArray; 
    private int nbrOfItemsInList = 0; 
    private double costCurrentOrder = 0; 

    private Order[] ordersList;
    int nbrOfOrdersInOrdersList;

    private boolean pizzaOrdered = false;



  
    public Controller() {
        view = new MainFrame(1200, 500, this);
        loadStringTestValues(); //for test purposes - remove when not needed more
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

    //Prepares the arrays and creates pizzas and drinks 
    private void loadStringTestValues() {

        currentOrderArray = new String[10];
        ordersList = new Order[3];
    
        menu.addPizza(20, "Margarita", FoodType.Pizza, Ingredients.Cheese, Ingredients.Ham);
        menu.addPizza(40, "Peperoni", FoodType.Pizza, Ingredients.Pepperoni, Ingredients.Pepperoni);
        menu.addPizza(60, "Mozarella", FoodType.Pizza, Ingredients.Mozzarella, Ingredients.Ham);
        menu.addPizza(60, "Mozarella", FoodType.Pizza, Ingredients.Pepperoni, Ingredients.Ham);
        menu.addPizza(60, "Hawai", FoodType.Pizza, Ingredients.Pineapple, Ingredients.Cheese);

        menu.addDrink(15, "Cola", DrinkType.Nonalcoholic);
        menu.addDrink(15, "Fanta", DrinkType.Nonalcoholic);
        menu.addDrink(15, "Zero", DrinkType.Nonalcoholic);
        menu.addDrink(15, "Sprite", DrinkType.Nonalcoholic);
        menu.addAlcoholicDrink(36, "Carlsberg", DrinkType.Alcoholic, 5.0);
    }

    //This method is called by class MinFrame when a button in teh GUI is pressed
    public void buttonPressed(ButtonType button){

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Food:
                setToFoodMenu();
                break;

            case Drinks:
                setToDrinkMenu();
                break;

            case MakePizza:
                addNewFood();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                //Cheks the number of orders chosen by user
                if(nbrOfItemsInList != 0){
                    if(pizzaOrdered == true){
                        placeOrder();
                    }else{
                        String message = "You have to order minimum one pizza!";
                        JOptionPane.showMessageDialog(newPizzaType, message);
                    }
                }else{
                    String message = "Nothing added to the order list!";
                    JOptionPane.showMessageDialog(newPizzaType, message);
                }

                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }

    //Adds chosen item to currentOrder array
    public void addItemToOrder(int selectionIndex) {
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if (selectionIndex != -1){ // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case Food:
                    currentOrderArray[nbrOfItemsInList] = menu.getFoods()[selectionIndex]; //for test purposes - needs to be replaced with solution of finding chosen menu item matching architecture for model
                    costCurrentOrder = costCurrentOrder + menu.getFoodCost(selectionIndex);
                    pizzaOrdered = true;
                    break;
                case Drinks:
                    //Checks the type of drink
                    if(menu.getTypeOfDrink(selectionIndex) == DrinkType.Alcoholic){
                        String ageOfUser = JOptionPane.showInputDialog( "How old are you?" );
                        int usersAge = Integer.parseInt(ageOfUser);

                        if(usersAge >= 18){
                            currentOrderArray[nbrOfItemsInList] = menu.getDrinks()[selectionIndex];
                            costCurrentOrder = costCurrentOrder + menu.getDrinkCost(selectionIndex); 
                        }else{
                            String message = "You have to be older than 18!";
                            JOptionPane.showMessageDialog(newPizzaType, message);
                        }
                    }else{
                        currentOrderArray[nbrOfItemsInList] = menu.getDrinks()[selectionIndex];
                        costCurrentOrder = costCurrentOrder + menu.getDrinkCost(selectionIndex); 
                    }
                    break;
            }
            
            //This method increase the length of the currentOrderArray while it is almost full
            if(nbrOfItemsInList == (currentOrderArray.length-1)){
                increaseCurrentOrderArrayLength();
            }
            
            nbrOfItemsInList++;
            view.populateRightPanel(currentOrderArray);
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder));
        }

    }

    //Gets and show the a chosen order from orderhistory
    public void viewSelectedOrder(int selectionIndex){
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed

        if ((selectionIndex != -1) && currentLeftMenu==ButtonType.OrderHistory){
            //Gets and shows orderhistory for chosen order from gui
            view.populateRightPanel(ordersList[selectionIndex].getOrderHistory()); //update right panel with order details - this takes a shortcut in updating the entire information in the panel not just adds to the en
            
            //Sets the cost of the chosen order
            view.setTextCostLabelRightPanel("Total cost of order: " + ordersList[selectionIndex].getOrderCost()); //set the text to show cost of current order

        }
    }

    //Sets foods to left panel
    public void setToFoodMenu() {
        currentLeftMenu = ButtonType.Food;
    
        view.populateLeftPanel(menu.getFoods());

        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableFoodMenuButton();
        view.disableViewSelectedOrderButton();
    }

    //Sets drinks to left panel
    public void setToDrinkMenu() {
        currentLeftMenu = ButtonType.Drinks;
        view.populateLeftPanel(menu.getDrinks());
        view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableDrinksMenuButton();
        view.disableViewSelectedOrderButton();
    }

    //Sets early order to left panel
    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        view.clearRightPanel();

        String[] ordersName = new String[ordersList.length];

        for (int i = 0; i < ordersList.length; i++) {
            if(ordersList[i] != null){
                ordersName[i] = ordersList[i].getOrderName();
            }
        }

        view.populateLeftPanel(ordersName);
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    //Creates a custom pizza
    public void addNewFood() {
        //newPizzaType = new CustomPizzaFrame(this);        

        //For grade VG: Add more code to save the new Pizza type and update menu,
        view.enableAllButtons();
    }

    //Adds order to orderList array, clears the currentOrderArray and resets the variables
    public void placeOrder() {
        
        //Counts the amount orders in orderslist to generate a name for newOrder
        for (int i = 0; i < ordersList.length; i++) {
            if(ordersList[i] == null){
                nbrOfOrdersInOrdersList = i;
                break;
            }
        }
        
        String newOrderName = "Order " + (nbrOfOrdersInOrdersList + 1); 

        //Creates new Order object
        Order newOrder = new Order(nbrOfItemsInList, costCurrentOrder, newOrderName);

        //Adds all ordered items to Order history array in Order class
        for (String itemInCurrentOrderArray : currentOrderArray) {
            if(itemInCurrentOrderArray != null){
                newOrder.addToArray(itemInCurrentOrderArray);
            }
        }

        //Loops to find an empty place to add newOrder 
        for (int i = 0; i < ordersList.length; i++) {
           
            if(ordersList[i] == null){

                //When ordersList array is almost full
                if(i == (ordersList.length-1)){
                    increaseOrdersList();
                }

                ordersList[i] = newOrder;
                break;
            }
        }

        //Resets the order array
        currentOrderArray = new String[10];  // for test purposes - remove when not needed more
        nbrOfItemsInList = 0;
        costCurrentOrder = 0;
        pizzaOrdered = false;
        
        view.clearRightPanel(); //Removes information from right panel in GUI
        view.setTextCostLabelRightPanel("TOTAL COST: 0");
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

    //Increases the length of ordersList array
    public void increaseOrdersList(){
        Order[] tempOrdersList = new Order[ordersList.length + 10];

        for (int i = 0; i<ordersList.length; i++){
            if(tempOrdersList[i] == null){
                tempOrdersList[i] = ordersList[i];
            }
        }

        ordersList = tempOrdersList;
    }

    //This method increase the length of the currentOrderArray while it is almost full
    public void increaseCurrentOrderArrayLength(){
        String[] tempCurrentOrderArray = new String[currentOrderArray.length + 10];

        for (int i = 0; i<currentOrderArray.length; i++){
            if(tempCurrentOrderArray[i] == null){
                tempCurrentOrderArray[i] = currentOrderArray[i];
            }
        }

        currentOrderArray = tempCurrentOrderArray;
    }
}

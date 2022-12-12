package model;

public class Order {
    private String[] orderItems;
    private Double orderCost;
    private String orderName;

    public Order(int amountOfItemsInCurrentOrder, double orderCost, String ordername) {
        orderItems = new String[amountOfItemsInCurrentOrder];
        this.orderCost = orderCost;
        this.orderName = ordername;
    }

    //@return
    public String[] getOrderHistory() {
        return orderItems;
    }

    //@return
    public Double getOrderCost() {
        return orderCost;
    }

    //@return
    public String getOrderName(){
        return orderName;
    }

    //Adds item to the orderItems string array
    public void addToArray(String item) {
        for (int i = 0; i<orderItems.length; i++){
            if(orderItems[i] == null){
                orderItems[i] = item;
                break;
            }
        }
    }

}

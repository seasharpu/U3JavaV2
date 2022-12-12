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

    /** Returns a String array that contains all order items
     * @return orderItems
     */
    public String[] getOrderHistory() {
        return orderItems;
    }

    /** Returns the cost of an order
     * @return orderCost
     */
    public Double getOrderCost() {
        return orderCost;
    }

    /** Returns the name of an order.
     * @return orderName
     */
    public String getOrderName(){
        return orderName;
    }

    /** Adds a string version of product object into an array for one order.
     * @param item - String version of product object
     * @author Mehmet
     */
    public void addToArray(String item) {
        for (int i = 0; i<orderItems.length; i++){
            if(orderItems[i] == null){
                orderItems[i] = item;
                break;
            }
        }
    }

}

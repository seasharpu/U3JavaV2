package model;

public class Order {
    private String[] orderItems;
    private Double orderCost;
    private String orderName;

    public Order(int lengthOfOrderHistoryString, double orderCost, String ordername) {
        orderItems = new String[lengthOfOrderHistoryString];
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

    public void addToArray(String order) {
        for (int i = 0; i<orderItems.length; i++){
            if(orderItems[i] == null){
                orderItems[i] = order;
                break;
            }
        }
    }

}

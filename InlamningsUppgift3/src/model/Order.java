package model;

public class Order {
    private String[] orderHistory = new String[10];

    public Order() {}

    //@return
    public String[] getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String[] orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void addToArray(String order) {
        for (int i = 0; i<orderHistory.length; i++){
            if(orderHistory[i] == null){
                orderHistory[i] = order;
                break;
            }
        }
    }

}
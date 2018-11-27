package com.company;

public class Order {
    private String orderText;
    private boolean acceptedOrder = false;
    private boolean newOrder = true;
    private boolean orderDone = false;
    public void orderViewed(){
        this.newOrder = false;
    }
    public void orderAccepted(){
        this.acceptedOrder = true;
    }
    public void orderDone(){
        this.orderDone = true;
    }
    public boolean getDone(){
        return this.orderDone;
    }
    public boolean getAccepted(){
        return this.acceptedOrder;
    }
    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }

    public String getOrderText(){
        return this.orderText;
    }

    public Order(String orderText){
        this.orderText = orderText;
    }
    @Override
    public String toString(){
        String s = "";
        if ( this.acceptedOrder ) {
            s += "Accepted";
        }
        else if ( !this.acceptedOrder){
            s += "Declined";
        }
        String s1 = "";
        if ( this.newOrder){
            s1 += "Checked";
        }
        else
        if ( !this.newOrder ){
            s1 += "Not Checked";
        }
        String s2 = "";
        if ( this.orderDone ){
            s2 += "Done";
        }
        else
        if ( !this.orderDone ){
            s2 += "Not Done";
        }
        return "The order: " + this.orderText + " is " + s + ", " + s1 + " and it's " + s2;
    }
    @Override
    public boolean equals(Object obj){
        if ( obj instanceof  Order){
            Order ord = (Order) obj;
            if (this.orderText.equals(ord.orderText)){
                return true;
            }
            else return false;
        }
        else return false;
    }
}

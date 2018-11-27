package com.company;

import java.util.*;

public class Executor extends User {
    private String username;
    private String password;
    private String name;
    private ArrayList<Order> orders;
    public Executor(String name){
        this.name = name;
    }
    public void setExecutorName(String name){
        this.name = name;
    }
    public void viewOrders(){
        Scanner sc = new Scanner(System.in);
        Order order = super.getOrderPrim();
        System.out.println("Welcome! Is this order is acceptable? Type -Accept- or -Reject-. Without '-'.");
        order.toString();
        String s1 = sc.nextLine();
        if (s1.equals("Accept")){
            order.orderAccepted();
        }
        else
            if (s1.equals("Reject")){
                //for modifying
            }
            System.out.println("If this order has already been done you can type -Done-. If it's not type -Exit-");
            s1 = sc.nextLine();
            if (s1.equals("Done")){
                order.orderDone();
            }
            else if (s1.equals("Exit")){
                orders.add(order);
            }

    }
    public void viewDoneOrAccepted(   ){
        System.out.println("You're going to see the full list of -Done- or -Accepted, but not Done- orders:");
        for(int i = 0; i < orders.size(); i++){
            if (orders.get(i).getDone() || orders.get(i).getAccepted() && !orders.get(i).getDone()){
                System.out.println(orders.get(i).toString());
            }
        }
    }
    @Override
    public void register(){
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your password:");
        String s1 = sc.nextLine();
        this.password = s1;
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Executor){
            Executor ex = (Executor) obj;
            if(this.name.equals(ex.name)){
                return true;
            }
            else return false;
        }
        else return false;
    }
}

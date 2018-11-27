package com.company;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {

    private static Order orderPrim;
    private static String message;
    private static ArrayList<Teacher> tchs;
    public void addTeacher1(Teacher teacher){
        tchs.add(teacher);
    }
    private static ArrayList<Student> stdnts;
    public void addStudent1(Student student){
        stdnts.add(student);
    }

    public ArrayList<Teacher> getTeacher1(){
        return tchs;
    }
    public ArrayList<Student> getStudent1(){
        return stdnts;
    }

    public void setOrderPrim(Order o){
        orderPrim = o;
    }
    public Order getOrderPrim(){
        return orderPrim;
    }
    public void setMessage(String s){
        message = s;
    }
    public String getMessage(){
        return message;
    }
    public abstract void register() throws IOException;

}

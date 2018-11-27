package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Serializable {
    private ArrayList<User> users;
    private String username;
    private String password;
    private String name;

    public Admin(){
    }
    public Admin(String name){
        this.name = name;
        try {
            this.register();
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    public String getAdminName(){
        return this.name;
    }

    public void setAdminName(String name){
        this.name = name;
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your new password:");
        String s1 = sc.nextLine();
        this.password = s1;
    }



    @Override
    public void register() throws IOException{
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your new password:");
        String s1 = sc.nextLine();
        this.password = s1;

        FileOutputStream file = new FileOutputStream("admintPW.txt");
        ObjectOutputStream in = new ObjectOutputStream(file);
        LoginPassword lp = new LoginPassword(this.username, this.password);
        in.writeObject(lp);
        in.close();
        file.close();
    }
    public void addUser(Object user){
            User uss = (User)user;
        try {
            uss.register();
        }
        catch (Exception e){
            System.out.println("Error1");
        }
            users.add(uss);

    }
    public void deleteUser( Object user){
        if (this.users.contains(user)){
            this.users.remove(user);
        }
    }
    public void updateUser(){
        User u;
        int occu = 0;
        u = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user's name and surname");
        String s3 = sc.nextLine();
        System.out.println("Enter user's occupation");
        String s4 = sc.nextLine();
        if (s4.equals("Student")){
            System.out.println("Enter Student's speciality");
            String s5 = sc.nextLine();
            u = new Student(s3, s5);
            occu = 1;
        }
        else
        if (s4.equals("Teacher")){
            System.out.println("Enter Teacher's email");
            String s5 = sc.nextLine();
            System.out.println("Enter Teacher's phone number");
            String s6 = sc.nextLine();
            u= new Teacher(s3, s5, s6);
            occu = 2;
        }
        else
        if (s4.equals("Manager")){
            u = new Manager(s3);
            occu = 3;
        }
        else
        if (s4.equals("Executor")){
            u = new Executor(s3);
            occu = 4;
        }

        System.out.println("Which particular part of the user's info you want to change?");
        while(true) {
            String str = sc.nextLine();
            if(str.equals("exit")){
                break;
            }
            if(str.equals("change name")){
                int i = findUser(u);
                String inp = sc.nextLine();
                if (occu == 1) {
                    Student std = (Student)this.users.get(i);
                    std.setStudentName(inp);
                }
                else
                if (occu == 2) {
                    Teacher std = (Teacher) this.users.get(i);
                    std.setTeacherName(inp);
                }
                else
                if (occu == 3) {
                    Manager std = (Manager) this.users.get(i);
                    std.setName(inp);
                }
                else
                if (occu == 4) {
                    Executor std = (Executor) this.users.get(i);
                    std.setExecutorName(inp);
                }
            }
        }

    }
    public void checkLogs(){
        //coming soon
        //requires test class for providing the streams
    }

    public boolean adminRun(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter command: ");
            String s1 = sc.nextLine();
            if(s1.equals("add user")){
                System.out.println("Enter user's occupation");
                String s2 = sc.nextLine();
                System.out.println("Enter user's name and surname");
                String s3 = sc.nextLine();
                System.out.println("Enter user's occupation");
                String s4 = sc.nextLine();
                if (s4.equals("Student")){
                    System.out.println("Enter Student's speciality");
                    String s5 = sc.nextLine();
                    Student std = new Student(s3, s5);
                    this.addUser(std);
                }
                else
                if (s4.equals("Teacher")){
                    System.out.println("Enter Teacher's email");
                    String s5 = sc.nextLine();
                    System.out.println("Enter Teacher's phone number");
                    String s6 = sc.nextLine();
                    Teacher tch = new Teacher(s3, s5, s6);
                    this.addUser(tch);
                }
                else
                if (s4.equals("Manager")){
                    Manager mng = new Manager(s3);
                    this.addUser(mng);
                }
                else
                if (s4.equals("Executor")){
                    Executor exc = new Executor(s3);
                    this.addUser(exc);
                }
            }
            if (s1.equals("remove user")){
                System.out.println("Enter user's occupation");
                String s2 = sc.nextLine();
                System.out.println("Enter user's name and surname");
                String s3 = sc.nextLine();
                System.out.println("Enter user's occupation");
                String s4 = sc.nextLine();
                if (s4.equals("Student")){
                    System.out.println("Enter Student's speciality");
                    String s5 = sc.nextLine();
                    Student std = new Student(s3, s5);
                    this.deleteUser(std);
                }
                else
                if (s4.equals("Teacher")){
                    System.out.println("Enter Teacher's email");
                    String s5 = sc.nextLine();
                    System.out.println("Enter Teacher's phone number");
                    String s6 = sc.nextLine();
                    Teacher tch = new Teacher(s3, s5, s6);
                    this.deleteUser(tch);
                }
                else
                if (s4.equals("Manager")){
                    Manager mng = new Manager(s3);
                    this.deleteUser(mng);
                }
                else
                if (s4.equals("Executor")){
                    Executor exc = new Executor(s3);
                    this.deleteUser(exc);
                }
            }
            if (s1.equals("update user")){
                this.updateUser();
            }

        }
    }

    public void saveUsers(){


    }

    public int findUser(User user){
        for(int i = 0; i < users.size(); i++){
        if(this.users.get(i).equals(user)){
            return i;
        }
        }
        return -1;
    }

    @Override
    public String toString(){
        return "Admin's name: " + this.name;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Admin){
            if(this.name.equals(((Admin)obj).name)){
                return true;
            }
            else return false;
        }
        else return false;
    }
}

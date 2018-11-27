package com.company;

import sun.plugin2.liveconnect.JavaClass;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //Admin admin = new Admin("Mike Douglas");

        while(true) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Welcome to IntraNet v1.0.");
            System.out.println("Type 'help' to get list of commands");

            String c = br.readLine();

            if(c.equals("login")) {
                System.out.println("Are you an Admin-1, Executor-2, Manager-3, Student-4, Teacher-5 ?");
                String code = br.readLine();
                User us;
                if (Integer.parseInt(code) == 1) {
                    System.out.println("Enter login:");
                    String login = br.readLine();
                    System.out.println("Enter password:");
                    String password = br.readLine();
                    while (true) {
                        try {
                            FileInputStream file = new FileInputStream("admintPW.txt");
                            ObjectInputStream in = new ObjectInputStream(file);
                            LoginPassword s1 = (LoginPassword)in.readObject();
                            LoginPassword s2 = new LoginPassword(login, password);
                            System.out.println(s1);
                            if (s1.equals(s2)) {
                                System.out.println("The user is found.");
                            }
                            Admin a = new Admin();
                            a.adminRun();
                            in.close();
                            file.close();
                        } catch (Exception e) {
                            System.out.println("Exception thrown during test: " + e.toString());
                            break;
                        }
                    }
                } else if (Integer.parseInt(code) == 2) {

                } else if (Integer.parseInt(code) == 3) {

                } else if (Integer.parseInt(code) == 4) {

                } else if (Integer.parseInt(code) == 5) {

                }
            }

            }
        }





    }


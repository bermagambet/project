package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    private String username;
    private String password;
    private String name;
    private int year;
    private double mark;
    private String speciality;
    private ArrayList<Course> courses;
    public Student(String name, String speciality){
        this.name = name;
        this.speciality = speciality;
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
    public void registerCourse(Course course){
        if (course.getAccessSpeciality().equals(this.speciality) && course.getAccessYear() == this.year) {
            this.courses.add(course);
        }
        else
            System.out.println("The subject is not allowed to choose.");
    }

    public String getStudentName(){
        return this.name;
    }
    public int getYear(){
        return this.year;
    }
    public double getMark(){
        return this.mark;
    }
    public String getSpeciality(){
        return this.speciality;
    }

    public void setStudentName(String name){
        this.name = name;
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your new password:");
        String s1 = sc.nextLine();
        this.password = s1;
    }
    public void setYear(int year){
    this.year = year;
    }
    public void setMark(double mark){
    this.mark = mark;
    }
    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void viewTeacher(){
        System.out.println("Type the title of the course: ");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseTitle().equals(s1)){
                System.out.println("System has found this course. Enter teacher's name:");
                String s2 = sc.nextLine();
                for(int j = 0; j < courses.get(i).getTeachers().size(); j++){
                    if (courses.get(i).getTeachers().get(j).getTeacherName().equals(s2)){
                        System.out.println(courses.get(i).getTeachers().get(j).toString());
                    }
                }
            }
        }
    }
    public void viewMarks(){
        System.out.println("Type the title of the course: ");
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseTitle().equals(s1)){
                for(int j = 0; j < courses.get(i).getMarks().size(); j++){
                    System.out.println(courses.get(i).getMarks().get(j).toString());
                }
            }
        }
    }
    public void viewTranscript(){
        for(int i = 0; i < courses.size(); i++){
           System.out.println(courses.get(i).getCourseTitle());
           for(int j = 0; j < courses.get(i).getMarks().size();j++){
               if (courses.get(i).getMarks().get(j).getStudentName().equals(this.name))
               System.out.println(courses.get(i).getMarks().get(j).toString());
           }
        }
    }
    public void calcMark(){
        int sch = 0;
        for(int i = 0; i < courses.size(); i++){
            System.out.println(courses.get(i).getCourseTitle());
            for(int j = 0; j < courses.get(i).getMarks().size();j++){
                if (courses.get(i).getMarks().get(j).getStudentName().equals(this.name)){
                    sch++;
                    this.mark = (mark + Integer.parseInt(courses.get(i).getMarks().get(j).getMarks().get(j).getKeyValue())) / sch;
                }
            }
        }
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Student){
            Student st = (Student) obj;
            if(this.name.equals(st.name) && this.year == st.year){
                return true;
            }
            else return false;
        }
        else return false;
    }
}

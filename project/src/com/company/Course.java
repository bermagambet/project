package com.company;

import java.util.ArrayList;

public class Course{
    private String courseTitle;
    private ArrayList<Student> students;
    private ArrayList<CourseFile> courseFiles;
    private ArrayList<Teacher> teachers;
    private ArrayList<Mark> marks;
    private boolean isOpen = false;
    private int accessYear;
    private String accessSpeciality;

    public Course(){
    }

    public Course(String courseTitle, ArrayList<Student> students, ArrayList<CourseFile> courseFiles, ArrayList<Teacher> teachers){
        this.courseTitle = courseTitle;
        this.students = students;
        this.courseFiles = courseFiles;
        this.teachers = teachers;
    }

    public String getCourseTitle(){
        return this.courseTitle;
    }
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    public ArrayList<CourseFile> getCourseFiles(){
        return this.courseFiles;
    }
    public ArrayList<Mark> getMarks(){
        return this.marks;
    }
    public ArrayList<Teacher> getTeachers(){
        return this.teachers;
    }
    public int getAccessYear(){
        return this.accessYear;
    }
    public String getAccessSpeciality(){
        return this.accessSpeciality;
    }

    public void setAccesability(boolean isOpen, int accessYear, String accessSpeciality){
        this.accessSpeciality = accessSpeciality;
        this.accessYear = accessYear;
        this.isOpen = isOpen;
    }
    public void setCourseTitle(String courseTitle){
        this.courseFiles = courseFiles;
    }
    public void seteStudents(ArrayList<Student> students){
        this.students = students;
    }
    public void setCourseFiles(ArrayList<CourseFile> courseFiles){
        this.courseFiles = courseFiles;
    }
    public void setMarks(ArrayList<Mark> marks){
        this.marks = marks;
    }
    public void setStudents(ArrayList<Teacher> teachers){
        this.teachers = teachers;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void addCourseFile(CourseFile courseFile){
        this.courseFiles.add(courseFile);
    }
    public void addMark(Mark mark){
        this.marks.add(mark);
    }
    @Override
    public String toString(){
        String s = "Title: " + this.getCourseTitle() + "\nList of students:";
        for(int i = 0; i < this.students.size(); i++){
            s += "\n" + students.get(i).toString();
        }
        s += "\nList of Course Files:";
        for(int i = 0; i < this.courseFiles.size(); i++){
            s += "\n" + courseFiles.get(i).toString();
        }
        s += "\nList of Marks:";
        for(int i = 0; i < this.marks.size(); i++){
            s += "\n" + marks.get(i).toString();
        }
        s += ".";
        return s;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Course){
            Course cr = (Course) obj;
            if (this.courseTitle.equals(cr.courseTitle)){
                return true;
            }
            else return false;
        }
        else return false;
    }




}

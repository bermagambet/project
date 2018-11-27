package com.company;

public class Mark extends Course {
    private Student student;
    private String keyValue;
    public Mark(Student student, int digitalNumber){
        this.student = student;
        if(digitalNumber <= 100 && digitalNumber >= 90){
            this.keyValue = "A";
        }
        else
        if(digitalNumber <= 89 && digitalNumber >= 80){
            this.keyValue = "B";
        }
        else
        if(digitalNumber <= 79 && digitalNumber >= 70){
            this.keyValue = "C";
        }
        else
        if(digitalNumber <= 69 && digitalNumber >= 60){
            this.keyValue = "D";
        }
    }
    public String getStudentName(){
        return this.student.getStudentName();
    }
    public String getKeyValue(){
        return  this.keyValue;
    }
    @Override
    public String toString(){
        return "Student: " + this.student + ", Mark: " + keyValue;
     }
     @Override
    public boolean equals(Object obj){
        if(obj instanceof Mark){
            if(this.keyValue.equals(((Mark)obj).keyValue) && this.student.equals(((Mark)obj).student)){
                return true;
            }
            else return false;
        }
        return false;
     }
}

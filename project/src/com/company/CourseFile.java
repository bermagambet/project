package com.company;

import java.util.Calendar;

public class CourseFile extends Course{
    private String courseFileName;
    public CourseFile(String courseFileName){
        this.courseFileName = courseFileName;
    }
    @Override
    public String toString(){
        return this.courseFileName;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof CourseFile){
            if (this.courseFileName.equals(((CourseFile)(obj)).courseFileName)){
                return true;
            }
            else
                return false;
        }
        return false;
    }
}

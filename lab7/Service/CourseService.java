package com.example.lab7.Service;


import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course>courses=new ArrayList<>();

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourses(Course course){
        courses.add(course);
    }

    public boolean update(String id, Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getID().equals(id)){
                courses.set(i,course);
                return true;
            }
        }

        return false;
    }


    public boolean delete(String id){
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getID().equals(id)){
                courses.remove(i);
                return true;
            }
        }
        return false;}


    public boolean applyOffer(String courseID,int percent){
        if(percent<5 || percent>100)return false;
     for(Course c:courses){
    if(c.getID().equalsIgnoreCase(courseID)){
        c.setPrice(c.getPrice()*(percent/100.00)-c.getPrice());
        return true;
    }
     }
        return false;
    }

    public boolean changCourseAvailability(String courseID){
        for (Course c:courses){
            if(c.isAvalible()==true){
                c.setAvalible(false);
            }else{
                c.setAvalible(true);
            }
            return true;
        }
        return false;
    }


    public ArrayList<Course> getCourseByLanguage(String language){
        ArrayList<Course>byLanguge=new ArrayList<>();
        for(Course c:courses){
            if (c.getCourseLanguage().equalsIgnoreCase(language))
                byLanguge.add(c);
        }
        return byLanguge;
    }










}

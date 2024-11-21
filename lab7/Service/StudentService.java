package com.example.lab7.Service;

import com.example.lab7.Model.Course;
import com.example.lab7.Model.Student;
import com.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudent(){
        return students;
    }

    public void addStudent(Student Student){
        students.add(Student);
    }

    public boolean update(String id, Student Student){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getID().equals(id)){
                students.set(i,Student);
                return true;
            }
        }

        return false;
    }


    public boolean delete(String id){
        for (int i = 0; i <students.size() ; i++) {
            if(students.get(i).getID().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;}


    public boolean addReview(String id,String review){
        if(review==null)return false;
        for (Student s:students){
            if(s.getID().equals(id))
                s.setReview(review);
        }
        return true;
    }

    public int GetAverageStudentAge(){
        int ages=0;
        ArrayList<Student>byAge=new ArrayList<>();
        for (Student s:students){
            ages=ages+s.getAge();
        }
        return (int) ages /students.size();
    }


    public boolean SubscribeInNews(String id){
        for (Student s:students){
            if(s.getID().equalsIgnoreCase(id))
                s.setSubscrib(true);
            return true;
        }
        return false;
    }




}

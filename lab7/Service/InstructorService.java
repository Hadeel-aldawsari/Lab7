package com.example.lab7.Service;
import com.example.lab7.Model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructorService {
    ArrayList<Instructor>instructors=new ArrayList<>();

    public ArrayList<Instructor> getInstructors(){
        return instructors;
    }

    public void addCourses(Instructor instructor){
        instructors.add(instructor);
    }

    public boolean update(String id, Instructor instructor){
        for (int i = 0; i < instructors.size(); i++) {
            if(instructors.get(i).getID().equals(id)){
                instructors.set(i,instructor);
                return true;
            }
        }
        return false;
    }


    public boolean delete(String id){
        for (int i = 0; i <instructors.size() ; i++) {
            if(instructors.get(i).getID().equals(id)){
                instructors.remove(i);
                return true;}
        }
        return false;}



    public ArrayList<Instructor>getInstructorByField(String field){
        ArrayList<Instructor>byField=new ArrayList<>();
        for(Instructor in:instructors){
            if(in.getField().equalsIgnoreCase(field))
                byField.add(in);
        }
        return byField;
    }


    public boolean debitBalance(String id,double amount) {
        if (amount<=0)return false;
        for (Instructor in : instructors) {
            if (in.getBalance() > amount) {
                return false;
            }
            in.setBalance(in.getBalance() - amount);
        }
        return true;
    }


    public String classifyInstructor(String id){
        for(Instructor in:instructors){
            if(in.getYearsOfExperience()<=3)return "Beginner";
            if(in.getYearsOfExperience()>=4 && in.getYearsOfExperience()<=8)
             return "Intermediate";

            return "Advanced";
        }
        return null;
    }


    }





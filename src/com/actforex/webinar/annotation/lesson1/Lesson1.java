package com.actforex.webinar.annotation.lesson1;


import com.actforex.webinar.annotation.rtti.ProxyUtils;

import java.util.Date;

public class Lesson1 {
    public static void main(String [] args) {
        try{
            UserRegistration game = Lesson1ProxyFactory.create(new GameRegistration()) ;
            UserRegistration dating = Lesson1ProxyFactory.create(new DatingRegistration()) ;
            UserRegistration job = Lesson1ProxyFactory.create(new JobRegistration()) ;

            // Game - ok
            try{
                System.out.println("Game: ok start");
                game.addUser("Duke", null, "duke@java.com", null, "Ukraine", null, null, null);
                System.out.println("Game: ok end");
            }catch(Exception e){
                System.out.println("Game: "+e.getMessage());
            }
            // Game - fail
            try{
                System.out.println("Game: fail start");
                game.addUser(null, null, "duke@java.com", null, "Ukraine", null, null, null);
            }catch(Exception e){
                System.out.println("Game: "+e.getMessage());
                System.out.println("Game: fail end");
            }
            System.out.println();
            // Dating - ok
            try{
                System.out.println("Dating: ok start");
                dating.addUser("Duke", null, "duke@java.com", new Date(), "Ukraine", null, null, Status.Married);
                System.out.println("Dating: ok end");
            }catch(Exception e){
                System.out.println("Dating: "+e.getMessage());
            }
            // Dating - fail
            try{
                System.out.println("Dating: fail start");
                dating.addUser("Duke", null, "duke@java.com", new Date(), "Ukraine",  null, null, null);
            }catch(Exception e){
                System.out.println("Dating: "+e.getMessage());
                System.out.println("Dating: fail end");
            }
            System.out.println();
            // Job - ok
            try{
                System.out.println("Job: ok start");
                job.addUser("Duke", "Java", "duke@java.com", new Date(), "Ukraine", "Kiev", "Jse", null);
                System.out.println("Job: ok end");
            }catch(Exception e){
                System.out.println("Job: "+e.getMessage());
            }
            // Job - fail
            try{
                System.out.println("Job: fail start");
                job.addUser("Duke", "Java", "duke@java.com",  new Date(), null, "Kiev", "Jse", null);
            }catch(Exception e){
                System.out.println("Job: "+e.getMessage());
                System.out.println("Job: fail end");
            }




        }catch(Exception e){
            System.out.println("MAIN: "+e.getMessage());
        }




    }
}

enum Status{
    Single,
    Married
}
@ProxyUtils.DynamicProxy
interface UserRegistration{
    void addUser(String firstName, String secondName, String email, Date dob, String country, String city, String address, Status status);
}

class GeneralRegistration implements UserRegistration{
    @Override
    public void addUser(String firstName, String secondName,  String email, Date dob, String country, String city, String address,  Status status) {
        System.out.println("Registration is completed. Saving ["+ firstName+","+ secondName+","+email+","+dob+","+ country +","+ city+","+address+","+status+"]");
    }
}

class GameRegistration extends GeneralRegistration{
    @Override
    public void addUser(@Required String firstName, String secondName, @Required String email, Date dob, @Required String country, String city, String address, Status status) {
        super.addUser(firstName, secondName, email, dob, country, city, address, status);
        System.out.println("Welcome to game");
    }
}

class DatingRegistration extends GeneralRegistration{
    @Override
    public void addUser(@Required String firstName, String secondName, @Required String email, @Required Date dob, @Required String country, String city, String address,  @Required Status status) {
        super.addUser(firstName, secondName, email, dob, country, city, address, status);
        System.out.println("Welcome to dating");
    }
}

class JobRegistration extends GeneralRegistration{
    @Override
    public void addUser(@Required String firstName, @Required String secondName, @Required String email, @Required Date dob, @Required String country, @Required String city, @Required String address, Status status) {
        super.addUser(firstName, secondName, email, dob, country, city, address, status);
        System.out.println("Welcome to job");
    }
}

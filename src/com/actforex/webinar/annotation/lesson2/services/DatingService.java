package com.actforex.webinar.annotation.lesson2.services;


import com.actforex.webinar.annotation.lesson2.Start;

public class DatingService implements FreeService {
    @Start
    public void init(){
        System.out.println("DatingService 1 is started");
    }

    public void notInit(){
        System.out.println("DatingService should not be started");
    }
}

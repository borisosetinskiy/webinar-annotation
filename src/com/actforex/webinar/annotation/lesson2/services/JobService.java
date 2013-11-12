package com.actforex.webinar.annotation.lesson2.services;

import com.actforex.webinar.annotation.lesson2.Start;

public class JobService implements FreeService {
    @Start
    public void init1(){
       System.out.println("JobService 1 is started");
    }
    @Start
    public void init2(){
        System.out.println("JobService 2 is started");
    }
}

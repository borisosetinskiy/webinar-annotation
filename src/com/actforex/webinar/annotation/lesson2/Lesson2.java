package com.actforex.webinar.annotation.lesson2;


import com.actforex.webinar.annotation.lesson2.services.CommerceService;
import com.actforex.webinar.annotation.lesson2.services.FreeService;

public class Lesson2 {

    public static void main(String [] args) {
       ServiceManager service =  ServiceManager.getInstance();
       service.<FreeService>start(FreeService.class);
       service.<CommerceService>start(CommerceService.class);
    }
}



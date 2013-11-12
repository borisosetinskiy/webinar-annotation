package com.actforex.webinar.annotation.lesson2.services;


import com.actforex.webinar.annotation.lesson2.Start;

public class TradingService implements CommerceService{
    @Start
    public void begin(){
        System.out.println("TradingService 1 is started");
    }
}

package com.actforex.webinar.annotation.lesson2.services;


import com.actforex.webinar.annotation.lesson2.Start;

public class GameService implements FreeService {
    @Start
    public void startGame1(){
        System.out.println("GameService 1 is started");
    }
    @Start
    public void startGame2(){
        System.out.println("GameService 2 is started");
    }
}

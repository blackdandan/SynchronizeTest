package com.example.blackdandan.synchronizetest;

/**
 * description :
 * Created by blackdandan on 2017/10/16.
 */

public class Pen {

    private static Pen instance = null;
    private Pen(){}
    private String status = "Waiting";
    public static Pen getInstance(){
        if (instance == null){
            synchronized (Pen.class){
                if (instance == null){
                    instance = new Pen();
                }
            }
        }
        return instance;
    }
    public void draw(){
        synchronized (status){
            try {
                System.out.println("do====Pen.draw.status.wait");
                status = "drawing";
                Thread.sleep(5000);
                status = "Waiting";
                status.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public String getStatus(){
        return status;
    }
}

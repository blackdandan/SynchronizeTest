package com.example.blackdandan.synchronizetest;

/**
 * description :
 * Created by blackdandan on 2017/10/16.
 */

public class Child {
    public void pickUpPen(){
        System.out.println("do====pickUpPen be invoked");
        synchronized (Pen.getInstance().getStatus()){
            if (Pen.getInstance().getStatus().equals("drawing")){
                try {
                    Pen.getInstance().getStatus().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("do====pickUpPen===status=="+Pen.getInstance().getStatus()+" THread:"+Thread.currentThread().getId());

            Pen.getInstance().getStatus().notifyAll();
        }

    }
}

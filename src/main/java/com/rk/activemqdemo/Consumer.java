package com.rk.activemqdemo;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "greetings.queue")
    public void listener(String message){
        System.out.println("Received Greetings:"+message);
    }

}

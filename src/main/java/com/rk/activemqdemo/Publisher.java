package com.rk.activemqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class Publisher {

    @Autowired
    private JmsTemplate jmsTemplate;


    @Autowired
    private Queue queue;


    @GetMapping("publish/{msg}")
    public String publishMessage(@PathVariable("msg") String message){
        jmsTemplate.convertAndSend("greetings.queue",message);
        System.out.println("Greeting published");
        return "Published";
    }

}

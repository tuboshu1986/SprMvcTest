package com.hb.spr.service.impl;

import org.springframework.stereotype.Service;

import com.hb.spr.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String returnHello() {
        return "Hello World !!!";
    }
    
}

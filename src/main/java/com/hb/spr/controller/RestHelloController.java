package com.hb.spr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hb.spr.service.HelloService;

@RestController
@RequestMapping("/restHello")
public class RestHelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value="/str", produces="application/json;charset=UTF-8")
    public String helloStr(Model model){
        return helloService.returnHello();
    }
    
    @RequestMapping(value="/hello/{name}", produces="application/json;charset=UTF-8")
    public String hello(@PathVariable String name, HttpServletRequest request){
        request.setAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping(value="/hello", produces="application/xml;charset=UTF-8")
    public Object hello(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "aaa");
        map.put("bbb", "啊啊吖");
        map.put("ccc", "啊啊啊");
        map.put("ddd", "对对对");
        map.put("eee", "呃呃呃");
        map.put("fff", "发发发");
        return map; 
    }

    public HelloService getHelloService()
    {
        return helloService;
    }

    public void setHelloService(HelloService helloService)
    {
        this.helloService = helloService;
    }
    
}

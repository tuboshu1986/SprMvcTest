package com.hb.spr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.spr.service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    @RequestMapping("/str")
    public String helloStr(Model model){
        model.addAttribute("hello", helloService.returnHello());
        return "hello";
    }
    
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name, HttpServletRequest request){
        request.setAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping(value="/hello", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object hello(String id){
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "aaa");
        map.put("bbb", "啊啊吖");
        map.put("ccc", "啊啊啊");
        map.put("ddd", "对对对");
        map.put("eee", "呃呃呃");
        map.put("fff", "发发发");
        map.put("id", id);
        return map; 
    }
    
    @RequestMapping("/exception")
    public String exception(Model model) throws Exception{
        if(model.containsAttribute("说明")){
            throw new Exception("全局异常");
        }
        return "hello";
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

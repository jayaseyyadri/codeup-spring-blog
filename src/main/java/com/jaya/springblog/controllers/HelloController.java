//where it lives
package com.jaya.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// first- annotation
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring";
    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " +name +"!";
    }

//with request mapping indicate path like below:default a get req, can use get/post
    @RequestMapping(path ="/increment/{number}",method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return number +"plus one is " +(number +1) +"!";
    }

}
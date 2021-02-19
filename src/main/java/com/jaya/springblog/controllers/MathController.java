package com.jaya.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numberOne, @PathVariable int numberTwo) {
        return "the sum is " + (numberOne + numberTwo);
    }


    @RequestMapping(path = "/subtract/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int numberOne, @PathVariable int numberTwo) {
        return "the subtract is " + (numberOne - numberTwo);
    }

    @RequestMapping(path = "/multiply/{numberOne}/and/{numberTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int numberOne, @PathVariable int numberTwo) {
        return " the product is " + (numberOne * numberTwo);
    }

    @RequestMapping(path = "/divide/{numOne}/and/{numTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int numOne, @PathVariable int numTwo) {
        return " the result when you divide is " + (numOne / numTwo);
    }

//
//    @RequestMapping(path ="/increment/{number}",method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number){
//        return number +"plus one is " +(number +1) +"!";
//    }
}
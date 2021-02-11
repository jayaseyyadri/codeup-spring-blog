package com.jaya.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping(path = "/posts/view/{body}", method = RequestMethod.GET)
    @ResponseBody
    public String post(@PathVariable String body) {
        return "Hello," + body + "this is the index page!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postIndiviudal(@PathVariable int id) {
        return "vieweing individual posts ";
    }


    @RequestMapping(path = "/posts/create/{test}", method = RequestMethod.GET)
    @ResponseBody
    public String postForm(@PathVariable String test) {
        return " create post here " + test;
    }


    @RequestMapping(path = "/posts/create/{test2}", method = RequestMethod.POST)
    @ResponseBody
    public String viewPost(@PathVariable String test2) {
        return "here are your posts" + test2;
    }

}

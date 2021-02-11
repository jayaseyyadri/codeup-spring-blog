package com.jaya.springblog.controllers;

import com.jaya.springblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@Controller
public class PostController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String post() {
        return "Hello,this is the index page!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postIndividualPost(@PathVariable int id, Post post) {
        post.setBody("Hello there , this is my first post");
        post.setTitle("First Post");
        return "index";
    }


    @RequestMapping(path = "/posts/create/}", method = RequestMethod.GET)
    @ResponseBody
    public String postForm() {
        return " input post data here " ;
    }


    @RequestMapping(path = "/posts/create/", method = RequestMethod.POST)
    @ResponseBody
    public String viewPost(Post post) {


        return "view your created posts";
    }

}

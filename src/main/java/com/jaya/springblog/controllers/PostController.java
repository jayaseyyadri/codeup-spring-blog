//package com.jaya.springblog.controllers;
//
//import com.jaya.springblog.model.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Controller
//public class PostController {
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    public String post(Model model) {
//
//    Post post1 = new Post("First new post","Yaay , lets keep posting");
//    Post post2 = new Post("Second Post","Today is day 2 and this is my second Post");
//
//    List<Post> seeAllPosts = new ArrayList<>();
//       seeAllPosts.add(post1);
//       seeAllPosts.add(post2);
//
//       model.addAttribute("AllPosts",seeAllPosts);
//        return "posts/index";
//    }
//
//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    public String postIndividualPost(Model model) {
//        //add post object into the model
//        Post post = new Post(1,"First Post","wow ,this is my first post!");
//        model.addAttribute("post",post);
//        return "posts/show";
//    }
//
//
//    @RequestMapping(path = "/posts/create/}", method = RequestMethod.GET)
//    @ResponseBody
//    public String postForm() {
//        return " input post data here " ;
//    }
//
//
//    @RequestMapping(path = "/posts/create/", method = RequestMethod.POST)
//    @ResponseBody
//    public String viewPost() {
//        return "view your created posts";
//    }
//
//}


//use Response bosy when we want to get results immediately w/out a view
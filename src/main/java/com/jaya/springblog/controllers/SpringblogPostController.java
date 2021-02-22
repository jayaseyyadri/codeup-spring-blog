package com.jaya.springblog.controllers;

import com.jaya.springblog.model.Post;
import com.jaya.springblog.model.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpringblogPostController {
    private final PostRepository postDao;


    public SpringblogPostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model model){
        //logic to send the attribute
        List<Post> allPosts=postDao.findAll();
        model.addAttribute("posts",allPosts);
        return "posts/index";
        //return view here

    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id,Model model){
        Post onePost =postDao.getOne(id);
        model.addAttribute("post",onePost);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id,@RequestParam String title, @RequestParam String content){
       Post post = new Post(
               id,
               title,
               content
               );
       postDao.save(post);
       return "redirect:/posts";
    }


    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";

        //we use Path Request Param when we need get info from a prepopulated form
        //  path variable when we need to use use a param we declare

    }


}


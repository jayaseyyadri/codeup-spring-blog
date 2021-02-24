package com.jaya.springblog.controllers;

import com.jaya.springblog.model.Post;
import com.jaya.springblog.model.PostRepository;
import com.jaya.springblog.model.User;
import com.jaya.springblog.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpringblogPostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;


    public SpringblogPostController(PostRepository postsDao,UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao=usersDao;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model model){
        //logic to send the attribute
        List<Post> allPosts=postsDao.findAll();
        model.addAttribute("posts",allPosts);
        return "posts/index";
        //return view here

    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id,Model model){
        Post onePost =postsDao.getOne(id);
        model.addAttribute("post",onePost);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id,@RequestParam String title, @RequestParam String content){
       Post post = new Post(
               id,
               title,
               content
               );
       postsDao.save(post);
       return "redirect:/posts";
    }


    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts";

        //we use Path Request Param when we need get info from a prepopulated form
        //  path variable when we need to use use a param we declare

    }

    @GetMapping("/posts/create")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

@PostMapping ("/posts/create")
    public String createPost(@RequestParam String title,@RequestParam String content){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

    User user =usersDao.getOne(0L);
       post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts/"+post.getId();
}

}


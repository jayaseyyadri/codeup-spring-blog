package com.jaya.springblog.controllers;

import com.jaya.springblog.model.Post;
import com.jaya.springblog.model.PostRepository;
import com.jaya.springblog.model.User;
import com.jaya.springblog.model.UserRepository;
import com.jaya.springblog.services.EmailService;
import com.jaya.springblog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SpringblogPostController {

    //    if a property is final has to be injected through constructor
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;
    private final UserService userService;


    public SpringblogPostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService, UserService userService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model model) {
        //logic to send the attribute
        List<Post> allPosts = postsDao.findAll();
        model.addAttribute("posts", allPosts);
        return "posts/index";
        //return view here

    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        Post onePost = postsDao.getOne(id);
        model.addAttribute("post", onePost);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        User temp = userService.loggedInUser();
        if (temp == null) {
            return "redirect:/posts";
        }
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
        User user = usersDao.findAll().get(0);
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {

        if (postsDao.findById(id).isPresent()) {
            postsDao.deleteById(id);
            return "redirect:/posts";
        }
        return "redirect:/posts";
    }

    //we use Path Request Param when we need get info from a prepopulated form
    //  path variable when we need to use use a param we declare


    @GetMapping("/posts/create")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

//        Post post = new Post();
//        post.setTitle(title);
//        post.setContent(content);


        User user = userService.loggedInUser();
        post.setUser(user);
        Post savedPost = postsDao.save(post);
        String subject = "New post created";
        String body = "Dear" + savedPost.getUser().getUsername() + ". Thank you for creating a post ! Your post id is " + savedPost.getId();
        emailService.prepareAndSend(savedPost, subject, body);
        return "redirect:/posts";
    }

}


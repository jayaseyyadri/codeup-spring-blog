package com.jaya.springblog.services;

import com.jaya.springblog.model.User;
import com.jaya.springblog.model.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository usersDao;

    public UserService(UserRepository usersDao){
        this.usersDao=usersDao;
    }

    public User loggedInUser(){
        return usersDao.findAll().get(0);
    }
}

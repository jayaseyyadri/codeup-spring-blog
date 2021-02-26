package com.jaya.springblog.services;

import com.jaya.springblog.model.User;
import com.jaya.springblog.model.UserRepository;
import com.jaya.springblog.model.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository userDao;

    public UserDetailsLoader(UserRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Couldn't find a user for username: " + username);
        }
        return new UserWithRoles(user);
    }
}
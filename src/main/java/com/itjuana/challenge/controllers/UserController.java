package com.itjuana.challenge.controllers;

import com.itjuana.challenge.dao.UserDao;
import com.itjuana.challenge.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = { "http://localhost:4200", "https://itjuana-challenge-web-app-dot-itjuana.uc.r.appspot.com" }, maxAge = 3600)
    @RequestMapping(value = "api/user", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    @CrossOrigin(origins = { "http://localhost:4200", "https://itjuana-challenge-web-app-dot-itjuana.uc.r.appspot.com" }, maxAge = 3600)
    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return userDao.getUser(id);
    }

    @CrossOrigin(origins = { "http://localhost:4200", "https://itjuana-challenge-web-app-dot-itjuana.uc.r.appspot.com" }, maxAge = 3600)
    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userDao.create(user);
    }

    @CrossOrigin(origins = { "http://localhost:4200", "https://itjuana-challenge-web-app-dot-itjuana.uc.r.appspot.com" }, maxAge = 3600)
    @RequestMapping(value = "api/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userDao.update(user);
    }

    @CrossOrigin(origins = { "http://localhost:4200", "https://itjuana-challenge-web-app-dot-itjuana.uc.r.appspot.com" }, maxAge = 3600)
    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable Integer id) {
        userDao.remove(id);
    }
}

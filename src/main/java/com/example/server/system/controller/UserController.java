package com.example.server.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.server.system.model.User;
import com.example.server.system.dao.UserDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserDao userRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addNewUser (@RequestBody User user) {
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(path="/list")
    public @ResponseBody Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }
}
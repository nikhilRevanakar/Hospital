package com.hms.controller;

import com.hms.model.User;
import com.hms.model.UserDto;
import com.hms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //@Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
    
  //@Secured("ROLE_USER")
    @PreAuthorize("hasRole('DOCTOR')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/doctor", method = RequestMethod.GET)
    public String showDoctor(){
        return "hello doctor";
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }



}

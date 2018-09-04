package com.hms.service;

import java.util.List;

import com.hms.model.User;
import com.hms.model.UserDto;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);

    User findById(Long id);
}

package com.itjuana.challenge.dao;

import com.itjuana.challenge.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void create(User user);

    void update(User user);

    void remove(Integer id);
}

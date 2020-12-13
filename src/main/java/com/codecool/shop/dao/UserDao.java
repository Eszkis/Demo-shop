package com.codecool.shop.dao;

import com.codecool.shop.model.*;


public interface UserDao {

    void add(User user);
    User find(int id);
    User find(String string);
    void remove(String username);
    void remove(int id);

}

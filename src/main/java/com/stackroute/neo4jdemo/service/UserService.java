package com.stackroute.neo4jdemo.service;

import com.stackroute.neo4jdemo.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {



    User saveUser(User user);

    Collection<User> getAll();

    void deleteUser(Long id);

    User updateUser(User user,Long userId);

    User getByName(String name);


     User saveRelation(Long userId,Long movieId);
}

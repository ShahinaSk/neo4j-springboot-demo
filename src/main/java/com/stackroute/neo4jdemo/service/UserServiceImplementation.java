package com.stackroute.neo4jdemo.service;


import com.stackroute.neo4jdemo.domain.User;
import com.stackroute.neo4jdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User savedUser=null;

        savedUser=userRepository.createNode(user.getId(),user.getName(),user.getAge());
        return savedUser;

    }

    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteNode(id);
    }

    @Override
    public User updateUser(User user,Long userId) {
        return userRepository.updateNode(userId,user.getName(),user.getAge());
    }

    @Override
    public User getByName(String name) {
        return userRepository.getNode(name);
    }

    @Override
    public User saveRelation(Long userId,Long movieId) {
        return userRepository.createRelation(userId,movieId);
    }



}

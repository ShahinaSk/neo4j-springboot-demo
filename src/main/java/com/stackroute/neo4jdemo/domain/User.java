package com.stackroute.neo4jdemo.domain;


import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class User {

    @Idt
    private  Long id;
    private String name;
    private int age;

    @Relationship(type= "RATED")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public User(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

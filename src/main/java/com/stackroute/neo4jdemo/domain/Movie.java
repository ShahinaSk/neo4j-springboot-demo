package com.stackroute.neo4jdemo.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Movie {

    @Id
    private Long id;
    private String title;
    private String director;

    public Movie() {
    }

    public Movie(Long id, String title, String director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

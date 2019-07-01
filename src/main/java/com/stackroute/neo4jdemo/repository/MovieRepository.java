package com.stackroute.neo4jdemo.repository;

import com.stackroute.neo4jdemo.domain.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie,Long> {

    @Query("MATCH (m:Movie) RETURN m")
    Collection<Movie> getAllMovies();

    @Query("CREATE (m:Movie) SET m.id={id},m.title={title},m.director={director} RETURN m")
    public Movie createNode(Long id, String title,String director);

    @Query("MATCH (m:Movie) WHERE id(n)={id} SET m.title={title},m.director={director} RETURN m")
    Movie updateNode(@Param("id") Long id, @Param("title") String title, @Param("director") String director);

    @Query("MATCH (u:Movie) WHERE u.title={title} RETURN u")
    public Movie getNode(@Param("title") String title);






}

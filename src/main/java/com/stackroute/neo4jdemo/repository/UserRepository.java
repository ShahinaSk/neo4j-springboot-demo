package com.stackroute.neo4jdemo.repository;

import com.stackroute.neo4jdemo.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.age={age} RETURN u")
    User createNode(Long userId, String userName, int age);

    @Query("MATCH (u:User) WHERE id(u)={userId} DETACH DELETE u RETURN 'Deleted User'")
    User deleteNode(Long userId);

    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    User getNode(@Param("userName") String userName);

    @Query("MATCH (u:User) WHERE id(u)={id} SET u.name={name},u.age={age} RETURN u")
    User updateNode(@Param("id") Long id, @Param("name") String name, @Param("age") int age);

    @Query("MATCH (a:User),(b:Movie) WHERE a.id={userId} AND b.id={movieId} CREATE (a)-[r:RATED{rating:9}]->(b) RETURN a")
    User createRelation(@Param("userId") Long userId,@Param("movieId") Long movieId);

}

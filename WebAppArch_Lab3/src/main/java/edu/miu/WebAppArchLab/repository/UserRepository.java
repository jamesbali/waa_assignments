package edu.miu.WebAppArchLab.repository;

import edu.miu.WebAppArchLab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :n")
    List<User> findUsersWithMoreThanNPosts(@Param("n") int n);

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.posts p WHERE p.title = :title")
    List<User>findUsersByPostsTitle(String title);

}

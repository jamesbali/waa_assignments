package edu.miu.WebAppArchLab.repository;

import edu.miu.WebAppArchLab.domain.Comment;
import edu.miu.WebAppArchLab.domain.Post;
import edu.miu.WebAppArchLab.domain.User;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


   // @Query("SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :n")
    List<User> findUsersWithMoreThanNPosts(@Param("n") int n);

    @Query("SELECT DISTINCT u FROM User u JOIN FETCH u.posts p WHERE p.title = :title")
    List<User>findUsersByPostsTitle(String title);

    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId AND c.id = :commentId AND c.post.author = (SELECT u.name FROM User u WHERE u.id = :userId)")
    Optional<Comment> findCommentByUserAndPost(Long userId, Long postId, Long commentId);





}

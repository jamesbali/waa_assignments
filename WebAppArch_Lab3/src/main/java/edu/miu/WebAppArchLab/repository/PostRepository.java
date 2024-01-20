package edu.miu.WebAppArchLab.repository;

import edu.miu.WebAppArchLab.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List <Post> findByTitle(String title);


}

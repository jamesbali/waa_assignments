package edu.miu.WebAppArchLab1.repository;

import edu.miu.WebAppArchLab1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List <Post> findByTitle(String title);


}

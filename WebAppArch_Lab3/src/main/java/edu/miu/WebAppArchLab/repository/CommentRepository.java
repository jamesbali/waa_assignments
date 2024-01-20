package edu.miu.WebAppArchLab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.miu.WebAppArchLab.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


}

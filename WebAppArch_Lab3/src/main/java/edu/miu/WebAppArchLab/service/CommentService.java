package edu.miu.WebAppArchLab.service;

import edu.miu.WebAppArchLab.DTO.CommentDTO;
import edu.miu.WebAppArchLab.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    CommentDTO getCommentById(Long id);

    List <CommentDTO>getAllComments ();

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment (Long id, CommentDTO commentDTO);

    CommentDTO addCommentToPost(Long postId, CommentDTO commentDTO);

    boolean deleteComment(Long id);

    public CommentDTO convertToDTO(Comment comment);

    public Comment convertToEntity(CommentDTO commentDTO);



}

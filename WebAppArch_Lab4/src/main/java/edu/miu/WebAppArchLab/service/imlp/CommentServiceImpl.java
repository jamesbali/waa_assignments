package edu.miu.WebAppArchLab.service.imlp;

import edu.miu.WebAppArchLab.DTO.CommentDTO;
import edu.miu.WebAppArchLab.domain.Comment;
import edu.miu.WebAppArchLab.domain.Post;
import edu.miu.WebAppArchLab.repository.CommentRepository;
import edu.miu.WebAppArchLab.repository.PostRepository;
import edu.miu.WebAppArchLab.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CommentDTO getCommentById(Long id) {

        Comment comment =  commentRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Comment not found"));
        return convertToDTO(comment);

    }
    public List<CommentDTO> getAllComments(){
        List <Comment> comments = commentRepository.findAll();

        return comments.stream().map(comment -> modelMapper.map(comment, CommentDTO.class))
                    .collect(Collectors.toList());
    }

    public  CommentDTO createComment(CommentDTO commentDTO){

        Comment comment = convertToEntity(commentDTO);
        comment = commentRepository.save(comment);
        return convertToDTO(comment);

    }


    public CommentDTO updateComment(Long id, CommentDTO commentDTO){

        Optional<Comment> optionalComment = commentRepository.findById(id);

        if(optionalComment.isPresent()){

            Comment existingComment = optionalComment.get();
            existingComment.setName(commentDTO.getName());

            Comment updatedComment = commentRepository.save(existingComment);
            return modelMapper.map(updatedComment, CommentDTO.class);
        }
        else {
            return null;
        }
    }
    public CommentDTO addCommentToPost(Long postId, CommentDTO commentDTO){

        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){

            Post post = optionalPost.get();
            Comment comment = convertToEntity(commentDTO);
            comment.setPost(post);
            comment = commentRepository.save(comment);
            return modelMapper.map(comment, CommentDTO.class);
        }
        else {
            throw new NoSuchElementException("Post with id " + postId + " not found");
        }
    }

    public boolean deleteComment(Long id){

        Optional<Comment> optionalComment = commentRepository.findById(id);
        if(optionalComment.isPresent()){
            Comment commentToDelete = optionalComment.get();
            commentRepository.delete(commentToDelete);
            return true;
        }
        else {
            return false;
        }
    }

    public CommentDTO convertToDTO(Comment comment){

        return modelMapper.map(comment, CommentDTO.class);
    }

    public Comment convertToEntity(CommentDTO commentDTO){

        return modelMapper.map(commentDTO, Comment.class);
    }



}

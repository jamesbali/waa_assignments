package edu.miu.WebAppArchLab1.service;

import edu.miu.WebAppArchLab1.DTO.PostDTO;
import edu.miu.WebAppArchLab1.domain.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    PostDTO getPostById(Long id);
    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    boolean deletePost(Long id);
    public PostDTO convertToDTO(Post post);

    public Post convertToEntity(PostDTO postDTO);

}

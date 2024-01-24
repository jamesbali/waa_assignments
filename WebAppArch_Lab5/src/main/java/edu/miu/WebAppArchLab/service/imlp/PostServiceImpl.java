package edu.miu.WebAppArchLab.service.imlp;

import edu.miu.WebAppArchLab.DTO.PostDTO;
import edu.miu.WebAppArchLab.domain.Post;
import edu.miu.WebAppArchLab.repository.PostRepository;
import edu.miu.WebAppArchLab.service.PostService;
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
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepositroy;

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO getPostById(Long id) {

        Post post = postRepositroy.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
        return convertToDTO(post);

    }
    public List<PostDTO> getAllPosts() {

        List<Post> posts = postRepositroy.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }
    public PostDTO createPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        post = postRepositroy.save(post);
        return convertToDTO(post);
    }

    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Optional<Post>optionalPost = postRepositroy.findById(id);
        if(optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setTitle(postDTO.getTitle());
            existingPost.setContent(postDTO.getContent());
            existingPost.setAuthor(postDTO.getAuthor());

            Post updatedPost = postRepositroy.save(existingPost);

            return modelMapper.map(updatedPost, PostDTO.class);

        }
        else {
            return null;
        }
    }

    public boolean deletePost(Long id) {

        Optional<Post> optionalPost = postRepositroy.findById(id);
        if(optionalPost.isPresent()) {
            Post postToDelete = optionalPost.get();
            postRepositroy.delete(postToDelete);
            return true;
        }
        else {
            return false;
        }
    }
    public PostDTO convertToDTO(Post post) {

        return modelMapper.map(post, PostDTO.class);
    }
    public Post convertToEntity(PostDTO postDTO) {
        return modelMapper.map(postDTO, Post.class);
    }

}

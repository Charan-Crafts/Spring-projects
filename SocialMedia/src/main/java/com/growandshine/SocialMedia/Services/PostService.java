package com.growandshine.SocialMedia.Services;

import com.growandshine.SocialMedia.DTO.PostDTO.PostRequestDTO;
import com.growandshine.SocialMedia.DTO.PostDTO.PostResponseDTO;
import com.growandshine.SocialMedia.Entites.Posts;
import com.growandshine.SocialMedia.Entites.Users;
import com.growandshine.SocialMedia.Repositories.PostRepository;
import com.growandshine.SocialMedia.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {

        List<Posts> getAllPosts = postRepository.findAll();

        List<PostResponseDTO> allPosts = getAllPosts.stream()
                .map(post->PostResponseDTO.builder()
                        .postId(post.getPostId())
                        .description(post.getDescription())
                        .title(post.getTitle())
                        .likes(post.getLikes())
                        .build()
                ).toList();

        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    public ResponseEntity<String> createNewPost(String userName, PostRequestDTO postRequestDTO) {

        //find the user

        Users user = usersRepository.findByUserName(userName).orElse(null);

        if(user==null){

            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }

        Posts newPost = new Posts();
        newPost.setUser(user);
        newPost.setDescription(postRequestDTO.getDescription());
        newPost.setTitle(postRequestDTO.getTitle());

        postRepository.save(newPost);

        return new ResponseEntity<>("Post added",HttpStatus.CREATED);


    }

    public ResponseEntity<String> likeThePost(String postId) {

        //Get the postById

        Posts post = postRepository.findById(postId).orElse(null);

        if(post==null){
            return new ResponseEntity<>("post not found",HttpStatus.NOT_FOUND);
        }
        post.setLikes(post.getLikes()+1);

        postRepository.save(post);

        return new ResponseEntity<>("Thanks 😊",HttpStatus.OK);
    }
}

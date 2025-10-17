package com.growandshine.SocialMedia.Controllers;

import com.growandshine.SocialMedia.DTO.PostDTO.PostRequestDTO;
import com.growandshine.SocialMedia.DTO.PostDTO.PostResponseDTO;
import com.growandshine.SocialMedia.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostControllers {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(){

        return postService.getAllPosts();
    }

    @PostMapping("/create/{userName}")
    public ResponseEntity<String> createNewPost(@PathVariable String userName, @RequestBody PostRequestDTO postRequestDTO){

        return postService.createNewPost(userName,postRequestDTO);
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<String> like(@PathVariable String postId){

        return postService.likeThePost(postId);
    }
}

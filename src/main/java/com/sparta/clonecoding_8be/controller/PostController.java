package com.sparta.clonecoding_8be.controller;



import com.sparta.clonecoding_8be.dto.EditPostRequestDto;
import com.sparta.clonecoding_8be.dto.PostDetailResponseDto;
import com.sparta.clonecoding_8be.dto.PostRequestDto;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.repository.PostRepository;
import com.sparta.clonecoding_8be.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    // Post 생성
    @PostMapping("/api/posts")
    public PostDetailResponseDto createPosts(@RequestBody PostRequestDto requestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();
        return postService.createPosts(requestDto, username);
    }

    // Post 전체조회
    @GetMapping("/api/posts")
    public List<Post> getAllPosts(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    // Post 상세조회
    @GetMapping("/api/posts/{post_ID}")
    public PostDetailResponseDto getPostDetail(@PathVariable Long post_ID){
        return postService.getPostDetail(post_ID);
    }

    // Post 수정
    @PutMapping("/api/posts/{post_ID}")
    public void editPost(@PathVariable Long post_ID,
                        @RequestBody EditPostRequestDto requestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal=(User) authentication.getPrincipal();
        String username = principal.getUsername();
        postService.editPost(post_ID,requestDto,username);
    }

    // Post 삭제
    @DeleteMapping("/api/posts/{post_ID}")
    public String deletePost(@PathVariable Long post_ID, String Username){
        return postService.deletePost(post_ID, Username);
    }
}
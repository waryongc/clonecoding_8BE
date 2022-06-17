package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.dto.PostDetailResponseDto;
import com.sparta.clonecoding_8be.dto.PostRequestDto;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.repository.PostRepository;
import com.sparta.clonecoding_8be.service.MemberService;
import com.sparta.clonecoding_8be.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // Post 생성
    @PostMapping("/api/posts")
    public String createPosts(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.createPosts(id,requestDto);
    }

    // Post 전체조회
    @GetMapping("/api/posts")
    public ResponseEntity<Post> creatPost()

    // Post 상세조회
    @GetMapping("/api/posts/{post_ID}")
    public PostDetailResponseDto getPostDetail(@PathVariable Long post_ID){
        return postService.getPostDetail(post_ID);
    }

    // Post 수정
    @PutMapping("/api/posts/{post_ID}")
    public PostDetailResponseDto editPost(@PathVariable Long post_ID,@PathVariable Long id){
        return postService.editPost(post_ID);
    }

    // Post 삭제
    @DeleteMapping("/api/posts/{post_ID}")
    public void deletePost(@PathVariable Long post_ID){
        Authentication authentication = SecurityContextHolder.getContext();

        return postService.deletePost(post_ID);
    }

}
package com.sparta.clonecoding_8be.controller;

import com.sparta.clonecoding_8be.dto.CommentRequestDto;
import com.sparta.clonecoding_8be.dto.EditCommentRequestDto;
import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.User;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/api/posts/{postID}/comments")
    public ResponseEntity<Void> registComment(@PathVariable Long postID,
                                              @RequestBody CommentRequestDto commentRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        commentService.saveComment(postID, username, commentRequestDto);
        return ResponseEntity.ok().build();

    }

    //댓글 삭제
    @DeleteMapping("/api/posts/{postID}/comments/{comments}")
    public Boolean deleteComment(@PathVariable Long comments){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Boolean result = false;

        if (username != null) {
            result = commentService.deleteComment(comments, username);
        }
        return result;


    }

    //댓글 수정
    @PutMapping("/api/posts/{postID}/comments/{comments}")
    public Boolean updateComment(@PathVariable Long comments,
                                 @RequestBody EditCommentRequestDto editCommentRequestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();
        Boolean result = false;

        if(username != null){
            result = commentService.updateComment(comments,editCommentRequestDto,username);
        }
        return result;
    }
}

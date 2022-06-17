package com.sparta.clonecoding_8be.service;

import com.sparta.clonecoding_8be.dto.*;
import com.sparta.clonecoding_8be.model.Post;
import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import com.sparta.clonecoding_8be.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    // Post 저장
    @Transactional
    public Post createPosts (PostRequestDto postRequestDto, String username){
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 ID의 회원이 존재하지 않습니다.")
        );
        Post post = new Post(postRequestDto, member);
        postRepository.save(post);

        return post;
    }

    // Post 상세 조회
    public PostDetailResponseDto getPostDetail(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        return new PostDetailResponseDto(post);
    }

    // Post 전체 조회


    // Post 수정
    public void editPost(Long id, EditPostRequestDto requestDto, String Username){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!Objects.equals(Username, post.getMember().getUsername())){
            throw new IllegalArgumentException("본인이 작성한 글만 수정이 가능합니다.");
        }
        post.editPost(requestDto);
        postRepository.save(post);

    }

    // Post 삭제
    public void deletePost(Long id, String Username){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(!Objects.equals(Username, post.getMember().getUsername())){
            throw new IllegalArgumentException("본인이 작성한 글만 삭제가 가능합니다.");
        }
        postRepository.deleteById(id);
    }
}
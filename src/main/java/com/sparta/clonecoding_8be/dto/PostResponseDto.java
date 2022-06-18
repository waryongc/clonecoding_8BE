package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Comment;
import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private String title;
    private Integer price;
    private String contents;
    private String imagefile;
    //좋아요 한 사람들의 아이디 리스트는?
    //comment 수는?
}

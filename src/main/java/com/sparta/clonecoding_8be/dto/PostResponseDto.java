package com.sparta.clonecoding_8be.dto;


import com.sparta.clonecoding_8be.model.Comment;
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
    private String address;
    private LocalDateTime createdAtPost;
    private LocalDateTime modifiedAtPost;
    private List<Comment> commentList;
    int cntComment = commentList.size();



    public PostResponseDto(Long id, String title, Integer price, String contents,
                           String imagefile, String address, LocalDateTime createdAtPost,
                           LocalDateTime modifiedAtPost, int cntComment) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.contents = contents;
        this.imagefile = imagefile;
        this.address = address;
        this.createdAtPost = createdAtPost;
        this.modifiedAtPost = modifiedAtPost;
        this.cntComment = cntComment;
    }


    //좋아요 한 사람들의 아이디 리스트는?
    //comment 수는?

//    this.cntComment = post.getCommentList().size();
}

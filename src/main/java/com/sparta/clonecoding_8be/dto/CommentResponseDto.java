package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private String username;
    private String comment;
    private LocalDateTime createdAtComment;
    private LocalDateTime modifiedAtComment;

    //postingid는?
    //commentid는?
    //username과 userid는?

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.username = comment.getMember().getUsername();
        this.comment = comment.getComment();
        this.createdAtComment = comment.getCreatedAt();
        this.modifiedAtComment = comment.getModifiedAt();
    }
}

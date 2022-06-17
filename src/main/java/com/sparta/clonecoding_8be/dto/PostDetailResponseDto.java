package com.sparta.clonecoding_8be.dto;

import com.sparta.clonecoding_8be.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDetailResponseDto {
    private Long id;
    private String title;
    private Integer price;
    private String contents;
    private String image;

    //modifiedAt ? 민지님께 물어보자

    //commentList ? 해보고 여쭤보자

    public PostDetailResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.contents = post.getContents();
        this.image = post.getImage();
    }

}

package com.sparta.clonecoding_8be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {
    private String title;
    private Integer price;
    private String contents;
    private String image;
}

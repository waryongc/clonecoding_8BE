package com.sparta.clonecoding_8be.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {
    private String username;
    private String nickname;
    private String title;
    private Long price;
    private String contents;
    private String address;
    // address는?
}

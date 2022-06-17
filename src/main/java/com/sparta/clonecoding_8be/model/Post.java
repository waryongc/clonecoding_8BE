package com.sparta.clonecoding_8be.model;

import com.sparta.clonecoding_8be.dto.EditPostRequestDto;
import com.sparta.clonecoding_8be.dto.PostRequestDto;
import com.sparta.clonecoding_8be.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String imagefile;

    //address는 아직 못해봤다.

    @JsonIgnore // 안붙게함
    @ManyToOne // 포스트가 다수니까
    @JoinColumn // 다른 model과 연결하겠다
    private Member member;


    public Post (PostRequestDto postRequestDto, Member member){
        this.title = postRequestDto.getTitle();
        this.price = postRequestDto.getPrice();
        this.contents = postRequestDto.getContents();
        this.imagefile = postRequestDto.getImagefile();
        this.member = member;
    }

    public void editPost(EditPostRequestDto editPostRequestDto){
        this.title = editPostRequestDto.getTitle();
        this.price = editPostRequestDto.getPrice();
        this.contents = editPostRequestDto.getContents();
    }
}

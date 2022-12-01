package com.example.blog.entity;

import com.example.blog.dto.BoardRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto responseDto) {
        this.title = responseDto.getTitle();
        this.content = responseDto.getContent();
        this.writer = responseDto.getWriter();
        this.password = responseDto.getPassword();
    }
}

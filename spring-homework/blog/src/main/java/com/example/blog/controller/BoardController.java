package com.example.blog.controller;

import com.example.blog.dto.BoardListResponseDto;
import com.example.blog.dto.BoardRequestDto;
import com.example.blog.dto.BoardResponseDto;
import com.example.blog.dto.ResponseDto;
import com.example.blog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController                     // json 형식으로 받기 위함
@RequiredArgsConstructor
@RequestMapping("/api")          // 공통적인 url이 겹칠때 사용.
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save/board")                     // 클라이언트로 부터 요청을 받음.
    public ResponseDto saveBoard(@RequestBody BoardRequestDto requestDto) {
        System.out.println("requestDto.getWriter() = " + requestDto.getWriter());           // requestDto 안에 변수 저장됨.
        System.out.println("requestDto.getContent() = " + requestDto.getContent());
        System.out.println("requestDto.getTitle() = " + requestDto.getTitle());
        System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

        ResponseDto responseDto = boardService.saveBoard(requestDto);
        return responseDto;

        //return boardService.saveBoard(requestDto);              // 클라이언트로 전달 , 서비스에서 받아서.
    }
    

    @GetMapping("/get/boards")
    public BoardListResponseDto getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/get/board")
    public BoardResponseDto getBoard(@RequestParam Long id) {
        return boardService.getBoard(id);
    }

    @PutMapping("/update/board/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping("/delete/board/{id}")
    public ResponseDto deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }





}

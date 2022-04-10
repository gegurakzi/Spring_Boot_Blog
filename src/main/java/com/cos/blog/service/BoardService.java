package com.cos.blog.service;


import com.cos.blog.dto.ReplyRequestDto;
import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;

import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void write(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional
    public Board readPage(int id){
        Board selectedBoard = boardRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no board"));
        selectedBoard.setCount(selectedBoard.getCount()+1);
        return selectedBoard;
    }

    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public void deletePosting(int id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updatePosting(int id, Board requestBoard){
        Board board = boardRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("no board"));
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void writeReply(ReplyRequestDto replyDto){

        replyRepository.saveDto(replyDto.getUserId(), replyDto.getBoardId(), replyDto.getContent());
    }

    @Transactional
    public void deleteComment(int id){
        replyRepository.deleteById(id);
    }
}

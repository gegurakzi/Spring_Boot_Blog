package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.Board;
import com.cos.blog.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class BoardController {

    //
    //DTO를 반환하는 Service
    //모델에 DTO를 맵핑하여 불필요한 정보의 노출 줄이기


    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/"})
    public String Index(Model model, @PageableDefault(size=12, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards",  boardService.list(pageable));
        return "index"; // Model에 탬플릿에 필요한 정보를 담으면 자동으로 전달해줌
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.readPage(id));
        return "board/detail"; // Model에 탬플릿에 필요한 정보를 담으면 자동으로 전달해줌
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.readPage(id));
        return "board/updateForm";
    }
}

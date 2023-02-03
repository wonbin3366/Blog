package shop.mtcoding.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.util.Script;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "board" })
    public String main() {
        return "/board/main";
    }

    @GetMapping("/board/{id}/updateForm")
    public String UpdateForm(@PathVariable int id) {
        return "/board/updateForm";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "/board/saveForm";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id) {
        return "/board/detail";
    }

    @PostMapping("/board")
    @ResponseBody
    public String board(String title, String content) {
        int result = boardRepository.insert(title, content);
        if (result != 1) {
            return Script.back("글쓰기 오류");
        }
        return Script.href("글쓰기 성공", "/");
    }

}

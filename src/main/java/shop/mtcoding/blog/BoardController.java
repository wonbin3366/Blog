package shop.mtcoding.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/boardUpdateForm")
    public String boardUpdateForm() {
        return "/board/boardUpdateForm";
    }

    @GetMapping("/")
    public String main() {
        return "/board/main";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "/board/saveForm";
    }

    @GetMapping("/board/detail")
    public String detail() {
        return "/board/detail";
    }

}

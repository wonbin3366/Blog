package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.util.Script;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/user/joinForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "/user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @PostMapping("/join")
    @ResponseBody
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result != 1) {
            return Script.back("회원가입이 잘안됨");
        }
        return Script.href("/loginForm");
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        User principal = userRepository.findByUsernameAndPassword(username, password);
        if (principal == null) {
            return Script.back("로그인 실패");
        }
        session.setAttribute("principal", principal);
        return Script.href("/");
    }

}

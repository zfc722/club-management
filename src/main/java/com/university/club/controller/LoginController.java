package com.university.club.controller;

import com.university.club.mapper.UserMapper;
import com.university.club.model.UserAccount;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    private final UserMapper userMapper;

    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping({"/", "/login"})
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        UserAccount user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("currentUser", user);
            return "redirect:/clubs";
        }
        return "redirect:/login?error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}

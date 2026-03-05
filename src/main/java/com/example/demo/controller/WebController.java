package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserRegistrationForm;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserService userService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("users", userService.searchUsers(keyword));
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @PostMapping("/simulate")
    public String simulate() {
        userService.simulateNewUser();
        return "redirect:/";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute UserRegistrationForm form) {
        User newUser = userService.registerFullUser(form);
        return "redirect:/?createdId=" + newUser.getId();
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}

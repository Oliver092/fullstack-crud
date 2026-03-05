package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserRegistrationForm;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserService userService;

    @GetMapping("/")
    public String index(@RequestParam(required = false) String keyword, Model model) {
        List<User> users;
        if (keyword == null || keyword.isEmpty()) {
            users = userService.getAllUsers();
        } else {
            users = userService.searchUsers(keyword);
        }
        model.addAttribute("users", users);
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

    @PostMapping("/update-user/{id}")
    public String updateUserName(@PathVariable String id, @RequestParam String newName) {
        userService.updateUserName(id, newName);
        return "redirect:/";
    }

    @PostMapping("/add-icon/{id}")
    public String addIcon(@PathVariable String id, @RequestParam String iconName) {
        userService.addIconToUser(id, iconName);
        return "redirect:/";
    }

    @PostMapping("/update-theme/{id}")
    public String updateTheme(@PathVariable String id, @RequestParam String theme, @RequestParam String wallpaper) {
        userService.updateTheme(id, theme, wallpaper);
        return "redirect:/";
    }

    @PostMapping("/delete-icon/{userId}/{iconId}")
    public String deleteIcon(@PathVariable String userId, @PathVariable String iconId) {
        userService.deleteIcon(userId, iconId);
        return "redirect:/";
    }
}

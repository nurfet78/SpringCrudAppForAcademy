package com.academy.controller;

import com.academy.model.User;
import com.academy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
public class UsersController {

    private final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String viewHomePage(Model model) {
        List<User> listUsers = service.getAllUsers();

        model.addAttribute("listUsers", listUsers);

        return "index";
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());

        return "new_user";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "new_user";
        }

        service.saveUser(user);

        return "redirect:/";
    }


    @PostMapping("/updateUser")
    public String updateUser( @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update_user";
        }

        service.updateUser(user);

        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") long id, Model model) {
        User user = service.getUserById(id);

        model.addAttribute("user", user);

        return "update_user";
    }


    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        service.deleteUser(id);

        return "redirect:/";
    }
}

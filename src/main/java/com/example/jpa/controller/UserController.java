package com.example.jpa.controller;

import com.example.jpa.entity.user.User;
import com.example.jpa.service.MultiDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    private final MultiDBService multiDBService;

    @Autowired
    public UserController(MultiDBService multiDBService) {
        this.multiDBService = multiDBService;
    }

    @GetMapping("/users")
    public List<User> getAllCustomers() {
        return multiDBService.findUsersByCusipNumbers();
    }


}

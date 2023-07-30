package com.skypro.exception1.controller;

import com.skypro.exception1.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }
@GetMapping
    public static void registrationOnWebsite(@RequestParam("login") String login,
                                               @RequestParam("password") String password,
                                               @RequestParam("confirmPassword") String confirmPassword) {
    Service.registrationOnWebsite(login, password, confirmPassword);
}
}

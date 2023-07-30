package com.skypro.exception1.controller;

import com.skypro.exception1.WrongLoginException;
import com.skypro.exception1.WrongPasswordException;
import com.skypro.exception1.service.Service;
import com.skypro.exception1.service.ServiceImpl;
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

    public static String registrationOnWebsite(@RequestParam("login") String login,
                                               @RequestParam("password") String password,
                                               @RequestParam("confirmPassword") String confirmPassword) {
        try {
            ServiceImpl.registrationOnWebsite(login, password, confirmPassword);

        } catch (WrongLoginException | WrongPasswordException ex) {
            return(ex.getMessage());
        }
        return "Регистрация пройдена успешно";
    }
}


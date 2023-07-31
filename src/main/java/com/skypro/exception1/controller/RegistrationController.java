package com.skypro.exception1.controller;

import com.skypro.exception1.WrongLoginException;
import com.skypro.exception1.WrongPasswordException;
import com.skypro.exception1.service.RegistrationService;
import com.skypro.exception1.service.RegistrationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping

    public String registrationOnWebsite(@RequestParam("login") String login,
                                        @RequestParam("password") String password,
                                        @RequestParam("confirmPassword") String confirmPassword) {
        try {
            service.registrationOnWebsite(login, password, confirmPassword);

        } catch (WrongLoginException | WrongPasswordException ex) {
            return (ex.getMessage());
        }
        return "Регистрация пройдена успешно";
    }
}


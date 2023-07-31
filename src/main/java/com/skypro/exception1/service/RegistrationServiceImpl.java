package com.skypro.exception1.service;

import com.skypro.exception1.WrongLoginException;
import com.skypro.exception1.WrongPasswordException;

import java.util.regex.Pattern;

@org.springframework.stereotype.Service
public class RegistrationServiceImpl implements RegistrationService {

    private Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    @Override
    public void registrationOnWebsite(String login, String password, String confirmPassword) throws WrongPasswordException {
        checkLogin(login);
        checkPassword(password);
        checkEqualsPassword(password, confirmPassword);
    }


    private void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException(" Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не длиннее 20 символов");
        }
    }


    private void checkPassword(String password) throws WrongPasswordException {
        if (!password.matches(regex.pattern())) {
            throw new WrongPasswordException(" Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не длиннее 20 символов");
        }
    }


    private void checkEqualsPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException(" Пароли не совпадают!");
        }
    }
}

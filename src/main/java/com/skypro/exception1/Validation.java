package com.skypro.exception1;

import java.util.regex.Pattern;

public class Validation {
    private static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");
    public  static void registrationOnWebsite (String login, String password, String confirmPassword) {

    }
    private static void checkLogin(String login) {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException(" Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не длиннее 20 символов");
        }
    }
    private static void checkPassword(String password) throws WrongPasswordException {
        if (!password.matches(regex.pattern())) {
            throw new WrongLoginException(" Пароль должен содержать в себе только латинские буквы, цифры и знак подчеркивания " +
                    "и быть не длиннее 20 символов");
        }

    }
    private static void checkEqualsPassword( String password, String confirmPassword) {}
}

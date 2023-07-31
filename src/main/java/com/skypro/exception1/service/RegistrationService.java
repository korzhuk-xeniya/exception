package com.skypro.exception1.service;

import com.skypro.exception1.WrongLoginException;
import com.skypro.exception1.WrongPasswordException;

import java.util.regex.Pattern;

public interface RegistrationService {


    void registrationOnWebsite(String login, String password, String confirmPassword) throws WrongPasswordException ;


}


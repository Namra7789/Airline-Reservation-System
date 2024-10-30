package com.airline.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.airline.utils.Session;
import com.airline.database.DatabaseConnection;
import com.airline.models.User;
import com.airline.services.UserService;

public class UserController {
    private static UserService userService = new UserService();

    // Regular user login method
    public static boolean loginUser(String username, String password) {
        User user = userService.findUserByUsername(username.trim());
        if (user != null && "user".equals(user.getRole())) { // Only allow regular users
            String hashedInputPassword = userService.hashPassword(password.trim());
            if (hashedInputPassword.equals(user.getPassword())) {
                // Store user ID in session
                Session.setUserId(user.getId());
                return true;
            }
        }
        return false;
    }

    // Employee login method
    public static boolean loginEmployee(String username, String password) {
        User user = userService.findUserByUsername(username.trim());
        if (user != null && "employee".equals(user.getRole())) { // Only allow employees
            String hashedInputPassword = userService.hashPassword(password.trim());
            if (hashedInputPassword.equals(user.getPassword())) {
                // Store employee ID in session
                Session.setUserId(user.getId());
                return true;
            }
        }
        return false;
    }

    public static boolean registerUser(User user) {
        if (userService.findUserByUsername(user.getUsername()) == null) {
            userService.saveUser(user);
            return true;
        } else {
            return false;
        }
    }
}

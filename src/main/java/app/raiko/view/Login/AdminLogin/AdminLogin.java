package app.raiko.view.Login.AdminLogin;

import app.raiko.controller.admin.AdminController;
import app.raiko.exception.NotFoundException;
import app.raiko.model.admin.domain.Admin;

import java.util.Optional;
import java.util.Scanner;


public class AdminLogin {
    public static Optional<Admin> show(AdminController adminController) {
        var countOfTry=0;
        System.out.println("******Login******");
        do {
            System.out.println("please enter your username : ");
            var adminUserName = new Scanner(System.in).next();
            System.out.println("please enter your password : ");
            var adminPassword = new Scanner(System.in).next();
            try {
                var loginedAdmin = adminController.LoginAdmin(adminUserName,adminPassword);
                System.out.println("welcome");
                return Optional.of(loginedAdmin);
            } catch (NotFoundException e) {
                countOfTry++;
                showError(e.getMessage());
            }
        }while (countOfTry<3);
        return Optional.empty();
    }
    private static void showError(String message) {
        System.out.println(message);
    }
}


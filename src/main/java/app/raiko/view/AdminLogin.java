package app.raiko.view;

import app.raiko.controller.admin.AdminController;
import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.util.Scanner;

@AllArgsConstructor
@Setter
@Getter
public class AdminLogin {
    private AdminController adminController;
    private Admin admin;


    public void show() {
        System.out.println("please enter your username : ");
        var adminUserName = new Scanner(System.in).next();
        System.out.println("please enter your password : ");
        var adminPassword = new Scanner(System.in).next();

        try {
            var LoginAdmin = adminController.LoginAdmin(adminUserName,adminPassword);
            System.out.println("welcome");
            setAdmin(LoginAdmin);
        } catch (NotFoundAdminException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        System.out.println(message);
    }
}


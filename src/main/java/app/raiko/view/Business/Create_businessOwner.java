package app.raiko.view.Business;

import app.raiko.controller.businessOwner.BusinessOwnerController;
import app.raiko.exception.NotFoundException;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class Create_businessOwner {
    private BusinessOwnerController businessController;
    private Admin admin;
    public void createBusinessOwner(){

        System.out.println("please insert BusinessOwner data!!");

        Scanner scanner=new Scanner(System.in);
        System.out.println("firstname : ");
       var firstName=scanner.next();
       System.out.println("lastName : ");
       var lastName=scanner.next();
       System.out.println("nationalCode : ");
       var nationalCode=scanner.next();
       System.out.println("phoneNumber : ");
       var phoneNumber=scanner.next();


      var businessOwner=new BusinessOwner(
             0,firstName,lastName,nationalCode,phoneNumber,admin.getId()
      );

        try {
            var newBusinessOwner = businessController.createBusinessOwner(null,businessOwner);
            System.out.println("done");
            return;
        } catch (NotFoundException e) {
            showError(e.getMessage());
        }
    }
    private void showError(String message) {
        System.out.println(message);
    }
}

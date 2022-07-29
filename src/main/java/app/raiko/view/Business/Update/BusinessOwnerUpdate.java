package app.raiko.view.Business.Update;

import app.raiko.controller.businessOwner.BusinessOwnerController;
import app.raiko.exception.NotFoundException;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;

import java.util.Scanner;

public class BusinessOwnerUpdate {
    public static void editBusinnessOwner(BusinessOwnerController businessController, Admin admin){
        System.out.println("please insert BusinnessOwner id");
        Scanner scanner =new Scanner(System.in);
        var id= scanner.nextInt();
        System.out.println("new firstname : ");
        var firstName=scanner.next();
        System.out.println("new lastName : ");
        var lastName=scanner.next();
        System.out.println("new nationalCode : ");
        var nationalCode=scanner.next();
        System.out.println("new phoneNumber : ");
        var phoneNumber=scanner.next();
        var businessOwner=new BusinessOwner(
                0,firstName,lastName,nationalCode,phoneNumber,admin.getId()
        );
        try {
            var updated = businessController.editBusinessOwner(id,businessOwner);
            System.out.println("done");
            return;
        } catch (NotFoundException e) {
            showError(e.getMessage());
        }
    }
    private static void showError(String message) {
        System.out.println(message);
    }
}

package org.example;

//import org.example.Utils.UtilsLibrary;

import org.example.Utils.PasswordValidator;
import org.example.Utils.UtilsLibrary;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean bInput = false;
        boolean bGenerate = false;

        // until one is true
        while (!bInput && !bGenerate) {

            UtilsLibrary.printText(1, "Hallo, wie kann ich ihnen helfen?", 0);
            UtilsLibrary.printText(0, "1 = Passwort eingeben, 2 = Passwort automatisch generieren, 0 = Exit", 0);

            // trim will shorten the string to its "actual" literal input
            String input = sc.nextLine().trim();
            if (input.isBlank() || !Character.isDigit(input.charAt(0))) {
                continue;
            }

            int num = Integer.parseInt(input);
            switch (num) {
                case 1:
                    bInput = true;
                    break;
                case 2:
                    bGenerate = true;
                    break;
                case 0:
                    UtilsLibrary.printText(1, "Auf Wiedersehen!", 1);
                    return;
                default:
                    continue;

            }
        }

        // TODO: list input allowed
        UtilsLibrary.printText(1, "Bitte geben sie ihren Namen ein: ", 0);
        String Name = sc.nextLine();
        UtilsLibrary.printText(1, "Hallo " + Name, 1);

        // TODO:add while password != confirmationPassword or 0 = exit
        if (bInput) {

            boolean bContinue = true;

            while (bContinue) {

                UtilsLibrary.printText(0, "Bitte Passwort eingeben: ", 0);

                String password = sc.nextLine();
                if (PasswordValidator.isValid(password))
                    bContinue = false;
                ;
            }


//            while (!password.equals(confirmationPassword)) {
//
//                UtilsLibrary.printText(1, "Bitte Passwort bestätigen: ", 0);
//                confirmationPassword = sc.nextLine();
//
//                if (confirmationPassword.equals(password)) {
//                    UtilsLibrary.printText(1, "Danke " + Name, 0);
//                    UtilsLibrary.printText(0, "Ihr Passwort wurde gespeichert", 0);
//
//                    String savedPassword = confirmationPassword;
//
//                    UtilsLibrary.printText(1, "Auf wiedersehen...", 1);
//
//                } else {
//                    UtilsLibrary.printText(1, "Eingaben stimmen nicht überein!", 1);
//                }
//            }

        }
    }


//        UtilsLibrary.printText(1, "Ihr Passwort lautet: " + InputPassword, 1);
//
//        String outPut = "Passwort akzeptiert!";
//        if(!PasswordValidator.isValid(InputPassword)) {
//
//            outPut = "Passwort nicht akzeptiert!";
//        }
//
//        UtilsLibrary.printText(2, outPut, 1);


}

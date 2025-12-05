package org.example;

//import org.example.Utils.UtilsLibrary;

import org.example.Utils.PasswordValidator;
import org.example.Utils.UtilsLibrary;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);

        boolean bExit = false;
        boolean bGenerate = false;
        boolean bInput = false;

        while (!bExit && !bGenerate && !bInput) {

            UtilsLibrary.printText(1, "Hallo, wie kann ich ihnen helfen?", 0);
            UtilsLibrary.printText(0, "1 = Passwort eingeben, 2 = Passwort automatisch generieren, 0 = Exit", 0);
            String Input = sc.nextLine();
            if (Input.isEmpty() || Input.length() > 1 || !Input.matches("[0-2]")) {

                continue;

            }

            if (Input.equals("1")) {
                bInput = true;
            } else if (Input.matches("2")) {
                bGenerate = true;
            } else {
                bExit = true;
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
}

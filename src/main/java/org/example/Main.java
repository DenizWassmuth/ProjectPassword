package org.example;

//import org.example.Utils.UtilsLibrary;

import org.example.Utils.PasswordValidator;
import org.example.Utils.UtilsLibrary;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);

        UtilsLibrary.printText(1, "Hallo, bitte geben sie ein Password ein: ", 0);
        String InputPassword = sc.nextLine();

        UtilsLibrary.printText(1, "Ihr Passwort lautet: " + InputPassword, 1);

        String outPut = "Passwort akzeptiert!";
        if(!PasswordValidator.isValid(InputPassword)) {

            outPut = "Passwort nicht akzeptiert!";
        }

        UtilsLibrary.printText(2, outPut, 1);

    }
}

/*
Exceptions

Exercise 1
Create a class called ”NemIdAuthorizer”. NemIdAuthorizer has a method called isValidInput that returns a boolean value.
isValidInput receives two parameters: String cpr & String password.
• If cpr does not adhere to a valid cpr number - it will throw a new Input- MismatchException
• If InputMismatchException is thrown - the program will inform the user and request another input
 */

/*
Exercise 2
Write a data source for NemIdAuthorizer. The data source is a .csv file with 2 columns: Username & Password.
Expand the program such that a custom exception ”NoSuchUserException” is thrown, if a certain user does not exist.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NemIdAuthorizer {
    public void fileReader(){
        try {
            File file = new File("src/Source");
            Scanner fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Fil mangler.");
        }

    }

    static boolean isValidInput(String cpr, String password) /*throws InputMismatchException*/{
        if(cpr.length() != 10 || !isNumeric(cpr)){
            return false;
            //throw new InputMismatchException();
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Indtast dir CPR-nummeruden bindestreg.");
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            String cprInput = sc.nextLine();
            try {
                isValidInput(cprInput, "");
                String gemtCPR = cprInput;
                System.out.println("CPR er indtastet.");
                end = true;
            } catch (InputMismatchException exception) {
                System.out.println("Input ikke forstået. Prøv igen.");
            }
        }

    }

    //Denne metode bruges til at undersøge, om et string-input er et tal.
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

/*
public class NoSuchUserException extends  {
    NoSuchUserException(){
        super("Bruger findes ikke");
    }
}

 */
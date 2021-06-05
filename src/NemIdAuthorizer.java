/*
Exceptions

Exercise 1
Create a class called ”NemIdAuthorizer”. NemIdAuthorizer has a method called isValidInput that returns a boolean value.
isValidInput receives two parameters: String cpr & String password.
• If cpr does not adhere to a valid cpr number - it will throw a new InputMismatchException
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

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class NemIdAuthorizer {

    //Her kaldes alle metoderne, og exceptions catches.
    public static void main(String[] args) {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("Indtast dit CPR-nummer uden bindestreg:");
                Scanner sc = new Scanner(System.in);
                String cprInput = sc.nextLine();
                System.out.println("Indtast kodeord:");
                String passwordInput = sc.nextLine();

                isValidInput(cprInput, passwordInput);
                File file = new File("src/Source");
                Scanner fileScanner = new Scanner(file);
                userExists(fileScanner, cprInput, passwordInput);
                Scanner fileScanner2 = new Scanner(file);
                //Skipper metadatalinjen
                fileScanner2.nextLine();

                while (fileScanner2.hasNext()) {
                    String currentUser = fileScanner2.nextLine();

                    String [] userArray = currentUser.split(";");

                    if (cprInput.equals(userArray[0]) && passwordInput.equals(userArray[1])){
                    }
                    else {

                    }
                }


                System.out.println("Dit NemID er gyldigt.");
                end = true;
                break;
            } catch (InputMismatchException | FileNotFoundException | NoSuchUserException | WrongPasswordExceptions exception ) {
                System.out.println(exception);
            }
        }

    }


    //Denne metode tester, om CPR- og passwordinputtet overholder kravene og returnerer resultatet som en boolean-værdi.
    static boolean isValidInput(String cpr, String password) throws WrongPasswordExceptions {
        if(cpr.length() != 10 || !isNumeric(cpr) || parseInt(cpr.substring(0,2))>31 || parseInt(cpr.substring(2,4))>12
                || parseInt(cpr.substring(0,2))==00 || parseInt(cpr.substring(2,4))==00){
            throw new InputMismatchException("Ugyldigt CPR-nummer. Prøv igen.");
        }
        else{
            if(password.length()!=4 || !isNumeric(password)){
                throw new WrongPasswordExceptions("Forkert password. Prøv igen.");
            } else{
                return true;
            }
        }
    }




    //Denne metode scanner en fil for at se, om en bruger eksisterer.
    static boolean userExists(Scanner fileScanner, String cpr, String password) throws NoSuchUserException {
        boolean result = false;

        while (fileScanner.hasNextLine()) {
            if (fileScanner.nextLine().equals(cpr + ";" + password)) {
                result = true;
            }
        }
        if (result == true) {
            return true;
        } else {
            throw new NoSuchUserException("Brugeren findes ikke. Prøv igen.");
        }

    }

    //Denne metode bruges til at undersøge, om et string-input er et tal.
    public static boolean isNumeric(String str) {
        try {
            parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //Her opretter jeg min egen exception, som opgaven dikterer det.
    public static class NoSuchUserException extends Exception {
        public NoSuchUserException(String errorMessage) {
            super(errorMessage);
        }
    }

    //Her opretter jeg en ekstra custom exception, så jeg kan skelne mellem forkert CPR og forkert password.
    public static class WrongPasswordExceptions extends Exception {
        public WrongPasswordExceptions(String errorMessage) {
            super(errorMessage);
        }
    }

}
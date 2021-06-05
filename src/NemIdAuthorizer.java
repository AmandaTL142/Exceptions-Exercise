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

    static boolean isValidInput(String cpr, String password) {
        if(cpr.length() != 10 || !isNumeric(cpr) || parseInt(cpr.substring(0,2))>31 || parseInt(cpr.substring(2,4))>12
                || parseInt(cpr.substring(0,2))==00 || parseInt(cpr.substring(2,4))==00){
            throw new InputMismatchException();
        }
        else{
            return true;
        }
    }

    static boolean userExists(File file, String cpr, String password) throws FileNotFoundException, NoSuchUserException {
        boolean result = false;

        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            if (fileScanner.nextLine().equals(cpr + ";" + password)) {
                result = true;
            }
        }
        if (result == true) {
            return true;
        } else {
            throw new NoSuchUserException();
        }

    }

    public static void main(String[] args) {
        System.out.println("Indtast dit CPR-nummeruden bindestreg:");
        Scanner sc = new Scanner(System.in);
        String cprInput = sc.nextLine();
        System.out.println("Indtast kodeord:");
        String passwordInput = sc.nextLine();

        boolean end = false;
        while (!end) {
            try {
                isValidInput(cprInput, passwordInput);
                File file = new File("src/Source");
                userExists(file, cprInput, passwordInput);

                Scanner fileScanner = new Scanner(file);

                //Skipper metadatalinjen
                fileScanner.nextLine();

                while (fileScanner.hasNext()) {
                    String currentUser = fileScanner.nextLine();

                    String [] userArray = currentUser.split(";");

                    if (cprInput.equals(userArray[0]) && passwordInput.equals(userArray[1])){
                    }
                    else {

                    }
                }


                System.out.println("CPR er indtastet.");
                end = true;
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Ugyldigt CPR-nummer. Prøv igen.\nIndtast CPR nummer:");
                cprInput = sc.nextLine();
                System.out.println("Indtast kodeord:");
                passwordInput = sc.nextLine();
            } catch(FileNotFoundException exception){
                System.out.println("Filen findes ikke. Prøv igen.\nIndtast CPR nummer:");
                cprInput = sc.nextLine();
                System.out.println("Indtast kodeord:");
                passwordInput = sc.nextLine();
            }catch(NoSuchUserException exception){
                System.out.println("Brugeren findes ikke. Prøv igen.\nIndtast CPR nummer:");
                cprInput = sc.nextLine();
                System.out.println("Indtast kodeord:");
                passwordInput = sc.nextLine();
            }
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


    public static class NoSuchUserException extends Exception {
        public NoSuchUserException() {
            super();
        }
    }

}
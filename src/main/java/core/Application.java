package core;

import enums.Gender;

import java.util.Scanner;

public class Application implements Runnable {

    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        printCommands();

        String command = "";
        while (!command.equals("Exit")) {
            command = scanner.nextLine();
            switch (command) {
                case "Create account":
                    createAccount();
                    break;
                case "Sing in":
                    signInProcess();
                    break;
                case "Exit":
                    System.out.println("Library application turning off...");
                    break;
                default:
                    System.out.println("Invalid command! Enter again:");
            }
        }
    }

    private void signInProcess() {
        System.out.println("Enter \"username\", \"password\"");
        String[] usernamePassword = scanner.nextLine().split(", ");
        controller.singIn(usernamePassword[0], usernamePassword[1]);

    }

    private void createAccount() {
        System.out.println("Do you agree with the terms of the use of personal data ? (Yes/No)");
        String isAgree = scanner.nextLine();
        if (isAgree.equalsIgnoreCase("No")) {
            System.out.println("We can't create account if you are not agree. Enter new command: ");
        }

        System.out.println("Enter data in order: " +
                "(first name), (last name), (country), (city), (address), (e-mail), (gender -> Male/Female), (age)");
        String[] userData = scanner.nextLine().split(", ");

        System.out.println("(username), (password)");
        String[] usernamePassword = scanner.nextLine().split(", ");

        String firstName = userData[0];
        String lastName = userData[1];
        String country = userData[2];
        String city = userData[3];
        String address = userData[4];
        String email =  userData[5];
        String gender =  userData[6];
        String age = userData[7];
        String username = usernamePassword[0];
        String password = usernamePassword[1];

        controller.createAccount(firstName, lastName, country, city, address, email, gender, age, username, password);
        System.out.println("You can sign in your account!\n" + "Enter command:");
    }

    private void printCommands() {
        System.out.println("Welcome!\n" +
                "Our commands are \"Create account\", \"Sign in\" and \"Exit\"\n" +
                "Create your account or sign in.");
    }

}

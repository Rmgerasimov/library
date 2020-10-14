package core;

import models.people.User;

import java.util.Scanner;

public class Application implements Runnable {

    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Welcome!");
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
                case "Help":
                    printCommands();
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

        User user = controller.signIn(usernamePassword[0], usernamePassword[1]);
        if (user == null) {
            System.out.println("Invalid username or password!\nEnter new command:");
            return;
        }

        String instruction = "";
        while (!instruction.equals("Sign out")) {
            instruction = scanner.nextLine();
            switch (instruction) {
                case "Find book by title":
                    findBookByTitle();
                    break;
                case "Find books by author":
                    findBooksByAuthor();
                    break;
                case "Add paper book":
                    addPaperBook();
                    break;
                case "Add electronic book":
                    addElectronicBook();
                    break;
                case "Borrow the book":
                    borrowBook();
                    break;
                case "Read the book online":
                    readBookOnline();
                    break;
                case "Download the book":
                    downloadBook();
                    break;
                case "Get all books":
                    getAllBooks();
                    break;
                case "Help":
                    printInstruction();
                    break;
                case "Sign out":
                    System.out.println("Signing out...");
                    break;
                default:
                    System.out.println("Invalid command! Enter again:");
            }
        }


    }

    private void getAllBooks() {
        // todo
    }

    private void downloadBook() {
        // todo
    }

    private void readBookOnline() {
        // todo
    }

    private void borrowBook() {
        // todo
    }

    private void addElectronicBook() {
//        controller
        // todo
    }

    private void addPaperBook() {
        System.out.println("Enter data in order: " +
                "(title), (genre), (summary), (isbn), (pages), (year of publication), (total copies), " +
                "(author's name) -> one or many authors with delimiter \";\"");
        String[] bookData = scanner.nextLine().split(", ");

        String title = bookData[0];
        String bookGenre = bookData[1];
        String summary = bookData[2];
        String isbn = bookData[3];
        String pages = bookData[4];
        String yearOfPublication = bookData[5];
        String totalCopies = bookData[6];
        String[] separatedAuthors = bookData[7].split("; ");

        controller.addPaperBook(title, bookGenre, summary, isbn, pages, yearOfPublication, totalCopies, separatedAuthors);
        System.out.println("The book is added!");
    }

    private void findBooksByAuthor() {
        // todo
    }

    private void findBookByTitle() {
        // todo
    }

    private void createAccount() {
        System.out.println("Do you agree with the terms of the use of personal data ? (Yes/No)");
        String isAgree = scanner.nextLine();
        if (isAgree.equalsIgnoreCase("No")) {
            System.out.println("We can't create account if you are not agree. Enter new command: ");
            return;
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
        String email = userData[5];
        String gender = userData[6];
        String age = userData[7];
        String username = usernamePassword[0];
        String password = usernamePassword[1];

        controller.createAccount(firstName, lastName, country, city, address, email, gender, age, username, password);
        System.out.println("You can sign in your account!\n" + "Enter command:");
    }

    private void printInstruction() {
        // todo
    }

    private void printCommands() {
        System.out.println("Our commands are \"Create account\", \"Sign in\" and \"Exit\"\n" +
                "Create your account or sign in.");
    }
}

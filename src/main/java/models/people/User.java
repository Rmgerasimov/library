package models.people;

import models.History;
import models.books.Book;

import static validation.GeneralValidation.isValidInteger;
import static validation.GeneralValidation.isValidString;

public class User extends Person {
    private static final String INVALID_CITY = "City cannot be null or empty!";
    private static final String INVALID_ADDRESS = "Address cannot be null or empty!";
    private static final String INVALID_EMAIL = "Email cannot be null or empty!";
    private static final String INVALID_AGE = "Age cannot be zero or lower!";
    private static final String INVALID_USERNAME = "Username cannot be null or empty!";
    private static final String INVALID_PASSWORD = "Password cannot be null or empty!";

    private Book wantedBook;
    private final History history = new History();
    private final String city;
    private final String address;
    private final String email;
    private final Gender gender;
    private final String username;
    private final String password;
    private final int age;

    public User(String firstName, String lastName, String country, String city,
                String address, String email, Gender gender, int age, String username, String password) {

        super(firstName, lastName, country);
        validateParameters(city, address, email, age, username, password);
        this.city = city;
        this.address = address;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    private void validateParameters(String city, String address, String email, int age, String username, String password) {
        isValidString(city, INVALID_CITY);
        isValidString(address, INVALID_ADDRESS);
        isValidString(email, INVALID_EMAIL);
        isValidInteger(age, INVALID_AGE);
        isValidString(username, INVALID_USERNAME);
        isValidString(password, INVALID_PASSWORD);
    }

    public String getPassword() {
        return password;
    }

    public History getHistory() {
        return history;
    }

    public Book getWantedBook() {
        return wantedBook;
    }

    public void setWantedBook(Book book) {
        wantedBook = book;
    }
}

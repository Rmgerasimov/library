package controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.UserRepository;

import static models.people.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    UserController userController = new UserController();
    UserRepository userRepository = UserRepository.getInstance();

    @BeforeEach
    public void initAccount() {
        userController.createAccount(true, "Rado", "Gerasimov",
                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
                "Pardop", "12345");
    }

    @Test
    public void testCreateAccount() {
        String account = userController.createAccount(true, "Rado", "Gerasimov",
                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
                "Pardop", "12345");

        assertTrue(userRepository.checkForEqualUsername("Pardop"));
        assertEquals("Username already exist", account);
    }

    @Test
    public void testCreateAccountWithoutTermAgree() {
        // GIVEN
        // WHEN
        String account = userController.createAccount(false, "Rado", "Gerasimov",
                "Bulgaria", "Vidin", "Vida", "Rmgerasimov@abv.bg", MALE, 23,
                "Pardop", "12345");

        assertEquals("We can't create account if you are not agree with the terms!", account);
    }

    @Test
    public void testSignInWithRightParameters() {
        // GIVEN

        // WHEN
        boolean isTrue = userController.signIn("Pardop", "12345");

        // THEN
        assertTrue(isTrue);
    }

    @Test
    public void testSignInWithWrongUsername() {
        // GIVEN
        // WHEN
        boolean isFalse = userController.signIn("Rado", "12345");

        // THEN
        assertFalse(isFalse);
    }

    @Test
    public void testSignInWithWrongPassword() {
        // GIVEN
        // WHEN
        boolean isFalse = userController.signIn("Pardop", "84462562");

        // THEN
        assertFalse(isFalse);
    }
}
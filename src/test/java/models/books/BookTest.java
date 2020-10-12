package models.books;

import exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;

import static models.enums.Genre.HISTORICAL;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testTitleEmptyShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testTitleNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook(null, HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testGenreNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", null, "Imalo edno vreme...",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testSummaryNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, null,
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testSummaryEmptyShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testIsbnNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        null, 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testIsbnEmptyShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "  ", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testPagesZeroShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 0, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void testYearZeroShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 152, 0,
                        "Here comes the link", null));
    }

    @Test
    public void testYearUpperBoundShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 152, 2021,
                        "Here comes the link", null));
    }
}

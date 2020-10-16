package models.books;

import validation.InvalidParameterException;
import org.junit.jupiter.api.Test;

import static models.books.BookGenre.AUTOBIOGRAPHY;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void bookIsCreated_withEmptyTitleName_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withNullTitleName_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook(null, AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withNullSummary_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, null,
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withEmptySummary_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "",
                        "5452156698", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withNullIsbn_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        null, 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withEmptyIsbn_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "  ", 280, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withZeroPages_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 0, 2020,
                        "Here comes the link", null));
    }

    @Test
    public void bookIsCreated_withInvalidYear_shouldThrowException() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 152, 0,
                        "Here comes the link", null));
    }
}

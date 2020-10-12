package models.books;

import exceptions.InvalidParameterException;
import org.junit.jupiter.api.Test;

import static models.enums.Genre.HISTORICAL;
import static org.junit.jupiter.api.Assertions.*;

class PaperBookTest {

    @Test
    public void testTotalCopiesNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new PaperBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 152, 2020, 0));
    }

    @Test
    public void testAvailableCopies() {
        PaperBook paperBook = new PaperBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                "5452156698", 152, 2020, 25);
        assertEquals(paperBook.getTotalCopies(), paperBook.getAvailableCopies());
    }

    @Test
    public void testPaperBookShouldBeFine() {
        new PaperBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                "5452156698", 152, 2020, 25);
    }
}

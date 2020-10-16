package models.books;

import org.junit.jupiter.api.Test;
import validation.InvalidParameterException;

import static models.books.BookGenre.AUTOBIOGRAPHY;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElectronicBookTest {

    @Test
    public void testReadLinkEmptyShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 152, 2020,
                        "", null));
    }

    @Test
    public void testReadLinkNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", AUTOBIOGRAPHY, "Imalo edno vreme...",
                        "5452156698", 152, 2020,
                        null, null));
    }

    @Test
    public void testDownloadLinkWhenIsNullOrEmpty() {

    }

    @Test
    public void testElectronicBookShouldBeFine() {

    }
}

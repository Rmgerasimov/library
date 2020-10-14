package models.books;

import common.InvalidParameterException;
import org.junit.jupiter.api.Test;

import static enums.BookGenre.HISTORICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElectronicBookTest {

    @Test
    public void testReadLinkEmptyShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 152, 2020,
                        "", null));
    }

    @Test
    public void testReadLinkNullShouldThrow() {
        assertThrows(InvalidParameterException.class, () ->
                new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                        "5452156698", 152, 2020,
                        null, null));
    }

    @Test
    public void testDownloadLinkWhenIsNullOrEmpty() {
        ElectronicBook pardop = new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                "5452156698", 152, 2020,
                "Here comes the link", "");
        ElectronicBook rado = new ElectronicBook("Pardon", HISTORICAL, "Imalo edno vreme...",
                "5452156698", 152, 2020,
                "Here comes the link", null);

        assertEquals("There is no link for downloading!", pardop.getDownloadLink());
        assertEquals("There is no link for downloading!", rado.getDownloadLink());
    }

    @Test
    public void testElectronicBookShouldBeFine() {
        new ElectronicBook("Pardop", HISTORICAL, "Imalo edno vreme...",
                "5452156698", 280, 2020,
                "Here comes the read link", "Here comes the download link");
    }
}

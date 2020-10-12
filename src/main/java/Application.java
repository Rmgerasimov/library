import models.books.Book;
import models.books.ElectronicBook;
import models.enums.Genre;

public class Application {
    public static void main(String[] args) {
//        Person author = new Author("adasd", "adasda", Gender.MALE, "Bulgaria");

        Book book = new ElectronicBook("Govna", null, "Imalo edno vreme...", "0225452",
                250, 2020, "https://github.com/Rmgerasimov/library", "dsffsdfs");

        System.out.println();

    }
}

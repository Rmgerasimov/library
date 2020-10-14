package repositories;

import models.people.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Author getAuthor(String firstName, String lastName) {
        for (Author author : authors) {
            if (author.getFirstName().equals(firstName) && author.getLastName().equals(lastName)) {
                return author;
            }
        }
        return null;
    }
}

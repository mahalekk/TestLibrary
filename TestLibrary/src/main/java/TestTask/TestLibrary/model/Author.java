package TestTask.TestLibrary.model;

import TestTask.TestLibrary.Entity.AuthorEntity;
import TestTask.TestLibrary.Entity.BookEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Author {
    private Long id;
    private String authorName;
    private List<Book> books;

    public static Author toModel(AuthorEntity authorEntity) {
        Author model = new Author();
        model.setId(authorEntity.getId());
        model.setAuthorName((authorEntity.getAuthorName()));
        model.setBooks(authorEntity.getBooks().stream().map(Book :: toModel).collect(Collectors.toList()));
        return model;
    }

    public Author() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

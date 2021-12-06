package TestTask.TestLibrary.model;
import TestTask.TestLibrary.Entity.BookEntity;
import TestTask.TestLibrary.Entity.AuthorEntity;
import TestTask.TestLibrary.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class Book {
    private Long id;
    private String bookName;
    private String genre;
    private String author;

    @Autowired
    private AuthorRepo authorRepo;

    public static Book toModel(BookEntity bookEntity) {
        Book model = new Book();
        model.setId(bookEntity.getId());
        model.setBookName(bookEntity.getBookName());
        model.setGenre(bookEntity.getGenre());
        model.setAuthor(bookEntity.getAuthor().getAuthorName());
        return model;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

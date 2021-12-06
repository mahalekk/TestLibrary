package TestTask.TestLibrary.service;

import TestTask.TestLibrary.Entity.AuthorEntity;
import TestTask.TestLibrary.Entity.BookEntity;
import TestTask.TestLibrary.exception.BookNotFoundException;
import TestTask.TestLibrary.exception.NotFoundException;
import TestTask.TestLibrary.model.Book;
import TestTask.TestLibrary.repository.AuthorRepo;
import TestTask.TestLibrary.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorRepo authorRepo;

    public Book addBook(BookEntity book, Long authorId) {
        AuthorEntity author = authorRepo.findById(authorId).get();
        book.setAuthor(author);
        return Book.toModel(bookRepo.save(book));
    }

    public Book getBookById(Long id) throws BookNotFoundException {
        BookEntity book = bookRepo.findById(id).get();
        if (book == null) {
            throw new BookNotFoundException ("Такая книга в библиотеке отсутствует");
        }
        return Book.toModel(book);
    }

   // @Override
    public Book getByName(String name) {
        BookEntity searchingBook = bookRepo.findByBookName(name);
        if (searchingBook == null) {
            throw new NotFoundException(name);
        }
        return Book.toModel(searchingBook);
    }



    public Long deleteBookById(Long id)  {
        bookRepo.deleteById(id);
        return id;
    }
}

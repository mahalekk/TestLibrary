package TestTask.TestLibrary.repository;


import TestTask.TestLibrary.Entity.BookEntity;
import TestTask.TestLibrary.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity,Long> {
    BookEntity findByBookName(String bookName);

}

package TestTask.TestLibrary.Controller;

import TestTask.TestLibrary.Entity.BookEntity;

import TestTask.TestLibrary.exception.BookNotFoundException;
import TestTask.TestLibrary.exception.NotFoundException;
import TestTask.TestLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import TestTask.TestLibrary.repository.BookRepo;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepo bookRepo;

    @PostMapping
    public ResponseEntity addBooks(@RequestBody BookEntity book, @RequestParam Long authorId) {
        try {
            return ResponseEntity.ok(bookService.addBook(book, authorId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getBookById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(bookService.getBookById(id));
        } catch (BookNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка или книга не найдена");
        }
    }

    @GetMapping("/{bookName}")
    public  ResponseEntity getBookByName(@PathVariable("bookName") String name) {
        try {
            return ResponseEntity.ok(bookService.getByName(name));
        }
        catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBookById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookService.deleteBookById(id));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    }

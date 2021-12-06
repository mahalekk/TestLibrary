package TestTask.TestLibrary.Controller;


import TestTask.TestLibrary.Entity.AuthorEntity;
import TestTask.TestLibrary.exception.AuthorAlreadyExistsException;
import TestTask.TestLibrary.exception.AuthorNotFoundException;
import TestTask.TestLibrary.repository.AuthorRepo;
import TestTask.TestLibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity saveAuthor(@RequestBody AuthorEntity author) {
        try {
            authorService.saveAuthor(author);
            return ResponseEntity.ok("Автор был успешно сохранен");
        } catch (AuthorAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }

    @GetMapping
    public ResponseEntity getAuthorById(@RequestParam Long id){
        try {
            return ResponseEntity.ok(authorService.getAuthorById(id));
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка или автор не найден");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
            return ResponseEntity.ok(authorService.getAllOrderByIdDesc());
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAuthorById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(authorService.deleteAuthorById(id));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}

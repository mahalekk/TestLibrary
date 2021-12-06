package TestTask.TestLibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundException extends RuntimeException {

     public NotFoundException(String name) {
            super("Книга с названием= " + name + " не найдена");
        }
    }


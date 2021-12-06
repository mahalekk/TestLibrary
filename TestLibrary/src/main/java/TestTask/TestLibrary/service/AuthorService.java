package TestTask.TestLibrary.service;

import TestTask.TestLibrary.Entity.AuthorEntity;
import TestTask.TestLibrary.exception.AuthorAlreadyExistsException;
import TestTask.TestLibrary.exception.AuthorNotFoundException;
import TestTask.TestLibrary.model.Author;
import TestTask.TestLibrary.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public AuthorEntity saveAuthor(AuthorEntity author) throws AuthorAlreadyExistsException {
        if (authorRepo.findByAuthorName(author.getAuthorName()) != null) {
            throw new AuthorAlreadyExistsException("Автор с таким именем уже сущестует");
        }
        return authorRepo.save(author);
    }

    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        AuthorEntity author = authorRepo.findById(id).get();
        if (author == null) {
            throw new AuthorNotFoundException("Такой автор в библиотеке отсутствует");
        }
        return Author.toModel(author);
    }

    public List<AuthorEntity> getAllOrderByIdDesc() {
         return authorRepo.findAllByOrderByIdDesc();
    }

    public Long deleteAuthorById(Long id)  {
        authorRepo.deleteById(id);
        return id;
    }
}

package TestTask.TestLibrary.repository;

import TestTask.TestLibrary.Entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
    AuthorEntity findByAuthorName(String authorName);
   List<AuthorEntity> findAllByOrderByIdDesc();
}

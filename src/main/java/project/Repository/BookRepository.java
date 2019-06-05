package project.Repository;

import org.springframework.data.repository.CrudRepository;
import project.Model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository <Book,Integer> {
    Book findById(int id);
    List<Book> findAll();
}

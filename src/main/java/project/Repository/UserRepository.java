package project.Repository;

import org.springframework.data.repository.CrudRepository;
import project.Model.Book;
import project.Model.User;

import java.util.List;

public interface UserRepository extends CrudRepository <User,Integer> {
    User findById(int id);
    List<User> findAll();
}
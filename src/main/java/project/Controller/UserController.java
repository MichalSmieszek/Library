package project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.DTO.UserDTO;
import project.Model.Book;
import project.Model.User;
import project.Repository.BookRepository;
import project.Repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @ResponseBody
    @PostMapping
    public User addUser(@RequestBody User newUser){
        User user = new User(newUser.getName());
        userRepository.save(user);
        return user;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/{userId}",method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable("userId") int userId){
        User user = userRepository.findById(userId);
        if (user!=null)
            userRepository.delete(user);
        else{
            throw new IllegalArgumentException();
        }
        return (user);

    }

    // extra controller to check if everything is ok
    @CrossOrigin
    @ResponseBody
    @GetMapping
    public List<User > getUsers(){
        List <User> users = userRepository.findAll();
        List <UserDTO> usersDTO = new LinkedList<>();
        for (User user : users){
            usersDTO.add(new UserDTO(user));
        }
        return(users);
    }
}

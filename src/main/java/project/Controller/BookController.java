package project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.DTO.BookDTO;
import project.Model.User;
import project.Repository.BookRepository;
import project.Model.Book;
import project.Repository.UserRepository;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(path="/book")
public class BookController{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;


    @CrossOrigin
    @ResponseBody
    @PostMapping
    public Book addBook(@RequestBody Book newBook){
        Book book = new Book(newBook.getTitle());
        bookRepository.save(book);
        return book;
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/{bookId}",method=RequestMethod.DELETE)
    public Book deleteBook(@PathVariable("bookId") int bookId){
        Book book = bookRepository.findById(bookId);
         if (book!=null)
             bookRepository.delete(book);
         else{
             throw new IllegalArgumentException();
         }
         return book;

    }

    // extra controller to check if everything is ok
    @CrossOrigin
    @ResponseBody
    @GetMapping
    public List<Book >getBooks(){
        List<Book> books = bookRepository.findAll();

       return(books);
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping(path="/borrow")
    public BookDTO borrowBook (@RequestBody BookDTO bookDTO){
        Book book = bookRepository.findById(bookDTO.getId());
        User user = userRepository.findById(bookDTO.getUserID());
        //check if book and user exist
        if (book==null || user==null){
            throw new IllegalArgumentException();
        }
        //check if book is in library
        else if (book.getUser()!=null){
            throw new IllegalArgumentException();

        }
        else book.setUser(user);
        bookRepository.save(book);
        return(new BookDTO(book));
    }

    @CrossOrigin
    @ResponseBody
    @PutMapping(path="/return")
    public Book returnBook (@RequestBody BookDTO bookDTO){
        Book book = bookRepository.findById(bookDTO.getId());
        //check if book exist
        if (book==null){
            throw new IllegalArgumentException();
        }
       //check if book isn't in library
        else if (book.getUser()==null){
            throw new IllegalArgumentException();
        }
        else book.setUser(null);
        bookRepository.save(book);
       return(book);
    }

}
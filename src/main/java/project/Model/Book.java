package project.Model;

import javax.persistence.*;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    private User user ;

    public Book(){}
    public Book(String title){
        this.title= title;
    }
    public Book(int id){this.id=id;}
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

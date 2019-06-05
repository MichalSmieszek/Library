package project.DTO;

import project.Model.User;
import project.Model.Book;
public class BookDTO {
    String title;
    int id;
    int userID;

    public BookDTO(){}
    public BookDTO(Book book){
        this.id=book.getId();
        this.title=book.getTitle();
        this.userID=book.getUser().getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

package project.DTO;

import project.Model.User;

public class UserDTO {
    String name;
    int id;

    public UserDTO(){}
    public UserDTO(User user){
        this.id=user.getId();
        this.name=user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

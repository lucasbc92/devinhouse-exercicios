package ex06.entities;

import java.util.ArrayList;
import java.util.List;

public class UserAuthenticator {
    private List<User> users;

    public UserAuthenticator(){
        this.users = new ArrayList<User>();        
    }

    public List<User> getUsers(){
        return users;
    }

    private boolean hasUser(String email){
        for(User user: this.getUsers()){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public User getUser(String email){
        for(User user: this.getUsers()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User user){
        if(this.hasUser(user.getEmail())){
            return false;
        }
        this.getUsers().add(user);
        return true;
    }

    public boolean removeUser(String email){
        User user = this.getUser(email);
        return this.getUsers().remove(user);
    }

    public boolean authenticate(String email, String password){
        User user = this.getUser(email);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public String printUsers(){
        String usersStr = "";
        for(User user: this.getUsers()){
            usersStr += String.format("%s%n", user.toString());
        }
        if(usersStr.equals("")){
            return String.format("The users list is empty!%n");
        }
        return usersStr;
    }
}

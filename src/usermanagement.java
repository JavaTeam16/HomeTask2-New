import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.zip.ZipOutputStream;


// Part 1: User Management

class User {
    private String username;
    private String password;
    private UserType userType;

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

}

enum UserType {
    EXTERNAL, ADMINISTRATOR
}

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean authorizeUser(User user, Privilege privilege) {
        if (user.getUserType() == UserType.ADMINISTRATOR) {
            return true;
        } else {
            return false;
        }
    }

    public void manageProfile(User user, String newUsername, String newPassword) {
        user.setUsername(newUsername);
        user.setPassword(newPassword);
    }
}

class Privilege {
    private String name;
    private String description;

    public Privilege(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}


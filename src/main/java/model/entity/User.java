package model.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private int state;

    public User() {
    }

    public User(int id, String username, String password, String role, int state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
    }

    public User(String username, String password, String role, int state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = 0;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setState(int state) {
        this.state = state;
    }
}

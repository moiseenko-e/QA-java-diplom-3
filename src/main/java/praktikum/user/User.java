package praktikum.user;

public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

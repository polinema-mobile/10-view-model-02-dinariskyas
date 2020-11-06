package id.putraprima.mvvmlogin.models;

public class User {
    private String email = "dinarisky04@gmail.com";
    private String password = "dinarisky";

    public User(){

    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

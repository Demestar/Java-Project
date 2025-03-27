package CombinedAssignment;

public class User {
    private String username;
    private String password;
    private String role;
    private String gender;
    private String email;
    
    public User(String username, String password, String role, String gender, String email) {
        this.username = username;
        this.password = password;
        this.role = role; 
        this.gender = gender;
        this.email = email;
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
    
    public String getGender() {
        return gender;
    }
    
    public String getEmail() {
        return email;
    }
}

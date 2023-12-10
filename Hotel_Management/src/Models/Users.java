
package Models;


public class Users {
    private int id;
    private String name;
    private String username;
    private String password;
    private int role;
    
    public Users(int id, String name, String username, int role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }    
    
    public int getRole() {
        return role;
    }
}

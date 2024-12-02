
package model;

/**
 *
 * @author JOHN SHADARY
 */
public class Administrator {
    
    private int adminId;
    private String name;
    private String phoneNo;
    private String username;
    private String email;
    private String password;
    
    // default constructor

    public Administrator() {
    }

    public Administrator(int adminId, String name, String phoneNo, String username, String email, String password) {
        this.adminId = adminId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    // getters and setters

    public int getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

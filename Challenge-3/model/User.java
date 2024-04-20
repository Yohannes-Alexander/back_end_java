import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String email_address;
    private String password;


    public User(String username, String email_address, String password){
        this.id = UUID.randomUUID();
        this.email_address = email_address;
        this.password = password;
    }
    
    public UUID getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getEmailAddress(){
        return email_address;
    }
}

package com.jaya.springblog.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable =false,length=500)
    private String username;

    @Column(nullable = false,length =200)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;


//        copy constructor
    public User(User copy){
        this.id = copy.id;
        this.username =copy.username;
        this.password= copy.password;
        this.email =copy.email;
    }

    public User(){}

    public User(long id, String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

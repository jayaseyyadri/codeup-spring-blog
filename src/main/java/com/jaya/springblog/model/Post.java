package com.jaya.springblog.model;
import javax.persistence.*;

@Entity
@Table(name="blogposts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 500, unique = true)
    private String title;

    @Column(nullable = false, length = 100000)
    private String content;

//    @Column(nullable = false)
//    private Date postingDate;



    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
//        this.postingDate = date;
    }

    public Post( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String body) {
        this.content = body;
    }
}

//    public Date getPostingDate() {
//        return postingDate;
//    }
//
//    public void setPostingDate(Date postingDate) {
//        this.postingDate = postingDate;
//    }
//}


//Java bean is a model in Spring

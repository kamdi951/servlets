package model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tweet")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //pierwwszy wyraz "Many" do nazwy klasy(wiele Tweetów), drugi do pola(jeden Autor)
    //@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    //@JoinColumn(name = "author_fk")
    //@JoinColumn dołączany kolumne Author id
    //lepiej robić Many to One niż One to Many
    private String author;
    private String message;
    @Column(name = "published_at")
    @CreationTimestamp
    private Date publishedAt;

    public Tweet(){
    }

    public Tweet(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", author=" + author +
                ", message='" + message + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}

package br.project.mongospring.domain;

import br.project.mongospring.dto.AuthorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private LocalDate date;
    private String tittle;
    private String body;
    private AuthorDTO author;

    public Post() {
    }
    public Post(String id, LocalDate date, String tittle, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.tittle = tittle;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }


}

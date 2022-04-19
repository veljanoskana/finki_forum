package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private Integer ID;

    private Student author;

    private LocalDateTime timestamp;

    private String body;

    public Comment() {}

    public Comment(Integer ID, Student author, LocalDateTime timestamp, String body) {
        this.ID = ID;
        this.author = author;
        this.timestamp = timestamp;
        this.body = body;
    }
}

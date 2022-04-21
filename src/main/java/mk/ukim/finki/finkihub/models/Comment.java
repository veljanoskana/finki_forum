package mk.ukim.finki.finkihub.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @ManyToOne
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

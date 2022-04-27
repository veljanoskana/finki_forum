package mk.ukim.finki.finkihub.models;

import lombok.Data;
import org.ocpsoft.prettytime.PrettyTime;

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

    public String getTimestampFormatted(){
        PrettyTime p = new PrettyTime();
        return p.format(this.timestamp);
    }

    public String getURL(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://ui-avatars.com/api/?name=");
        stringBuilder.append(this.author.getName()).append("+").append(this.author.getSurname());
        return stringBuilder.toString();
    }
}

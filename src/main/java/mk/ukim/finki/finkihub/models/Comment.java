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

    private LocalDateTime timestamp;

    private String body;

    private Integer likes;

    private Integer dislikes;

    private String authorName;

    public Comment() {
    }

    public Comment(LocalDateTime timestamp, String body) {
        this.timestamp = timestamp;
        this.body = body;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Comment(Integer ID, LocalDateTime timestamp, String body, Integer likes, Integer dislikes, String authorName) {
        this.ID = ID;
        this.timestamp = timestamp;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.authorName = authorName;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getTimestampFormatted() {
        PrettyTime p = new PrettyTime();
        return p.format(this.timestamp);
    }

//    public String getURL() {
//       StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("https://ui-avatars.com/api/?name=");
//        stringBuilder.append(this.author.getName()).append("+").append(this.author.getSurname());
//        return stringBuilder.toString();
//    }
}

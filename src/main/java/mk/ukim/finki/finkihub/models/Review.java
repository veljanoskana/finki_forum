package mk.ukim.finki.finkihub.models;

import lombok.Data;

import java.util.List;

@Data
public class Review {

    private Integer ID;

    private List<Comment> comments;

    private List<String> pros;

    private List<String> cons;

    private Double rating;

    public Review() {
        this.rating = 0.0;
    }

    public Review(Integer ID, List<Comment> comments, List<String> pros, List<String> cons) {
        this.ID = ID;
        this.comments = comments;
        this.pros = pros;
        this.cons = cons;
        this.rating = 0.0;
    }
}

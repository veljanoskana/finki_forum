package mk.ukim.finki.finkihub.models;

import lombok.Data;

@Data
public class Professor {

    private Integer ID;

    private String name;

    private String surname;

    private String link;

    public Professor() {}

    public Professor(Integer ID, String name, String surname, String link) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.link = link;
    }
}

package mk.ukim.finki.finkihub.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
public class Student {

    @Id
    private Integer index;

    private String name;

    private String surname;

    private String password;

    @ManyToOne
    private Preference preference;

    @ManyToOne
    private Program program;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public Student() {
    }

    public Student(Integer index, String name, String surname, String password, Preference preference, Program program, Role role) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.preference = preference;
        this.password = password;
        this.program = program;
        this.role = role;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    public int getYear() {
        return ((LocalDateTime.now().getYear()) % 100) - (index / 10000);
    }
}

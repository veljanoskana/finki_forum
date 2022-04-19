package mk.ukim.finki.finkihub.bootstrap;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {

    @PostConstruct
    public void init() {
//        TODO: Create lists for initial data
    }

}

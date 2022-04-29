package mk.ukim.finki.finkihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.annotation.WebServlet;


@SpringBootApplication
public class FinkiHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinkiHubApplication.class, args);
    }

}

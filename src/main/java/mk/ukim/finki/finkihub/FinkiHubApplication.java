package mk.ukim.finki.finkihub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.annotation.WebServlet;


@SpringBootApplication
public class FinkiHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinkiHubApplication.class, args);
    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
}

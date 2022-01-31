package fr.hellocorp.projetmoscatelli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProjetMoscatelliApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetMoscatelliApplication.class, args);
    }

}

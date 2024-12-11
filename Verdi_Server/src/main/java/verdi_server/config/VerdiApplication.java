package verdi_server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("verdi_server")
public class VerdiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerdiApplication.class, args);
    }

}

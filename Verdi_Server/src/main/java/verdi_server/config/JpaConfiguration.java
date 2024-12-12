package verdi_server.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "verdi_server")
@EnableJpaRepositories(basePackages = "verdi_server")
public class JpaConfiguration {
}

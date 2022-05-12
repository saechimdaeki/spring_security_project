package me.saechimdaeki.security.config;

import me.saechimdaeki.security.repository.ResourcesRepository;
import me.saechimdaeki.security.security.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository){
        return new SecurityResourceService(resourcesRepository);
    }

}

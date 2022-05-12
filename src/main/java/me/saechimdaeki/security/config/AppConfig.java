package me.saechimdaeki.security.config;

import me.saechimdaeki.security.repository.AccessIpRepository;
import me.saechimdaeki.security.repository.ResourcesRepository;
import me.saechimdaeki.security.security.service.RoleHierarchyService;
import me.saechimdaeki.security.security.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository, AccessIpRepository accessIpRepository) {
        SecurityResourceService SecurityResourceService = new SecurityResourceService(resourcesRepository,  accessIpRepository);
        return SecurityResourceService;
    }

}

package me.saechimdaeki.security.repository;

import me.saechimdaeki.security.domain.AccessIp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessIpRepository extends JpaRepository<AccessIp, Long> {

    AccessIp findByIpAddress(String IpAddress);

}
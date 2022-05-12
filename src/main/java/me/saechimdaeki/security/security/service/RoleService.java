package me.saechimdaeki.security.security.service;

import me.saechimdaeki.security.domain.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}
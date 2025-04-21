package com.flyway.service;

import com.flyway.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    Role createRole(Role role);

    List<Role> createRole(List<Role> role);

    Role getRole(Long id);

    List<Role> getAllRoles();

    Role updateRole(Role role);

    void deleteRole(Long id);
}

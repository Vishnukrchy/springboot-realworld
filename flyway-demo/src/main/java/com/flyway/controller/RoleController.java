package com.flyway.controller;

import com.flyway.entity.Role;
import com.flyway.repository.RoleRepository;
import com.flyway.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("/add")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }
    @PostMapping(value = "/add/all" )
    public List<Role> createRole(@RequestBody List<Role> role) {
        return roleService.createRole(role);
    }
    @GetMapping("/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }
    @GetMapping("/all")
    public List<Role> getAllRoles() { return roleService.getAllRoles(); }

    @PutMapping("/update")
    public Role updateRole(@RequestBody Role role) {
        return roleService.updateRole(role);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}

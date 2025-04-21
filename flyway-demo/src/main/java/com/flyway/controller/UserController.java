package com.flyway.controller;

import com.flyway.entity.Role;
import com.flyway.entity.User;
import com.flyway.repository.RoleRepository;
import com.flyway.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        Set<Role> validRoles =user.getRoles();
        for (Role role : validRoles) {
            roleRepository.findById(role.getId()).orElseThrow(()->new RuntimeException("Role not found"+role.getId()));
        }
        user.setRoles(validRoles);
        return ResponseEntity.ok(userRepository.save(user));

    }
    @GetMapping
    public ResponseEntity<Set<User>> getAllUsers(){
        return (ResponseEntity<Set<User>>) userRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@RequestBody Long id){
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id){
        return  userRepository.findById(id)
                .map(user->{
                    user.setName(user.getName());
                    user.setEmail(user.getEmail());
                    return ResponseEntity.ok(userRepository.save(user));
                }).orElse(ResponseEntity.notFound().build());


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        return userRepository.findById(id)
                .map(user->{
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}

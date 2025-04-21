package com.jsp.phone_verification.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password")
    private String password; // Hash this before storing

    @Column(name = "role")
    private String role = "ADMIN"; // Role can be ADMIN or other roles if necessary

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<User> managedUsers;// The admin who manages this user

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Order> managedOrders; // Admin can manage multiple orders
// Permissions management can be added later

}

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Column(name = "username", unique = true,nullable = false)
    private String username;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", unique = true,nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password",nullable = false)
    private String password; // Hash this before storing

    @Column(name = "created_at")
    private Date createdAt = new Date(); // Timestamp of creation

    @Column(name = "updated_at")
    private Date updatedAt = new Date(); // Timestamp of last update

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders; // Users can have multiple orders

    @ManyToOne
    @JoinColumn(name = "admin_id",referencedColumnName = "admin_id")
    private  Admin admin;// The admin who manages this user

}

package com.jsp.phone_verification.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_name")
    private String name;

    @Column(name = "order_date")
    private Date orderDate = new Date();

    @Column(name = "estimated_delivery_date")
    private Date estimatedDeliveryDate;

    @Column(name = "order_status" ,nullable = false)
    private String orderStatus; // e.g., "PENDING", "SHIPPED", "DELIVERED"

    @Column(name = "total_price" ,nullable = false)
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user; // The user associated with this order

    @Column(name = "created_at")
    private Date createdAt = new Date(); // Timestamp of creation

    @Column(name = "updated_at")
    private Date updatedAt = new Date(); // Timestamp of last update

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin; // The admin who manages this order
}

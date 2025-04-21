package com.jsp.phone_verification.repository;

import com.jsp.phone_verification.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Additional query methods can be defined here if needed
}

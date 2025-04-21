package com.jsp.phone_verification.service;

import com.jsp.phone_verification.model.Admin;
import com.jsp.phone_verification.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    @Autowired
    AdminServiceImpl(AdminRepository adminRepository){
        adminRepository=adminRepository;
    }
    @Override
    public Admin createAdmin(Admin admin) {
       try {
           return adminRepository.save(admin);
       }catch (Exception e){
           e.printStackTrace();
           throw  new RuntimeException("DATA IS NOT FOUND !!! "+e.getMessage());
       }
    }
}

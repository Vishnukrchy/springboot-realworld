package com.jsp.phone_verification.controller;

import com.jsp.phone_verification.model.Admin;
import com.jsp.phone_verification.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create")
    public Admin createAdmin(@RequestBody Admin admin){
            return  adminService.createAdmin(admin);
    }
}

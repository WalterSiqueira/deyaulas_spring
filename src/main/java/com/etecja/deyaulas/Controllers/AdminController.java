package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.etecja.deyaulas.Repositories.AdminRepository;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/dashboard")
    public String adminDasboard() {
        return "admin";
    }
        
}

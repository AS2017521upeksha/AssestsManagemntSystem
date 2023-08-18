package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.models.AdminModel;
import com.example.repositories.AdminRepository;

public class AdminService {

    @Autowired
    private AdminRepository adminRepositoryObj;

    public AdminModel createAdmin(AdminModel admin) {
        return adminRepositoryObj.save(admin);
    }

    public Optional<AdminModel> getAdminById(String id) {
        return Optional.ofNullable(adminRepositoryObj.findOneById(id));
    }

    public List<AdminModel> getAllAdmins() {
        return adminRepositoryObj.findAll();
    }

    public AdminModel updateAdmin(AdminModel admin) {
        return adminRepositoryObj.save(admin);
    }

    public void deleteAdmin(String id) {
        adminRepositoryObj.deleteById(id);
    }

    public AdminModel getAdminByUsername(String username) {
        return adminRepositoryObj.findByUsername(username);
    }
}

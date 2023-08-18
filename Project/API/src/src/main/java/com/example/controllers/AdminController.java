package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AdminModel;
import com.example.services.AdminService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {

    // Create object from AdminService class
    @Autowired
    private AdminService adminServiceObj;

    /*
     * @GetMapping
     * public ResponseEntity<List<AdminModel>> getAllAdmins(){
     * return new ResponseEntity<List<AdminModel>>(adminServiceObj.add, null,
     * }
     */

    // Http requests
    @GetMapping
    public ResponseEntity<List<AdminModel>> getAllAdmins() {
        List<AdminModel> admins = adminServiceObj.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    public ResponseEntity<AdminModel> createAdmin(@RequestBody AdminModel admin) {
        AdminModel createdAdmin = adminServiceObj.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminModel> updateAdmin(@PathVariable String id, @RequestBody AdminModel admin) {
        Optional<AdminModel> existingAdmin = adminServiceObj.getAdminById(id);
        if (existingAdmin.isPresent()) {
            admin.setId(existingAdmin.get().getId());
            AdminModel updatedAdmin = adminServiceObj.updateAdmin(admin);
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        Optional<AdminModel> admin = adminServiceObj.getAdminById(id);
        if (admin.isPresent()) {
            adminServiceObj.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AdminModel admin) {
        User adminObj = AdminService.findByUsername(admin.getUsername());

        if (adminObj != null && adminObj.getPassword().equals(admin.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}

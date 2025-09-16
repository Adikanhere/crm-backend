package com.example.crm.controller;

import com.example.crm.model.Lead;
import com.example.crm.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "http://localhost:5173/", 
    "https://splendorous-truffle-da5cba.netlify.app")
public class LeadController {

    @Autowired
    private LeadService service;

    @GetMapping
    public List<Lead> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Lead add(@RequestBody Lead l) {
        return service.save(l);
    }

    // ✅ Update Lead
    @PutMapping("/{id}")
    public Lead update(@PathVariable Long id, @RequestBody Lead l) {
        return service.update(id, l);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

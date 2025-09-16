package com.example.crm.controller;

import com.example.crm.model.Opportunity;
import com.example.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opportunity")
@CrossOrigin(origins = "http://localhost:5173/", 
    "https://splendorous-truffle-da5cba.netlify.app")
public class OpportunityController {

    @Autowired
    private OpportunityService service;

    @GetMapping
    public List<Opportunity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Opportunity add(@RequestBody Opportunity o) {
        return service.save(o);
    }

    // ✅ Update
    @PutMapping("/{id}")
    public Opportunity update(@PathVariable Long id, @RequestBody Opportunity updatedOpportunity) {
        return service.update(id, updatedOpportunity);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

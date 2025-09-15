package com.example.crm.service;

import com.example.crm.model.Lead;
import com.example.crm.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository repo;

    public List<Lead> getAll() {
        return repo.findAll();
    }

    public Lead save(Lead l) {
        return repo.save(l);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ✅ Update Lead
    public Lead update(Long id, Lead l) {
        return repo.findById(id).map(existing -> {
            existing.setName(l.getName());
            existing.setContact(l.getContact());
            existing.setStatus(l.getStatus());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Lead not found with id " + id));
    }
}

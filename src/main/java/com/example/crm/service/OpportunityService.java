package com.example.crm.service;

import com.example.crm.model.Opportunity;
import com.example.crm.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {

    @Autowired
    private OpportunityRepository repo;

    public List<Opportunity> getAll() {
        return repo.findAll();
    }

    public Opportunity save(Opportunity o) {
        return repo.save(o);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    // ✅ Update
    public Opportunity update(Long id, Opportunity updatedOpportunity) {
        Opportunity existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Opportunity not found"));

        existing.setDescription(updatedOpportunity.getDescription());
        existing.setValue(updatedOpportunity.getValue());
        existing.setStage(updatedOpportunity.getStage());

        return repo.save(existing);
    }

}

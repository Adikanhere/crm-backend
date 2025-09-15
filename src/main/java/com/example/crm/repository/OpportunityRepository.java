package com.example.crm.repository;

import com.example.crm.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<Opportunity,Long> {
}

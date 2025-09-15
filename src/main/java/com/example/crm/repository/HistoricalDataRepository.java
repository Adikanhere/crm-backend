package com.example.crm.repository;

import com.example.crm.model.HistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalDataRepository extends JpaRepository<HistoricalData,Long> {
}

package com.example.crm.service;

import com.example.crm.model.HistoricalData;
import com.example.crm.repository.HistoricalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalDataService {

    @Autowired
    private HistoricalDataRepository repo;

    public List<HistoricalData> getAll(){
        return repo.findAll();
    }

    public HistoricalData save(HistoricalData h){
        return repo.save(h);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}

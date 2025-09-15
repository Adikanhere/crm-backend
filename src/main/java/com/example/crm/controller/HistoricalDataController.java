package com.example.crm.controller;

import com.example.crm.model.HistoricalData;
import com.example.crm.service.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/histodata")
@CrossOrigin(origins = "http://localhost:5173/")
public class HistoricalDataController {

    @Autowired
    private HistoricalDataService service;

    @GetMapping
    public List<HistoricalData> getAll(){
        return service.getAll();
    }

    @PostMapping
    public HistoricalData add(@RequestBody HistoricalData h){
        return service.save(h);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

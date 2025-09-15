//package com.example.crm.controller;
//
//import com.example.crm.model.Customer;
//import com.example.crm.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/customers")
//@CrossOrigin(origins = "http://localhost:5173/")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService service;
//
//    @GetMapping
//    public List<Customer> getAll(){
//        return service.getAll();
//    }
//
//    @PostMapping
//    public Customer add(@RequestBody Customer c){
//        System.out.println("Received: " + c);
//        return service.save(c);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        service.delete(id);
//    }
//}



package com.example.crm.controller;

import com.example.crm.model.Customer;
import com.example.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:5173/")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Customer add(@RequestBody Customer c) {
        System.out.println("Received: " + c);
        return service.save(c);
    }

    @PutMapping("/{id}") // ✅ New endpoint to update a customer
    public Customer update(@PathVariable Long id, @RequestBody Customer c) {
        Customer existing = service.getById(id);
        if (existing != null) {
            existing.setName(c.getName());
            existing.setEmail(c.getEmail());
            existing.setPhone(c.getPhone());
            return service.save(existing);
        }
        return null; // or throw exception
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

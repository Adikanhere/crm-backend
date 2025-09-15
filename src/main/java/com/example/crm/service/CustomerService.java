package com.example.crm.service;

import com.example.crm.model.Customer;
import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> getAll(){
        return repo.findAll();
    }

    public Customer save(Customer c){
        return repo.save(c);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public Customer getById(Long id) {
        Optional<Customer> optionalCustomer = repo.findById(id);
        return optionalCustomer.orElse(null);
    }
}

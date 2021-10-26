package com.example.master_spring_boot.customer;

import com.example.master_spring_boot.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@EqualsAndHashCode
public class CustomerService {

    private final CustomerRepository customerRepository;

    List<Customer> getCustomers() {
        log.info("getCustomers() was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("customer with id: " + id + " not found");
                    log.error("error in getting customer {} ", id, notFoundException);
                    return notFoundException;
                });
    }

}

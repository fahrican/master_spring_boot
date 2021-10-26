package com.example.master_spring_boot.customer;

import java.util.List;

public class CustomerFakeRepo implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "Müslüm Baba", "123pass", "baba@tmüslü.tr"),
                new Customer(2L, "Thor Odinson", "password123", "thor@asgard.uni")
        );
    }
}

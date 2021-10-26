package com.example.master_spring_boot.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService objectUnderTest;

    @BeforeEach
    void setUp() {
        objectUnderTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "Jamila", "test", "jamila@gmail.com");
        Customer ahmad = new Customer(2L, "Ahmad", "1234", "ahmad@gmail.com");

        customerRepository.saveAll(Arrays.asList(jamila, ahmad));

        assertEquals(2, objectUnderTest.getCustomers().size());
    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(1L, "Jamila", "test", "jamila@gmail.com");
        customerRepository.save(jamila);

        assertEquals(1L, objectUnderTest.getCustomer(1L).getId());
        assertEquals("Jamila", objectUnderTest.getCustomer(1L).getName());
        assertEquals("test", objectUnderTest.getCustomer(1L).getPassword());
        assertEquals("jamila@gmail.com", objectUnderTest.getCustomer(1L).getEmail());
    }
}
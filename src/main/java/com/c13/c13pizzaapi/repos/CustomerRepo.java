package com.c13.c13pizzaapi.repos;

import com.c13.c13pizzaapi.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

    Customer findByName(String name);

}

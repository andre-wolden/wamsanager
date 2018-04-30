package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
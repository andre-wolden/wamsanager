package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
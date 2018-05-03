package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepo extends JpaRepository<Operator, Long> {
}

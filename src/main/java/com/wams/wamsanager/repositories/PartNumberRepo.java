package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.PartNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartNumberRepo extends JpaRepository<PartNumber, Long> {
}

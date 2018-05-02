package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.TestResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResourceRepo extends JpaRepository<TestResource, Long> {
}

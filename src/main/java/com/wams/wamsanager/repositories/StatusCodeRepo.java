package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusCodeRepo extends JpaRepository<StatusCode, Long> {
    public StatusCode findByStep(Integer step);
}

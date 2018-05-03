package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.LogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogItemRepo extends JpaRepository<LogItem, Long> {
}

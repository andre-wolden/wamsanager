package com.wams.wamsanager.repositories;

import com.wams.wamsanager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}

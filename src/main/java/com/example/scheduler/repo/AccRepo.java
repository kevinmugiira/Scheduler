package com.example.scheduler.repo;

import com.example.scheduler.model.AccModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepo extends JpaRepository<AccModel, Long> {
}

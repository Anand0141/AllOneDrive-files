package com.example.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.PlanHistory;

@Repository
public interface PlanHistoryRepository extends JpaRepository<PlanHistory, LocalDateTime>
{

}

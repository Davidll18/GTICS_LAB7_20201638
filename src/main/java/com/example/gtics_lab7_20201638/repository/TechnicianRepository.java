package com.example.gtics_lab7_20201638.repository;

import com.example.gtics_lab7_20201638.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}

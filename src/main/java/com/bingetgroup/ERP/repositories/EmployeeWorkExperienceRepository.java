package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.EmployeeWorkExperiences;
import com.bingetgroup.ERP.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeWorkExperienceRepository extends JpaRepository<EmployeeWorkExperiences,Long> {
   Optional<EmployeeWorkExperiences> findByEmployee(Employees employee);
}

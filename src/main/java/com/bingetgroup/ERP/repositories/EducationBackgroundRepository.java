package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.EducationBackgrounds;
import com.bingetgroup.ERP.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationBackgroundRepository extends JpaRepository<EducationBackgrounds,Long> {

    Optional<EducationBackgrounds> findByEmployee(Employees employee);
}

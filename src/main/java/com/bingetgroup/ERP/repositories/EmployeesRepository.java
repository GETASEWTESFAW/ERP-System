package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {
}

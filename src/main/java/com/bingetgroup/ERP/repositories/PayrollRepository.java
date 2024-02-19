package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll,Long> {
}

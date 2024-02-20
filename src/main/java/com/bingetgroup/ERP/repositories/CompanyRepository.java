package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Companies,Long> {
}

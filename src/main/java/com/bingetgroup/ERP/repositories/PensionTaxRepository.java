package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.PensionTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionTaxRepository extends JpaRepository<PensionTax,Long> {
}

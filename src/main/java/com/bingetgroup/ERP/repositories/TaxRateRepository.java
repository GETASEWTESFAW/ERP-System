package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.IncomeTaxRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRateRepository extends JpaRepository<IncomeTaxRates,Long> {
}

package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.OtherTaxPayable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherTaxPayableRepository extends JpaRepository<OtherTaxPayable, Long> {
}

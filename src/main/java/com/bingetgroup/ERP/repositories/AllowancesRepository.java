package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Allowances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AllowancesRepository extends JpaRepository<Allowances,Long> {
}

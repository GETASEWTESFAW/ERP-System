package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.enums.AllowanceType;
import com.bingetgroup.ERP.models.Allowances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AllowancesRepository extends JpaRepository<Allowances,Long> {

    Optional<Allowances> findByAllowanceType(AllowanceType allowanceType);
}

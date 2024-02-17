package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Performances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformancesRepository extends JpaRepository<Performances, Long> {
}

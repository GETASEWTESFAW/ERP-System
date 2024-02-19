package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Overtimes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvertimeRepository extends JpaRepository<Overtimes, Long> {
}

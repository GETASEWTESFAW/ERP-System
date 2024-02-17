package com.bingetgroup.ERP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendancesRepository extends JpaRepository<AttendancesRepository,Long> {
}

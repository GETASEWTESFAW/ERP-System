package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Attendances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendancesRepository extends JpaRepository<Attendances,Long> {
}

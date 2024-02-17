package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepository extends JpaRepository<Positions,Long> {
}

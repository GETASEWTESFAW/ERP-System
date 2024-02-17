package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepository extends JpaRepository<Leaves,Long> {
}

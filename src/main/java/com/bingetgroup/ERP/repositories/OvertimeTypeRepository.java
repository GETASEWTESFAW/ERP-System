package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.OvertimeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvertimeTypeRepository extends JpaRepository<OvertimeTypes,Long> {
}

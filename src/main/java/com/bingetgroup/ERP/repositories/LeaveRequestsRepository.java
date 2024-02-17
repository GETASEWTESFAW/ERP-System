package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.LeaveRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestsRepository extends JpaRepository<LeaveRequests,Long> {
}

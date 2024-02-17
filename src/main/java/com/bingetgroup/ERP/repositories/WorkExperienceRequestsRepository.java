package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.WorkExperienceRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRequestsRepository extends JpaRepository<WorkExperienceRequests, Long> {
}

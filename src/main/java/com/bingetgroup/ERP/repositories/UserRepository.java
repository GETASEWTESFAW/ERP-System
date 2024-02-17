package com.bingetgroup.ERP.repositories;

import com.bingetgroup.ERP.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    // Since email is unique, we'll find users by email
    Optional<Users> findByEmail(String email);
}

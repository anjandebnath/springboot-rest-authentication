package com.springboot.rest.authentication.repository;

import com.springboot.rest.authentication.model.ERole;
import com.springboot.rest.authentication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

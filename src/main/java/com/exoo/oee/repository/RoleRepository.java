package com.exoo.oee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByroleName(String name);





}

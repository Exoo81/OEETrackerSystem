package com.exoo.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exoo.oee.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

	//@Query("select u from UserDetails u where u.user.id = ?1")
	//UserDetails findUserDetailsByUserId(int id);

}

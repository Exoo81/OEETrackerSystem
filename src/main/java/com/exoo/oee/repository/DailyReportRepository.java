package com.exoo.oee.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;

public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {
	
	//@Query("select u from DailyReport u where u.user.id = ?1")
	//List<DailyReport> findReportsByUser(int id);
	
	List<DailyReport> findByUser(User user, Pageable pageable);

}


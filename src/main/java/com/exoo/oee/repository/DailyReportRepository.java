package com.exoo.oee.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;

public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {
	
	//@Query("select u from DailyReport u where u.user.id = ?1")
	//List<DailyReport> findReportsByUser(int id);
	
	Page<DailyReport> findByReportCreatedBy(User user, Pageable pageable);

	List<DailyReport> findByReportCreatedBy(User user);

	



}


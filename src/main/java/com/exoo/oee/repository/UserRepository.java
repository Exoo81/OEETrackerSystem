package com.exoo.oee.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.ProductionLine;
import com.exoo.oee.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Page<User> findAll(Pageable pageable);

	User findByUsername(String name);

	User findByDailyReports(DailyReport report);

	Page<User> findByAuthorizedProductionLines(ProductionLine pL, Pageable pageable);

	List<User> findByAuthorizedProductionLines(ProductionLine pL);

	/*List<User> findByAuthorizedProductionLines(int productionLineID);*/

}

package com.exoo.oee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.UserDetails;

public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {

}


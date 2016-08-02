package com.exoo.oee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.repository.DailyReportRepository;


@Service
public class DailyReportService {

	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	
	//public List<DailyReport> getReportList(int id) {
	//	return dailyReportRepository.findReportsByUser(id);
	//}

	
	
}

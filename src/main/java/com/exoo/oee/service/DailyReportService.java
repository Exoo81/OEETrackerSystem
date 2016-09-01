package com.exoo.oee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;
import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.UserRepository;


@Service
public class DailyReportService {

	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	//public List<DailyReport> getReportList(int id) {
	//	return dailyReportRepository.findReportsByUser(id);
	//}

	@Transactional
	public Page<DailyReport> getDailyReportsForUser(int id, Integer pageNumber) {
		User user = userRepository.findOne(id);
        PageRequest request =
            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "dateOfReport");
        return dailyReportRepository.findByUser(user, request);
    }


	public User getUserById(int id) {
		User user = userRepository.findOne(id);
		return user;
	}
	
}

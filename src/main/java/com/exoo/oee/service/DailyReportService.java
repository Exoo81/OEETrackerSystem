package com.exoo.oee.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.RoleRepository;
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
        return dailyReportRepository.findByReportCreatedBy(user, request);
    }


	public User getUserById(int id) {
		User user = userRepository.findOne(id);
		return user;
	}


	public Page<DailyReport> findAll(Integer pageNumber) {
		PageRequest request =
	            new PageRequest(pageNumber - 1, 5, Sort.Direction.DESC, "dateOfReport");
		Page<DailyReport> page = dailyReportRepository.findAll(request);
		
		List<DailyReport> dailyReports = page.getContent();
		
		for(DailyReport report : dailyReports){
			User user = userRepository.findByDailyReports(report);
			report.setReportCreatedBy(user);
		}
		
		return page;
	}


	public void delete(int reportId) {
		dailyReportRepository.delete(reportId);
		
	}


	public boolean checkOwner(String userLogged, int reportId) {
		
		DailyReport report = dailyReportRepository.findOne(reportId);
		//System.out.println(report);
		
		User user = userRepository.findByDailyReports(report);
		//report.setReportCreatedBy(user);
		
		if(userLogged.equals(user.getUsername())){
			return true;
		}else{
			return false;
		}
		
		
	}
		
}

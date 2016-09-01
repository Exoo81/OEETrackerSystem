package com.exoo.oee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.UserRepository;
import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	
	public Page<User> findAll(int pageNumber){
		PageRequest request =
	            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
		Page<User> page = userRepository.findAll(request);
		
		List<User> users = page.getContent();
		
		for(User user : users ){
			List<DailyReport> dailyReportList  = dailyReportRepository.findByUser(user);
			user.setDailyReports(dailyReportList);
		}
		
		return page ;
	}

	public User getOne(int id) {
		return userRepository.findOne(id);
	}

	/*@Transactional
	public User getOneWithReports(int id) {
		User user = getOne(id);
		List<DailyReport> reportsList = dailyReportRepository.findByUser(user, new PageRequest(0, 10, Direction.DESC, "dateOfReport"));
		user.setDailyReports(reportsList);
		return user;
	}*/


	// example for fetch=FetchType.LAZY
	/*public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}*/

	public void save(User user) {
		userRepository.save(user);
		
	}
	
	
	
}

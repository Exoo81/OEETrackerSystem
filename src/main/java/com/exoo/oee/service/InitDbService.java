package com.exoo.oee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;
import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.RoleRepository;
import com.exoo.oee.repository.UserDetailsRepository;
import com.exoo.oee.repository.UserRepository;


@Transactional
@Service
public class InitDbService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@PostConstruct
	public void init(){
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm:ss"); 
		
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("ROLE_OPERATOR");
		roleRepository.save(userRole);
		
		Role analystRole = new Role();
		analystRole.setRoleName("ROLE_ANALYST");
		roleRepository.save(analystRole);
		
		User masterUser = new User();
		masterUser.setEnabled(true);
		masterUser.setUsername("exoo");
		//masterUser.setPassword("klocek12");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		masterUser.setPassword(encoder.encode("klocek12"));
		List<Role> rolesMaster = new ArrayList<Role>();
		rolesMaster.add(userRole);
		rolesMaster.add(adminRole);
		rolesMaster.add(analystRole);
		masterUser.setRoles(rolesMaster);
		userRepository.save(masterUser);
		
			// masetrUser - UserDetails 
			UserDetails masterUserDet = new UserDetails();
			masterUserDet.setFirstName("Marcin");
			masterUserDet.setLastName("Piskor");
			masterUserDet.setJobTitle("System Administrator");
			masterUserDet.setUser(masterUser);
			userDetailsRepository.save(masterUserDet);
		
		User operatorUser1 = new User();
		operatorUser1.setEnabled(true);
		operatorUser1.setUsername("operator1");
		//operatorUser1.setPassword("operator1");
		operatorUser1.setPassword(encoder.encode("operator1"));
		List<Role> rolesOperator1 = new ArrayList<Role>();
		rolesOperator1.add(userRole);
		operatorUser1.setRoles(rolesOperator1);	
		userRepository.save(operatorUser1);
		
			// operatorUser1 - UserDetails
			UserDetails operatorUser1Det = new UserDetails();
			operatorUser1Det.setFirstName("Al");
			operatorUser1Det.setLastName("Pacino");
			operatorUser1Det.setJobTitle("Line operator");
			operatorUser1Det.setUser(operatorUser1);
			userDetailsRepository.save(operatorUser1Det);
			
			// operatorUser1 - DailyReports 
			DailyReport dr11 = new DailyReport();
			dr11.setReportCreatedBy(operatorUser1);
			dr11.setShift("day");
				String dateString11 = "01/07/2016 15:55:00";
				Date date11 = formatStringToDate(sdf,dateString11);
			dr11.setDateOfReport(date11);
			//dr11.setActualOutput(221);
			dailyReportRepository.save(dr11);
			
			DailyReport dr12 = new DailyReport();
			dr12.setReportCreatedBy(operatorUser1);
			dr12.setShift("day");
				String dateString12 = "02/07/2016 15:51:00";
				Date date12 = formatStringToDate(sdf,dateString12);
			dr12.setDateOfReport(date12);
			//dr12.setActualOutput(219);
			dailyReportRepository.save(dr12);
			
			DailyReport dr13 = new DailyReport();
			dr13.setReportCreatedBy(operatorUser1);
			dr13.setShift("day");
				String dateString13 = "03/07/2016 15:56:00";
				Date date13 = formatStringToDate(sdf,dateString13);
			dr13.setDateOfReport(date13);
			//dr13.setActualOutput(229);
			dailyReportRepository.save(dr13);
			
			DailyReport dr14 = new DailyReport();
			dr14.setReportCreatedBy(operatorUser1);
			dr14.setShift("day");
				String dateString14 = "04/07/2016 15:59:00";
				Date date14 = formatStringToDate(sdf,dateString14);
			dr14.setDateOfReport(date14);
			//dr14.setActualOutput(205);
			dailyReportRepository.save(dr14);
			
			DailyReport dr15 = new DailyReport();
			dr15.setReportCreatedBy(operatorUser1);
			dr15.setShift("day");
				String dateString15 = "05/07/2016 15:59:00";
				Date date15 = formatStringToDate(sdf,dateString15);
			dr15.setDateOfReport(date15);
			//dr15.setActualOutput(222);
			dailyReportRepository.save(dr15);
		
		User operatorUser2 = new User();
		operatorUser2.setEnabled(true);
		operatorUser2.setUsername("operator2");
		//operatorUser2.setPassword("operator2");
		operatorUser2.setPassword(encoder.encode("operator2"));
		List<Role> rolesOperator2 = new ArrayList<Role>();
		rolesOperator2.add(userRole);
		operatorUser2.setRoles(rolesOperator2);
		userRepository.save(operatorUser2);
		
			// operatorUser2 - UserDetails
			UserDetails operatorUser2Det = new UserDetails();
			operatorUser2Det.setFirstName("Jackie");
			operatorUser2Det.setLastName("Chan");
			operatorUser2Det.setJobTitle("Line operator");
			operatorUser2Det.setUser(operatorUser2);
			userDetailsRepository.save(operatorUser2Det);
			
			// operatorUser2 - DailyReports
			DailyReport dr21 = new DailyReport();
			dr21.setReportCreatedBy(operatorUser2);
			dr21.setShift("evening");
				String dateString21 = "01/07/2016 23:55:00";
				Date date21 = formatStringToDate(sdf,dateString21);
			dr21.setDateOfReport(date21);
			//dr21.setActualOutput(250);
			dailyReportRepository.save(dr21);
			
			DailyReport dr22 = new DailyReport();
			dr22.setReportCreatedBy(operatorUser2);
			dr22.setShift("evening");
				String dateString22 = "02/07/2016 23:51:00";
				Date date22 = formatStringToDate(sdf,dateString22);
			dr22.setDateOfReport(date22);
			//dr22.setActualOutput(209);
			dailyReportRepository.save(dr22);
			
			DailyReport dr23 = new DailyReport();
			dr23.setReportCreatedBy(operatorUser2);
			dr23.setShift("evening");
				String dateString23 = "03/07/2016 23:56:00";
				Date date23 = formatStringToDate(sdf,dateString23);
			dr23.setDateOfReport(date23);
			//dr23.setActualOutput(251);
			dailyReportRepository.save(dr23);
			
			DailyReport dr24 = new DailyReport();
			dr24.setReportCreatedBy(operatorUser2);
			dr24.setShift("evening");
				String dateString24 = "04/07/2016 23:59:00";
				Date date24 = formatStringToDate(sdf,dateString24);
			dr24.setDateOfReport(date24);
			//dr24.setActualOutput(150);
			dailyReportRepository.save(dr24);
			
			DailyReport dr25 = new DailyReport();
			dr25.setReportCreatedBy(operatorUser2);
			dr25.setShift("evening");
				String dateString25 = "05/07/2016 23:59:00";
				Date date25 = formatStringToDate(sdf,dateString25);
			dr25.setDateOfReport(date25);
			//dr25.setActualOutput(231);
			dailyReportRepository.save(dr25);
		
		
		User operatorUser3 = new User();
		operatorUser3.setEnabled(true);
		operatorUser3.setUsername("operator3");
		//operatorUser3.setPassword("operator3");
		operatorUser3.setPassword(encoder.encode("operator3"));
		List<Role> rolesOperator3 = new ArrayList<Role>();
		rolesOperator3.add(userRole);
		operatorUser3.setRoles(rolesOperator3);
		userRepository.save(operatorUser3);
		
			// operatorUser3 - UserDetails
			UserDetails operatorUser3Det = new UserDetails();
			operatorUser3Det.setFirstName("Jack");
			operatorUser3Det.setLastName("Nicholson");
			operatorUser3Det.setJobTitle("Line operator");
			operatorUser3Det.setUser(operatorUser3);
			userDetailsRepository.save(operatorUser3Det);
			
			// operatorUser3 - DailyReports
			DailyReport dr31 = new DailyReport();
			dr31.setReportCreatedBy(operatorUser3);
			dr31.setShift("night");
				String dateString31 = "01/07/2016 06:55:00";
				Date date31 = formatStringToDate(sdf,dateString31);
			dr31.setDateOfReport(date31);
			//dr31.setActualOutput(201);
			dailyReportRepository.save(dr31);
			
			DailyReport dr32 = new DailyReport();
			dr32.setReportCreatedBy(operatorUser3);
			dr32.setShift("night");
				String dateString32 = "02/07/2016 06:51:00";
				Date date32 = formatStringToDate(sdf,dateString32);
			dr32.setDateOfReport(date32);
			//dr32.setActualOutput(213);
			dailyReportRepository.save(dr32);
			
			DailyReport dr33 = new DailyReport();
			dr33.setReportCreatedBy(operatorUser3);
			dr33.setShift("night");
				String dateString33 = "03/07/2016 06:56:00";
				Date date33 = formatStringToDate(sdf,dateString33);;
			dr33.setDateOfReport(date33);
			//dr33.setActualOutput(241);
			dailyReportRepository.save(dr33);
			
			DailyReport dr34 = new DailyReport();
			dr34.setReportCreatedBy(operatorUser3);
			dr34.setShift("night");
				String dateString34 = "04/07/2016 06:59:00";
				Date date34 = formatStringToDate(sdf,dateString34);
			dr34.setDateOfReport(date34);
			//dr34.setActualOutput(217);
			dailyReportRepository.save(dr34);
			
			DailyReport dr35 = new DailyReport();
			dr35.setReportCreatedBy(operatorUser3);
			dr35.setShift("night");
				String dateString35 = "05/07/2016 06:59:00";
				Date date35 = formatStringToDate(sdf,dateString35);
			dr35.setDateOfReport(date35);
			//dr35.setActualOutput(205);
			dailyReportRepository.save(dr35);
		
		User analystUser1 = new User();
		analystUser1.setEnabled(true);
		analystUser1.setUsername("analyst1");
		//analystUser1.setPassword("analyst1");
		analystUser1.setPassword(encoder.encode("analyst1"));
		List<Role> rolesAnalyst1 = new ArrayList<Role>();
		rolesAnalyst1.add(analystRole);
		analystUser1.setRoles(rolesAnalyst1);
		userRepository.save(analystUser1);
		
			// analystUser1 - UserDetails
			UserDetails analystUser1Det = new UserDetails();
			analystUser1Det.setFirstName("Angelina");
			analystUser1Det.setLastName("Jolie");
			analystUser1Det.setJobTitle("Data analysis specialist");
			analystUser1Det.setUser(analystUser1);
			userDetailsRepository.save(analystUser1Det);*/
		
	
	}
	
	public Date formatStringToDate(SimpleDateFormat sdf, String stringDate){
		
		Date date = null;
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
}

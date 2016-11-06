package com.exoo.oee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;
import com.exoo.oee.service.DailyReportService;


@Controller
public class DailyReportController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	@RequestMapping("/dailyReport")
	public String dailyReport(){
		
		return "dailyReport";
	}
	
	@RequestMapping(value = "/user/{id}/{pageNumber}/reports", method = RequestMethod.GET)
	public String getRunbookPage(@PathVariable Integer pageNumber, Model model,@PathVariable int id) {
	    Page<DailyReport> page = dailyReportService.getDailyReportsForUser(id,pageNumber);

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    User user = dailyReportService.getUserById(id);
	    
	    model.addAttribute("user", user);
	    model.addAttribute("id", id);
	    model.addAttribute("deploymentReports", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
	    model.addAttribute("dailyReports", page.getContent()); // add by me

	    return "user_report_list";
	}
	
	@RequestMapping(value = "/{pageNumber}/dailyReport")
	public String reports(Model model, @PathVariable Integer pageNumber){
		
		Page<DailyReport> page = dailyReportService.findAll(pageNumber);
		
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    List<DailyReport> dailyReports = page.getContent();
	    
	    model.addAttribute("deploymentDailyReports", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
	    model.addAttribute("dailyReportWoW", dailyReports); // add by me
		
		return "dailyReport";
	}
	
	@RequestMapping("/dailyReport/remove/{reportId}")
	public String removeReportByAdmin(@PathVariable int reportId){
		dailyReportService.delete(reportId);
		return "redirect:/1/dailyReport.html?delete=true";
	}
	
	@RequestMapping("/dailyReport/{userName}/remove/{reportId}")
	public String removeReportByUser(@PathVariable int reportId, Principal principal){
		
		String userLogged = principal.getName();
		if(dailyReportService.checkOwner(userLogged, reportId)){
			dailyReportService.delete(reportId);
			return "redirect:/1/dailyReport.html?delete=true";
		}else{
			return "redirect:/1/dailyReport.html?delete=false";
		}
	}
	
}

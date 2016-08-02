package com.exoo.oee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exoo.oee.service.DailyReportService;


@Controller
public class DailyReportController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	@RequestMapping("/dailyReport")
	public String dailyReport(){
		return "dailyReport";
	}
	
	@RequestMapping("/reports/{id}")
	public String getListOfReportsBuUser(Model model, @PathVariable int id){
		model.addAttribute("reportsWoW", dailyReportService.getReportList(id));
		return "user_report_list";
		
	}
}

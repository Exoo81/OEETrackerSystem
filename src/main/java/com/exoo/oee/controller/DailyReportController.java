package com.exoo.oee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DailyReportController {
	
	@RequestMapping("/dailyReport")
	public String dailyReport(){
		return "dailyReport";
	}

}

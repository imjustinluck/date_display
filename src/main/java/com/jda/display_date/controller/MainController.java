package com.jda.display_date.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer updated = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", updated);
			System.out.println(session.getAttribute("count"));
		}
		return "index.jsp";
	}
	
	@RequestMapping("/count")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		System.out.println(currentCount);
		return "";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEE', the' d ' of ' MMMM', 'y");
		String formatted = df.format(date);
		model.addAttribute("date", formatted);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		DateFormat tf = new SimpleDateFormat("h:mm a");
		String formatted = tf.format(date);
		model.addAttribute("time", formatted);
		return "time.jsp";
	}
}

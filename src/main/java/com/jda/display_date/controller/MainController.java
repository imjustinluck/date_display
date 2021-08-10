package com.jda.display_date.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
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

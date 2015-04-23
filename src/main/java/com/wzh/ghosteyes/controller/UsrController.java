package com.wzh.ghosteyes.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzh.ghosteyes.dao.UsrDao;
import com.wzh.ghosteyes.po.Usr;

@Controller
public class UsrController {
	private static final Logger logger = LoggerFactory.getLogger(UsrController.class);
	private String error_info = "";
	@Autowired
	private UsrDao usrDao;
	
	
	//sign in
	@RequestMapping(value = "/usr/signin", method = RequestMethod.POST)
	public String sigin(String email, String passwd, Model model) {

		if(email.equals("") || passwd.equals("")) {
			error_info = "Your email address or your password is not corret.";
			model.addAttribute("error_info", error_info);
			return "error";
		}
		Usr usr = usrDao.loadByEmail(email);
		if(usr == null) {
			error_info = "Your email address or your password is not corret.";
			model.addAttribute("error_info", error_info);
			return "error";
		}
		if(usr.getPasswd().equals(passwd)) {
			logger.info(usr.getEmail() + " returns.");
			model.addAttribute("usrid", usr.getUsrid());
			return "note";
		}
		else {
			error_info = "Your email address or your password is not corret.";
			model.addAttribute("error_info", error_info);
			return "error";
		}
		
	}
	
	//sign up
	@RequestMapping(value = "/usr/signup", method = RequestMethod.POST)
	public String create(Usr usr, Model model) {
		if(usrDao.loadByUsername(usr.getUsername()) != null) {
			error_info = "This username has been registered!!!";
			model.addAttribute("error_info", error_info);
			return "error";
		}
		if(usrDao.loadByEmail(usr.getEmail()) != null) {
			error_info = "This email address has been registered!!!";
			model.addAttribute("error_info", error_info);
			return "error";
		}
		Date now = new Date();
		usr.setCreateDate(now);
		usr.setLastEditeDate(now);
		usrDao.save(usr);
		logger.info(usr.getEmail() + " has been registered.");
		model.addAttribute("usrid", usr.getUsrid());
		return "note";
	}
	
	
	//get profile
	@RequestMapping(value = "/usr/{id}", method = RequestMethod.GET)
	public String profile(@PathVariable int id, Model model) {
		
		return "profile";
	}
	
	
	
}

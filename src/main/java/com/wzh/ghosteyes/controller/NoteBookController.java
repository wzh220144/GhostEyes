package com.wzh.ghosteyes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wzh.ghosteyes.dao.NoteBookDao;

@Controller
public class NoteBookController  {

	private static final Logger logger = LoggerFactory.getLogger(NoteBookController.class);
	private String error_info = "";
	
	@Autowired
	private NoteBookDao noteBookDao;
	
	@RequestMapping(value = "/notebook/{usrid}/all", method = RequestMethod.GET)
	public void showAllNotebooks(@PathVariable Integer usrid, Model model) {
		model.addAttribute("notebooks", noteBookDao.loadByUsrid(usrid));
	}
	
	@RequestMapping(value = "/notebook/{nbid}", method = RequestMethod.GET)
	public void searchByNbid(@PathVariable Integer nbid, Model model) {
		model.addAttribute("notebook", noteBookDao.loadByNbid(nbid));
	}
	
	
	
}

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

import com.wzh.ghosteyes.dao.NoteBookDao;
import com.wzh.ghosteyes.dao.NoteDao;
import com.wzh.ghosteyes.po.Note;
import com.wzh.ghosteyes.po.NoteBook;

@Controller
public class NoteController {

	private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	private String error_info = "";
	
	@Autowired
	private NoteDao  noteDao;
	@Autowired
	private NoteBookDao noteBookDao;
	
	
	//recover a note
	@RequestMapping(value = "/note/recover/{articleid}", method = RequestMethod.POST)
	public void recoverNote(@PathVariable Integer articleid, Model model) {
		Note note = noteDao.loadByArticleid(articleid);
		Date now = new Date();
		note.setStat(0);
		note.setLastEditDate(now);
		noteDao.save(note);
		model.addAttribute("status", "success");
	}
	
	//delete a note
	@RequestMapping(value = "/note/delete/{articleid}", method = RequestMethod.POST)
	public void recycleNote(@PathVariable Integer articleid, Model model) {		
		Note note = noteDao.loadByArticleid(articleid);
		Date now = new Date();
		//if first delete this note
		if(note.getStat() == 0) {
			noteDao.recycle(note);
		}
		//if you want to delete forever(second time delete)
		else {
			//update notebook
			NoteBook noteBook = noteBookDao.loadByNbid(note.getNbid());
			noteBook.setNt_Count(noteBook.getNt_Count() - 1);
			noteBook.setLastEditDate(now);
			noteBookDao.save(noteBook);
			noteDao.delete(note);
		}
		model.addAttribute("status", "success");
	}
	
	//search all the notes in recycle
	@RequestMapping(value = "/note/{usrid}/recycle", method = RequestMethod.GET)
	public void searchRecycleNote(@PathVariable Integer usrid, Model model) {		
		model.addAttribute("notes", noteDao.loadByUsridInRecycle(usrid));
	}
	
	//search all the notes except notes in recycle ordered by time
	@RequestMapping(value = "/note/{usrid}/time", method = RequestMethod.GET)
	public void searchNotesOrderedByTime(@PathVariable Integer usrid, Model model) {		
		model.addAttribute("notes", noteDao.loadByUsridOrderByTime(usrid));
	}
	
	//search a note by id
	@RequestMapping(value = "/note/{articleid}", method = RequestMethod.GET) 
	public void searchNoteByID(@PathVariable int articleid, Model model) {
		model.addAttribute("note", noteDao.loadByArticleid(articleid));
	}
	
	//save a note
	@RequestMapping(value = "/note", method = RequestMethod.POST) 
	public void save(Note note, String notebook, Integer usrid, Integer noteid, Model model) {
		
		//now date
		Date now = new Date();
		
		//get the notebook
		NoteBook noteBook = noteBookDao.loadByNameAndUsrid(notebook, usrid);
		if(noteBook == null) {	//if it is a new notebook
			noteBook = new NoteBook(usrid, notebook, 0, now, now);
		}
		
		//if it is a note
		if(noteid == -1) {
			//save notebook
			noteBook.setNt_Count(noteBook.getNt_Count() + 1);
			noteBook.setLastEditDate(now);
			noteBookDao.save(noteBook);	//save the notebook
			//save note
			note.setStat(0);
			note.setCreateDate(now);
			note.setLastEditDate(now);
			note.setNbid(noteBook.getNbid());
			note.setUsrid(usrid);
			noteDao.save(note);
		}
		//else if it is an old note
		else {
			// get the old note
			Note oldNote = noteDao.loadByArticleid(noteid);
			//get the old notebook
			NoteBook oldNoteBook = noteBookDao.loadByNbid(oldNote.getNbid());
			//if new notebook is not the old notebook
			if(oldNoteBook.getNbid() != noteBook.getNbid()) {
				oldNoteBook.setNt_Count(oldNoteBook.getNt_Count() - 1);
				oldNoteBook.setLastEditDate(now);
				noteBookDao.save(oldNoteBook);
				noteBook.setNt_Count(noteBook.getNt_Count() + 1);
				noteBook.setLastEditDate(now);
				noteBookDao.save(noteBook);	//save the notebook
			}
			//update the old note
			oldNote.setContent(note.getContent());
			oldNote.setCategory(note.getCategory());
			oldNote.setNbid(noteBook.getNbid());
			oldNote.setLastEditDate(now);
			note = oldNote;
			noteDao.save(note);
		}
		model.addAttribute("articleid", note.getArticleid());
		logger.info(note.getTitle() + " has been saved.");
	}
	
	//get the brief a note by id
	@RequestMapping(value = "/note/{id}/brief", method = RequestMethod.GET) 
	String brief(@PathVariable String id, Model model) {
		return "note";
	}
	
	//get all the titles by usrid and nbid
	@RequestMapping(value = "/note/title/{usrid}/{nbid}/all", method = RequestMethod.GET)
	public void searchByUsridAndNbid(@PathVariable Integer usrid, @PathVariable Integer nbid, Model model) {
		model.addAttribute("notes", noteDao.loadByUsridAndNbid(usrid, nbid));
	}
	
	
	
}

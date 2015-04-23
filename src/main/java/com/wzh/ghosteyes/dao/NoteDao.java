package com.wzh.ghosteyes.dao;

import java.util.List;

import com.wzh.ghosteyes.po.Note;

public interface NoteDao {
	
	//load a note based on articleid
	public Note loadByArticleid(int articleid);
	
	//load a note based on username & title
	public Note loadByUsridAndTitle(int usrid, String title);

	// show all notes
	public List<Note> showAll();

	// save a note
	public boolean save(Note note);

	// save a list of notes
	public int save(List<Note> notes);
	
	//load notes based on userid & nbid
	public List<Note> loadByUsridAndNbid(int usrid, int nbid);
	
	//delete a note
	public boolean delete(Note note);
	
	//recycle a note
	public boolean recycle(Note note);
	
	//load notes based on usrid and ordered by createtime
	public List<Note>  loadByUsridOrderByTime(int usrid);
	
	//load notes in recycle
	public List<Note>  loadByUsridInRecycle(int usrid);
	
}

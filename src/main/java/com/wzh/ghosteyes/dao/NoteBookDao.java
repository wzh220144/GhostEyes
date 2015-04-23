package com.wzh.ghosteyes.dao;

import java.util.List;

import com.wzh.ghosteyes.po.NoteBook;

public interface NoteBookDao {
	
	//show all the notebooks
	public List<NoteBook> showAll();
	
	//save a notebook
	public boolean save(NoteBook noteBook);
	
	//save a list of notebooks
	public int save(List<NoteBook> noteBooks);
	
	//load a notebook by name
	public NoteBook loadByName(String notebook);
	
	//load a notebook by id
	public NoteBook loadByNbid(int nbid);
	
	//load a notebook by name and usrid
	public NoteBook loadByNameAndUsrid(String notebook, int usrid);
	
	//load a list of notebook by usrid
	public List<NoteBook> loadByUsrid(int usrid);
}

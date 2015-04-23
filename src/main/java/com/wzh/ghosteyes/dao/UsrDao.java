package com.wzh.ghosteyes.dao;

import java.util.List;

import com.wzh.ghosteyes.po.Usr;

public interface UsrDao {
	
	//load a usr based on username
	public Usr loadByUsername(String username);
	
	//load a usr based on email address
	public Usr loadByEmail(String email);
	
	//show all usrs
	public List<Usr> showAll();
	
	//save a usr
	public boolean save(Usr usr);
	
	//save a list of usrs
	public int save(List<Usr> usrs);
	
}

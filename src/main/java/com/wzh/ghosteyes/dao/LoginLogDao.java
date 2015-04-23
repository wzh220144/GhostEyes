package com.wzh.ghosteyes.dao;

import java.util.List;

import com.wzh.ghosteyes.po.LoginLog;

public interface LoginLogDao {
	
	//show all the logs
	public List<LoginLog> showAll();
	
	//save a log
	public boolean save(LoginLog log);
	
	//save logs
	public int save(List<LoginLog> logs);
	
	//load a log
	public LoginLog loadById(int id);
}

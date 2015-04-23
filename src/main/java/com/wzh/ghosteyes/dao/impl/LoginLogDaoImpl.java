package com.wzh.ghosteyes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wzh.ghosteyes.dao.BaseDao;
import com.wzh.ghosteyes.dao.LoginLogDao;
import com.wzh.ghosteyes.po.LoginLog;

@Repository
public class LoginLogDaoImpl extends BaseDao implements LoginLogDao {
	//show all the logs
	public List<LoginLog> showAll() {
		String sql = "from LoginLog";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<LoginLog> list = (List<LoginLog>)session.createQuery(sql);
		return list;
	}
		
	//save a log
	public boolean save(LoginLog log) {
		Session session = getcurSession();
		session.saveOrUpdate(log);
		return true;
	}
		
	//save logs, return value represent from which log, exception has started
	public int save(List<LoginLog> logs) {
		int len = logs.size();
		for(int i = 0; i < len; i ++) {
			if(!save(logs.get(i))) {
				return i;
			}
		}
		return -1;
	}
		
	//load a log
	public LoginLog loadById(int id) {
		LoginLog log = null;
		String sql = "from LoginLog t where t.logid = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<LoginLog> list = (List<LoginLog>) session.createQuery(sql).setInteger(0, id).list();
		if(list.size() > 0)
			log = list.get(0);
		return log;
	}
}

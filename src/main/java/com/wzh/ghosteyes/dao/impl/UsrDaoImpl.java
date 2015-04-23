package com.wzh.ghosteyes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wzh.ghosteyes.dao.BaseDao;
import com.wzh.ghosteyes.dao.UsrDao;
import com.wzh.ghosteyes.po.Usr;

@Repository
public class UsrDaoImpl extends BaseDao implements UsrDao {
	// show all usrs
	public List<Usr> showAll() {
		String sql = "from Usr";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Usr> list = (List<Usr>) session.createQuery(sql).list();
		return list;
	}

	// save a list of usrs
	public int save(List<Usr> usrs) {
		int len = usrs.size();
		for (int i = 0; i < len; i++) {
			if (!save(usrs.get(i))) {
				return i;
			}
		}
		return -1;
	}

	// load a usr based on username & passwd
	public Usr loadByUsername(String username) {
		Usr usr = null;
		String sql = "from Usr u where u.username = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Usr> list = (List<Usr>) session.createQuery(sql).setString(0, username).list();
		if (list.size() > 0)
			usr = list.get(0);
		return usr;
	}
	
	//load a usr based on email address
	public Usr loadByEmail(String email) {
		Usr usr = null;
		String sql = "from Usr u where u.email = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Usr> list = (List<Usr>) session.createQuery(sql).setString(0, email).list();
		if (list.size() > 0)
			usr = list.get(0);
		return usr;
	}
	
	//save a usr
	public boolean save(Usr usr) {
		Session session = getcurSession();
		session.saveOrUpdate(usr);
		return true;
	}
}

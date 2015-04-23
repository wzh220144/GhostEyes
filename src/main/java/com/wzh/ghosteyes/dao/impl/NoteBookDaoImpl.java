package com.wzh.ghosteyes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wzh.ghosteyes.dao.BaseDao;
import com.wzh.ghosteyes.dao.NoteBookDao;
import com.wzh.ghosteyes.po.NoteBook;

@Repository
public class NoteBookDaoImpl extends BaseDao implements NoteBookDao {
	
	//load a list of notebook by usrid
	public List<NoteBook> loadByUsrid(int usrid) {
		String sql = "from NoteBook t where t.usrid = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<NoteBook> list = (List<NoteBook>) session.createQuery(sql)
				.setInteger(0, usrid).list();
		return list;
	}
	
	// show all the notebooks
	public List<NoteBook> showAll() {
		String sql = "from NoteBook";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<NoteBook> list = (List<NoteBook>) session.createQuery(sql).list();
		return list;
	}

	// save a notebook
	public boolean save(NoteBook noteBook) {
		Session session = getcurSession();
		session.saveOrUpdate(noteBook);
		return true;
	}

	// save a list of notebooks
	public int save(List<NoteBook> noteBooks) {
		int len = noteBooks.size();
		for (int i = 0; i < len; i++) {
			if (!save(noteBooks.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	//load a notebook by name
	public NoteBook loadByName(String notebook) {
		NoteBook noteBook = null;
		String sql = "from NoteBook t where t.notebook = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<NoteBook> list = (List<NoteBook>) session.createQuery(sql)
				.setString(0, notebook).list();
		if (list.size() > 0)
			noteBook = list.get(0);
		return noteBook;
	}
		
		//load a notebook by id
		public NoteBook loadByNbid(int nbid) {
			NoteBook noteBook = null;
			String sql = "from NoteBook t where t.nbid = ?";
			Session session = getcurSession();
			@SuppressWarnings("unchecked")
			List<NoteBook> list = (List<NoteBook>) session.createQuery(sql)
					.setInteger(0, nbid).list();
			if (list.size() > 0)
				noteBook = list.get(0);
			return noteBook;
		}
		
		//load a notebook by name and usrid
		public NoteBook loadByNameAndUsrid(String notebook, int usrid) {
			NoteBook noteBook = null;
			String sql = "from NoteBook t where t.usrid = ? and t.notebook = ?";
			Session session = getcurSession();
			@SuppressWarnings("unchecked")
			List<NoteBook> list = (List<NoteBook>) session.createQuery(sql)
					.setInteger(0, usrid).setString(1, notebook).list();
			if (list.size() > 0)
				noteBook = list.get(0);
			return noteBook;
		}

}

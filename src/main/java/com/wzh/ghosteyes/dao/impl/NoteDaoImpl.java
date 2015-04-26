package com.wzh.ghosteyes.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wzh.ghosteyes.dao.BaseDao;
import com.wzh.ghosteyes.dao.NoteDao;
import com.wzh.ghosteyes.po.Note;

@Repository
public class NoteDaoImpl extends BaseDao implements NoteDao {
	// show all notes
	public List<Note> showAll() {
		String sql = "from Note";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql);
		return list;
	}

	// save a note
	public boolean save(Note note) {
		Session session = getcurSession();
		session.saveOrUpdate(note);
		return true;
	}

	//save a list of notes
	public int save(List<Note> notes) {
		int len = notes.size();
		for (int i = 0; i < len; i++) {
			if (!save(notes.get(i))) {
				return i;
			}
		}
		return -1;
	}

	// search a note based on usrid & title
	public Note loadByUsridAndTitle(int usrid, String title) {
		Note note = null;
		String sql = "from Note t where t.usrid = ? and t.title = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql)
				.setInteger(0, usrid).setString(1, title).list();
		if (list.size() > 0)
			note = list.get(0);
		return note;
	}
	
	//search a note based on id
	public Note loadByArticleid(int articleid) {
		Note note = null;
		String sql = "from Note t where t.articleid = ?";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql)
				.setInteger(0, articleid).list();
		if (list.size() > 0)
			note = list.get(0);
		return note;
	}
	
	//load notes based on userid & nbid & is not in recycle
	public List<Note> loadByUsridAndNbid(int usrid, int nbid) {
		String sql = "from Note t where t.usrid = ? and t.nbid = ? and t.stat != 1";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql)
				.setInteger(0, usrid).setInteger(1, nbid).list();
		return list;
		
	}
	
	//delete a note
	public boolean delete(Note note) {
		Session session = getcurSession();
		session.delete(note);
		return true;
	}
	
	//recycle a note
	public boolean recycle(Note note) {
		Session session = getcurSession();
		Date now = new Date();
		note.setLastEditDate(now);
		note.setStat(1);
		session.saveOrUpdate(note);
		return true;
	}
	
	//load notes based on usrid and ordered by createtime
	public List<Note> loadByUsridOrderByTime(int usrid) {
		String sql = "from Note t where t.usrid = ? and t.stat != 1 order by t.createDate";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql)
				.setInteger(0, usrid).list();
		return list;
	}
		
	//load notes in recycle
	public List<Note> loadByUsridInRecycle(int usrid) {
		String sql = "from Note t where t.usrid = ? and t.stat = 1";
		Session session = getcurSession();
		@SuppressWarnings("unchecked")
		List<Note> list = (List<Note>) session.createQuery(sql)
				.setInteger(0, usrid).list();
		return list;
	}
}

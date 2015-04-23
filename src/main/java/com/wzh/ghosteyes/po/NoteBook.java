package com.wzh.ghosteyes.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_notebook")
@SuppressWarnings("serial")
public class NoteBook extends BaseDomain {
	
	// field
	
	@Column(name = "notebook")
	String notebook;
	
	@Column(name = "createDate")
	Date createDate;
	
	@Column(name = "lastEditDate")
	Date lastEditDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nbid")
	int nbid;
	
	@Column(name = "nt_count")
	int nt_count;
	
	@Column(name = "usrid")
	int usrid;
	
	//constructor
	public NoteBook() {
		// TODO Auto-generated constructor stub
		
	}
	
	//full
	public NoteBook(int usrid, int nbid, String notebook, int nt_count, Date createDate, Date lastEditDate) {
		this.usrid = usrid;
		this.nbid = nbid;
		this.notebook = notebook;
		this.nt_count = nt_count;
		this.createDate = createDate;
		this.lastEditDate = lastEditDate;
	}
	
	public NoteBook(int usrid, String notebook, int nt_count, Date createDate, Date lastEditDate) {
		this.usrid = usrid;
		this.notebook = notebook;
		this.nt_count = nt_count;
		this.createDate = createDate;
		this.lastEditDate = lastEditDate;
	}
	
	//property accessors
	
	public String getNotebook() {
		return notebook;
	}
	public void setNotebook(String notebook) {
		this.notebook = notebook;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	public int getNbid() {
		return nbid;
	}
	public void setNbid(int nbid) {
		this.nbid = nbid;
	}
	public int getNt_Count() {
		return nt_count;
	}
	public void setNt_Count(int nt_count) {
		this.nt_count = nt_count;
	}
	public int getUsrid() {
		return usrid;
	}
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	
}

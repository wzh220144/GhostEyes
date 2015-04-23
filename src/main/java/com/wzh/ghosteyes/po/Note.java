package com.wzh.ghosteyes.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_note")
@SuppressWarnings("serial")
public class Note extends BaseDomain {

	// field
	@Column(name = "nbid")
	private int nbid;
	
	@Column(name = "usrid")
	private Integer usrid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "articleid")
	private Integer articleid;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "md5")
	private String md5;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "lastEditDate")
	private Date lastEditDate;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "stat")
	private Integer stat;

	// Constructors
	Note() {

	}

	Note(int usrid, int nbid, String title, String content, String md5,
			String category, Date createDate, Date lastEditDate, Integer stat) {
		this.nbid = nbid;
		this.usrid = usrid;
		this.title = title;
		this.content = content;
		this.md5 = md5;
		this.category = category;
		this.createDate = createDate;
		this.lastEditDate = lastEditDate;
		this.stat = stat;
	}

	public int getNbid() {
		return nbid;
	}

	public void setNbid(int nbid) {
		this.nbid = nbid;
	}

	public Integer getUsrid() {
		return usrid;
	}

	public void setUsrid(Integer usrid) {
		this.usrid = usrid;
	}

	public Integer getArticleid() {
		return articleid;
	}

	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	

}

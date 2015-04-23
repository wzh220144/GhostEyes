package com.wzh.ghosteyes.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usr entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_usr")
public class Usr extends BaseDomain {

	// Fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usrid")
	private Integer usrid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "passwd")
	private String passwd;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "superuser")
	private String superuser;
	
	@Column(name = "birth")
	private Date birth;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "lastEditeDate")
	private Date lastEditeDate;

	// Constructors

	/** default constructor */
	public Usr() {
	}

	/** full constructor */
	public Usr(String username, String passwd, String email, String tel,
			String superuser, Date birth, String note, String country,
			Date createDate) {
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.tel = tel;
		this.superuser = superuser;
		this.birth = birth;
		this.note = note;
		this.country = country;
		this.createDate = createDate;
		this.lastEditeDate = createDate;
	}

	// Property accessors

	public Integer getUsrid() {
		return this.usrid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setUsrid(Integer id) {
		this.usrid = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSuperuser() {
		return this.superuser;
	}

	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastEditeDate() {
		return lastEditeDate;
	}

	public void setLastEditeDate(Date lastEditeDate) {
		this.lastEditeDate = lastEditeDate;
	}
	
	

}

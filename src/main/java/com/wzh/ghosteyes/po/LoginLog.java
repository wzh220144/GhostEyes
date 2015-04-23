package com.wzh.ghosteyes.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_login_log")
@SuppressWarnings("serial")
public class LoginLog extends BaseDomain {

	// Fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "logid")
	private int logid;
	
	@Column(name = "usrid")
	private int usrid;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "loginDate")
	private Date loginDate;

	// Constructors

	// Constructors

	LoginLog() {

	}

	LoginLog(int logid, int usrid, String ip, Date loginDate) {
		this.loginDate = loginDate;
		this.ip = ip;
		this.logid = logid;
		this.usrid = usrid;
	}

	// Property accessors

	public int getLogid() {
		return logid;
	}

	public void setLogid(int logid) {
		this.logid = logid;
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}

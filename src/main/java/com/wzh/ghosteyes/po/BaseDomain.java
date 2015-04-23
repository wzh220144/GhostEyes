package com.wzh.ghosteyes.po;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788229434882994171L;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

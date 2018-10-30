package com.topkst.gateway.dto;

import java.sql.Date;

public class EnrollList {
	
	String cometime;
	String beacon_id; 
	String kid_system_code; 
	String kid_name;  
	String kid_sex;
	public EnrollList() {
	}
	public EnrollList(String cometime, String beacon_id, String kid_system_code, String kid_name, String kid_sex) {
		super();
		this.cometime = cometime;
		this.beacon_id = beacon_id;
		this.kid_system_code = kid_system_code;
		this.kid_name = kid_name;
		this.kid_sex = kid_sex;
	}
	public String getCometime() {
		return cometime;
	}
	public void setCometime(String cometime) {
		this.cometime = cometime;
	}
	public String getBeacon_id() {
		return beacon_id;
	}
	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}
	public String getKid_system_code() {
		return kid_system_code;
	}
	public void setKid_system_code(String kid_system_code) {
		this.kid_system_code = kid_system_code;
	}
	public String getKid_name() {
		return kid_name;
	}
	public void setKid_name(String kid_name) {
		this.kid_name = kid_name;
	}
	public String getKid_sex() {
		return kid_sex;
	}
	public void setKid_sex(String kid_sex) {
		this.kid_sex = kid_sex;
	}
	
	
}
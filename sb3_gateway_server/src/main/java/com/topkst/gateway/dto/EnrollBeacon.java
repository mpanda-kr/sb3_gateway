package com.topkst.gateway.dto;

public class EnrollBeacon {
	private String beacon_id;
	private String beacon_mac;
	private String beacon_uuid;
	private int beacon_major;
	private int beacon_minor;
	public EnrollBeacon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnrollBeacon(String beacon_id, String beacon_mac, String beacon_uuid, int beacon_major, int beacon_minor) {
		super();
		this.beacon_id = beacon_id;
		this.beacon_mac = beacon_mac;
		this.beacon_uuid = beacon_uuid;
		this.beacon_major = beacon_major;
		this.beacon_minor = beacon_minor;
	}
	public String getBeacon_id() {
		return beacon_id;
	}
	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}
	public String getBeacon_mac() {
		return beacon_mac;
	}
	public void setBeacon_mac(String beacon_mac) {
		this.beacon_mac = beacon_mac;
	}
	public String getBeacon_uuid() {
		return beacon_uuid;
	}
	public void setBeacon_uuid(String beacon_uuid) {
		this.beacon_uuid = beacon_uuid;
	}
	public int getBeacon_major() {
		return beacon_major;
	}
	public void setBeacon_major(int beacon_major) {
		this.beacon_major = beacon_major;
	}
	public int getBeacon_minor() {
		return beacon_minor;
	}
	public void setBeacon_minor(int beacon_minor) {
		this.beacon_minor = beacon_minor;
	}
	
	
	
}

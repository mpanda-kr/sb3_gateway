package com.topkst.gateway.dto;


import java.sql.Date;

public class ScanBeacon {
	private String gateway;
	private String center;
	private String createtime;
	private String mac_address;
	private String uuid;
	private int major;
	private int minor;
	private int	rssi;
	private int tx_power;
	
	public ScanBeacon(String gateway, String center, String createtime, String mac_address, String uuid, int major,
			int minor, int rssi, int tx_power) {
		super();
		this.gateway = gateway;
		this.center = center;
		this.createtime = createtime;
		this.mac_address = mac_address;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
		this.rssi = rssi;
		this.tx_power = tx_power;
	}
	public ScanBeacon() {
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getMac_address() {
		return mac_address;
	}
	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	public int getTx_power() {
		return tx_power;
	}
	public void setTx_power(int tx_power) {
		this.tx_power = tx_power;
	}
	

	
}

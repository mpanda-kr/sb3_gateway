package com.topkst.gateway.dto;

public class BeaconToken {
	private String fcm_token;

	public BeaconToken() {
		super();
		
	}
	public BeaconToken(String fcm_token) {
		super();
		this.fcm_token = fcm_token;
	}
	public String getFcm_token() {
		return fcm_token;
	}
	public void setFcm_token(String fcm_token) {
		this.fcm_token = fcm_token;
	}

	
	
}

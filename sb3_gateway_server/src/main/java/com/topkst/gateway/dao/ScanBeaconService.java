package com.topkst.gateway.dao;

import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.ScanBeacon;

@Service
public interface ScanBeaconService {

	public void setScanBeacon(ScanBeacon beacon);
	public void setUltraBeacon(ScanBeacon beacon);

}

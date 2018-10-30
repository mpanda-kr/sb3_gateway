package com.topkst.gateway.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.EnrollBeacon;

@Service
public interface EnrollBeaconService {

	public List<EnrollBeacon> center_getEnrollBeaconList(String center_code);

}

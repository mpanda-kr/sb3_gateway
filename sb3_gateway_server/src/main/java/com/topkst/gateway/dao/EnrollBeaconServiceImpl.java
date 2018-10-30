package com.topkst.gateway.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.EnrollBeacon;

@Service
public class EnrollBeaconServiceImpl implements EnrollBeaconService {

	@Autowired
	EnrollBeaconDAO beaconDAO;

	public List<EnrollBeacon> center_getEnrollBeaconList(String center_code) {

		System.out.println("EnrollBeaconServiceImpl : " + center_code );
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("center_code", center_code);
		System.out.println(">> EnrollBeaconServiceImpl map : " + map + "\n");

		return beaconDAO.center_selectEnrollBeaconList(map);

	}
}

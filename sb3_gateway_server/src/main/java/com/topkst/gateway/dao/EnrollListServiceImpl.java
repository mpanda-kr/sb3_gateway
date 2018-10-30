package com.topkst.gateway.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.ScanBeacon;

@Service
public class EnrollListServiceImpl implements EnrollListService {

	@Autowired
	EnrollListDAO enrollListDAO;

	@Override
	public List<ScanBeacon> getenroll_list(String center_code) {
		System.out.println("EnrollListServiceImpl ¡¯¿‘");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("center_code", center_code);
		System.out.println(">> EnrollBeaconServiceImpl map : " + map);
		return enrollListDAO.get_enroll_list(map);
	}

}

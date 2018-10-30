package com.topkst.gateway.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.BeaconToken;

@Service
public class BeaconTokenServiceImpl implements BeaconTokenService {

	@Autowired
	BeaconTokenDAO beaconTokenDAO;

	@Override
	public List<BeaconToken> getBeaconTokenList(String beacon_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beacon_id", beacon_id);
		
		return beaconTokenDAO.getBeaconTokenList(map);
	}
}

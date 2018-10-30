package com.topkst.gateway.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.RidingBeacon;
import com.topkst.gateway.dto.RidingGetBeacon;
import com.topkst.gateway.dto.ScanBeacon;

@Service
public class RidingBeaconServiceImpl implements RidingBeaconService {

	@Autowired
	RidingBeaconDAO beaconDAO;

	@Override
	public void setRidingBeacon(RidingBeacon ridingBeacon) {
		beaconDAO.setRidingGeacon_insert(ridingBeacon);

	}

	@Override
	public List<RidingGetBeacon> get_riding_list(int _id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", _id);

		return beaconDAO.get_riding_list(map);
	}

	@Override
	public void setAttendBeacon(RidingBeacon ridingBeacon) {
		beaconDAO.setAttendBeacon_insert(ridingBeacon);
		
	}

	@Override
	public List<RidingGetBeacon> get_attend_list(int _id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("_id", _id);

		return beaconDAO.get_attend_list(map);
	}

}

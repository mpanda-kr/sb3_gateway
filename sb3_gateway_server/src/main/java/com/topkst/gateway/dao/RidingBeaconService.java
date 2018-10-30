package com.topkst.gateway.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.RidingBeacon;
import com.topkst.gateway.dto.RidingGetBeacon;

@Service
public interface RidingBeaconService {

	public void setRidingBeacon(RidingBeacon ridingBeacon);
	public List<RidingGetBeacon> get_riding_list(int _id);
	public void setAttendBeacon(RidingBeacon ridingBeacon);
	public List<RidingGetBeacon> get_attend_list(int _id);

}

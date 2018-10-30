package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.RidingBeacon;
import com.topkst.gateway.dto.RidingGetBeacon;
import com.topkst.gateway.dto.ScanBeacon;

public interface RidingBeaconDAO {

	public void setRidingGeacon_insert(RidingBeacon ridingBeacon);

	public List<RidingGetBeacon> get_riding_list(Map<String, Object> map);

	public void setAttendBeacon_insert(RidingBeacon ridingBeacon);

	public List<RidingGetBeacon> get_attend_list(Map<String, Object> map);

}

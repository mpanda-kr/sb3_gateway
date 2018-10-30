package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.EnrollBeacon;

public interface EnrollBeaconDAO {

	List<EnrollBeacon> center_selectEnrollBeaconList(Map<String, Object> map);

}

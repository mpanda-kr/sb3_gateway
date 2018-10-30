package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.EnrollBeacon;

public interface BeaconTokenDAO {

	List<BeaconToken> getBeaconTokenList(Map<String, Object> map);

}

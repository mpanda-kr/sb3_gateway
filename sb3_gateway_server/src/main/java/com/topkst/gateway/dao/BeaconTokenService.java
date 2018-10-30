package com.topkst.gateway.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.BeaconToken;

@Service
public interface BeaconTokenService {

	public List<BeaconToken> getBeaconTokenList(String beacon_id);

}

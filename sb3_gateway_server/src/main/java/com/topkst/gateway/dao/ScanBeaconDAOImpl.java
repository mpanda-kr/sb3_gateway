package com.topkst.gateway.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.ScanBeacon;
@Repository
public class ScanBeaconDAOImpl implements ScanBeaconDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void setScanBeacon_insert(ScanBeacon beacon) {
		sqlSession.selectList("com.topkst.beacon.mapper.scanBeacon_isert",beacon);
		
	}

	public void setUltraBeacon_insert(ScanBeacon beacon) {
		sqlSession.selectList("com.topkst.beacon.mapper.ultraBeacon_isert",beacon);
	}

	

}

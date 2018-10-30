package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.RidingBeacon;
import com.topkst.gateway.dto.RidingGetBeacon;
import com.topkst.gateway.dto.ScanBeacon;

@Repository
public class RidingBeaconDAOImpl implements RidingBeaconDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void setRidingGeacon_insert(RidingBeacon ridingBeacon) {
		sqlSession.insert("com.topkst.gateway.mapper.riding_getoff_insert", ridingBeacon);

	}

	@Override
	public List<RidingGetBeacon> get_riding_list(Map<String, Object> map) {

		return sqlSession.selectList("com.topkst.gateway.mapper.check_log", map);
	}

	@Override
	public void setAttendBeacon_insert(RidingBeacon ridingBeacon) {
		sqlSession.insert("com.topkst.gateway.mapper.attendBeacon_isert", ridingBeacon);
		
		
	}

	@Override
	public List<RidingGetBeacon> get_attend_list(Map<String, Object> map) {
		return sqlSession.selectList("com.topkst.gateway.mapper.get_attend_Receive", map);
	}

}

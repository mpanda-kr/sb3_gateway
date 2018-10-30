package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.EnrollBeacon;
@Repository
public class EnrollBeaconDAOImpl implements EnrollBeaconDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EnrollBeacon> center_selectEnrollBeaconList(Map<String, Object> map_data) {
		//System.out.println("\\n서버에 저장된 유효 비콘 데이터를 가져오는 DAO : EnrollBeaconDAOImpl 진입");
		System.out.println("EnrollBeaconDAOImpl : " + map_data);
		return sqlSession.selectList("com.topkst.gateway.mapper.get_enrollList",map_data);
	}

}

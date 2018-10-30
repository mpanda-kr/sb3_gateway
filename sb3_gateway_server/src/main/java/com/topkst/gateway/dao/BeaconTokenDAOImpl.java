package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.BeaconToken;
import com.topkst.gateway.dto.EnrollBeacon;
@Repository
public class BeaconTokenDAOImpl implements BeaconTokenDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;


	public List<BeaconToken> getBeaconTokenList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.topkst.gateway.mapper.get_par_token",map);
	}

}

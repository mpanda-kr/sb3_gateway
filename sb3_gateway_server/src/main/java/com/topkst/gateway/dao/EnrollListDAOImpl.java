package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.ScanBeacon;
@Repository
public class EnrollListDAOImpl implements EnrollListDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ScanBeacon> get_enroll_list(Map<String, Object> map) {
		System.out.println("EnrollBeaconDAOImpl ¡¯¿‘");
		return sqlSession.selectList("com.topkst.gateway.mapper.get_enrollList",map);
		}

}

package com.topkst.gateway.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.ScanBeacon;
@Repository
public class TodayDataDAOImpl implements TodayDataDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void setTodayData() {
		sqlSession.selectList("com.topkst.gateway.mapper.set_today_data");
		
	}

	

}

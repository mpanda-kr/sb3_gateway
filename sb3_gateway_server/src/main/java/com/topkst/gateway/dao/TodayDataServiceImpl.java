package com.topkst.gateway.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.ScanBeacon;

@Service
public class TodayDataServiceImpl implements TodayDataService {

	@Autowired
	TodayDataDAO dataDAO;
	
	@Override
	public void setTodayData() {
		dataDAO.setTodayData();
		
	}

}

package com.topkst.gateway.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.topkst.gateway.dto.EnrollBeacon;
import com.topkst.gateway.dto.ScanBeacon;

public interface EnrollListDAO {
	List<ScanBeacon> get_enroll_list(Map<String, Object> map);

}

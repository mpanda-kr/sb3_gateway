package com.topkst.gateway.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topkst.gateway.dto.ScanBeacon;

@Service
public interface EnrollListService {

	List<ScanBeacon> getenroll_list(String center_code);
}

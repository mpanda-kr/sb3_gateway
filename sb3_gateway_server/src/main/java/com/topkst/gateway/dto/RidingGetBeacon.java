package com.topkst.gateway.dto;

public class RidingGetBeacon {
	
	private int log_id;
	private String log_beacon_id ;
	private String log_createtime;
	private String log_data_type;
	private String log_equiment_id;
	private String log_timestamp;
	private int log_send;
	private int log_receive;
	
	
	
	public RidingGetBeacon() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RidingGetBeacon(int log_id, String log_beacon_id, String log_createtime, String log_data_type,
			String log_equiment_id, String log_timestamp, int log_send, int log_receive) {
		super();
		this.log_id = log_id;
		this.log_beacon_id = log_beacon_id;
		this.log_createtime = log_createtime;
		this.log_data_type = log_data_type;
		this.log_equiment_id = log_equiment_id;
		this.log_timestamp = log_timestamp;
		this.log_send = log_send;
		this.log_receive = log_receive;
	}



	public int getLog_id() {
		return log_id;
	}



	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}



	public String getLog_beacon_id() {
		return log_beacon_id;
	}



	public void setLog_beacon_id(String log_beacon_id) {
		this.log_beacon_id = log_beacon_id;
	}



	public String getLog_createtime() {
		return log_createtime;
	}



	public void setLog_createtime(String log_createtime) {
		this.log_createtime = log_createtime;
	}



	public String getLog_data_type() {
		return log_data_type;
	}



	public void setLog_data_type(String log_data_type) {
		this.log_data_type = log_data_type;
	}



	public String getLog_equiment_id() {
		return log_equiment_id;
	}



	public void setLog_equiment_id(String log_equiment_id) {
		this.log_equiment_id = log_equiment_id;
	}



	public String getLog_timestamp() {
		return log_timestamp;
	}



	public void setLog_timestamp(String log_timestamp) {
		this.log_timestamp = log_timestamp;
	}



	public int getLog_send() {
		return log_send;
	}



	public void setLog_send(int log_send) {
		this.log_send = log_send;
	}



	public int getLog_receive() {
		return log_receive;
	}



	public void setLog_receive(int log_receive) {
		this.log_receive = log_receive;
	}
	
	
	
	
	
	
}

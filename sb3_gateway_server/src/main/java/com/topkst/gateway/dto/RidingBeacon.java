package com.topkst.gateway.dto;

public class RidingBeacon {
	
	private int _id;
	private String beacon_id ;
	private String createtime;
	private String data_type;
	private String equiment_id;
	private String timestamp;
	private int send;
	private int receive;
	public RidingBeacon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RidingBeacon(int _id, String beacon_id, String createtime, String data_type, String equiment_id,
			String timestamp, int send, int receive) {
		super();
		this._id = _id;
		this.beacon_id = beacon_id;
		this.createtime = createtime;
		this.data_type = data_type;
		this.equiment_id = equiment_id;
		this.timestamp = timestamp;
		this.send = send;
		this.receive = receive;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getBeacon_id() {
		return beacon_id;
	}
	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getEquiment_id() {
		return equiment_id;
	}
	public void setEquiment_id(String equiment_id) {
		this.equiment_id = equiment_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getSend() {
		return send;
	}
	public void setSend(int send) {
		this.send = send;
	}
	public int getReceive() {
		return receive;
	}
	public void setReceive(int receive) {
		this.receive = receive;
	}
	
	
	
	
	
	
	
	
}

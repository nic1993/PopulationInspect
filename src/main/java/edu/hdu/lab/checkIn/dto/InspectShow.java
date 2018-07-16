package edu.hdu.lab.checkIn.dto;

import java.util.Date;

public class InspectShow {
	private Integer inspId;

	private Integer roomId;

	private Date inspTime;

	private String inspRec;
	
	private Integer builId;
	
	private Integer roomUnit;

    private Integer roomFloor;

    private String roomNo;
    
    private String builName;
    
    private Integer commId;
    
    private String commName;
    
    private Integer poliId;
    
    private String poliName;
    
    public Integer getPoliId() {
		return poliId;
	}

	public void setPoliId(Integer poliId) {
		this.poliId = poliId;
	}

	public String getPoliName() {
		return poliName;
	}

	public void setPoliName(String poliName) {
		this.poliName = poliName;
	}

	public Integer getInspId() {
		return inspId;
	}

	public void setInspId(Integer inspId) {
		this.inspId = inspId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Date getInspTime() {
		return inspTime;
	}

	public void setInspTime(Date inspTime) {
		this.inspTime = inspTime;
	}

	public String getInspRec() {
		return inspRec;
	}

	public void setInspRec(String inspRec) {
		this.inspRec = inspRec;
	}

	public Integer getBuilId() {
		return builId;
	}

	public void setBuilId(Integer builId) {
		this.builId = builId;
	}

	public Integer getRoomUnit() {
		return roomUnit;
	}

	public void setRoomUnit(Integer roomUnit) {
		this.roomUnit = roomUnit;
	}

	public Integer getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(Integer roomFloor) {
		this.roomFloor = roomFloor;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBuilName() {
		return builName;
	}

	public void setBuilName(String builName) {
		this.builName = builName;
	}

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}
}

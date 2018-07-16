package edu.hdu.lab.checkIn.model;

import java.util.Date;

import edu.hdu.lab.checkIn.dto.RoomStatis;

public class Room {
    private Integer roomId;

    private Integer builId;

    private Integer roomUnit;

    private Integer roomFloor;

    private String roomNo;

    private String roomClass;

    private String roomSubclass;

    private Integer countInspect;

    private Date timeLastinspect;

    private String recLastinspect;

    private Boolean isFocus;
    
    private Boolean isDeleted;
    
    private String ramark;

    private RoomStatis roomStatis;
    
    
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass == null ? null : roomClass.trim();
    }

    public String getRoomSubclass() {
        return roomSubclass;
    }

    public void setRoomSubclass(String roomSubclass) {
        this.roomSubclass = roomSubclass == null ? null : roomSubclass.trim();
    }

    public Integer getCountInspect() {
        return countInspect;
    }

    public void setCountInspect(Integer countInspect) {
        this.countInspect = countInspect;
    }

    public Date getTimeLastinspect() {
        return timeLastinspect;
    }

    public void setTimeLastinspect(Date timeLastinspect) {
        this.timeLastinspect = timeLastinspect;
    }

    public String getRecLastinspect() {
        return recLastinspect;
    }

    public void setRecLastinspect(String recLastinspect) {
        this.recLastinspect = recLastinspect == null ? null : recLastinspect.trim();
    }

    public Boolean getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(Boolean isFocus) {
        this.isFocus = isFocus;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRamark() {
        return ramark;
    }

    public void setRamark(String ramark) {
        this.ramark = ramark == null ? null : ramark.trim();
    }

	public RoomStatis getRoomStatis() {
		return roomStatis;
	}

	public void setRoomStatis(RoomStatis roomStatis) {
		this.roomStatis = roomStatis;
	}

	
    
    
}
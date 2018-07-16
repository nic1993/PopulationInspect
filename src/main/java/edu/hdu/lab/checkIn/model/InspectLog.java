package edu.hdu.lab.checkIn.model;

import java.util.Date;

public class InspectLog {
    private Integer inspId;

    private Integer roomId;

    private Integer poliId;

    private Date inspTime;

    private String inspRec;

    private String ramark;

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

    public Integer getPoliId() {
        return poliId;
    }

    public void setPoliId(Integer poliId) {
        this.poliId = poliId;
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
        this.inspRec = inspRec == null ? null : inspRec.trim();
    }

    public String getRamark() {
        return ramark;
    }

    public void setRamark(String ramark) {
        this.ramark = ramark == null ? null : ramark.trim();
    }
}
package edu.hdu.lab.checkIn.model;

public class Community {
    private Integer commId;

    private Integer poliId;

    private String commName;

    private String commGpslist;

    private Boolean isDeleted;

    private String ramark;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getPoliId() {
        return poliId;
    }

    public void setPoliId(Integer poliId) {
        this.poliId = poliId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    public String getCommGpslist() {
        return commGpslist;
    }

    public void setCommGpslist(String commGpslist) {
        this.commGpslist = commGpslist == null ? null : commGpslist.trim();
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
}
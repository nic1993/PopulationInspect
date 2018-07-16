package edu.hdu.lab.checkIn.model;

public class Building {
    private Integer builId;

    private Integer commId;

    private Integer poliId;

    private String builName;

    private Float builGpse;

    private Float builGpsn;

    private String builType;

    private Boolean isDeleted;

    private String ramark;

    public Integer getBuilId() {
        return builId;
    }

    public void setBuilId(Integer builId) {
        this.builId = builId;
    }

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

    public String getBuilName() {
        return builName;
    }

    public void setBuilName(String builName) {
        this.builName = builName == null ? null : builName.trim();
    }

    public Float getBuilGpse() {
        return builGpse;
    }

    public void setBuilGpse(Float builGpse) {
        this.builGpse = builGpse;
    }

    public Float getBuilGpsn() {
        return builGpsn;
    }

    public void setBuilGpsn(Float builGpsn) {
        this.builGpsn = builGpsn;
    }

    public String getBuilType() {
        return builType;
    }

    public void setBuilType(String builType) {
        this.builType = builType == null ? null : builType.trim();
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
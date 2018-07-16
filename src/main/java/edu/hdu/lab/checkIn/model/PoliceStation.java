package edu.hdu.lab.checkIn.model;

public class PoliceStation {
    private Integer statId;

    private Integer branId;

    private String branName;

    private String statName;

    private String statGpslist;

    private Byte isDelete;

    private String ramark;

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer statId) {
        this.statId = statId;
    }

    public Integer getBranId() {
        return branId;
    }

    public void setBranId(Integer branId) {
        this.branId = branId;
    }

    public String getBranName() {
        return branName;
    }

    public void setBranName(String branName) {
        this.branName = branName == null ? null : branName.trim();
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName == null ? null : statName.trim();
    }

    public String getStatGpslist() {
        return statGpslist;
    }

    public void setStatGpslist(String statGpslist) {
        this.statGpslist = statGpslist == null ? null : statGpslist.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public String getRamark() {
        return ramark;
    }

    public void setRamark(String ramark) {
        this.ramark = ramark == null ? null : ramark.trim();
    }
}
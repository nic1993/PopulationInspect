package edu.hdu.lab.checkIn.model;

public class DictionaryKey {
    private String dictClass;

    private String dictItem;

    public String getDictClass() {
        return dictClass;
    }

    public void setDictClass(String dictClass) {
        this.dictClass = dictClass == null ? null : dictClass.trim();
    }

    public String getDictItem() {
        return dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem == null ? null : dictItem.trim();
    }
}
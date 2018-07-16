package edu.hdu.lab.checkIn.model;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDictClassIsNull() {
            addCriterion("DICT_CLASS is null");
            return (Criteria) this;
        }

        public Criteria andDictClassIsNotNull() {
            addCriterion("DICT_CLASS is not null");
            return (Criteria) this;
        }

        public Criteria andDictClassEqualTo(String value) {
            addCriterion("DICT_CLASS =", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassNotEqualTo(String value) {
            addCriterion("DICT_CLASS <>", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassGreaterThan(String value) {
            addCriterion("DICT_CLASS >", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CLASS >=", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassLessThan(String value) {
            addCriterion("DICT_CLASS <", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassLessThanOrEqualTo(String value) {
            addCriterion("DICT_CLASS <=", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassLike(String value) {
            addCriterion("DICT_CLASS like", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassNotLike(String value) {
            addCriterion("DICT_CLASS not like", value, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassIn(List<String> values) {
            addCriterion("DICT_CLASS in", values, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassNotIn(List<String> values) {
            addCriterion("DICT_CLASS not in", values, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassBetween(String value1, String value2) {
            addCriterion("DICT_CLASS between", value1, value2, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictClassNotBetween(String value1, String value2) {
            addCriterion("DICT_CLASS not between", value1, value2, "dictClass");
            return (Criteria) this;
        }

        public Criteria andDictItemIsNull() {
            addCriterion("DICT_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andDictItemIsNotNull() {
            addCriterion("DICT_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andDictItemEqualTo(String value) {
            addCriterion("DICT_ITEM =", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemNotEqualTo(String value) {
            addCriterion("DICT_ITEM <>", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemGreaterThan(String value) {
            addCriterion("DICT_ITEM >", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_ITEM >=", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemLessThan(String value) {
            addCriterion("DICT_ITEM <", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemLessThanOrEqualTo(String value) {
            addCriterion("DICT_ITEM <=", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemLike(String value) {
            addCriterion("DICT_ITEM like", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemNotLike(String value) {
            addCriterion("DICT_ITEM not like", value, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemIn(List<String> values) {
            addCriterion("DICT_ITEM in", values, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemNotIn(List<String> values) {
            addCriterion("DICT_ITEM not in", values, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemBetween(String value1, String value2) {
            addCriterion("DICT_ITEM between", value1, value2, "dictItem");
            return (Criteria) this;
        }

        public Criteria andDictItemNotBetween(String value1, String value2) {
            addCriterion("DICT_ITEM not between", value1, value2, "dictItem");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNoteIsNull() {
            addCriterion("ITEM_NOTE is null");
            return (Criteria) this;
        }

        public Criteria andItemNoteIsNotNull() {
            addCriterion("ITEM_NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andItemNoteEqualTo(String value) {
            addCriterion("ITEM_NOTE =", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteNotEqualTo(String value) {
            addCriterion("ITEM_NOTE <>", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteGreaterThan(String value) {
            addCriterion("ITEM_NOTE >", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NOTE >=", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteLessThan(String value) {
            addCriterion("ITEM_NOTE <", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NOTE <=", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteLike(String value) {
            addCriterion("ITEM_NOTE like", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteNotLike(String value) {
            addCriterion("ITEM_NOTE not like", value, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteIn(List<String> values) {
            addCriterion("ITEM_NOTE in", values, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteNotIn(List<String> values) {
            addCriterion("ITEM_NOTE not in", values, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteBetween(String value1, String value2) {
            addCriterion("ITEM_NOTE between", value1, value2, "itemNote");
            return (Criteria) this;
        }

        public Criteria andItemNoteNotBetween(String value1, String value2) {
            addCriterion("ITEM_NOTE not between", value1, value2, "itemNote");
            return (Criteria) this;
        }

        public Criteria andRamarkIsNull() {
            addCriterion("RAMARK is null");
            return (Criteria) this;
        }

        public Criteria andRamarkIsNotNull() {
            addCriterion("RAMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRamarkEqualTo(String value) {
            addCriterion("RAMARK =", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkNotEqualTo(String value) {
            addCriterion("RAMARK <>", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkGreaterThan(String value) {
            addCriterion("RAMARK >", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkGreaterThanOrEqualTo(String value) {
            addCriterion("RAMARK >=", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkLessThan(String value) {
            addCriterion("RAMARK <", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkLessThanOrEqualTo(String value) {
            addCriterion("RAMARK <=", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkLike(String value) {
            addCriterion("RAMARK like", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkNotLike(String value) {
            addCriterion("RAMARK not like", value, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkIn(List<String> values) {
            addCriterion("RAMARK in", values, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkNotIn(List<String> values) {
            addCriterion("RAMARK not in", values, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkBetween(String value1, String value2) {
            addCriterion("RAMARK between", value1, value2, "ramark");
            return (Criteria) this;
        }

        public Criteria andRamarkNotBetween(String value1, String value2) {
            addCriterion("RAMARK not between", value1, value2, "ramark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package edu.hdu.lab.checkIn.model;

import java.util.ArrayList;
import java.util.List;

public class PoliceStationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoliceStationExample() {
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

        public Criteria andStatIdIsNull() {
            addCriterion("STAT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStatIdIsNotNull() {
            addCriterion("STAT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStatIdEqualTo(Integer value) {
            addCriterion("STAT_ID =", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdNotEqualTo(Integer value) {
            addCriterion("STAT_ID <>", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdGreaterThan(Integer value) {
            addCriterion("STAT_ID >", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAT_ID >=", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdLessThan(Integer value) {
            addCriterion("STAT_ID <", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdLessThanOrEqualTo(Integer value) {
            addCriterion("STAT_ID <=", value, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdIn(List<Integer> values) {
            addCriterion("STAT_ID in", values, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdNotIn(List<Integer> values) {
            addCriterion("STAT_ID not in", values, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdBetween(Integer value1, Integer value2) {
            addCriterion("STAT_ID between", value1, value2, "statId");
            return (Criteria) this;
        }

        public Criteria andStatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("STAT_ID not between", value1, value2, "statId");
            return (Criteria) this;
        }

        public Criteria andBranIdIsNull() {
            addCriterion("BRAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andBranIdIsNotNull() {
            addCriterion("BRAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBranIdEqualTo(Integer value) {
            addCriterion("BRAN_ID =", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdNotEqualTo(Integer value) {
            addCriterion("BRAN_ID <>", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdGreaterThan(Integer value) {
            addCriterion("BRAN_ID >", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BRAN_ID >=", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdLessThan(Integer value) {
            addCriterion("BRAN_ID <", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdLessThanOrEqualTo(Integer value) {
            addCriterion("BRAN_ID <=", value, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdIn(List<Integer> values) {
            addCriterion("BRAN_ID in", values, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdNotIn(List<Integer> values) {
            addCriterion("BRAN_ID not in", values, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdBetween(Integer value1, Integer value2) {
            addCriterion("BRAN_ID between", value1, value2, "branId");
            return (Criteria) this;
        }

        public Criteria andBranIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BRAN_ID not between", value1, value2, "branId");
            return (Criteria) this;
        }

        public Criteria andBranNameIsNull() {
            addCriterion("BRAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBranNameIsNotNull() {
            addCriterion("BRAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBranNameEqualTo(String value) {
            addCriterion("BRAN_NAME =", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameNotEqualTo(String value) {
            addCriterion("BRAN_NAME <>", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameGreaterThan(String value) {
            addCriterion("BRAN_NAME >", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRAN_NAME >=", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameLessThan(String value) {
            addCriterion("BRAN_NAME <", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameLessThanOrEqualTo(String value) {
            addCriterion("BRAN_NAME <=", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameLike(String value) {
            addCriterion("BRAN_NAME like", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameNotLike(String value) {
            addCriterion("BRAN_NAME not like", value, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameIn(List<String> values) {
            addCriterion("BRAN_NAME in", values, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameNotIn(List<String> values) {
            addCriterion("BRAN_NAME not in", values, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameBetween(String value1, String value2) {
            addCriterion("BRAN_NAME between", value1, value2, "branName");
            return (Criteria) this;
        }

        public Criteria andBranNameNotBetween(String value1, String value2) {
            addCriterion("BRAN_NAME not between", value1, value2, "branName");
            return (Criteria) this;
        }

        public Criteria andStatNameIsNull() {
            addCriterion("STAT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStatNameIsNotNull() {
            addCriterion("STAT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStatNameEqualTo(String value) {
            addCriterion("STAT_NAME =", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameNotEqualTo(String value) {
            addCriterion("STAT_NAME <>", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameGreaterThan(String value) {
            addCriterion("STAT_NAME >", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameGreaterThanOrEqualTo(String value) {
            addCriterion("STAT_NAME >=", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameLessThan(String value) {
            addCriterion("STAT_NAME <", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameLessThanOrEqualTo(String value) {
            addCriterion("STAT_NAME <=", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameLike(String value) {
            addCriterion("STAT_NAME like", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameNotLike(String value) {
            addCriterion("STAT_NAME not like", value, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameIn(List<String> values) {
            addCriterion("STAT_NAME in", values, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameNotIn(List<String> values) {
            addCriterion("STAT_NAME not in", values, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameBetween(String value1, String value2) {
            addCriterion("STAT_NAME between", value1, value2, "statName");
            return (Criteria) this;
        }

        public Criteria andStatNameNotBetween(String value1, String value2) {
            addCriterion("STAT_NAME not between", value1, value2, "statName");
            return (Criteria) this;
        }

        public Criteria andStatGpslistIsNull() {
            addCriterion("STAT_GPSLIST is null");
            return (Criteria) this;
        }

        public Criteria andStatGpslistIsNotNull() {
            addCriterion("STAT_GPSLIST is not null");
            return (Criteria) this;
        }

        public Criteria andStatGpslistEqualTo(String value) {
            addCriterion("STAT_GPSLIST =", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistNotEqualTo(String value) {
            addCriterion("STAT_GPSLIST <>", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistGreaterThan(String value) {
            addCriterion("STAT_GPSLIST >", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistGreaterThanOrEqualTo(String value) {
            addCriterion("STAT_GPSLIST >=", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistLessThan(String value) {
            addCriterion("STAT_GPSLIST <", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistLessThanOrEqualTo(String value) {
            addCriterion("STAT_GPSLIST <=", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistLike(String value) {
            addCriterion("STAT_GPSLIST like", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistNotLike(String value) {
            addCriterion("STAT_GPSLIST not like", value, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistIn(List<String> values) {
            addCriterion("STAT_GPSLIST in", values, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistNotIn(List<String> values) {
            addCriterion("STAT_GPSLIST not in", values, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistBetween(String value1, String value2) {
            addCriterion("STAT_GPSLIST between", value1, value2, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andStatGpslistNotBetween(String value1, String value2) {
            addCriterion("STAT_GPSLIST not between", value1, value2, "statGpslist");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
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
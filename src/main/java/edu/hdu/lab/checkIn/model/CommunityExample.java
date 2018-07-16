package edu.hdu.lab.checkIn.model;

import java.util.ArrayList;
import java.util.List;

public class CommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityExample() {
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

        public Criteria andCommIdIsNull() {
            addCriterion("COMM_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommIdIsNotNull() {
            addCriterion("COMM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommIdEqualTo(Integer value) {
            addCriterion("COMM_ID =", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotEqualTo(Integer value) {
            addCriterion("COMM_ID <>", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdGreaterThan(Integer value) {
            addCriterion("COMM_ID >", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMM_ID >=", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdLessThan(Integer value) {
            addCriterion("COMM_ID <", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMM_ID <=", value, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdIn(List<Integer> values) {
            addCriterion("COMM_ID in", values, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotIn(List<Integer> values) {
            addCriterion("COMM_ID not in", values, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdBetween(Integer value1, Integer value2) {
            addCriterion("COMM_ID between", value1, value2, "commId");
            return (Criteria) this;
        }

        public Criteria andCommIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMM_ID not between", value1, value2, "commId");
            return (Criteria) this;
        }

        public Criteria andPoliIdIsNull() {
            addCriterion("POLI_ID is null");
            return (Criteria) this;
        }

        public Criteria andPoliIdIsNotNull() {
            addCriterion("POLI_ID is not null");
            return (Criteria) this;
        }

        
        //ÃÌº”æØ≤ÏID–≈œ¢
        public Criteria andPoliIdEqualTo(Integer value) {
            addCriterion("POLI_ID =", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdNotEqualTo(Integer value) {
            addCriterion("POLI_ID <>", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdGreaterThan(Integer value) {
            addCriterion("POLI_ID >", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("POLI_ID >=", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdLessThan(Integer value) {
            addCriterion("POLI_ID <", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdLessThanOrEqualTo(Integer value) {
            addCriterion("POLI_ID <=", value, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdIn(List<Integer> values) {
            addCriterion("POLI_ID in", values, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdNotIn(List<Integer> values) {
            addCriterion("POLI_ID not in", values, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdBetween(Integer value1, Integer value2) {
            addCriterion("POLI_ID between", value1, value2, "poliId");
            return (Criteria) this;
        }

        public Criteria andPoliIdNotBetween(Integer value1, Integer value2) {
            addCriterion("POLI_ID not between", value1, value2, "poliId");
            return (Criteria) this;
        }

        public Criteria andCommNameIsNull() {
            addCriterion("COMM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCommNameIsNotNull() {
            addCriterion("COMM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCommNameEqualTo(String value) {
            addCriterion("COMM_NAME =", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotEqualTo(String value) {
            addCriterion("COMM_NAME <>", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameGreaterThan(String value) {
            addCriterion("COMM_NAME >", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMM_NAME >=", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLessThan(String value) {
            addCriterion("COMM_NAME <", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLessThanOrEqualTo(String value) {
            addCriterion("COMM_NAME <=", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameLike(String value) {
            addCriterion("COMM_NAME like", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotLike(String value) {
            addCriterion("COMM_NAME not like", value, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameIn(List<String> values) {
            addCriterion("COMM_NAME in", values, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotIn(List<String> values) {
            addCriterion("COMM_NAME not in", values, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameBetween(String value1, String value2) {
            addCriterion("COMM_NAME between", value1, value2, "commName");
            return (Criteria) this;
        }

        public Criteria andCommNameNotBetween(String value1, String value2) {
            addCriterion("COMM_NAME not between", value1, value2, "commName");
            return (Criteria) this;
        }

        public Criteria andCommGpslistIsNull() {
            addCriterion("COMM_GPSLIST is null");
            return (Criteria) this;
        }

        public Criteria andCommGpslistIsNotNull() {
            addCriterion("COMM_GPSLIST is not null");
            return (Criteria) this;
        }

        public Criteria andCommGpslistEqualTo(String value) {
            addCriterion("COMM_GPSLIST =", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistNotEqualTo(String value) {
            addCriterion("COMM_GPSLIST <>", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistGreaterThan(String value) {
            addCriterion("COMM_GPSLIST >", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistGreaterThanOrEqualTo(String value) {
            addCriterion("COMM_GPSLIST >=", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistLessThan(String value) {
            addCriterion("COMM_GPSLIST <", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistLessThanOrEqualTo(String value) {
            addCriterion("COMM_GPSLIST <=", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistLike(String value) {
            addCriterion("COMM_GPSLIST like", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistNotLike(String value) {
            addCriterion("COMM_GPSLIST not like", value, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistIn(List<String> values) {
            addCriterion("COMM_GPSLIST in", values, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistNotIn(List<String> values) {
            addCriterion("COMM_GPSLIST not in", values, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistBetween(String value1, String value2) {
            addCriterion("COMM_GPSLIST between", value1, value2, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andCommGpslistNotBetween(String value1, String value2) {
            addCriterion("COMM_GPSLIST not between", value1, value2, "commGpslist");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
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
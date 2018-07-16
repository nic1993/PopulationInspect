package edu.hdu.lab.checkIn.model;

import java.util.ArrayList;
import java.util.List;

public class SysParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysParamExample() {
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

        public Criteria andParaIdIsNull() {
            addCriterion("PARA_ID is null");
            return (Criteria) this;
        }

        public Criteria andParaIdIsNotNull() {
            addCriterion("PARA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParaIdEqualTo(Integer value) {
            addCriterion("PARA_ID =", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotEqualTo(Integer value) {
            addCriterion("PARA_ID <>", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdGreaterThan(Integer value) {
            addCriterion("PARA_ID >", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARA_ID >=", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdLessThan(Integer value) {
            addCriterion("PARA_ID <", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdLessThanOrEqualTo(Integer value) {
            addCriterion("PARA_ID <=", value, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdIn(List<Integer> values) {
            addCriterion("PARA_ID in", values, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotIn(List<Integer> values) {
            addCriterion("PARA_ID not in", values, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdBetween(Integer value1, Integer value2) {
            addCriterion("PARA_ID between", value1, value2, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PARA_ID not between", value1, value2, "paraId");
            return (Criteria) this;
        }

        public Criteria andParaNameIsNull() {
            addCriterion("PARA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParaNameIsNotNull() {
            addCriterion("PARA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParaNameEqualTo(String value) {
            addCriterion("PARA_NAME =", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotEqualTo(String value) {
            addCriterion("PARA_NAME <>", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameGreaterThan(String value) {
            addCriterion("PARA_NAME >", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_NAME >=", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLessThan(String value) {
            addCriterion("PARA_NAME <", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLessThanOrEqualTo(String value) {
            addCriterion("PARA_NAME <=", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameLike(String value) {
            addCriterion("PARA_NAME like", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotLike(String value) {
            addCriterion("PARA_NAME not like", value, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameIn(List<String> values) {
            addCriterion("PARA_NAME in", values, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotIn(List<String> values) {
            addCriterion("PARA_NAME not in", values, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameBetween(String value1, String value2) {
            addCriterion("PARA_NAME between", value1, value2, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaNameNotBetween(String value1, String value2) {
            addCriterion("PARA_NAME not between", value1, value2, "paraName");
            return (Criteria) this;
        }

        public Criteria andParaValueIsNull() {
            addCriterion("PARA_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andParaValueIsNotNull() {
            addCriterion("PARA_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andParaValueEqualTo(String value) {
            addCriterion("PARA_VALUE =", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotEqualTo(String value) {
            addCriterion("PARA_VALUE <>", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueGreaterThan(String value) {
            addCriterion("PARA_VALUE >", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueGreaterThanOrEqualTo(String value) {
            addCriterion("PARA_VALUE >=", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLessThan(String value) {
            addCriterion("PARA_VALUE <", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLessThanOrEqualTo(String value) {
            addCriterion("PARA_VALUE <=", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueLike(String value) {
            addCriterion("PARA_VALUE like", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotLike(String value) {
            addCriterion("PARA_VALUE not like", value, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueIn(List<String> values) {
            addCriterion("PARA_VALUE in", values, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotIn(List<String> values) {
            addCriterion("PARA_VALUE not in", values, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueBetween(String value1, String value2) {
            addCriterion("PARA_VALUE between", value1, value2, "paraValue");
            return (Criteria) this;
        }

        public Criteria andParaValueNotBetween(String value1, String value2) {
            addCriterion("PARA_VALUE not between", value1, value2, "paraValue");
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
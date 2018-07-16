package edu.hdu.lab.checkIn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InspectLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspectLogExample() {
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

        public Criteria andInspIdIsNull() {
            addCriterion("INSP_ID is null");
            return (Criteria) this;
        }

        public Criteria andInspIdIsNotNull() {
            addCriterion("INSP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInspIdEqualTo(Integer value) {
            addCriterion("INSP_ID =", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdNotEqualTo(Integer value) {
            addCriterion("INSP_ID <>", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdGreaterThan(Integer value) {
            addCriterion("INSP_ID >", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("INSP_ID >=", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdLessThan(Integer value) {
            addCriterion("INSP_ID <", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdLessThanOrEqualTo(Integer value) {
            addCriterion("INSP_ID <=", value, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdIn(List<Integer> values) {
            addCriterion("INSP_ID in", values, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdNotIn(List<Integer> values) {
            addCriterion("INSP_ID not in", values, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdBetween(Integer value1, Integer value2) {
            addCriterion("INSP_ID between", value1, value2, "inspId");
            return (Criteria) this;
        }

        public Criteria andInspIdNotBetween(Integer value1, Integer value2) {
            addCriterion("INSP_ID not between", value1, value2, "inspId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("ROOM_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("ROOM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("ROOM_ID =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("ROOM_ID <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("ROOM_ID >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROOM_ID >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("ROOM_ID <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROOM_ID <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("ROOM_ID in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("ROOM_ID not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("ROOM_ID between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROOM_ID not between", value1, value2, "roomId");
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

        public Criteria andInspTimeIsNull() {
            addCriterion("INSP_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInspTimeIsNotNull() {
            addCriterion("INSP_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInspTimeEqualTo(Date value) {
            addCriterion("INSP_TIME =", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeNotEqualTo(Date value) {
            addCriterion("INSP_TIME <>", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeGreaterThan(Date value) {
            addCriterion("INSP_TIME >", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INSP_TIME >=", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeLessThan(Date value) {
            addCriterion("INSP_TIME <", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeLessThanOrEqualTo(Date value) {
            addCriterion("INSP_TIME <=", value, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeIn(List<Date> values) {
            addCriterion("INSP_TIME in", values, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeNotIn(List<Date> values) {
            addCriterion("INSP_TIME not in", values, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeBetween(Date value1, Date value2) {
            addCriterion("INSP_TIME between", value1, value2, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspTimeNotBetween(Date value1, Date value2) {
            addCriterion("INSP_TIME not between", value1, value2, "inspTime");
            return (Criteria) this;
        }

        public Criteria andInspRecIsNull() {
            addCriterion("INSP_REC is null");
            return (Criteria) this;
        }

        public Criteria andInspRecIsNotNull() {
            addCriterion("INSP_REC is not null");
            return (Criteria) this;
        }

        public Criteria andInspRecEqualTo(String value) {
            addCriterion("INSP_REC =", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecNotEqualTo(String value) {
            addCriterion("INSP_REC <>", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecGreaterThan(String value) {
            addCriterion("INSP_REC >", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecGreaterThanOrEqualTo(String value) {
            addCriterion("INSP_REC >=", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecLessThan(String value) {
            addCriterion("INSP_REC <", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecLessThanOrEqualTo(String value) {
            addCriterion("INSP_REC <=", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecLike(String value) {
            addCriterion("INSP_REC like", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecNotLike(String value) {
            addCriterion("INSP_REC not like", value, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecIn(List<String> values) {
            addCriterion("INSP_REC in", values, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecNotIn(List<String> values) {
            addCriterion("INSP_REC not in", values, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecBetween(String value1, String value2) {
            addCriterion("INSP_REC between", value1, value2, "inspRec");
            return (Criteria) this;
        }

        public Criteria andInspRecNotBetween(String value1, String value2) {
            addCriterion("INSP_REC not between", value1, value2, "inspRec");
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
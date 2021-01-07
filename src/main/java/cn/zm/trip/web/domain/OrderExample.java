package cn.zm.trip.web.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_order
     *
     * @mbg.generated
     */
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

        public Criteria andTpOidIsNull() {
            addCriterion("tp_oid is null");
            return (Criteria) this;
        }

        public Criteria andTpOidIsNotNull() {
            addCriterion("tp_oid is not null");
            return (Criteria) this;
        }

        public Criteria andTpOidEqualTo(String value) {
            addCriterion("tp_oid =", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidNotEqualTo(String value) {
            addCriterion("tp_oid <>", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidGreaterThan(String value) {
            addCriterion("tp_oid >", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidGreaterThanOrEqualTo(String value) {
            addCriterion("tp_oid >=", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidLessThan(String value) {
            addCriterion("tp_oid <", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidLessThanOrEqualTo(String value) {
            addCriterion("tp_oid <=", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidLike(String value) {
            addCriterion("tp_oid like", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidNotLike(String value) {
            addCriterion("tp_oid not like", value, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidIn(List<String> values) {
            addCriterion("tp_oid in", values, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidNotIn(List<String> values) {
            addCriterion("tp_oid not in", values, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidBetween(String value1, String value2) {
            addCriterion("tp_oid between", value1, value2, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpOidNotBetween(String value1, String value2) {
            addCriterion("tp_oid not between", value1, value2, "tpOid");
            return (Criteria) this;
        }

        public Criteria andTpUidIsNull() {
            addCriterion("tp_uid is null");
            return (Criteria) this;
        }

        public Criteria andTpUidIsNotNull() {
            addCriterion("tp_uid is not null");
            return (Criteria) this;
        }

        public Criteria andTpUidEqualTo(Integer value) {
            addCriterion("tp_uid =", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidNotEqualTo(Integer value) {
            addCriterion("tp_uid <>", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidGreaterThan(Integer value) {
            addCriterion("tp_uid >", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tp_uid >=", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidLessThan(Integer value) {
            addCriterion("tp_uid <", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidLessThanOrEqualTo(Integer value) {
            addCriterion("tp_uid <=", value, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidIn(List<Integer> values) {
            addCriterion("tp_uid in", values, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidNotIn(List<Integer> values) {
            addCriterion("tp_uid not in", values, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidBetween(Integer value1, Integer value2) {
            addCriterion("tp_uid between", value1, value2, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpUidNotBetween(Integer value1, Integer value2) {
            addCriterion("tp_uid not between", value1, value2, "tpUid");
            return (Criteria) this;
        }

        public Criteria andTpOinfoIsNull() {
            addCriterion("tp_oinfo is null");
            return (Criteria) this;
        }

        public Criteria andTpOinfoIsNotNull() {
            addCriterion("tp_oinfo is not null");
            return (Criteria) this;
        }

        public Criteria andTpOinfoEqualTo(String value) {
            addCriterion("tp_oinfo =", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoNotEqualTo(String value) {
            addCriterion("tp_oinfo <>", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoGreaterThan(String value) {
            addCriterion("tp_oinfo >", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoGreaterThanOrEqualTo(String value) {
            addCriterion("tp_oinfo >=", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoLessThan(String value) {
            addCriterion("tp_oinfo <", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoLessThanOrEqualTo(String value) {
            addCriterion("tp_oinfo <=", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoLike(String value) {
            addCriterion("tp_oinfo like", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoNotLike(String value) {
            addCriterion("tp_oinfo not like", value, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoIn(List<String> values) {
            addCriterion("tp_oinfo in", values, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoNotIn(List<String> values) {
            addCriterion("tp_oinfo not in", values, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoBetween(String value1, String value2) {
            addCriterion("tp_oinfo between", value1, value2, "tpOinfo");
            return (Criteria) this;
        }

        public Criteria andTpOinfoNotBetween(String value1, String value2) {
            addCriterion("tp_oinfo not between", value1, value2, "tpOinfo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_order
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_order
     *
     * @mbg.generated
     */
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
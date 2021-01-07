package cn.zm.trip.web.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
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
     * This method corresponds to the database table tp_user
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
     * This method corresponds to the database table tp_user
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_user
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
     * This class corresponds to the database table tp_user
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

        public Criteria andTpUnameIsNull() {
            addCriterion("tp_uname is null");
            return (Criteria) this;
        }

        public Criteria andTpUnameIsNotNull() {
            addCriterion("tp_uname is not null");
            return (Criteria) this;
        }

        public Criteria andTpUnameEqualTo(String value) {
            addCriterion("tp_uname =", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameNotEqualTo(String value) {
            addCriterion("tp_uname <>", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameGreaterThan(String value) {
            addCriterion("tp_uname >", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameGreaterThanOrEqualTo(String value) {
            addCriterion("tp_uname >=", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameLessThan(String value) {
            addCriterion("tp_uname <", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameLessThanOrEqualTo(String value) {
            addCriterion("tp_uname <=", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameLike(String value) {
            addCriterion("tp_uname like", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameNotLike(String value) {
            addCriterion("tp_uname not like", value, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameIn(List<String> values) {
            addCriterion("tp_uname in", values, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameNotIn(List<String> values) {
            addCriterion("tp_uname not in", values, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameBetween(String value1, String value2) {
            addCriterion("tp_uname between", value1, value2, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUnameNotBetween(String value1, String value2) {
            addCriterion("tp_uname not between", value1, value2, "tpUname");
            return (Criteria) this;
        }

        public Criteria andTpUemailIsNull() {
            addCriterion("tp_uemail is null");
            return (Criteria) this;
        }

        public Criteria andTpUemailIsNotNull() {
            addCriterion("tp_uemail is not null");
            return (Criteria) this;
        }

        public Criteria andTpUemailEqualTo(String value) {
            addCriterion("tp_uemail =", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailNotEqualTo(String value) {
            addCriterion("tp_uemail <>", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailGreaterThan(String value) {
            addCriterion("tp_uemail >", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailGreaterThanOrEqualTo(String value) {
            addCriterion("tp_uemail >=", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailLessThan(String value) {
            addCriterion("tp_uemail <", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailLessThanOrEqualTo(String value) {
            addCriterion("tp_uemail <=", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailLike(String value) {
            addCriterion("tp_uemail like", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailNotLike(String value) {
            addCriterion("tp_uemail not like", value, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailIn(List<String> values) {
            addCriterion("tp_uemail in", values, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailNotIn(List<String> values) {
            addCriterion("tp_uemail not in", values, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailBetween(String value1, String value2) {
            addCriterion("tp_uemail between", value1, value2, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUemailNotBetween(String value1, String value2) {
            addCriterion("tp_uemail not between", value1, value2, "tpUemail");
            return (Criteria) this;
        }

        public Criteria andTpUpwdIsNull() {
            addCriterion("tp_upwd is null");
            return (Criteria) this;
        }

        public Criteria andTpUpwdIsNotNull() {
            addCriterion("tp_upwd is not null");
            return (Criteria) this;
        }

        public Criteria andTpUpwdEqualTo(String value) {
            addCriterion("tp_upwd =", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdNotEqualTo(String value) {
            addCriterion("tp_upwd <>", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdGreaterThan(String value) {
            addCriterion("tp_upwd >", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdGreaterThanOrEqualTo(String value) {
            addCriterion("tp_upwd >=", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdLessThan(String value) {
            addCriterion("tp_upwd <", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdLessThanOrEqualTo(String value) {
            addCriterion("tp_upwd <=", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdLike(String value) {
            addCriterion("tp_upwd like", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdNotLike(String value) {
            addCriterion("tp_upwd not like", value, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdIn(List<String> values) {
            addCriterion("tp_upwd in", values, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdNotIn(List<String> values) {
            addCriterion("tp_upwd not in", values, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdBetween(String value1, String value2) {
            addCriterion("tp_upwd between", value1, value2, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpUpwdNotBetween(String value1, String value2) {
            addCriterion("tp_upwd not between", value1, value2, "tpUpwd");
            return (Criteria) this;
        }

        public Criteria andTpAgeIsNull() {
            addCriterion("tp_age is null");
            return (Criteria) this;
        }

        public Criteria andTpAgeIsNotNull() {
            addCriterion("tp_age is not null");
            return (Criteria) this;
        }

        public Criteria andTpAgeEqualTo(String value) {
            addCriterion("tp_age =", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeNotEqualTo(String value) {
            addCriterion("tp_age <>", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeGreaterThan(String value) {
            addCriterion("tp_age >", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeGreaterThanOrEqualTo(String value) {
            addCriterion("tp_age >=", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeLessThan(String value) {
            addCriterion("tp_age <", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeLessThanOrEqualTo(String value) {
            addCriterion("tp_age <=", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeLike(String value) {
            addCriterion("tp_age like", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeNotLike(String value) {
            addCriterion("tp_age not like", value, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeIn(List<String> values) {
            addCriterion("tp_age in", values, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeNotIn(List<String> values) {
            addCriterion("tp_age not in", values, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeBetween(String value1, String value2) {
            addCriterion("tp_age between", value1, value2, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpAgeNotBetween(String value1, String value2) {
            addCriterion("tp_age not between", value1, value2, "tpAge");
            return (Criteria) this;
        }

        public Criteria andTpGenderIsNull() {
            addCriterion("tp_gender is null");
            return (Criteria) this;
        }

        public Criteria andTpGenderIsNotNull() {
            addCriterion("tp_gender is not null");
            return (Criteria) this;
        }

        public Criteria andTpGenderEqualTo(String value) {
            addCriterion("tp_gender =", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderNotEqualTo(String value) {
            addCriterion("tp_gender <>", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderGreaterThan(String value) {
            addCriterion("tp_gender >", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderGreaterThanOrEqualTo(String value) {
            addCriterion("tp_gender >=", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderLessThan(String value) {
            addCriterion("tp_gender <", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderLessThanOrEqualTo(String value) {
            addCriterion("tp_gender <=", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderLike(String value) {
            addCriterion("tp_gender like", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderNotLike(String value) {
            addCriterion("tp_gender not like", value, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderIn(List<String> values) {
            addCriterion("tp_gender in", values, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderNotIn(List<String> values) {
            addCriterion("tp_gender not in", values, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderBetween(String value1, String value2) {
            addCriterion("tp_gender between", value1, value2, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpGenderNotBetween(String value1, String value2) {
            addCriterion("tp_gender not between", value1, value2, "tpGender");
            return (Criteria) this;
        }

        public Criteria andTpUpicIsNull() {
            addCriterion("tp_upic is null");
            return (Criteria) this;
        }

        public Criteria andTpUpicIsNotNull() {
            addCriterion("tp_upic is not null");
            return (Criteria) this;
        }

        public Criteria andTpUpicEqualTo(String value) {
            addCriterion("tp_upic =", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicNotEqualTo(String value) {
            addCriterion("tp_upic <>", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicGreaterThan(String value) {
            addCriterion("tp_upic >", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicGreaterThanOrEqualTo(String value) {
            addCriterion("tp_upic >=", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicLessThan(String value) {
            addCriterion("tp_upic <", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicLessThanOrEqualTo(String value) {
            addCriterion("tp_upic <=", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicLike(String value) {
            addCriterion("tp_upic like", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicNotLike(String value) {
            addCriterion("tp_upic not like", value, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicIn(List<String> values) {
            addCriterion("tp_upic in", values, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicNotIn(List<String> values) {
            addCriterion("tp_upic not in", values, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicBetween(String value1, String value2) {
            addCriterion("tp_upic between", value1, value2, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpUpicNotBetween(String value1, String value2) {
            addCriterion("tp_upic not between", value1, value2, "tpUpic");
            return (Criteria) this;
        }

        public Criteria andTpPhoneIsNull() {
            addCriterion("tp_phone is null");
            return (Criteria) this;
        }

        public Criteria andTpPhoneIsNotNull() {
            addCriterion("tp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTpPhoneEqualTo(String value) {
            addCriterion("tp_phone =", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneNotEqualTo(String value) {
            addCriterion("tp_phone <>", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneGreaterThan(String value) {
            addCriterion("tp_phone >", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("tp_phone >=", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneLessThan(String value) {
            addCriterion("tp_phone <", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneLessThanOrEqualTo(String value) {
            addCriterion("tp_phone <=", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneLike(String value) {
            addCriterion("tp_phone like", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneNotLike(String value) {
            addCriterion("tp_phone not like", value, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneIn(List<String> values) {
            addCriterion("tp_phone in", values, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneNotIn(List<String> values) {
            addCriterion("tp_phone not in", values, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneBetween(String value1, String value2) {
            addCriterion("tp_phone between", value1, value2, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpPhoneNotBetween(String value1, String value2) {
            addCriterion("tp_phone not between", value1, value2, "tpPhone");
            return (Criteria) this;
        }

        public Criteria andTpRegdateIsNull() {
            addCriterion("tp_regdate is null");
            return (Criteria) this;
        }

        public Criteria andTpRegdateIsNotNull() {
            addCriterion("tp_regdate is not null");
            return (Criteria) this;
        }

        public Criteria andTpRegdateEqualTo(Date value) {
            addCriterion("tp_regdate =", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateNotEqualTo(Date value) {
            addCriterion("tp_regdate <>", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateGreaterThan(Date value) {
            addCriterion("tp_regdate >", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateGreaterThanOrEqualTo(Date value) {
            addCriterion("tp_regdate >=", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateLessThan(Date value) {
            addCriterion("tp_regdate <", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateLessThanOrEqualTo(Date value) {
            addCriterion("tp_regdate <=", value, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateIn(List<Date> values) {
            addCriterion("tp_regdate in", values, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateNotIn(List<Date> values) {
            addCriterion("tp_regdate not in", values, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateBetween(Date value1, Date value2) {
            addCriterion("tp_regdate between", value1, value2, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpRegdateNotBetween(Date value1, Date value2) {
            addCriterion("tp_regdate not between", value1, value2, "tpRegdate");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeIsNull() {
            addCriterion("tp_update_time is null");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeIsNotNull() {
            addCriterion("tp_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeEqualTo(Date value) {
            addCriterion("tp_update_time =", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeNotEqualTo(Date value) {
            addCriterion("tp_update_time <>", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeGreaterThan(Date value) {
            addCriterion("tp_update_time >", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tp_update_time >=", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeLessThan(Date value) {
            addCriterion("tp_update_time <", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("tp_update_time <=", value, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeIn(List<Date> values) {
            addCriterion("tp_update_time in", values, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeNotIn(List<Date> values) {
            addCriterion("tp_update_time not in", values, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("tp_update_time between", value1, value2, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("tp_update_time not between", value1, value2, "tpUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTpLikeIsNull() {
            addCriterion("tp_like is null");
            return (Criteria) this;
        }

        public Criteria andTpLikeIsNotNull() {
            addCriterion("tp_like is not null");
            return (Criteria) this;
        }

        public Criteria andTpLikeEqualTo(String value) {
            addCriterion("tp_like =", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeNotEqualTo(String value) {
            addCriterion("tp_like <>", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeGreaterThan(String value) {
            addCriterion("tp_like >", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeGreaterThanOrEqualTo(String value) {
            addCriterion("tp_like >=", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeLessThan(String value) {
            addCriterion("tp_like <", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeLessThanOrEqualTo(String value) {
            addCriterion("tp_like <=", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeLike(String value) {
            addCriterion("tp_like like", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeNotLike(String value) {
            addCriterion("tp_like not like", value, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeIn(List<String> values) {
            addCriterion("tp_like in", values, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeNotIn(List<String> values) {
            addCriterion("tp_like not in", values, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeBetween(String value1, String value2) {
            addCriterion("tp_like between", value1, value2, "tpLike");
            return (Criteria) this;
        }

        public Criteria andTpLikeNotBetween(String value1, String value2) {
            addCriterion("tp_like not between", value1, value2, "tpLike");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tp_user
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
     * This class corresponds to the database table tp_user
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
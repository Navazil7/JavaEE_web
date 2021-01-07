package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.City;
import cn.zm.trip.web.domain.CityExample;
import java.util.List;

public interface CityDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer tpCid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    int insert(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    int insertSelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    List<City> selectByExample(CityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    City selectByPrimaryKey(Integer tpCid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_city
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(City record);


    /**
     * 返回所有城市
     */
    List<City> selectAllCity();
}
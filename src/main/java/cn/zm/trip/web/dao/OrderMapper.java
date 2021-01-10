package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Order;
import cn.zm.trip.web.domain.OrderExample;
import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String tpOid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    Order selectByPrimaryKey(String tpOid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Order record);

    /**
     * 查找某一用户的所有订单
     */
    List<Order> findOrdersByUid(int uid);
}
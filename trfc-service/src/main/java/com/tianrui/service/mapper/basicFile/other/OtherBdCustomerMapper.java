package com.tianrui.service.mapper.basicFile.other;

import com.tianrui.service.bean.basicFile.other.OtherBdCustomer;

public interface OtherBdCustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    int insert(OtherBdCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    int insertSelective(OtherBdCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    OtherBdCustomer selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OtherBdCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tr_other_bd_customer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OtherBdCustomer record);
}
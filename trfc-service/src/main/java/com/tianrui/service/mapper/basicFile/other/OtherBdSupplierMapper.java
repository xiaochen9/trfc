package com.tianrui.service.mapper.basicFile.other;

import java.util.List;

import com.tianrui.service.bean.basicFile.other.OtherBdSupplier;

public interface OtherBdSupplierMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	int insert(OtherBdSupplier record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	int insertSelective(OtherBdSupplier record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	OtherBdSupplier selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(OtherBdSupplier record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tr_other_bd_supplier
	 * @mbggenerated
	 */
	int updateByPrimaryKey(OtherBdSupplier record);
	/**
	 * 查询信息通过 orgId
	 * @param supplier
	 * @return
	 */
	List<OtherBdSupplier> selectSelective(OtherBdSupplier supplier);
	/**
	 * 查询最大时间戳
	 */
	Long getMaxUtc();
}
package com.tianrui.service.mapper.businessManage.salesManage;

import java.util.List;

import com.tianrui.api.req.businessManage.salesManage.SalesArriveQuery;
import com.tianrui.service.bean.businessManage.salesManage.SalesArrive;

public interface SalesArriveMapper {
    int deleteByPrimaryKey(String id);

    int insert(SalesArrive record);

    int insertSelective(SalesArrive record);

    SalesArrive selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SalesArrive record);

    int updateByPrimaryKey(SalesArrive record);
    
    List<SalesArrive> selectSelective(SalesArrive record);
    /**
     * @Description 分页和查询总条数
     * @author zhanggaohao
     * @version 2017年2月17日 上午8:58:24
     * @param query
     * @return
     */
	long findSalesArrivePageCount(SalesArriveQuery query);
	/**
	 * @Description 分页查询
	 * @author zhanggaohao
	 * @version 2017年2月17日 上午8:58:16
	 * @param query
	 * @return
	 */
	List<SalesArrive> findSalesArrivePage(SalesArriveQuery query);
	/**
	 * @Description 检查IC卡是否正在使用中
	 * @author zhanggaohao
	 * @version 2017年2月17日 上午8:57:28
	 * @param query
	 * @return
	 */
	int checkICUse(SalesArriveQuery query);
	/**
	 * @Description 查询车辆等待数量
	 * @author zhanggaohao
	 * @version 2017年2月17日 上午8:57:22
	 * @param query
	 * @return
	 */
	int selectWaitingNumber(SalesArriveQuery query);
	/**
	 * @Description 检查车辆和司机是否已有正在执行的销售通知单
	 * @author zhanggaohao
	 * @version 2017年2月17日 上午8:56:52
	 * @param record
	 * @return
	 */
	List<SalesArrive> checkDriverAndVehicleIsUse(SalesArrive record);
}
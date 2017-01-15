package com.tianrui.api.intf.businessManage.salesManage;

import com.tianrui.api.req.businessManage.salesManage.ApiSalesArriveQuery;
import com.tianrui.api.req.businessManage.salesManage.SalesArriveQuery;
import com.tianrui.api.req.businessManage.salesManage.SalesArriveSave;
import com.tianrui.api.resp.businessManage.salesManage.SalesArriveResp;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;

/**
 * 销售提货通知单Service接口
 * @author zhanggaohao
 * @createtime 2017年1月9日 下午2:23:16
 * @classname ISalesArriveService.java
 */
public interface ISalesArriveService {

	/**
	 * 分页查询销售提货通知单
	 * @param query
	 * @return
	 * @throws Exception
	 */
	PaginationVO<SalesArriveResp> page(SalesArriveQuery query) throws Exception;
	/**
	 * 新增销售提货通知单
	 * @param save
	 * @return
	 * @throws Exception 
	 */
	Result add(SalesArriveSave save) throws Exception;
	/**
	 * 查询销售提货通知单
	 * @param query
	 * @return
	 * @throws Exception 
	 */
	SalesArriveResp findOne(SalesArriveQuery query) throws Exception;
	/**
	 * 修改销售提货通知单
	 * @param save
	 * @return
	 * @throws Exception 
	 */
	Result update(SalesArriveSave save) throws Exception;
	/**
	 * 审核销售提货通知单
	 * @param query
	 * @return
	 */
	Result audit(SalesArriveQuery query);
	/**
	 * 反审销售提货通知单
	 * @param query
	 * @return
	 */
	Result unaudit(SalesArriveQuery query);
	/**
	 * 作废销售提货通知单
	 * @param query
	 * @return
	 */
	Result invalid(SalesArriveQuery query);
	/**
	 * 强制出厂销售提货通知单
	 * @param query
	 * @return
	 */
	Result outfactory(SalesArriveQuery query);
	/**
	 * 查询提货单详情api接口
	 * @param query
	 * @return
	 * @throws Exception 
	 */
	Result detailApi(ApiSalesArriveQuery query) throws Exception;

}
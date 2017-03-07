package com.tianrui.api.intf.quality.purchase;

import com.tianrui.api.req.quality.purchase.PurchaseSamplingReq;
import com.tianrui.smartfactory.common.vo.Result;

public interface IPurchaseSamplingService {
	
	/**
	 * 删除数据
	 */
	Result delete(PurchaseSamplingReq req) throws Exception;
	/**
	 * 新增数据
	 */
	Result add(PurchaseSamplingReq req) throws Exception;
	/**
	 * 更新数据
	 */
	Result update(PurchaseSamplingReq req) throws Exception;
	/**
	 * 分页查询数据
	 */
	Result page(PurchaseSamplingReq req) throws Exception;
}

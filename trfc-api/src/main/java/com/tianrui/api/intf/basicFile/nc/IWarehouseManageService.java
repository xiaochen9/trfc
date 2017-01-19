package com.tianrui.api.intf.basicFile.nc;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.api.req.basicFile.nc.WarehouseManageQuery;
import com.tianrui.api.req.basicFile.nc.WarehouseManageSave;
import com.tianrui.api.resp.basicFile.nc.WarehouseManageResp;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;
/**
 * 仓库管理Service接口
 * @author zhanggaohao
 * @createtime 2016年12月10日 上午10:22:44
 * @classname IWarehouseManageService.java
 */
public interface IWarehouseManageService {

	/**
	 * 查询分页
	 * @param req
	 * @return
	 * @throws Exception
	 */
	PaginationVO<WarehouseManageResp> page(WarehouseManageQuery query) throws Exception;
	/**
	 * 根据id查询仓库
	 * @param query
	 * @return
	 * @throws Exception
	 */
	WarehouseManageResp findOne(WarehouseManageQuery query) throws Exception;
	/**
	 * 修改仓库
	 * @param req
	 * @return
	 * @throws Exception
	 */
	Result updateWarehouse(WarehouseManageSave save) throws Exception;
	/**
	 * 新增仓库
	 * @param req
	 * @return
	 * @throws Exception
	 */
	Result addWarehouse(WarehouseManageSave save) throws Exception;
	/**
	 * 查询仓库
	 * @param query
	 * @return
	 * @throws Exception
	 */
	Result findListByParmas(WarehouseManageQuery query) throws Exception;
	
	Result findMaxUtc(WarehouseManageQuery query) throws Exception;
	
	Result updateDataWithDC(List<JSONObject> list )throws Exception;
	
	
	
}


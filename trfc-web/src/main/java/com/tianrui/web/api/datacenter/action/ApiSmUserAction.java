package com.tianrui.web.api.datacenter.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tianrui.api.req.system.auth.SmUserReq;
import com.tianrui.service.impl.system.auth.SmUserService;
import com.tianrui.smartfactory.common.api.ApiParam;
import com.tianrui.smartfactory.common.api.ApiResult;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.vo.Result;
import com.tianrui.web.smvc.ApiParamRawType;

/**
 * sm_user用户对接数据中心
 * @author Yangzhenfu
 * @createtime 2017年2月20日 上午11:45:30
 */
@Controller
@RequestMapping("api/dc/smUser")
public class ApiSmUserAction {
	
	private Logger log=LoggerFactory.getLogger(ApiSmUserAction.class);
	
	@Autowired
	SmUserService smUserService;
	
	/**
	 * 获取最大时间戳
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/getLastUTC",method=RequestMethod.POST)
	@ApiParamRawType(SmUserReq.class)
	@ResponseBody
	public ApiResult getLastUTC(ApiParam<SmUserReq> req){
		Result rs=Result.getErrorResult();

		SmUserReq cardApi =req.getBody();
		try {
			rs = smUserService.findMaxUtc(cardApi);
		} catch (Exception e) {
			rs.setErrorCode(ErrorCode.SYSTEM_ERROR);
			log.error(e.getMessage(),e);
		}
		return ApiResult.valueOf(rs);
	}
	
	/**
	 * 批量更新数据
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/updateData",method=RequestMethod.POST)
	@ApiParamRawType(List.class)
	@ResponseBody
	public ApiResult updateData(ApiParam<List<JSONObject>> req){
		Result rs=Result.getErrorResult();

		List<JSONObject> list=req.getBody();
		try {
			rs = smUserService.updateDataWithDC(list);
		} catch (Exception e) {
			rs.setErrorCode(ErrorCode.SYSTEM_ERROR);
			log.error(e.getMessage(),e);
		}
		return ApiResult.valueOf(rs);
	}
	
	
}

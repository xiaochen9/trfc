package com.tianrui.web.api.android.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianrui.api.intf.api.android.imple.IAppSalesStaticService;
import com.tianrui.api.req.android.BillListParam;
import com.tianrui.api.req.android.BillSave;
import com.tianrui.api.req.android.HomePageParam;
import com.tianrui.api.req.android.LoginUserParam;
import com.tianrui.api.req.android.MyPnListParam;
import com.tianrui.api.req.android.MyVehicleListParam;
import com.tianrui.api.req.android.NoticeListParam;
import com.tianrui.api.req.android.NoticeSave;
import com.tianrui.api.req.android.SearchKeyParam;
import com.tianrui.smartfactory.common.api.ApiParam;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.vo.AppResult;
import com.tianrui.web.smvc.ApiParamRawType;

/**
 * @annotation 客商APP接口
 * @author zhanggaohao
 */
@Controller
@RequestMapping("api/android/sales/static")
public class AppSalesStaticAction {

	private Logger log = LoggerFactory.getLogger(AppSalesStaticAction.class);

	@Autowired
	private IAppSalesStaticService appService;

	@RequestMapping(value="/home",method=RequestMethod.POST)
	@ApiParamRawType(HomePageParam.class)
	@ResponseBody
	public AppResult home(ApiParam<HomePageParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.home(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/bill/list",method=RequestMethod.POST)
	@ApiParamRawType(BillListParam.class)
	@ResponseBody
	public AppResult billList(ApiParam<BillListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.billList(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/bill/detail",method=RequestMethod.POST)
	@ApiParamRawType(BillListParam.class)
	@ResponseBody
	public AppResult billDetail(ApiParam<BillListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.billDetail(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	/**
	 * @annotation 客商APP一单一车下单
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/saveBill",method=RequestMethod.POST)
	@ApiParamRawType(BillSave.class)
	@ResponseBody
	public AppResult saveBill(ApiParam<BillSave> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.saveBill(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	/**
	 * @annotation 销售订单作废（一车一单）
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/bill/delete",method=RequestMethod.POST)
	@ApiParamRawType(BillListParam.class)
	@ResponseBody
	public AppResult billDelete(ApiParam<BillListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			result = appService.billDelete(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/sendCar",method=RequestMethod.POST)
	@ApiParamRawType(NoticeSave.class)
	@ResponseBody
	public AppResult saveNotice(ApiParam<NoticeSave> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.saveNotice(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/listMoreBill",method=RequestMethod.POST)
	@ApiParamRawType(BillListParam.class)
	@ResponseBody
	public AppResult listMoreBill(ApiParam<BillListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.listMoreBill(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/moreSendCar",method=RequestMethod.POST)
	@ApiParamRawType(NoticeSave.class)
	@ResponseBody
	public AppResult moreSendCar(ApiParam<NoticeSave> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.moreSendCar(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/notice/list",method=RequestMethod.POST)
	@ApiParamRawType(NoticeListParam.class)
	@ResponseBody
	public AppResult noticeList(ApiParam<NoticeListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.noticeList(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/notice/detail",method=RequestMethod.POST)
	@ApiParamRawType(NoticeListParam.class)
	@ResponseBody
	public AppResult noticeDetail(ApiParam<NoticeListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.noticeDetail(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	//未审核的通知单可以修改，一单一车不能修改
	@RequestMapping(value="/notice/update",method=RequestMethod.POST)
	@ApiParamRawType(NoticeSave.class)
	@ResponseBody
	public AppResult noticeUpdate(ApiParam<NoticeSave> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.noticeUpdate(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/notice/cancel",method=RequestMethod.POST)
	@ApiParamRawType(NoticeListParam.class)
	@ResponseBody
	public AppResult noticeCancel(ApiParam<NoticeListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.noticeCancel(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/my/vehicle",method=RequestMethod.POST)
	@ApiParamRawType(MyVehicleListParam.class)
	@ResponseBody
	public AppResult myVehicle(ApiParam<MyVehicleListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.myVehicle(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/my/pn",method=RequestMethod.POST)
	@ApiParamRawType(MyPnListParam.class)
	@ResponseBody
	public AppResult myPn(ApiParam<MyPnListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			param.getBody().setSalesOrg(param.getHead().getSalesOrg());
			result = appService.myPn(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	@RequestMapping(value="/my/pn/detail",method=RequestMethod.POST)
	@ApiParamRawType(MyPnListParam.class)
	@ResponseBody
	public AppResult myPnDetail(ApiParam<MyPnListParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			result = appService.myPnDetail(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}

	/**
	 * 查询用户组成员
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/group/user",method=RequestMethod.POST)
	@ApiParamRawType(LoginUserParam.class)
	@ResponseBody
	public AppResult queryGroupUser(ApiParam<LoginUserParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			param.getBody().setUserId(param.getHead().getUserId());
			param.getBody().setNcId(param.getHead().getNcId());
			param.getBody().setIDType(param.getHead().getIDType());
			result = appService.customerGroupUser(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	/**
	 * 查询仓库的id和名称
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/warehouse/search",method=RequestMethod.POST)
	@ApiParamRawType(SearchKeyParam.class)
	@ResponseBody
	public AppResult queryWarehouse(ApiParam<SearchKeyParam> param){
		AppResult result = AppResult.getAppResult();
		try {
			result = appService.queryWarehouse(param.getBody());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}

}

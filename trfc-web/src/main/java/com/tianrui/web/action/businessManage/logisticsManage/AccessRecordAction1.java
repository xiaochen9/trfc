package com.tianrui.web.action.businessManage.logisticsManage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.api.intf.basicFile.measure.IVehicleManageService;
import com.tianrui.api.intf.basicFile.nc.IMaterielManageService;
import com.tianrui.api.intf.businessManage.logisticsManage.IAccessRecordService1;
import com.tianrui.api.req.businessManage.logisticsManage.AccessRecordQuery;
import com.tianrui.api.resp.businessManage.logisticsManage.AccessRecordResp;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;

@Controller
@RequestMapping("trfc/accessRecord")
public class AccessRecordAction1 {
	
	Logger logger = LoggerFactory.getLogger(AccessRecordAction1.class);
	
	@Autowired
	private IAccessRecordService1 accessRecordService;
	@Autowired
	private IMaterielManageService materielManageService;
	@Autowired
	private IVehicleManageService vehiclemanageService;
	
	@RequestMapping("main")
	public ModelAndView main(){
		ModelAndView view = new ModelAndView("businessManage/logisticsManage/accessRecord");
		try {
			view.addObject("materiel", materielManageService.findListByParmas(null).getData());
			view.addObject("vehicle", vehiclemanageService.findListByParmas(null).getData());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return view;
	}
	
	@RequestMapping("page")
	@ResponseBody
	public Result page(AccessRecordQuery query){
		Result result = Result.getSuccessResult();
		try {
			PaginationVO<AccessRecordResp> page = accessRecordService.page(query);
			result.setData(page);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
}
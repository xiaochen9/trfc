package com.tianrui.web.action.businessManage.report;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianrui.api.intf.businessManage.report.IPurchaseReportService;
import com.tianrui.api.req.businessManage.purchaseManage.PushSingleReq;
import com.tianrui.api.req.businessManage.report.ReportPurchaseQuery;
import com.tianrui.api.resp.businessManage.report.ReportPurchaseResp;
import com.tianrui.api.resp.system.auth.SystemUserResp;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;
import com.tianrui.web.util.SessionManager;


/**
 * 采购报表
 * @author Administrator
 *
 */
@RequestMapping("/trfc/purchaseReport")
@Controller
public class PurchaseReportAction {
	private Logger log = LoggerFactory.getLogger(PurchaseReportAction.class);
	
	private IPurchaseReportService purchaseReportService;
	
	/**
	 * 逐车明细
	 * @param req
	 * @return
	 */
	@RequestMapping("/commonPage")
	@ResponseBody
	public Result commonPage(ReportPurchaseQuery req,HttpServletRequest request){
		Result result = Result.getSuccessResult();
		try {
			SystemUserResp user = SessionManager.getSessionUser(request);
			if(req==null){
				req =new ReportPurchaseQuery();
			}
			req.setCurrUid(user.getId());
			PaginationVO<ReportPurchaseResp> page = purchaseReportService.page(req);
			result.setData(page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	/**
	 * 物料明细
	 * @param req
	 * @return
	 */
	@RequestMapping("/materPage")
	@ResponseBody
	public Result materPage(PushSingleReq req){
		Result result = Result.getSuccessResult();
		try {
			//PaginationVO<PushSingleResp> page = pushSingleService.page(req);
			//result.setData(page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	
	/**
	 * 采购单位明细
	 * @param req
	 * @return
	 */
	@RequestMapping("/customPage")
	@ResponseBody
	public Result customPage(PushSingleReq req){
		Result result = Result.getSuccessResult();
		try {
			//PaginationVO<PushSingleResp> page = pushSingleService.page(req);
			//result.setData(page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
	
	/**
	 * 采购收料明细
	 * @param req
	 * @return
	 */
	@RequestMapping("/receivePage")
	@ResponseBody
	public Result receivePage(PushSingleReq req){
		Result result = Result.getSuccessResult();
		try {
			//PaginationVO<PushSingleResp> page = pushSingleService.page(req);
			//result.setData(page);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setErrorCode(ErrorCode.SYSTEM_ERROR);
		}
		return result;
	}
	
}
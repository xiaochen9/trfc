package com.tianrui.service.impl.basicFile.measure;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianrui.api.intf.basicFile.measure.IBlacklistManageService;
import com.tianrui.api.req.basicFile.measure.BlacklistManageQuery;
import com.tianrui.api.req.basicFile.measure.BlacklistManageReq;
import com.tianrui.api.req.basicFile.measure.BlacklistManageSave;
import com.tianrui.api.req.basicFile.measure.TransportunitManageSave;
import com.tianrui.api.req.system.base.GetCodeReq;
import com.tianrui.api.resp.basicFile.measure.BlacklistManageResp;
import com.tianrui.api.resp.system.auth.SystemUserResp;
import com.tianrui.service.bean.basicFile.measure.BlacklistManage;
import com.tianrui.service.bean.basicFile.measure.TransportunitManage;
import com.tianrui.service.bean.basicFile.measure.VehicleManage;
import com.tianrui.service.impl.system.auth.SystemUserService;
import com.tianrui.service.mapper.basicFile.measure.BlacklistManageMapper;
import com.tianrui.service.mapper.basicFile.measure.VehicleManageMapper;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.utils.UUIDUtil;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;

@Service
public class BlacklistManageService implements IBlacklistManageService {
	
	@Autowired
	private BlacklistManageMapper blacklistManageMapper;
	@Autowired
	private SystemUserService userService;
	@Autowired
	private VehicleManageMapper vehicleManageMapper;
	
	@Override
	public int deleteBlacklist(String id){
		int n = 0;
		if(StringUtils.isNotBlank(id)){
			n = blacklistManageMapper.deleteBlacklistByVid(id);
		}
		return n;
	}

	@Override
	public int addBlacklist(BlacklistManageReq req) throws Exception {
		int n = 0;
		if(req != null){
			BlacklistManage blacklist = new BlacklistManage();
			blacklist.setVehicleno(req.getVehicleno());
			List<VehicleManage> list = this.blacklistManageMapper.selectSelective(blacklist);
			if(list != null && list.size() > 0){
				return -1;
			}
			PropertyUtils.copyProperties(blacklist, req);
			blacklist.setId(UUIDUtil.getId());
//			blacklist.setCreator("");
			blacklist.setCreatetime(System.currentTimeMillis());
//			blacklist.setModifier("");
			blacklist.setModifytime(System.currentTimeMillis());
			n = this.blacklistManageMapper.insert(blacklist);
		}
		return n;
	}

	@Override
	public Result page(BlacklistManageQuery query) throws Exception {
		Result result=Result.getSuccessResult();
		if(query!=null){
			PaginationVO<BlacklistManageResp> page = new PaginationVO<BlacklistManageResp>();
			long count=blacklistManageMapper.findBlacklistPageCount(query);
			if(count>0){
				query.setStart((query.getPageNo()-1)*query.getPageSize());
				query.setLimit(query.getPageSize());
				List<BlacklistManage> list=blacklistManageMapper.findBlacklistPage(query);
				page.setList(copyBeanList2RespList(list));
				page.setPageNo(query.getPageNo());
				page.setPageSize(query.getPageSize());
				page.setTotal(count);
				//成功时保存数据
				result.setData(page);
			}
			page.setPageNo(query.getPageNo());
			page.setPageSize(query.getPageSize());
			page.setTotal(count);
		}
		return result;
	}

	
	

	@Override
	public Result addCarBlacklist(BlacklistManageSave save) throws Exception{
		Result result=Result.getParamErrorResult();
	if(save!=null){
		BlacklistManage blacklist=new BlacklistManage();
		blacklist.setVehicleno(save.getVehicleno());
		List<VehicleManage> list = this.blacklistManageMapper.selectSelective(blacklist);
		if(list != null && list.size() > 0){
			result.setErrorCode(ErrorCode.VEHICLE_EXIST);
		}
	}
	return result;
	}

	/**
	 * 集合转换
	 * @param List<YardManage> list
	 * @return List<YardManageResp> 
	 * @throws Exception
	 */
	private List<BlacklistManageResp> copyBeanList2RespList(List<BlacklistManage> list) throws Exception {
		List<BlacklistManageResp> listResp = null;
		if(list != null && list.size() > 0){
			listResp = new ArrayList<BlacklistManageResp>();
			for(BlacklistManage blacklist : list){
				listResp.add(copyBeanList2RespList(blacklist));
			}
		}
		return listResp;
	}


	/**
	 * 实体bean类型转换
	 * @param BlacklistManage bean
	 * @return BlacklistManageResp
	 * @throws Exception
	 */
	private BlacklistManageResp copyBeanList2RespList(BlacklistManage bean) throws Exception {
		BlacklistManageResp resp = null;
		if(bean != null){
			resp = new BlacklistManageResp();
			PropertyUtils.copyProperties(resp, bean);
			if(StringUtils.isNotBlank(bean.getCreator())){
				SystemUserResp user = userService.getUser(bean.getCreator());
				if(user != null){
					resp.setCreatorName(user.getName());
				}
			}
		}
		return resp;
	}

	
	@Override
	public Result deleteblacklist(BlacklistManageQuery query) {
		Result result = Result.getParamErrorResult();
		if (query!=null && StringUtils.isNotBlank(query.getId())) {
			result = blacklistManageMapper.deleteBlacklistById(query.getId());
		}
		return result;
	}

	@Transactional
	@Override
	public Result add(BlacklistManageSave save) throws Exception {
		Result result = Result.getParamErrorResult();
		if(save != null && StringUtils.isNotBlank(save.getVehicleid())){
			BlacklistManage bean = new BlacklistManage();
			bean.setVehicleid(save.getVehicleid());
			VehicleManage vehicleManage = vehicleManageMapper.selectByPrimaryKey(save.getVehicleid());
			List<VehicleManage> list = blacklistManageMapper.selectSelective(bean);
			if(list == null || list.size() == 0){
				bean.setVehicleno(vehicleManage.getVehicleno());
				bean.setId(UUIDUtil.getId());
				GetCodeReq codeReq = new GetCodeReq();
				codeReq.setUserid(save.getCreator());
				bean.setCreator(save.getCreator());
				bean.setCreatetime(System.currentTimeMillis());
				bean.setRemarks(save.getRemarks());
				bean.setModifier(save.getCreator());
				bean.setIsvalid(save.getIsvalid());
				bean.setModifytime(save.getModifytime());
				if(blacklistManageMapper.insertSelective(bean) == 1){
					result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
				}
			}else{
				result.setErrorCode(ErrorCode.PRIMARY_SETTING_ERROR);
			}
		}
		return result;
	}
	/**
	 * 修改运输单位信息
	 */
	@Transactional
	@Override
	public Result updateBlacklist(BlacklistManageSave save) throws Exception {
		Result result = Result.getParamErrorResult();
		//参数不能为空校验
		if(save != null){
			save.setModifytime(System.currentTimeMillis());
			BlacklistManage blacklist = new BlacklistManage();
			PropertyUtils.copyProperties(blacklist, save);
			//执行修改方法，成功时提示信息
			if(blacklistManageMapper.updateByPrimaryKeySelective(blacklist) > 0){
				result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
			}else{
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return result;
	}
}
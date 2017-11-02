package com.tianrui.service.impl.system.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.tianrui.api.intf.system.auth.ISystemRolePermissionsService;
import com.tianrui.api.req.system.auth.SystemRoleMenuSave;
import com.tianrui.api.req.system.auth.SystemUserQueryReq;
import com.tianrui.api.req.system.auth.SystemUserRoleSave;
import com.tianrui.api.resp.system.auth.SystemRoleMenuResp;
import com.tianrui.api.resp.system.auth.SystemUserRoleResp;
import com.tianrui.service.bean.system.auth.SystemRoleMenu;
import com.tianrui.service.bean.system.auth.SystemUserRole;
import com.tianrui.service.mapper.system.auth.SystemRoleMenuMapper;
import com.tianrui.service.mapper.system.auth.SystemUserRoleMapper;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.utils.UUIDUtil;
import com.tianrui.smartfactory.common.vo.Result;

@Service
public class SystemRolePermissionsService implements ISystemRolePermissionsService {

	@Autowired
	private SystemUserRoleMapper systemUserRoleMapper;
	@Autowired
	private SystemRoleMenuMapper systemRoleMenuMapper;
	@Override
	public Result queryUserByRole(SystemUserQueryReq req) {
		Result result = Result.getParamErrorResult();
		if(req != null && StringUtils.isNotBlank(req.getRoleid())){
			List<SystemUserRoleResp> list = systemUserRoleMapper.queryUserByRole(req);
			result.setData(list);
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}
		return result;
	}

	@Override
	public Result queryAllUserByRole(SystemUserQueryReq req) {
		Result result = Result.getParamErrorResult();
		if(req != null && StringUtils.isNotBlank(req.getRoleid())){
			List<SystemUserRoleResp> list = systemUserRoleMapper.queryAllUserByRole(req);
			result.setData(list);
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}
		return result;
	}

	@Override
	public Result addUserToRole(SystemUserRoleSave save) {
		Result result = Result.getParamErrorResult();
		if(save != null &&StringUtils.isNotBlank(save.getUserIdJson()) 
				&& StringUtils.isNotBlank(save.getRoleId())
				&& StringUtils.isNotBlank(save.getCurrId())){
			List<String> ids = JSONArray.parseArray(save.getUserIdJson(), String.class);
			if(CollectionUtils.isNotEmpty(ids)){
				List<SystemUserRole> list = new ArrayList<SystemUserRole>();
				for(String str : ids){
					SystemUserRole bean = new SystemUserRole();
					bean.setId(UUIDUtil.getId());
					bean.setUserid(str);
					bean.setRoleid(save.getRoleId());
					bean.setIsvalid("1");
					bean.setCreator(save.getCurrId());
					bean.setCreatetime(System.currentTimeMillis());
					list.add(bean);
				}
				if(systemUserRoleMapper.insertBatch(list) == ids.size()){
					result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
				}else{
					result.setErrorCode(ErrorCode.OPERATE_ERROR);
				}
			}
		}
		return result;
	}

	@Override
	public Result deleteUserToRole(SystemUserRoleSave save) {
		Result result = Result.getParamErrorResult();
		if(save != null &&StringUtils.isNotBlank(save.getUserRoleIdJson()) 
				&& StringUtils.isNotBlank(save.getCurrId())){
			List<String> ids = JSONArray.parseArray(save.getUserRoleIdJson(), String.class);
			if(CollectionUtils.isNotEmpty(ids)){
				if(systemUserRoleMapper.deleteUserToRole(ids) == ids.size()){
					result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
				}else{
					result.setErrorCode(ErrorCode.OPERATE_ERROR);
				}
			}
		}
		return result;
	}

	@Override
	public Result queryMenuByRole(SystemUserQueryReq req) {
		Result result = Result.getParamErrorResult();
		if(req != null && StringUtils.isNotBlank(req.getRoleid())){
			List<SystemRoleMenuResp> list = systemRoleMenuMapper.queryMenuByRole(req);
			result.setData(list);
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}
		return result;
	}

	@Transactional
	@Override
	public Result authorizeMenuToRole(SystemRoleMenuSave save) {
		Result result = Result.getErrorResult();
		if(save != null && StringUtils.isNotBlank(save.getRoleId()) 
				&& StringUtils.isNotBlank(save.getMenuIdJson())){
			List<String> menuIdList = JSONArray.parseArray(save.getMenuIdJson(), String.class);
			systemRoleMenuMapper.deleteByRoleId(save.getRoleId());
			List<SystemRoleMenu> list = new ArrayList<SystemRoleMenu>();
			if(CollectionUtils.isNotEmpty(menuIdList)){
				for(String str : menuIdList){
					SystemRoleMenu bean = new SystemRoleMenu();
					bean.setId(UUIDUtil.getId());
					bean.setRoleid(save.getRoleId());
					bean.setMenuid(str);
					bean.setIsvalid("1");
					bean.setCreator(save.getCurrId());
					bean.setCreatetime(System.currentTimeMillis());
					list.add(bean);
				}
				systemRoleMenuMapper.insertBatch(list);
			}
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}else{
			result.setErrorCode(ErrorCode.OPERATE_ERROR);
		}
		return result;
	}

	@Override
	public Result resetMenuToRole(SystemRoleMenuSave save) {
		Result result = Result.getErrorResult();
		if(save != null && StringUtils.isNotBlank(save.getRoleId())){
			systemRoleMenuMapper.deleteByRoleId(save.getRoleId());
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}else{
			result.setErrorCode(ErrorCode.OPERATE_ERROR);
		}
		return result;
	}

	@Override
	public Result selectRole(SystemUserQueryReq req) {
		Result result = Result.getParamErrorResult();
		if(req != null && StringUtils.isNotBlank(req.getRoleid())){
		//	List<SystemRoleMenuResp> list = systemRoleMenuMapper.queryMenuByRole(req);
			List<SystemRoleMenuResp> list = systemRoleMenuMapper.selectRole(req);
			result.setData(list);
			result.setErrorCode(ErrorCode.SYSTEM_SUCCESS);
		}
		return result;
	}
	@Override
	public List<SystemRoleMenuResp> iphonRole(String id) {
		SystemUserRole  systemUserRole =systemUserRoleMapper.iphoneRole(id);
		List<SystemRoleMenuResp> list = systemRoleMenuMapper.iphoneRole(systemUserRole.getRoleid());
		return list;
	}
	
}
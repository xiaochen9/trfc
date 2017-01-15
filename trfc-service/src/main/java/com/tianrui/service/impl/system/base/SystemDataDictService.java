package com.tianrui.service.impl.system.base;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianrui.api.intf.system.base.ISystemDataDictService;
import com.tianrui.api.req.system.base.SystemDataDictItemReq;
import com.tianrui.api.req.system.base.SystemDataDictReq;
import com.tianrui.api.resp.system.base.SystemDataDictItemResp;
import com.tianrui.api.resp.system.base.SystemDataDictResp;
import com.tianrui.service.bean.system.base.SystemDataDict;
import com.tianrui.service.bean.system.base.SystemDataDictItem;
import com.tianrui.service.mapper.system.base.SystemDataDictItemMapper;
import com.tianrui.service.mapper.system.base.SystemDataDictMapper;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.utils.UUIDUtil;
import com.tianrui.smartfactory.common.vo.Result;
/**
 * 系统数据字典Service
 * @author Yangzhenfu
 * @createtime 2017年1月11日 下午2:56:14
 * @classname SystemDataDictService.java
 */
@Service
public class SystemDataDictService implements ISystemDataDictService{
	
	@Autowired
	private SystemDataDictMapper systemDataDictMapper;
	
	@Autowired
	private SystemDataDictItemMapper systemDataDictItemMapper;
	
	/**
	 * 查询所有数据字典类别
	 */
	@Override
	public Result findSystemDataDicts(SystemDataDictReq req){
		Result result=Result.getSuccessResult();
		if(req!=null){
			List<SystemDataDictResp> page=new ArrayList<SystemDataDictResp>();
			SystemDataDict dataDict=new SystemDataDict();
			try {
				PropertyUtils.copyProperties(dataDict, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			List<SystemDataDict> list=this.systemDataDictMapper.findSystemDataDicts(req);
			try {
				page=copyBeanListRespList(list);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
			result.setData(page);
		}
		return result;
	}
	
	
	/**
	 * 增加数据字典类别
	 */
	@Transactional
	@Override
	public Result addSystemDataDict(SystemDataDictReq req) {
		Result result = Result.getSuccessResult();
		if(req != null){
			SystemDataDict dataDict=new SystemDataDict();
			try {
				PropertyUtils.copyProperties(dataDict, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			dataDict.setId(UUIDUtil.getId());
			dataDict.setCreator("YZF");
			dataDict.setCreatetime(System.currentTimeMillis());
			dataDict.setModifier("YZF");
			dataDict.setModifytime(System.currentTimeMillis());
			dataDict.setUtc(new Timestamp(System.currentTimeMillis()));
			int n=this.systemDataDictMapper.insert(dataDict);
			if(n > 0){
				result.setData(n);
			}else if(n == -1){
				result.setErrorCode(ErrorCode.PARAM_REPEAT_ERROR);
			}else{
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return result;
	}
	
	/**
	 * 修改数据字典类别
	 */
	@Transactional
	@Override
	public Result editSystemDataDict(SystemDataDictReq req) {
		Result result=Result.getSuccessResult();
		if(req != null){
			SystemDataDict dataDict=new SystemDataDict();
			try {
				PropertyUtils.copyProperties(dataDict, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			dataDict.setModifytime(System.currentTimeMillis());
			dataDict.setUtc(new Timestamp(System.currentTimeMillis()));
			int n=this.systemDataDictMapper.updateByPrimaryKeySelective(dataDict);
			if(n > 0){
				result.setData(n);
			}else{
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return result;
	}
	
	/**
	 * 删除数据字典类别
	 */
	@Transactional
	@Override
	public Result deleteSystemDataDict(String id) {
		Result result=Result.getSuccessResult();
		if(id!=null && !id.trim().isEmpty()){
			SystemDataDict dataDict=this.systemDataDictMapper.selectByPrimaryKey(id);
			if(dataDict!=null){
				List<SystemDataDictItem> list=this.systemDataDictItemMapper.selectByDictId(id);
				if(list.isEmpty()){
					int n=this.systemDataDictMapper.deleteByPrimaryKey(id);
					if(n>0){
						result.setData(n); 	
					}
				}else{
					result.setErrorCode(ErrorCode.OPERATE_ERROR);
				}
			}else{
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			}
		}
		return result;
	}
	
	/**
	 * 集合类型转换
	 * @param List<SystemDataDict>
	 * @return List<SystemDataDictResp>
	 * @throws Exception
	 */
	private List<SystemDataDictResp> copyBeanListRespList(List<SystemDataDict> list) throws Exception {
		List<SystemDataDictResp> listResp = null;
		if(list != null && list.size() > 0){
			listResp = new ArrayList<SystemDataDictResp>();
			for(SystemDataDict dataDict : list){
				listResp.add(copyBeanResp(dataDict));
			}
		}
		return listResp;
	}


	/**
	 * 实体bean类型转换
	 * @param SystemDataDict
	 * @return SystemDataDictResp
	 * @throws Exception
	 */
	private SystemDataDictResp copyBeanResp(SystemDataDict bean) throws Exception {
		SystemDataDictResp resp = null;
		if(bean != null){
			resp = new SystemDataDictResp();
			PropertyUtils.copyProperties(resp, bean);
		}
		return resp;
	}


	/**
	 * 根据数据字典类别id查询所有的数据字典明细
	 */
	@Override
	public Result findSystemDataDictItems(SystemDataDictItemReq req) {
		Result result=Result.getSuccessResult();
		if(req!=null){
			List<SystemDataDictItemResp> page=new ArrayList<SystemDataDictItemResp>();
			SystemDataDictItem dictItem=new SystemDataDictItem();
			try {
				PropertyUtils.copyProperties(dictItem, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			String dictId=dictItem.getDictid();
			List<SystemDataDictItem> list=this.systemDataDictItemMapper.selectByDictId(dictId);
			try {
				page=copyBeanList2RespList(list);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
			result.setData(page);
		}
		return result;
	}

	/**
	 * 增加数据字典明细
	 */
	@Transactional
	@Override
	public Result addSystemDataDictItem(SystemDataDictItemReq req) {
		Result result = Result.getSuccessResult();
		if(req != null){ 
			SystemDataDictItem dictItem=new SystemDataDictItem();
			try {
				PropertyUtils.copyProperties(dictItem, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			dictItem.setId(UUIDUtil.getId());
			dictItem.setCreator("YZF");
			dictItem.setCreatetime(System.currentTimeMillis());
			dictItem.setModifier("YZF");
			dictItem.setModifytime(System.currentTimeMillis());
			dictItem.setUtc(new Timestamp(System.currentTimeMillis()));
			int n=this.systemDataDictItemMapper.insert(dictItem);
			if(n > 0){
				result.setData(n);
			}else if(n == -1){
				result.setErrorCode(ErrorCode.PARAM_REPEAT_ERROR);
			}else{
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return result;
	}

	/**
	 * 修改数据字典明细
	 */
	@Transactional
	@Override
	public Result editSystemDataDictItem(SystemDataDictItemReq req) {
		Result result=Result.getSuccessResult();
		if(req != null){
			SystemDataDictItem dictItem=new SystemDataDictItem();
			try {
				PropertyUtils.copyProperties(dictItem, req);
			} catch (Exception e) {
				e.printStackTrace();
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			} 
			dictItem.setModifytime(System.currentTimeMillis());
			dictItem.setUtc(new Timestamp(System.currentTimeMillis()));
			int n=this.systemDataDictItemMapper.updateByPrimaryKeySelective(dictItem);
			if(n > 0){
				result.setData(n);
			}else{
				result.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return result;
	}

	/**
	 * 删除数据字典明细
	 */
	@Transactional
	@Override
	public Result deleteSystemDataDictItem(String id) {
		Result result=Result.getSuccessResult();
		if(id!=null && !id.trim().isEmpty()){
			SystemDataDictItem dictItem=this.systemDataDictItemMapper.selectByPrimaryKey(id);
			if(dictItem!=null){
				int n=this.systemDataDictItemMapper.deleteByPrimaryKey(id);
				if(n > 0){
					result.setData(n);
				}else{
					result.setErrorCode(ErrorCode.OPERATE_ERROR);
				}
			}else{
				result.setErrorCode(ErrorCode.PARAM_ERROR);
			}
		}
		return result;
	}
	
	/**
	 * 集合类型转换
	 * @param List<SystemDataDictItem>
	 * @return List<SystemDataDictItemResp>
	 * @throws Exception
	 */
	private List<SystemDataDictItemResp> copyBeanList2RespList(List<SystemDataDictItem> list) throws Exception {
		List<SystemDataDictItemResp> listResp = null;
		if(list != null && list.size() > 0){
			listResp = new ArrayList<SystemDataDictItemResp>();
			for(SystemDataDictItem dataDict : list){
				listResp.add(copyBean2Resp(dataDict));
			}
		}
		return listResp;
	}


	/**
	 * 实体bean类型转换
	 * @param SystemDataDictItem
	 * @return SystemDataDictItemResp
	 * @throws Exception
	 */
	private SystemDataDictItemResp copyBean2Resp(SystemDataDictItem bean) throws Exception {
		SystemDataDictItemResp resp = null;
		if(bean != null){
			resp = new SystemDataDictItemResp();
			PropertyUtils.copyProperties(resp, bean);
		}
		return resp;
	}
}
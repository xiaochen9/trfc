package com.tianrui.service.impl.quality.file;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.tianrui.api.intf.quality.file.IQualitySchemeItemService;
import com.tianrui.api.req.quality.file.QualityItemReq;
import com.tianrui.api.req.quality.file.QualitySchemeItemReq;
import com.tianrui.api.resp.quality.file.QualitySchemeItemResp;
import com.tianrui.api.resp.quality.file.QualitySchemeItemRespSP;
import com.tianrui.service.bean.quality.file.QualityItem;
import com.tianrui.service.bean.quality.file.QualitySchemeItem;
import com.tianrui.service.mapper.quality.file.QualityItemMapper;
import com.tianrui.service.mapper.quality.file.QualitySchemeItemMapper;
import com.tianrui.service.mapper.quality.file.QualitySchemeMapper;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.utils.UUIDUtil;
import com.tianrui.smartfactory.common.vo.Result;

@Service
public class QualitySchemeItemService implements IQualitySchemeItemService {

	@Resource
	private QualitySchemeItemMapper qualitySchemeItemMapper;
	@Resource
	private QualityItemMapper qualityItemMapper;
	@Resource
	private QualitySchemeMapper qualitySchemeMapper;
	
	
	@Override
	@Transactional
	public Result delete(QualitySchemeItemReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getId())){
			//删除数据库中的数据
			int index = qualitySchemeItemMapper.deleteByPrimaryKey(req.getId());
			//判断操作是否成功
			if(index>0){
				rs = Result.getSuccessResult();
			}else{
				rs.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return rs;
	}

	@Override
	@Transactional
	public Result deleteBatch(QualitySchemeItemReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getSchemeid())){
			//删除数据库中的数据
			int index = qualitySchemeItemMapper.deleteBatch(req.getSchemeid());
			//判断操作是否成功
			if(index>0){
				rs = Result.getSuccessResult();
			}else{
				rs.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return rs;
	}

	@Override
	@Transactional
	public Result add(QualitySchemeItemReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null){
			QualitySchemeItem qi = new QualitySchemeItem();
			PropertyUtils.copyProperties(qi, req);
			//设置id
			qi.setId(UUIDUtil.getId());
			//设置创建者和修改者
			qi.setCreator(req.getUser());
			qi.setCreatetime(System.currentTimeMillis());
			qi.setModifier(req.getUser());
			qi.setModifytime(System.currentTimeMillis());
			qi.setUtc(System.currentTimeMillis());
			//保存数据
			int index = qualitySchemeItemMapper.insertSelective(qi);
			//判断操作是否成功
			if(index>0){
				rs = Result.getSuccessResult();
			}else{
				rs.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return rs;
	}

	@Override
	@Transactional
	public Result addBatch(QualitySchemeItemReq qsiReq) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(qsiReq!=null){
			List<QualitySchemeItemReq> list = getListReq(qsiReq);
			List<QualitySchemeItem> objs = new ArrayList<QualitySchemeItem>();
			//集合类型转换
			for(QualitySchemeItemReq req : list){
				QualitySchemeItem obj = new QualitySchemeItem();
				//类型转换
				PropertyUtils.copyProperties(obj, req);
				//获取ID
				obj.setId(UUIDUtil.getId());
				//获取单据编号
				obj.setCreator(req.getUser());
				obj.setModifier(req.getUser());
				obj.setModifytime(System.currentTimeMillis());
				//对状态进行默认复制
				obj.setStatus("0");
				objs.add(obj);
			}
			//调用批量添加
			int index = qualitySchemeItemMapper.insertBatch(objs);
			if(index==objs.size()){
				//操作成功
				rs = Result.getSuccessResult();
			}else{
				//操作失败
				rs.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return rs;
	}
	/**
	 * 通过req获取List集合
	 */
	public List<QualitySchemeItemReq> getListReq(QualitySchemeItemReq req){
		List<QualitySchemeItemReq> list = new ArrayList<QualitySchemeItemReq>();
		//将字符串转换为json数组
		JSONArray json = JSONArray.parseArray(req.getArrStr());
		//通过循环把数组中的数据添加到list集合中
		for(int i=0;i<json.size();i++){
			//json对象转换为java对象
			QualitySchemeItemReq s = JSONArray.toJavaObject(json.getJSONObject(i), QualitySchemeItemReq.class);
			s.setSchemeid(req.getSchemeid());
			s.setInvalid(req.getInvalid());
			//设置状态为 未初始化
			s.setStatus("0");
			s.setUser(req.getUser());
			list.add(s);
		}
		return list;
	}
	
	
	@Override
	@Transactional
	public Result update(QualitySchemeItemReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getId())){
			QualitySchemeItem batchnum  = new QualitySchemeItem();
			//类型转换
			PropertyUtils.copyProperties(batchnum, req);

			//获取修改者和时间
			batchnum.setModifier(req.getUser());
			batchnum.setModifytime(System.currentTimeMillis());
			batchnum.setUtc(System.currentTimeMillis());
			//更新数据到数据库
			int index = qualitySchemeItemMapper.updateByPrimaryKeySelective(batchnum);
			if(index>0){
				//操作成功
				rs = Result.getSuccessResult();
			}else{
				//操作失败
				rs.setErrorCode(ErrorCode.OPERATE_ERROR);
			}
		}
		return rs;
	}

	@Override
	public Result findBySchemeId(QualitySchemeItemReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getSchemeid())){
			List<QualitySchemeItem> list = qualitySchemeItemMapper.findBySchemeId(req);
			//判断需要查询的数据是否是已初始化的
			if("1"==req.getStatus()){
			List<QualitySchemeItemResp> resps = new ArrayList<QualitySchemeItemResp>();
			if(list!=null && !list.isEmpty()){
				for(QualitySchemeItem q : list){
					QualitySchemeItemResp resp = new QualitySchemeItemResp();
					PropertyUtils.copyProperties(resp,q);
					resps.add(resp);
				}
				rs = Result.getSuccessResult();
				rs.setData(resps);
			}
			}else{
				List<QualitySchemeItemRespSP> sps = new ArrayList<QualitySchemeItemRespSP>();
				if(list!=null && !list.isEmpty()){
					for(QualitySchemeItem q : list){
						QualitySchemeItemRespSP resp = new QualitySchemeItemRespSP();
						PropertyUtils.copyProperties(resp,q);
					
						//获取item对象
						QualityItem qi = qualityItemMapper.selectByPrimaryKey(resp.getItemid());
						if(qi!=null){
							resp.setItemcode(qi.getCode());
							resp.setItemname(qi.getName());
						}
						sps.add(resp);
					}
				}
				rs = Result.getSuccessResult();
				rs.setData(sps);
			}
		
		}
		return rs;
	}

	@Override
	public Result itemData() throws Exception {
		Result rs = Result.getErrorResult();
		QualityItemReq req = new QualityItemReq();
		List<QualityItem> list = qualityItemMapper.page(req);
		if(list==null){
			rs = Result.getSuccessResult();
			rs.setData(list);
		}
		return rs;
	}

}

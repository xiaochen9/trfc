package com.tianrui.service.impl.quality.file;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.tianrui.api.intf.quality.file.IQualitySchemeService;
import com.tianrui.api.req.quality.file.QualitySchemeReq;
import com.tianrui.api.resp.quality.file.QualitySchemeResp;
import com.tianrui.service.bean.basicFile.nc.MaterielManage;
import com.tianrui.service.bean.quality.file.QualityScheme;
import com.tianrui.service.bean.system.base.SystemDataDictItem;
import com.tianrui.service.mapper.basicFile.nc.MaterielManageMapper;
import com.tianrui.service.mapper.quality.file.QualitySchemeMapper;
import com.tianrui.service.mapper.system.base.SystemDataDictItemMapper;
import com.tianrui.smartfactory.common.constants.ErrorCode;
import com.tianrui.smartfactory.common.utils.UUIDUtil;
import com.tianrui.smartfactory.common.vo.PaginationVO;
import com.tianrui.smartfactory.common.vo.Result;

@Service
public class QualitySchemeService implements IQualitySchemeService {
	@Resource
	private QualitySchemeMapper qualitySchemeMapper;
	@Resource
	private MaterielManageMapper materielManageMapper;
	@Resource
	private	SystemDataDictItemMapper systemDataDictItemMapper;
	
	@Override
	public Result delete(QualitySchemeReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getId())){
			//删除数据
			int index = qualitySchemeMapper.deleteByPrimaryKey(req.getId());
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
	public Result add(QualitySchemeReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null){
			QualityScheme qs = new QualityScheme();
			PropertyUtils.copyProperties(qs, req);
			//设置id
			qs.setId(UUIDUtil.getId());
			//设置创建者和修改者
			qs.setCreator(req.getUser());
			qs.setCreatetime(System.currentTimeMillis());
			qs.setModifier(req.getUser());
			qs.setModifytime(System.currentTimeMillis());
			qs.setUtc(System.currentTimeMillis());
			//保存数据
			int index = qualitySchemeMapper.insertSelective(qs);
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
	public Result update(QualitySchemeReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null && StringUtils.isNotBlank(req.getId())){
			//转换类型
			QualityScheme qs = new QualityScheme();
			PropertyUtils.copyProperties(qs, req);
			//设置创建者和修改者
			qs.setModifier(req.getUser());
			qs.setModifytime(System.currentTimeMillis());
			qs.setUtc(System.currentTimeMillis());
			//更新数据
			int index = qualitySchemeMapper.updateByPrimaryKeySelective(qs);
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
	public Result page(QualitySchemeReq req) throws Exception {
		Result rs = Result.getParamErrorResult();
		if(req!=null){
			PaginationVO<QualitySchemeResp> page = new PaginationVO<QualitySchemeResp>();
			int pageNo = req.getPageNo();
			int pageSize = req.getPageSize();
			//设置开始位置,和每页数据量
			req.setStart((pageNo-1)*pageSize);
			req.setLimit(pageSize);
			//获取数据总数
			int total = qualitySchemeMapper.count(req);
			page.setPageNo(pageNo);
			page.setPageSize(pageSize);
			page.setTotal(total);
			System.out.println(total);
			//创建一个出参集合
			List<QualitySchemeResp> resps = new ArrayList<QualitySchemeResp>();
			//判断是否有数据可查询
			if(total>0){
				List<QualityScheme> list = qualitySchemeMapper.page(req);
				if(list!=null && !list.isEmpty()){
					//遍历集合,并转换类型
					for(QualityScheme c : list){
						QualitySchemeResp resp = new QualitySchemeResp();
						PropertyUtils.copyProperties(resp, c);
						//通过物料id 查询物料信息 获取物料名称
						MaterielManage m = materielManageMapper.selectByPrimaryKey(c.getMaterialid());
						if(m!=null){
							resp.setMaterialname(m.getName());
						}
						//通过单据id 查询单据信息,获取单据名称
						SystemDataDictItem sd = systemDataDictItemMapper.selectByPrimaryKey(c.getBills());
						if(sd!=null){
							resp.setBillsname(sd.getName());
						}
						//将对象放入集合
						resps.add(resp);
					}
				}
			}
			page.setList(resps);
			rs = Result.getSuccessResult();
			rs.setData(page);
		}
		return rs;
	}
	public Result billsData() throws Exception{
		Result rs = Result.getSuccessResult();
		//设置单据类型id
		String dictId = "dbca68d35daa485fa07a813504511d03";
		//查询所有单据类型
		List<SystemDataDictItem> list = systemDataDictItemMapper.selectByDictId(dictId);
		rs.setData(list);
		return rs;
	}

}

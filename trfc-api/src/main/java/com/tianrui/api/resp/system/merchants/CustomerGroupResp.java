package com.tianrui.api.resp.system.merchants;

import com.tianrui.api.resp.BaseResp;

/**
 * @Description 客户用户返回结果
 * @author zhanggaohao
 * @version 2017年5月9日 上午9:17:08
 */
public class CustomerGroupResp extends BaseResp {
	
	private static final long serialVersionUID = 5391895839927532175L;
	//主键
	private String id;
	//供应商主键id
	private String customerid;
	//供应商编码
	private String customercode;
	//供应商名称
	private String customername;
	//所属组id(所属供应商id)
	private String groupid;
	//状态（0：失效，1：有效）
    private String state;
    //创建人
    private String creator;
    //创建时间
    private Long createtime;
    //最后修改人
    private String modifier;
    //最后修改时间
    private Long modifytime;
    //备注
    private String remark;
    
	public String getId() {
		return id;
	}
	public String getCustomerid() {
		return customerid;
	}
	public String getCustomercode() {
		return customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public String getGroupid() {
		return groupid;
	}
	public String getState() {
		return state;
	}
	public String getCreator() {
		return creator;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public String getModifier() {
		return modifier;
	}
	public Long getModifytime() {
		return modifytime;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public void setModifytime(Long modifytime) {
		this.modifytime = modifytime;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
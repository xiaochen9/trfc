package com.tianrui.api.resp.basicFile.other;

import com.tianrui.api.resp.BaseResp;

public class OtherBdVehicleResp extends BaseResp{

	private static final long serialVersionUID = 8345430264466036754L;
	private String id;
    
    private String code;
   
    private String innercode;

    private String name;

    private String info;

    private String addr;

    private String telphone;

    private Byte isvalid;

    private String orgid;

    private String orgname;

    private String remark;

    private String creator;

    private Long createtime;

    private String modifier;

    private Long modifytime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInnercode() {
		return innercode;
	}

	public void setInnercode(String innercode) {
		this.innercode = innercode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Byte getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Byte isvalid) {
		this.isvalid = isvalid;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Long getModifytime() {
		return modifytime;
	}

	public void setModifytime(Long modifytime) {
		this.modifytime = modifytime;
	}

	@Override
	public String toString() {
		return "OtherBdVehicleResp [id=" + id + ", code=" + code + ", innercode=" + innercode + ", name=" + name
				+ ", info=" + info + ", addr=" + addr + ", telphone=" + telphone + ", isvalid=" + isvalid + ", orgid="
				+ orgid + ", orgname=" + orgname + ", remark=" + remark + ", creator=" + creator + ", createtime="
				+ createtime + ", modifier=" + modifier + ", modifytime=" + modifytime + "]";
	}
    
}

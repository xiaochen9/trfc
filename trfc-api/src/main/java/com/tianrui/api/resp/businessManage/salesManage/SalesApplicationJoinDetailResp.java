package com.tianrui.api.resp.businessManage.salesManage;

import com.tianrui.api.resp.BaseResp;
import com.tianrui.smartfactory.common.utils.DateUtil;

public class SalesApplicationJoinDetailResp extends BaseResp {
	
	private static final long serialVersionUID = -2559538852082320742L;
	//主键id
    private String id="";
    //订单编号
    private String code="";
    //订单状态
    private String status="";
    //来源
    private String source="";
    //订单类型id
    private String billtypeid="";
    //订单类型名称
    private String billtypename="";
    //客户id
    private String customerid="";
    //客户名称
    private String customername="";
    //区域码
    private String channelcode="";
    //业务员id
    private String salesmanid="";
    //业务员名称
    private String salesmanname="";
    //订单日期
    private Long billtime=0l;
    //订单日期Str
    private String billtimeStr="";
    //组织id
    private String orgid="";
    //组织名称
    private String orgname="";
    //运输公司id
    private String transportcompanyid="";
    //运输公司名称
    private String transportcompanyname="";
    //部门id
    private String departmentid="";
    //部门名称
    private String departmentname="";
    //审核人id
    private String auditid="";
    //审核人姓名
    private String auditname="";
    //审核日期
    private Long audittime=0l;
    //审核日期Str
    private String audittimeStr="";
    //状态：（0：删除，1：正常）
    private String state="";
    //制单人id
    private String makerid="";
    //制单人名称
    private String makebillname="";
    //制单时间
    private Long makebilltime=0l;
    //制单日期Str
    private String makebilltimeStr="";
    //备注
    private String remarks="";
    //创建人
    private String creator="";
    //创建时间
    private Long createtime=0l;
    //创建时间Str
    private String createtimeStr="";
    //最后修改人
    private String modifier="";
    //最后修改时间
    private Long modifytime=0l;
    //最后修改时间Str
    private String modifytimeStr="";
    /**
     * 订单详情
     */
    //字表id
    private String detailid="";
    //物料名称
    private String materielid="";
    //物料名称
    private String materielname="";
    //包装类型
    private String packagetype="";
    //订单数量
    private Double salessum=0d;
    //单位
    private String unit="";
    //单价
    private Double taxprice=0d;

    /**
     * 仓库物料数量统计
     */
    //余量
    private Double margin=0d;
    //入库占用量
    private Double storagequantity=0d;
    //未入库占用量
    private Double unstoragequantity=0d;
    //到货占用量
    private Double pretendingtake=0d;
    
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBilltypeid() {
		return billtypeid;
	}
	public void setBilltypeid(String billtypeid) {
		this.billtypeid = billtypeid;
	}
	public String getBilltypename() {
		return billtypename;
	}
	public void setBilltypename(String billtypename) {
		this.billtypename = billtypename;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getChannelcode() {
		return channelcode;
	}
	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}
	public String getSalesmanid() {
		return salesmanid;
	}
	public void setSalesmanid(String salesmanid) {
		this.salesmanid = salesmanid;
	}
	public String getSalesmanname() {
		return salesmanname;
	}
	public void setSalesmanname(String salesmanname) {
		this.salesmanname = salesmanname;
	}
	public Long getBilltime() {
		return billtime;
	}
	public void setBilltime(Long billtime) {
		this.billtime = billtime;
		this.billtimeStr = DateUtil.parse(billtime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getBilltimeStr() {
		return billtimeStr;
	}
	public void setBilltimeStr(String billtimeStr) {
		this.billtimeStr = billtimeStr;
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
	public String getTransportcompanyid() {
		return transportcompanyid;
	}
	public void setTransportcompanyid(String transportcompanyid) {
		this.transportcompanyid = transportcompanyid;
	}
	public String getTransportcompanyname() {
		return transportcompanyname;
	}
	public void setTransportcompanyname(String transportcompanyname) {
		this.transportcompanyname = transportcompanyname;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getAuditid() {
		return auditid;
	}
	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}
	public String getAuditname() {
		return auditname;
	}
	public void setAuditname(String auditname) {
		this.auditname = auditname;
	}
	public Long getAudittime() {
		return audittime;
	}
	public void setAudittime(Long audittime) {
		this.audittime = audittime;
		this.audittimeStr = DateUtil.parse(audittime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getAudittimeStr() {
		return audittimeStr;
	}
	public void setAudittimeStr(String audittimeStr) {
		this.audittimeStr = audittimeStr;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMakerid() {
		return makerid;
	}
	public void setMakerid(String makerid) {
		this.makerid = makerid;
	}
	public String getMakebillname() {
		return makebillname;
	}
	public void setMakebillname(String makebillname) {
		this.makebillname = makebillname;
	}
	public Long getMakebilltime() {
		return makebilltime;
	}
	public void setMakebilltime(Long makebilltime) {
		this.makebilltime = makebilltime;
		this.makebilltimeStr = DateUtil.parse(makebilltime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getMakebilltimeStr() {
		return makebilltimeStr;
	}
	public void setMakebilltimeStr(String makebilltimeStr) {
		this.makebilltimeStr = makebilltimeStr;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		this.createtimeStr = DateUtil.parse(createtime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getCreatetimeStr() {
		return createtimeStr;
	}
	public void setCreatetimeStr(String createtimeStr) {
		this.createtimeStr = createtimeStr;
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
		this.modifytimeStr = DateUtil.parse(modifytime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getModifytimeStr() {
		return modifytimeStr;
	}
	public void setModifytimeStr(String modifytimeStr) {
		this.modifytimeStr = modifytimeStr;
	}
	public String getDetailid() {
		return detailid;
	}
	public void setDetailid(String detailid) {
		this.detailid = detailid;
	}
	/**
	 * @return the materielid
	 */
	public String getMaterielid() {
		return materielid;
	}
	/**
	 * @param materielid the materielid to set
	 */
	public void setMaterielid(String materielid) {
		this.materielid = materielid;
	}
	public String getMaterielname() {
		return materielname;
	}
	public void setMaterielname(String materielname) {
		this.materielname = materielname;
	}
	public Double getSalessum() {
		return salessum;
	}
	public void setSalessum(Double salessum) {
		this.salessum = salessum;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the taxprice
	 */
	public Double getTaxprice() {
		return taxprice;
	}
	/**
	 * @param taxprice the taxprice to set
	 */
	public void setTaxprice(Double taxprice) {
		this.taxprice = taxprice;
	}
	public Double getMargin() {
		return margin;
	}
	public void setMargin(Double margin) {
		this.margin = margin;
	}
	public Double getStoragequantity() {
		return storagequantity;
	}
	public void setStoragequantity(Double storagequantity) {
		this.storagequantity = storagequantity;
	}
	public Double getUnstoragequantity() {
		return unstoragequantity;
	}
	public void setUnstoragequantity(Double unstoragequantity) {
		this.unstoragequantity = unstoragequantity;
	}
	public Double getPretendingtake() {
		return pretendingtake;
	}
	public void setPretendingtake(Double pretendingtake) {
		this.pretendingtake = pretendingtake;
	}
	public String getPackagetype() {
		return packagetype;
	}
	public void setPackagetype(String packagetype) {
		this.packagetype = packagetype;
	}

}
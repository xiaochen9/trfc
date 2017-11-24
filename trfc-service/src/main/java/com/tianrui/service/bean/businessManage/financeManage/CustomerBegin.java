package com.tianrui.service.bean.businessManage.financeManage;

public class CustomerBegin {
    //  主键id
    private String id;
    //客户期初编号
    private String code;
    //'审核状态 0-未审核，1-已审核'
    private String auditstatus;
    //组织id
    private String orgid;
    // 组织名称
    private String orgname;
    // 客户id
    private String customerid;
    // 客户名称
    private String customername;
    // 收款方式
    private String paymentmethod;
    // 付款人
    private String payer;
    // 单据日期
    private String billdate;
    // 金额
    private Double money;
    // 金额大写
    private String moneybig;
    // 收款单位
    private String collectionunit;
    // 制单人id
    private String makeid;
    // 制单人名称
    private String makebillname;
    // 制单日期
    private Long makebilltime;
    // 审核人id
    private String auditid;
    // 审核人名称
    private String auditname;
    // 审核日期
    private Long audittime;
    // 状态（0：删除，1：正常）
    private String state;
    // 创建人
    private String creator;
    // 创建日期
    private Long createtime;
    // 客户名称
    private String modifier;
    // 客户名称
    private Long modifytime;
    // 客户名称
    private String remark;
    // 客户名称
    private Long utc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus == null ? null : auditstatus.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod == null ? null : paymentmethod.trim();
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getCollectionunit() {
        return collectionunit;
    }

    public void setCollectionunit(String collectionunit) {
        this.collectionunit = collectionunit == null ? null : collectionunit.trim();
    }

    public String getMakeid() {
        return makeid;
    }

    public void setMakeid(String makeid) {
        this.makeid = makeid == null ? null : makeid.trim();
    }

    public String getMakebillname() {
        return makebillname;
    }

    public void setMakebillname(String makebillname) {
        this.makebillname = makebillname == null ? null : makebillname.trim();
    }

    public Long getMakebilltime() {
        return makebilltime;
    }

    public void setMakebilltime(Long makebilltime) {
        this.makebilltime = makebilltime;
    }

    public String getAuditid() {
        return auditid;
    }

    public void setAuditid(String auditid) {
        this.auditid = auditid == null ? null : auditid.trim();
    }

    public String getAuditname() {
        return auditname;
    }

    public void setAuditname(String auditname) {
        this.auditname = auditname == null ? null : auditname.trim();
    }

    public Long getAudittime() {
        return audittime;
    }

    public void setAudittime(Long audittime) {
        this.audittime = audittime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Long getModifytime() {
        return modifytime;
    }

    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getUtc() {
        return utc;
    }

    public void setUtc(Long utc) {
        this.utc = utc;
    }

	public String getMoneybig() {
		return moneybig;
	}

	public void setMoneybig(String moneybig) {
		this.moneybig = moneybig;
	}
    
}
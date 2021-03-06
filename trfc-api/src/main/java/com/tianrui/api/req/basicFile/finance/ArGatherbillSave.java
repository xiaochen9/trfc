package com.tianrui.api.req.basicFile.finance;

import com.tianrui.api.req.BaseReq;

public class ArGatherbillSave extends BaseReq{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    //  nc收款单子表id
    private String ncid2;
    //  nc收款单主表id
    private String ncid1;
    //  客户ncid
    private String customerId;
    //  客户编码
    private String customerCode;
    //  客户名称
    private String customerName;
    //  单据号
    private String billno;
    //  单据日期
    private String billdate;
    //  单据状态
    private String billstatus;
    //  组织本币金额
    private String localMoney;
    //  原币金额
    private String money;
    //  审批人
    private String approver;
    //  审批状态
    private String approvestatus;
    //  审批日期
    private String approvedated;
    //  收款组织ncid
    private String saleOrgId;
    //  收款组织名称
    private String saleOrgName;
    //  发货组织ncid
    private String deliveryOrgId;
    //  物料ncid
    private String materialId;
    //  物料编码
    private String materialCode;
    //  制单人
    private String billmaker;
    //  时间戳
    private String ts;
    //  创建时间
    private Long createTime;
    
  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNcid2() {
		return ncid2;
	}
	public void setNcid2(String ncid2) {
		this.ncid2 = ncid2;
	}
	public String getNcid1() {
		return ncid1;
	}
	public void setNcid1(String ncid1) {
		this.ncid1 = ncid1;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String getBillstatus() {
		return billstatus;
	}
	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}
	public String getLocalMoney() {
		return localMoney;
	}
	public void setLocalMoney(String localMoney) {
		this.localMoney = localMoney;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getApprovestatus() {
		return approvestatus;
	}
	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}
	public String getApprovedated() {
		return approvedated;
	}
	public void setApprovedated(String approvedated) {
		this.approvedated = approvedated;
	}
	public String getSaleOrgId() {
		return saleOrgId;
	}
	public void setSaleOrgId(String saleOrgId) {
		this.saleOrgId = saleOrgId;
	}
	public String getSaleOrgName() {
		return saleOrgName;
	}
	public void setSaleOrgName(String saleOrgName) {
		this.saleOrgName = saleOrgName;
	}
	public String getDeliveryOrgId() {
		return deliveryOrgId;
	}
	public void setDeliveryOrgId(String deliveryOrgId) {
		this.deliveryOrgId = deliveryOrgId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getBillmaker() {
		return billmaker;
	}
	public void setBillmaker(String billmaker) {
		this.billmaker = billmaker;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}

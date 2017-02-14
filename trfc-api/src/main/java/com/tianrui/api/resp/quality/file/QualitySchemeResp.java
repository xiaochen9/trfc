package com.tianrui.api.resp.quality.file;

import com.tianrui.api.resp.BaseResp;

public class QualitySchemeResp extends BaseResp {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4969730429290395169L;
	/**
	 * 主键id
	 */
    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 物料id
     */
    private String materialid;
    /**
     * 物料名称
     */
    private String materialname;
    /**
     * 单据
     */
    private String bills;
    /**
     * 单据名称
     */
    private String billsname;
    /**
     * 有效性(0:有效,1:无效)
     */
    private String invalid;
    /**
     * 默认的(0:默认的,1:非默认的)
     */
    private String defaults;
    /**
     * 类型(0:采购项目,1:销售项目)
     */
    private String type;
    /**
     * 质量标准(0:标准,1:非标准)
     */
    private String standard;
    /**
     * 描述
     */
    private String describe;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaterialid() {
		return materialid;
	}
	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}
	public String getMaterialname() {
		return materialname;
	}
	public void setMaterialname(String materialname) {
		this.materialname = materialname;
	}
	public String getBills() {
		return bills;
	}
	public void setBills(String bills) {
		this.bills = bills;
	}
	public String getBillsname() {
		return billsname;
	}
	public void setBillsname(String billsname) {
		this.billsname = billsname;
	}
	public String getInvalid() {
		return invalid;
	}
	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}
	public String getDefaults() {
		return defaults;
	}
	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
 
}

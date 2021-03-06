package com.tianrui.api.req.system.auth;

import com.tianrui.api.req.BaseReq;
/**
 * 菜单管理req
 * @author lixp
 *
 */
public class SystemMenuSaveReq extends BaseReq {

	private static final long serialVersionUID = 2174287526269962856L;
	
	private String id;
    //模块编码
    private String code;
    //模块名称
    private String name;
    //上级模块id
    private String roleid;
    //上级模块名称
    private String roleType;
    //有效性    默认无效 0无效 1有效
    private Byte isvalid;
    //链接地址
    private String uri;
    //排序
    private Integer orderBy;
    //深度	
    private Integer deep;
    //参数
    private String param;
    //菜单图片
    private String imgType;
    //说明
    private String info;
    //连接目标
    private String linkgoal;
    //分组行
    private Integer grouping;
    //当前登录用户id
  	private String currUId;
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
	public String getCurrUId() {
		return currUId;
	}
	public void setCurrUId(String currUId) {
		this.currUId = currUId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public Byte getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(Byte isvalid) {
		this.isvalid = isvalid;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Integer getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getDeep() {
		return deep;
	}
	public void setDeep(Integer deep) {
		this.deep = deep;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getLinkgoal() {
		return linkgoal;
	}
	public void setLinkgoal(String linkgoal) {
		this.linkgoal = linkgoal;
	}
	public Integer getGrouping() {
		return grouping;
	}
	public void setGrouping(Integer grouping) {
		this.grouping = grouping;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
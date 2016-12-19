<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
<meta name="keywords" content=" 天瑞" />
<meta name="description" content="">
<meta name="author" content="">
<link href="/resources/css/bootstrap.css" rel="stylesheet">
<link href="/resources/css/base.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
<link href="/resources/css/pagination.css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="/resources/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="left ">
		<div class="user">
			<a href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"> <img src="/resources/images/tx.jpg"
				class="img-circle"> <label>超级管理员</label> <i class="iconfont">&#xe602;</i>
			</a>
			<ul class="dropdown-menu">
				<li><a data-toggle="modal" data-target="#account"><i
						class="iconfont">&#xe60e;</i>个人资料</a></li>
				<li class="divider"></li>
				<li><a data-toggle="modal" data-target="#password"><i
						class="iconfont">&#xe60d;</i> 设置</a></li>
			</ul>
		</div>
		<div class="menu">
			<label>菜单</label> <i class="iconfont fr">&#xe61a;</i>
		</div>
		<ul class="typelist">
			<li><i class="iconfont">&#xe617;</i> <label>采购管理</label></li>
			<li><i class="iconfont">&#xe615;</i> <label>销售管理</label></li>
			<li><i class="iconfont">&#xe614;</i> <label>其他页面</label></li>
			<li class="active"><i class="iconfont">&#xe618;</i> <label>档案管理</label>
			</li>
		</ul>
	</div>
	<div class="leftmini hide">
		<div class="user">
			<a href="#" data-toggle="dropdown" data-target="#menu-messages"
				class="dropdown-toggle"> <img src="/resources/images/tx.jpg"
				class="img-circle">
			</a>
			<ul class="dropdown-menu">
				<li><a data-toggle="modal" data-target="#account"><i
						class="iconfont">&#xe60e;</i>个人资料</a></li>
				<li class="divider"></li>
				<li><a data-toggle="modal" data-target="#password"><i
						class="iconfont">&#xe60d;</i> 设置</a></li>
			</ul>
		</div>
		<div class="menu2">
			<i class="iconfont">&#xe635;</i>
		</div>
		<ul class="typelist">
			<li class="active" data-toggle="tooltip" data-placement="right"
				title="采购管理"><i class="iconfont">&#xe617;</i></li>
			<li data-toggle="tooltip" data-placement="right" title="销售管理"><i
				class="iconfont">&#xe615;</i></li>
			<li data-toggle="tooltip" data-placement="right" title=" 其他"><i
				class="iconfont">&#xe614;</i></li>
			<li><i class="iconfont">&#xe618;</i></li>
			<li><i class="iconfont">&#xe619;</i></li>
			<li><i class="iconfont">&#xe613;</i></li>
			<li><i class="iconfont">&#xe612;</i></li>
			<li><i class="iconfont">&#xe610;</i></li>
			<li><i class="iconfont">&#xe60f;</i></li>
			<li><i class="iconfont">&#xe611;</i></li>
		</ul>
	</div>
	<div class="right">
		<div class="intel_tab">
			<!--tab切换标题-->
			<ul class="intel_menu">
				<li>客户管理</li>
				<li>仓库管理</li>
				<li>供应商管理</li>
				<li class="select">物料管理</li>
			</ul>
			<!--tab切换标题end-->
			<div class="top_opera">
				<a><i class="iconfont" data-toggle="tooltip"
					data-placement="left" title="首页">&#xe605;</i></a> <a><i
					class="iconfont" data-toggle="tooltip" data-placement="left"
					title="控制面板">&#xe606;</i></a> <a><i class="iconfont"
					data-toggle="tooltip" data-placement="left" title="退出">&#xe607;</i></a>
			</div>
		</div>

		<!--tab切换的内容-->
		<div class="intel_tabbox">
			<div id="test" class="intel_tabcont">
				<div class="intel_search">
					<div class="intel_bggray">
						<div class="intel_bgblue"></div>
					</div>
					<div class="intel_sconditon">
						<div class="intel_solo">
							<label>查询条件：</label> 
							<select id="qtp" class="form-control">
								<option value="mc">名称</option>
								<option value="nm">内码</option>
								<option value="py">拼音助记码</option>
							</select>
						</div>
						<div class="intel_sline">
							<div class="intel_solo">
								<label>关键字：</label> 
								<input id="keyword" type="text">
							</div>
							<div class="intel_solo">
								<label>所属组织：</label> 
								<input id="orgid" type="text">
							</div>
							<div class="intel_solo">
								<label>业务类型：</label> 
								<select id="type"
									class="form-control">
									<option value="">请选择</option>
									<option value="0">采购</option>
									<option value="1">销售</option>
									<option value="2">共有</option>
								</select>
							</div>
							<div class="intel_solo">
								<div class="intel_sbtn">
									<button id="searchBtn" class="btn btnblue">搜索</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="intel_opera">
					<div id="refreshBtn" class="intel_operasolo">
						<i class="iconfont colorlv">&#xe61b;</i>
						<span>刷新</span>
					</div>
				</div>
				<div class="intel_table">
					<!--用户表格begin-->
					<table class="table table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>内码</th>
								<th>名称</th>
								<th>规格</th>
								<th>型号</th>
								<th>拼音助记码</th>
								<th>收货确认</th>
								<th>出厂编号</th>
								<th>包装类型</th>
								<th>业务类型</th>
								<th>有效</th>
								<th>散装写卡(计量)</th>
								<th>所属组织</th>
								<th>描述</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="materBody">
						</tbody>
					</table>
					<!--用户表格end-->
				</div>
				<!--分页效果开始-->
				<div class="page">
					<div class="page_date">
						<label>数据共：</label><i id="total" class="colorred">100</i><label>条</label>
					</div>
					<div class="page_date">
						<label>跳到第：</label> 
						<input id="jumpPageNo" type="text"> <label>页</label>
						<button id="jumpPageNoBtn" class="btn btn-default">确定</button>
					</div>
					<div class="page_date">
						<label>每页记录：</label>
						<select id="pageSize" class="form-control">
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="30">30</option>
						</select>
					</div>
					<div class="page_btn" id="pagination"></div>
				</div>
				<!--分页效果结束-->
			</div>
		</div>
	</div>
	<!--编辑begin-->
	<div class="modal fade" id="editMater" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width: 750px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="alt_head">
						<h5>物料信息管理</h5>
					</div>
				</div>
				<div class="modal-body">
					<input id="materId" type="hidden">
					<div class="alt_edit">
						<div class="alt_edit_div">
							<label>物料编号：</label> 
							<input id="code" type="text" readonly>
						</div>
						<div class="alt_edit_div">
							<label>物料内码：</label> 
							<input id="internalcode" type="text" readonly>
						</div>
						<div class="alt_edit_div">
							<label>物料名称：</label> 
							<input id="name" type="text">
						</div>
						<div class="alt_edit_div">
							<label>物料简称：</label> 
							<input id="abbrname" type="text">
						</div>
						<div class="alt_edit_div">
							<label>拼音助词码：</label> 
							<input id="pinyincode" type="text">
						</div>
						<div class="alt_edit_div">
							<label>有效性：</label> 
							<input id="effective" type="checkbox"><span>有效</span>
						</div>
						<div class="alt_edit_textarea">
							<label>备注： </label>
							<textarea id="remarks" class="form-control" rows="1"></textarea>
						</div>
						<div class="alt_title">
							<h4>常用物料设置</h4>
						</div>
						<div class="alt_edit_div">
							<label>业务类型：</label>
							<select id="businesstype" class="form-control">
								<option value="">请选择</option>
								<option value="0">采购</option>
								<option value="1">销售</option>
								<option value="2">共有</option>
							</select>
						</div>
						<div class="alt_edit_div">
							<label>包装类型：</label> 
							<select id="packagetype" class="form-control">
								<option value="">请选择</option>
								<option value="0">袋装</option>
								<option value="1">水泥散装</option>
								<option value="2">其他散装</option>
							</select>
						</div>
						<div class="alt_edit_div">
							<label>排队前缀：</label>
							<select id="queuingprefix" class="form-control">
								<option value="">请选择</option>
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
								<option value="E">E</option>
								<option value="F">F</option>
							</select>
						</div>
						<div class="alt_edit_div" style="width: 100%">
							<label>选项：</label>
							<input id="receiptstatus" type="checkbox"><span>收货确认</span>
							<input id="factorycode" type="checkbox"><span>出厂编号</span>
							<input id="bulkwritecard" type="checkbox"><span>散装写卡(计量)</span>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="updateBtn">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	<!--编辑end-->
	<script type="text/javascript" src="/resources/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="/resources/js/jquery.pagination.js"></script>
	<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="/resources/js/layer/layer.js"></script>
	<script type="text/javascript" src="/resources/js/basicFile/nc/materiel.js"></script>
</body>
</html>
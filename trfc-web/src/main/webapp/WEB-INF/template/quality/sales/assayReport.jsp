<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售化验报告</title>
<link href="${staticBasePath}/css/select2.css" rel="stylesheet">
<jsp:include page="../../common/base/header_busi.jsp"></jsp:include>
</head>
<body>

	<div class="it_admin">
		<jsp:include page="../../common/base/left_busi.jsp"></jsp:include>
		<div class="right">
			<jsp:include page="../../common/base/right_head_busi.jsp"></jsp:include>
			<div class="intel_tab">
				<!--tab切换标题-->
				<ul class="intel_menu">
					<li><a href="/trfc/quality/sales/batchnum/main">销售批号</a></li>
					<li class="select">销售化验报告</li>
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
				<!--采购申请单begin-->
				<div class="intel_tabcont">
					<div class="intel_search">
						<div class="intel_bggray">
							<div class="intel_bgblue"></div>
						</div>
						<div class="intel_sconditon">
							<div class="intel_sline">
								<div class="intel_solo">
									<label>开始时间：</label> <input type="text" readonly="true"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'})"
										class="Wdate" style="width: 160px" />
								</div>
								<div class="intel_solo">
									<label>结束时间：</label> <input type="text" readonly="true"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'})"
										class="Wdate" style="width: 160px" />
								</div>
								<div class="intel_solo">
									<label>单据编号：</label> <input type="text">
								</div>
								<div class="intel_solo">
									<label>出厂编号：</label> <input type="text">
								</div>
								<div class="intel_solo">
									<label>报告天数：</label> <select class="form-control">
										<option>请选择</option>
										<option>3天</option>
										<option>28天</option>
									</select>
								</div>
								<div class="intel_solo">
									<button class="btn btnblue ">搜索</button>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="intel_opera">
						<div class="intel_operasolo">
							<i class="iconfont colorlv">&#xe61b;</i>
							<h5>刷新</h5>
						</div>
						<div class="intel_operasolo">
							<a href=" "> <i class="iconfont coloradd">&#xe627;</i>
								<h5>新增</h5>
							</a>
						</div>

					</div>
					<div class="intel_table">
						<!--用户表格begin-->
						<table class="table table-hover">
							<thead>
								<tr>
									<th>行号</th>
									<th>单据编号</th>
									<th>审核状态</th>
									<th>打印状态</th>
									<th>水泥品种</th>
									<th>水泥名称</th>
									<th>批号</th>
									<th>生产日期</th>
									<th>试验日期</th>
									<th>销售日期</th>
									<th>报告天数</th>
									<th>报告人</th>
									<th>地址</th>
									<th>审核时间</th>
									<th>审核人</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>zg522121233</td>
									<td class="colorred">审核中</td>
									<td class="colorred">否</td>
									<td>未化验</td>
									<td>未入厂</td>
									<td>粉煤灰1</td>
									<td>粉煤灰1</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>28</td>
									<td>admin</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td><span> <a data-toggle="modal"
											data-target="#dele"><i class="iconfont"
												data-toggle="tooltip" data-placement="left" title="删除">&#xe63d;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="停用">&#xe624;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="审核">&#xe692;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="反审">&#xe651;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="复制">&#xe61c;</i></a>
									</span></td>
								</tr>
								<tr>
									<td>1</td>
									<td>zg522121233</td>
									<td class="colorred">待审核</td>
									<td class="colorred">否</td>
									<td>未化验</td>
									<td>未入厂</td>
									<td>粉煤灰1</td>
									<td>粉煤灰1</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>28天</td>
									<td>admin</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td><span> <a data-toggle="modal"
											data-target="#dele"><i class="iconfont"
												data-toggle="tooltip" data-placement="left" title="删除">&#xe63d;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="停用">&#xe624;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="审核">&#xe692;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="反审">&#xe651;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="复制">&#xe61c;</i></a>
									</span></td>
								</tr>
								<tr>
									<td>1</td>
									<td>zg522121233</td>
									<td>审核中</td>
									<td class="colorred">否</td>
									<td>未化验</td>
									<td>未入厂</td>
									<td>粉煤灰1</td>
									<td>粉煤灰1</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>28天</td>
									<td>admin</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td>未入厂</td>
									<td><span> <a data-toggle="modal"
											data-target="#dele"><i class="iconfont"
												data-toggle="tooltip" data-placement="left" title="删除">&#xe63d;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="停用">&#xe624;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="审核">&#xe692;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="反审">&#xe651;</i></a>
									</span> <span> <a data-toggle="modal" data-target="#dele"><i
												class="iconfont" data-toggle="tooltip" data-placement="left"
												title="复制">&#xe61c;</i></a>
									</span></td>
								</tr>
							</tbody>
						</table>
						<!--用户表格end-->
					</div>

					<!--分页效果开始-->
					<div class=" row fr">
						<div class="page_date">
							<label>数据共：</label><i class="colorred">100</i><label>条</label>
						</div>
						<div class="page_date">
							<label>跳到第：</label> <input type="text"> <label>页</label>
							<button class="btn btn-default">确定</button>
						</div>
						<div class="page_btn">
							<ul class="pagination">
								<li><a href="#">&laquo;上一页</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">...</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">下一页&raquo;</a></li>
							</ul>
						</div>
					</div>
					<!--分页效果结束-->
				</div>
			</div>
		</div>
	</div>
		<!-- 引用公共footer部分 -->
		<jsp:include page="../../common/base/footer_busi.jsp"></jsp:include>
			<script type="text/javascript"
		src="/javascript/quality/sales/assayReport.js"></script>
</body>
</html>

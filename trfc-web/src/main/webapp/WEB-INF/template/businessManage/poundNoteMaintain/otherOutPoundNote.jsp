<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>其他出库磅单维护</title>
<!-- 引用公共header部分 -->
<jsp:include page="../../common/base/header_busi.jsp"></jsp:include>
</head>
<body>
	<div class="it_admin">
		<jsp:include page="../../common/base/left_busi.jsp"></jsp:include>
		<div class="right">
			<!-- 引用公共right部分 -->
			<jsp:include page="../../common/base/right_head_busi.jsp"></jsp:include>
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
									<label>开始时间：</label> <input id="starttime" type="text" readonly
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',maxDate:'#F{$dp.$D(\'endtime\')}'})"
										class="Wdate" style="width: 160px" placeholder="请选择开始时间" />
								</div>
								<div class="intel_solo">
									<label>结束时间：</label> <input id="endtime" type="text" readonly
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',minDate:'#F{$dp.$D(\'starttime\')}'})"
										class="Wdate" style="width: 160px" placeholder="请选择结束时间" />
								</div>
								<div class="intel_solo">
									<label>仓库：</label> <input id="warehouse" type="text" placeholder="请选择仓库">
								</div>
								<div class="intel_solo">
									<label>客户：</label> <input id="customer" type="text" placeholder="请选择供应商">
								</div>
								<div class="intel_solo">
									<label>物料：</label> <input id="materiel" type="text" placeholder="请选择物料">
								</div>
								<div class="intel_solo">
									<label>车号：</label> <input id="vehicle" type="text" placeholder="请选择车号">
								</div>
								<div class="intel_solo">
									<label>过磅单号：</label> <input id="code" type="text" placeholder="请输入过磅单号">
								</div>
								<div class="intel_solo">
									<label>净重：</label> <select id="operator" class="mini_select form-control" style="padding: 0px;">
										<option value="0">大于</option>
										<option value="1">大于等于</option>
										<option value="2">小于</option>
										<option value="3">小于等于</option>
										<option value="4">等于</option>
									</select> <input id="netweight" type="text" class="mini_input" placeholder="请输入净重">
								</div>
								<div class="intel_solo">
									<label>单据类型：</label> <select id="status" class="form-control">
										<option value="">请选择</option>
										<option value="1">补增</option>
										<option value="3">作废</option>
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
						<!-- <div id="refresh" class="intel_operasolo">
							<a> <i class="iconfont colorlv">&#xe61b;</i>
								<span>刷新</span>
							</a>
						</div>
						<div id="addBtn" class="intel_operasolo">
							<a data-toggle="modal" data-target="#add"> <i
								class="iconfont coloradd">&#xe647;</i>
								<span>补增</span>
							</a>
						</div>
						<div id="invalid" class="intel_operasolo">
							<a> <i class="iconfont invalid">&#xe60c;</i>
								<span>作废</span>
							</a>
						</div> 
                        <div id="print" class="intel_operasolo">
                            <a> <i class="iconfont print">&#xe726;</i>
                                <span>补打榜单</span>
                            </a>
                        </div>-->
					</div>
					<div class="intel_table">
						<!--用户表格begin-->
						<table class="table table-hover maintable">
							<thead>
								<tr>
									<th>序号</th>
									<th>过磅单号</th>
									<th>单据状态</th>
									<th>通知单号</th>
									<th>客户</th>
									<th>单位</th>
									<th>发货单位</th>
									<th>仓库</th>
									<th>物料</th>
									<th>货物</th>
									<th>车号</th>
									<th>毛重</th>
									<th>皮重</th>
									<th>净重</th>
									<th>轻车时间</th>
									<th>重车时间</th>
									<th>制单人</th>
									<th>制单日期</th>
								</tr>
							</thead>
							<tbody id="dataBody">
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
							<label>跳到第：</label> <input id="jumpPageNo" type="text"> <label>页</label>
							<button id="jumpPageNoBtn" class="btn btn-default">确定</button>
						</div>
						<div class="page_date">
							<label>每页记录：</label> <select id="pageSize" class="form-control">
								<option value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
							</select>
						</div>
						<div class="page_btn" id="pagination"></div>
					</div>
					<!--分页效果结束-->
				</div>
				<!--tab切换的内容end-->
			</div>
		</div>
	</div>
	<!-- 引用公共footer部分 -->
	<jsp:include page="../../common/base/footer_busi.jsp"></jsp:include>
    <jsp:include page="../../common/module/printTemplate.jsp"></jsp:include>
	<script type="text/javascript"
		src="/javascript/businessManage/poundNoteMaintain/otherOutPoundNote.js?2018010301"></script>
</body>
</html>
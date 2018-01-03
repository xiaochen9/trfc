<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date"%>
<!Doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>其他报表</title>
  <style>
    .wuliao_opera .wuliao_tab ul  li.select {
            background: #434e8d;
            color: #ffffff;
        }
    .wuliao_opera .wuliao_tab ul{
        width: 50%;
        float:right;
    }
        .wuliao_opera .wuliao_tab ul li{
            border: 1px solid #e3e4ea;
            line-height: 36px;
            float:right;
            width: 14%;
            padding: 0 15px;
            text-align: center;
            cursor: pointer;
        }
        .biobiaop{
            text-align: left;
            font-size: 20px;
            margin-left: 20px;
            color:#434e8d;
        }
        .colorB{
            color:#434e8d ;
        }
        .intel_table{
            overflow: hidden;
        }
    </style>
<!-- 引用公共header部分 -->
<jsp:include page="../../common/base/header_busi.jsp"></jsp:include>
</head>
<body>
	<div class="it_admin">
		<!-- 引用公共left部分 -->
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
                <label class="colorB">供应商：</label>
                <input type="text" id="bbg_gys" placeholder="请选择供应商">
            </div>
            <div class="intel_solo">
                <label class="colorB">物料：</label>
                <input type="text" id="gys" placeholder="请选择物料">
            </div>
            <div class="intel_solo">
                <label class="colorB">司机姓名：</label>
                <input type="text" id="bbg_sjn" placeholder="请选择司机">
            </div>
            <div class="intel_solo">
                <label class="colorB">开始时间：</label>
                <input id="clock1" type="text" readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',maxDate:'#F{$dp.$D(\'clock2\')}'})" class="Wdate"
                       style="width:160px"/>
            </div>
            <div class="intel_solo">
                <label class="colorB">结束时间：</label>
                <input id="clock2" type="text" readonly onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',minDate:'#F{$dp.$D(\'clock1\')}'})" class="Wdate"
                       style="width:160px"/>
            </div>
            <div class="intel_solo">
           <button class="btn" id="yearNow" style="color: #166aa8;margin: 0 5px 0 -10px">当年</button>
            </div>
            <div class="intel_solo">
            <button class="btn" id="monthNow" style="color: #166aa8;margin: 0 5px 0 -10px">当月</button>
            </div>
            <div class="intel_solo">
            <button class="btn" id="dayNow" style="color: #166aa8;margin: 0 5px 0 -10px">当日</button>
            </div>
            <div class="intel_solo">
                <label class="colorB">车牌号：</label>
                <input type="text" id="bbg_cph" placeholder="请选择车号">
            </div>
            <div class="intel_solo">
                <label class="colorB">备注：</label>
                <input type="text" id="bbg_bz" placeholder="请选择备注">
            </div>
            <div class="intel_solo">
                <div class="intel_sbtn">
                    <button id="searchBtn" class="btn btnblue" onclick="bbgClick()">搜索</button>
                </div>
            </div>
            <div class="intel_solo">
                <div class="intel_sbtn">
                    <button class="btn" id="clean" style="color: #166aa8;margin: 0 5px 0 -20px">重置</button>
                </div>
            </div>
        </div>
							</div>
						</div>
						<div class="intel_opera">
    <!--物料四个按钮切换-->
    <div class="wuliao_opera" style="position:relative;">
        <div class="wuliao_tab tj_tab">
            <ul>
                <li style="width:150px;" id="receive" data-type="0">其他出库逐车明细</li>
                <li style="width:150px;" id="thing" class="select" data-type="1">其他入库逐车明细</li>
            </ul>
        </div>
        <div class="wuliao_tabbox">
            <div class="wuliao_tabcont hide_receive hide">
                <div class="intel_table">
                    <div class="intel_table">
                     <div style="position: absolute;left:0px;top:0px;">
						  <div class="intel_operasolo" id="allExport1">
						        <i class="iconfont" style="color: #0174c3;font-size: 25px;margin-left: 22px">&#xe63c;</i>
						        <p>导出全部</p>
						    </div>					
						    <div class="intel_operasolo" onclick="method('.tableExcel2')">
						        <i class="iconfont" style="color: #0174c3;font-size: 25px;margin-left: 22px">&#xe63c;</i>
						        <p>导出当前页</p>
						    </div>
						    <div class="intel_operasolo" onclick="preview2()">
						        <a data-toggle="modal" data-target="#add">
						            <i class="iconfont" style="color: #7fe29f;font-size: 25px;margin-left: 22px">&#xe726;</i>
						            <p>打印当前页</p>
						        </a>
						    </div>
                        </div>
                        <!--startprint2-->
                        <div class="intel_table" style="border:1px solid #dbe7f3;margin-top: 20px">
                            <!--用户表格begin-->
                            <table class="tableExcel2" width="100%" border="1" cellspacing="0" cellpadding="0">
                                <thead>
                                <tr>
                                    <td colspan="12" align="center" style="color:#434e8d;font-size: 40px;line-height:normal">
                                        	裕泰其他出库逐车明细
                                        <p class="biobiaop" style="margin-top: 10px">
                                            <span class="clock12"></span><span class="clock13"></span>
                                        </p>
                                        <p class="biobiaop" style="margin-bottom: 10px">条件：<span class="bbg_tiaojian3"></span></p>
                                    </td>
                                </tr>
                                <tr>
                                    <th style="font-size: 20px">过磅单号</th>
                                    <th style="font-size: 20px">通知单号</th>
                                    <th style="font-size: 20px">收货单位</th>
                                    <th style="font-size: 20px">发货单位</th>
                                    <th style="font-size: 20px">仓库</th>
                                    <th style="font-size: 20px">货物</th>
                                    <th style="font-size: 20px">车号</th>
                                    <th style="font-size: 20px">毛重</th>
                                    <th style="font-size: 20px">皮重</th>
                                    <th style="font-size: 20px">净重</th>
                                    <th style="font-size: 20px">轻车时间</th>
                                    <th style="font-size: 20px">重车时间</th>
                                </tr>
                                </thead>
                                <tbody id="RMg3">
                                
                                </tbody>
                            </table>
                            <div style="font-size: 20px;margin: 30px">制表时间：<span class="clock14"></span>
                              
                            </div>
                            <!--用户表格end-->
                        </div>
                        <!--endprint2-->
                       <!--  全部导出begin -->
                       <div style="display: none;text-indent:-9999px;height: 0px !important;" class="intel_table" style="border:1px solid #dbe7f3;margin-top: 20px">
                            <!--用户表格begin-->
                            <table class="tableExcelA" width="100%" border="1" cellspacing="0" cellpadding="0">
                                <thead>
                                <tr>
                                    <td colspan="12" align="center" style="color:#434e8d;font-size: 40px;line-height:normal">
                         			               裕泰其他出库逐车明细
                                    </td>
                                </tr>
                                <tr>
                                    <th style="font-size: 20px">过磅单号</th>
                                    <th style="font-size: 20px">通知单号</th>
                                    <th style="font-size: 20px">收货单位</th>
                                    <th style="font-size: 20px">发货单位</th>
                                    <th style="font-size: 20px">仓库</th>
                                    <th style="font-size: 20px">货物</th>
                                    <th style="font-size: 20px">车号</th>
                                    <th style="font-size: 20px">毛重</th>
                                    <th style="font-size: 20px">皮重</th>
                                    <th style="font-size: 20px">净重</th>
                                    <th style="font-size: 20px">轻车时间</th>
                                    <th style="font-size: 20px">重车时间</th>
                                </tr>
                                </thead>
                                <tbody id="RMgA">
                                
                                </tbody>
                            </table>  
                        </div>
                       <!--  全部导出end -->
                    </div>
                </div>
            </div>
            <div class="wuliao_tabcont hide_thing">
                <div class="intel_table">
                 <div style="position: absolute;left:0px;top:0px;">
						  <div class="intel_operasolo" id="allExport2">
						        <i class="iconfont" style="color: #0174c3;font-size: 25px;margin-left: 22px">&#xe63c;</i>
						        <p>导出全部</p>
						    </div>					
						    <div class="intel_operasolo" onclick="method('.tableExcel3')">
						        <i class="iconfont" style="color: #0174c3;font-size: 25px;margin-left: 22px">&#xe63c;</i>
						        <p>导出当前页</p>
						    </div>
						    <div class="intel_operasolo" onclick="preview3()">
						        <a data-toggle="modal" data-target="#add">
						            <i class="iconfont" style="color: #7fe29f;font-size: 25px;margin-left: 22px">&#xe726;</i>
						            <p>打印当前页</p>
						        </a>
						    </div>
                        </div>
                    <!--startprint3-->
                    <div class="intel_table" style="border:1px solid #dbe7f3;margin-top: 20px">
                        <!--用户表格begin-->
                        <table class="tableExcel3" width="100%" border="1" cellspacing="0" cellpadding="0">
                            <thead>
                            <tr>
                                <td colspan="13" align="center" style="color:#434e8d;font-size: 40px;line-height:normal">
                           				  裕泰其他入库逐车明细
                                    <p class="biobiaop" style="margin-top: 10px">
                                    <span class="clock3"></span><span class="clock4"></span>
                                    </p>
                                    <p class="biobiaop" style="margin-bottom: 10px">条件：<span class="bbg_tiaojian4"></span></p>
                                </td>
                            </tr>
                            <tr>
	                            <th style="font-size: 20px">过磅单号</th>
	                            <th style="font-size: 20px">通知单号</th>
	                            <th style="font-size: 20px">单位</th>
                                <th style="font-size: 20px">收货单位</th>
                                <th style="font-size: 20px">仓库</th>
                                <th style="font-size: 20px">货物</th>
                                <th style="font-size: 20px">车号</th>
                                <th style="font-size: 20px">毛重</th>
                                <th style="font-size: 20px">皮重</th>
                                <th style="font-size: 20px">净重</th>
                                <th style="font-size: 20px">轻车时间</th>
                                <th style="font-size: 20px">重车时间</th>
                                <th style="font-size: 20px">备注</th>
                            </tr>
                            </thead>
                            <tbody id="RMg4">
                            
                            </tbody>
                        </table>
                        <div style="font-size: 20px;margin: 30px">制表时间：<span class="clock5"></span>
                         
                        </div>
                        <!--用户表格end-->
                    </div>
                    <!--endprint3-->
                  <!--   导出全部begin -->
                  <div style="display: none;text-indent:-9999px;height: 0px !important;" class="intel_table" style="border:1px solid #dbe7f3;margin-top: 20px">
                        <!--用户表格begin-->
                        <table class="tableExcelB" width="100%" border="1" cellspacing="0" cellpadding="0">
                            <thead>
                            <tr>
                                <td colspan="13" align="center" style="color:#434e8d;font-size: 40px;line-height:normal">
                                	裕泰其他入库逐车明细               
                                </td>
                            </tr>
                            <tr>
	                            <th style="font-size: 20px">过磅单号</th>
	                            <th style="font-size: 20px">通知单号</th>
	                            <th style="font-size: 20px">单位</th>
                                <th style="font-size: 20px">收货单位</th>
                                <th style="font-size: 20px">仓库</th>
                                <th style="font-size: 20px">货物</th>
                                <th style="font-size: 20px">车号</th>
                                <th style="font-size: 20px">毛重</th>
                                <th style="font-size: 20px">皮重</th>
                                <th style="font-size: 20px">净重</th>
                                <th style="font-size: 20px">轻车时间</th>
                                <th style="font-size: 20px">重车时间</th>
                                <th style="font-size: 20px">备注</th>
                            </tr>
                            </thead>
                            <tbody id="RMgB">
                            
                            </tbody>
                        </table>
                    </div>
                  <!--   导出全部end -->
                </div>
            </div>
        </div>
    </div>
</div>
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
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
							</select>
						</div>
						<div class="page_btn" id="pagination"></div>
					</div>
					<!--分页效果结束-->
				</div>
			</div>
			<!-- 引用公共footer部分 -->
			<jsp:include page="../../common/base/footer_busi.jsp"></jsp:include>
			<script type="text/javascript"
				src="/javascript/businessManage/Report/ReportOtherTable.js?2018010301"></script>
			<script type="text/javascript"
				src="/javascript/businessManage/Report/ReportOtherTable2.js?2018010301"></script>
</body>
</html>
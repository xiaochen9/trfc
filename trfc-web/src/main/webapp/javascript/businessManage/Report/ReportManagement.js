(function($, win){
	//请求路径
	var URL = {
			commonUrl:"/trfc/purchaseReport/commonPage",		//采购逐车
			materUrl:"/trfc/purchaseReport/materPage",			//物料统计
			customUrl:"/trfc/purchaseReport/customPage",		//单位统计
			receiveUrl:"/trfc/purchaseReport/receivePage",    //收料统计
			commonListUrl:"/trfc/purchaseReport/commonList",
			customListUrl:"/trfc/purchaseReport/customList",
			receiveListUrl:"/trfc/purchaseReport/receiveList",    //收料统计
			materListUrl:"/trfc/purchaseReport/materList",			//物料统计
			BuZengUrl:"/trfc/purchaseReport/buZengPage",     //补增
			BuZengListUrl:"/trfc/purchaseReport/buZengList",     
			minemouthnameUrl:"/trfc/purchaseReport/ minemouthnamePage",  //矿口汇总
			minemouthnameListUrl:"/trfc/purchaseReport/ minemouthnameList",  //矿口汇总
			supplytimeUrl:"/trfc/purchaseReport/datePage",  //采购物料供应商时间汇总全部分页数据
			supplytimeListUrl:"/trfc/purchaseReport/dateList",  //采购物料供应商时间汇总 导出数据
			miningcollectUrl:"/trfc/purchaseReport/minPage",  //采矿点汇总全部分页数据
			miningcollectListUrl:"/trfc/purchaseReport/minList"  //采矿点汇总 导出数据
	};
	init();
	function init(){
		//初始化默认查询当天的数据
		var array = getTodayStr();
		$('#clock1').val(array[0]);
		$('#clock2').val(array[1]);
		bindEvent();
		materList();
		$(".wuliao_tabcont").hide();
		$(".hide_thing").show();
		searchData(1);
	}
	//tab切换，初始表格展示结果
	$('#thing').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_thing").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData4(1);
			
	});
	
	$('#receive').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_receive").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData3(1);
		
	});
	$('#unit').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
	    $(".wuliao_tabcont").hide();
		$(".hide_unit").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData2(1);
		
	});
	$('#buyCar').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_buyCar").show();
		$("#tag_display_billcode").removeClass("displayNone");
		$("#tag_display_poundcode").removeClass("displayNone");
		queryData(1);
		
	});	
	$('#buyAdd').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_buyAdd").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData5(1);
		
	});	
	$('#mineMouthSummary').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_mineMouthSummary").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData6(1);
		
	});
	//表格展示结果
	$('#supplytime').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_supplytime").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData7(1);
		
	});	
	$('#miningcollect').off('click').on('click',function(){
		$('input#jumpPageNo').val('');
		$(".wuliao_tabcont").hide();
		$(".hide_miningcollect").show();
		$("#tag_display_billcode").addClass("displayNone");
		$("#tag_display_poundcode").addClass("displayNone");
		queryData8(1);
		
	});	
	// 导出数据
	$("#allExport1").off('click').on('click',function(){
		commonList();
		method('.tableExcelA');
	})
	$("#allExport2").off('click').on('click',function(){
		customList();
		method('.tableExcelB');
	})
	$("#allExport3").off('click').on('click',function(){
		receiveList();
		method('.tableExcelC');
	})
	$("#allExport4").off('click').on('click',function(){
		materList();
		method('.tableExcelD');
	})
	$("#allExport5").off('click').on('click',function(){
		BuZengList();
		method('.tableExcelE');
	})
	$("#allExport6").off('click').on('click',function(){
		minemouthname();
		method('.tableExcelF');
	})
	$("#allExport7").off('click').on('click',function(){
		supplytimeList();
		method('.tableExcelG');
	})
	$("#allExport8").off('click').on('click',function(){
		miningcollectList();
		method('.tableExcelH');
	})
//	// 物料的四个tab切换菜单
	var wl_li = $('.wuliao_tab ul li');
	wl_li.click(function () {
	    $(this).addClass('select').siblings().removeClass('select');
	    var index = wl_li.index(this);
//	    $('.wuliao_tabbox > .wuliao_tabcont').eq(index).show().siblings().hide();
	});

//	采购物料供应商时间汇总--导出功能
	function supplytimeList(){
		 $.ajax({
	            url:URL.supplytimeListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){      	
	                	$('#RMgG').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
	        					.append('<td>'+(list[i].materialname||"")+'</td>')
	        					.append('<td>'+(list[i].dateStr||"")+'</td>')
	        					.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
	        					.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
	        					.append('<td>'+(list[i].sumTareweight||"")+'</td>')
	        					.append('<td>'+(list[i].sumNetweight||"")+'</td>')
	        	                .appendTo('#RMgG');
	        	            }       	
	                }
	            }
	        });
	}
//	采购采矿点汇总表--导出功能
	function miningcollectList(){
		 $.ajax({
	            url:URL.miningcollectListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){      	
	                	$('#RMgH').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
	        					.append('<td>'+(list[i].materialname||"")+'</td>')
	        					.append('<td>'+(list[i].dateStr||"")+'</td>')
	        					.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
	        					.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
	        					.append('<td>'+(list[i].sumTareweight||"")+'</td>')
	        					.append('<td>'+(list[i].sumNetweight||"")+'</td>')
	        	                .appendTo('#RMgH');
	        	            }       	
	                }
	            }
	        });
	}
//	采购补增--导出功能
	function BuZengList(){
		 $.ajax({
	            url:URL.BuZengListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){      	
	                	$('#RMgA').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	var lightt,weightt;
	        					if(list[i].lighttime){
	        						lightt=new Date(list[i].lighttime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						lightt="";
	        					}
	        					if(list[i].weighttime){
	        						weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						weightt="";
	        					}
	        	            	$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')
	        					.append('<td>'+(list[i].suppliername||"")+'</td>')
	        					.append('<td>'+(list[i].minemouthname||"")+'</td>')
	        					.append('<td>'+(list[i].yardname||"")+'</td>')
	        					.append('<td>'+(list[i].materialname||"")+'</td>')
	        					.append('<td>'+(list[i].vehicleno||"")+'</td>')
	        					.append('<td>'+(list[i].originalnetweight||"")+'</td>')
	        					.append('<td>'+(list[i].grossweight||"")+'</td>')
	        					.append('<td>'+(list[i].tareweight||"")+'</td>')
	        					.append('<td>'+(list[i].netweight||"")+'</td>')
	        					.append('<td>'+(lightt)+'</td>')
	        					.append('<td>'+(weightt)+'</td>')
	        					.append('<td>'+(list[i].remark||"")+'</td>')
	        	                .appendTo('#RMgE');
	        	            }       	
	                }
	            }
	        });
	}
	
//	采购逐车--导出功能
	function commonList(){
		 $.ajax({
	            url:URL.commonListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){   	
	                	$('#RMgA').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	var lightt,weightt;
	        					if(list[i].lighttime){
	        						lightt=new Date(list[i].lighttime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						lightt="";
	        					}
	        					if(list[i].weighttime){
	        						weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						weightt="";
	        					}
	        	            	$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')
	        					.append('<td>'+(list[i].billcode||"")+'</td>')
	        					.append('<td>'+(list[i].suppliername||"")+'</td>')
	        					.append('<td>'+(list[i].minemouthname||"")+'</td>')
	        					.append('<td>'+(list[i].yardname||"")+'</td>')
	        					.append('<td>'+(list[i].materialname||"")+'</td>')
	        					.append('<td>'+(list[i].vehicleno||"")+'</td>')
	        					.append('<td>'+(list[i].originalnetweight||"")+'</td>')
	        					.append('<td>'+(list[i].grossweight||"")+'</td>')
	        					.append('<td>'+(list[i].tareweight||"")+'</td>')
	        					.append('<td>'+(list[i].netweight||"")+'</td>')
	        					.append('<td>'+(lightt)+'</td>')
	        					.append('<td>'+(weightt)+'</td>')
	        					.append('<td>'+(list[i].remark||"")+'</td>')
	        	                .appendTo('#RMgA');
	        	            }       	
	                }
	            }
	        });
	}
//	矿口总汇
	function minemouthname(){
		 $.ajax({
	            url:URL.minemouthnameListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){          	
	                	$('#RMgB').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
								.append('<td>'+(list[i].minemouthname||"")+'</td>')
								.append('<td>'+(list[i].materialname||"")+'</td>')
								.append('<td>'+(list[i].yardname||"")+'</td>')
								.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
								.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
								.append('<td>'+(list[i].sumTareweight||"")+'</td>')
								.append('<td>'+(list[i].sumNetweight||"")+'</td>')
	        	                .appendTo('#RMgF');
	        	            }       	
	                }
	            }
	        });
	}
//	单位统计
	function customList(){
		 $.ajax({
	            url:URL.customListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){          	
	                	$('#RMgB').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
								.append('<td>'+(list[i].minemouthname||"")+'</td>')
								.append('<td>'+(list[i].materialname||"")+'</td>')
								.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
								.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
								.append('<td>'+(list[i].sumTareweight||"")+'</td>')
								.append('<td>'+(list[i].sumNetweight||"")+'</td>')
	        	                .appendTo('#RMgB');
	        	            }       	
	                }
	            }
	        });
	}
//	收料统计
	function receiveList(){
		 $.ajax({
	            url:URL.receiveListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){     	
	                	$('#RMgC').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	var signt,weightt;
	        					if(list[i].signtime){
	        						signt=new Date(list[i].signtime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						signt="";
	        					}
	        					if(list[i].weighttime){
	        						weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
	        					}else{
	        						weightt="";
	        					}
	        	            	$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')
	    						.append('<td>'+(list[i].suppliername||"")+'</td>')
	    						.append('<td>'+(list[i].materialname||"")+'</td>')
	    						.append('<td>'+(list[i].vehicleno||"")+'</td>')
	    						.append('<td>'+(list[i].minemouthname||"")+'</td>')
	    						.append('<td>'+(list[i].yardname||"")+'</td>')
	    						.append('<td>'+(list[i].signpersonname||"")+'</td>')
	    						.append('<td>'+(signt)+'</td>')
	    						.append('<td>'+(list[i].originalnetweight||"")+'</td>')
	    						.append('<td>'+(list[i].netweight||"")+'</td>')
	    						.append('<td>'+(weightt)+'</td>')
	    						.append('<td>'+(list[i].remark||"")+'</td>')
	        	                .appendTo('#RMgC');
	        	            }       	
	                }
	            }
	        });
	}
//	物料统计
	function materList(){
		 $.ajax({
	            url:URL.materListUrl,
	            async:false,
	            cache:false,
	            dataType:'json',
	            type:'post',
	            success:function(result){
	                if(result.code == '000000'){       	
	                	$('#RMgC').empty();
	        	        var list = result.data||[];
	        	            for(var i=0;i<list.length;i++){
	        	            	$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
	    						.append('<td>'+(list[i].materialname||"")+'</td>')
	    						.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
	    						.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
	    						.append('<td>'+(list[i].sumTareweight||"")+'</td>')
	    						.append('<td>'+(list[i].sumNetweight||"")+'</td>')
	    						.append('<td>'+(list[i].remark||"")+'</td>')
	        	                .appendTo('#RMgD');
	        	            }       	
	                }
	            }
	        });
	}
	
	function searchData(page) {
		var type=$('.tj_tab ul>li.select').attr('data-type');
		if(type==0){
			queryData5(page);
		}
		if(type==1){
			queryData(page);	
		}
		if(type==2){
			queryData2(page);
		}
		if(type==3){
			queryData3(page);	
		}
		if(type==4){
			queryData4(page);	
		}
		if(type==5){
			queryData6(page);
		}
		if(type==6){
			queryData7(page);
		}
		if(type==7){
			queryData8(page);
		}
	}
	$('#searchBtn').off('click').on('click',function(){
		searchData(1);
		var clock1=document.getElementById("clock1").value;
		var clock2=document.getElementById("clock2").value;
			document.querySelector(".clocka").innerHTML=clock1.slice(0,10);
			document.querySelector(".clockb").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock6").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock7").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock9").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock10").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock12").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock13").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock3").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock4").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock15").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock16").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock17").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock18").innerHTML="至"+clock2.slice(0,10);
			document.querySelector(".clock20").innerHTML=clock1.slice(0,10);
			document.querySelector(".clock21").innerHTML="至"+clock2.slice(0,10);
		if(clock1=="" && clock2==""){
			$(".biobiaophide").css("display","none");
		}else{
			$(".biobiaophide").css("display","block");
		}

	});
	$('#clean').off('click').on('click',function(){
		clean();
	});
	function bindEvent(){
		
		$('#jumpPageNoBtn').off('click').on('click',function(){
			var pageNo = $('input#jumpPageNo').val();pageNo = $.trim(pageNo);pageNo = parseInt(pageNo);
			var pageMaxNo = $('input#jumpPageNo').attr('maxpageno');pageMaxNo = $.trim(pageMaxNo);pageMaxNo = parseInt(pageMaxNo);
			if(!pageNo || !$.isNumeric(pageNo) || pageNo < 0 || pageNo > pageMaxNo){
				layer.msg('此处必须为1-'+pageMaxNo+'的数字');
				$('input#jumpPageNo').val('');
			}else{
				$('input#jumpPageNo').val(pageNo);
				searchData(pageNo);
			
			}
		});
		$('#pageSize').change(function(){
			searchData(1);
	
		});
	}
	function str2Long(dateStr){
		if(dateStr){
			return Date.parseYMD_HMS(dateStr).getTime();
		}
		return '';
	}
	function getParams(){
		var params = {};
		var billcode = $('#billcode').val();billcode = $.trim(billcode);
		var poundcode = $('#poundcode').val();poundcode = $.trim(poundcode);
		var suppliername = $('#bbg_gys').val();suppliername = $.trim(suppliername);
		var minemouthname = $('#bbg_kk').val();minemouthname = $.trim(minemouthname);
		var cargo = $('#gys').val();cargo = $.trim(cargo);
		var drivername = $('#bbg_sjn').val();drivername = $.trim(drivername);
		var beginTime = $('#clock1').val();beginTime = $.trim(beginTime);
		var endTime = $('#clock2').val();endTime = $.trim(endTime);
		var vehicleno = $('#bbg_cph').val();vehicleno = $.trim(vehicleno);
		var remark = $('#bbg_bz').val();remark = $.trim(remark);
		var yardname=$('#duichang').val();yardname = $.trim(yardname);
		var returnstatus = $('#pushStatus').val();returnstatus = $.trim(returnstatus);
		var pageSize = $('#pageSize').val() || 20;pageSize = $.trim(pageSize);
		return {
			poundcode:poundcode,
			billcode:billcode,
			suppliername:suppliername,
			minemouthname:minemouthname,
			cargo:cargo,
			returnstatus:returnstatus,
			drivername:drivername,
			beginTime:str2Long(beginTime),
			endTime:str2Long(endTime),
			vehicleno:vehicleno,
			remark:remark,
			yardname:yardname,
			pageSize:pageSize
		};
	}
	
	function getTodayStr(){
		var myDate = new Date();
		var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		var month = myDate.getMonth()+1;       //获取当前月份(0-11,0代表1月)
		var day = myDate.getDate();        //获取当前日(1-31)
		var day1 = myDate.getDate()+1;        //获取当前日(1-31)
		var hours = myDate.getHours();       //获取当前小时数(0-23)
		var minutes = myDate.getMinutes();     //获取当前分钟数(0-59)
		var seconds = myDate.getSeconds();     //获取当前秒数(0-59)
		if(month<10){
			month = "0"+ month;
		}
		if(day<10){
			day = "0"+day;
		}
		if(day1<10){
			day1 = "0"+day1;
		}
		var array = new Array();
		array[0]=year+"-"+month+"-"+day+" "+"00:00:00";
		array[1]=year+"-"+month+"-"+day1+" "+"00:00:00";
		return array;
	}
	
	function clean(){
		 $('#bbg_gys').val("");
		 $('#bbg_kk').val("");
		 $('#gys').val("");
		 $('#bbg_sjn').val("");
		 $('#clock1').val("");
		 $('#clock2').val("");
		 $('#bbg_cph').val("");
		 $('#bbg_bz').val("");
		 $('#duichang').val("");
		 $('#pushStatus').val("");
		 $("#billcode").val("");
		$("#poundcode").val("");
	}
//	供应商时间汇总
	function queryData7(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
		$.ajax({
			url:URL.supplytimeUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml7(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData7(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml7(data){
		$('#RMg7').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0,str3=0,str4=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].sumGrossweight;
				str2+=list[i].sumTareweight;
				str3+=list[i].sumNetweight;
				str4+=list[i].countVehicleNo;
				var signt;
				/*if(list[i].dateStr){
					signt=new Date(list[i].dateStr).format("yyyy-MM-dd HH:mm:ss");
				}else{
					signt="";
				}*/
				$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].dateStr ||"")+'</td>')
						.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
						.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
						.append('<td>'+(list[i].sumTareweight||"")+'</td>')
						.append('<td>'+(list[i].sumNetweight||"")+'</td>')
						.appendTo('#RMg7');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str4.toFixed(0))+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+(str3.toFixed(2))+'</td>')
			.appendTo('#RMg7');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}
	
//	采购采矿点汇总表
	function queryData8(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
		$.ajax({
			url:URL.miningcollectUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml7(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData8(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml8(data){
		$('#RMg8').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0,str3=0,str4=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].sumGrossweight;
				str2+=list[i].sumTareweight;
				str3+=list[i].sumNetweight;
				str4+=list[i].countVehicleNo;
				$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].miningpointname||"")+'</td>')
						.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
						.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
						.append('<td>'+(list[i].sumTareweight||"")+'</td>')
						.append('<td>'+(list[i].sumNetweight||"")+'</td>')
						.appendTo('#RMg8');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str4.toFixed(0))+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+(str3.toFixed(2))+'</td>')
			.appendTo('#RMg8');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}	
	
//		//初始化页面
	function queryData5(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
//		补增明细
		$.ajax({
			url:URL.BuZengUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml5(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData5(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml5(data){
		$('#RMg5').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0,str3=0,str4=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].originalnetweight;
				str2+=list[i].grossweight;
				str3+=list[i].tareweight;
				str4+=list[i].netweight;
				var lightt,weightt;
				if(list[i].lighttime){
					lightt=new Date(list[i].lighttime).format("yyyy-MM-dd HH:mm:ss");
				}else{
					lightt="";
				}
				if(list[i].weighttime){
					weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
				}else{
					weightt="";
				}
				$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')	
						.append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].minemouthname||"")+'</td>')
						.append('<td>'+(list[i].yardname||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].vehicleno||"")+'</td>')
						.append('<td>'+(list[i].originalnetweight||"")+'</td>')
						.append('<td>'+(list[i].grossweight||"")+'</td>')
						.append('<td>'+(list[i].tareweight||"")+'</td>')
						.append('<td>'+(list[i].netweight||"")+'</td>')
						.append('<td>'+(lightt)+'</td>')
						.append('<td>'+(weightt)+'</td>')
						.append('<td>'+(list[i].remark||"")+'</td>')
						.appendTo('#RMg5');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')	
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+(str3.toFixed(2))+'</td>')
			.append('<td>'+(str4.toFixed(2))+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.appendTo('#RMg5');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}
	
//	矿口统计
	function queryData6(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
		$.ajax({
			url:URL.minemouthnameUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml6(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData6(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml6(data){
		$('#RMg6').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0,str3=0,str4=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].countVehicleNo;
				str2+=list[i].sumGrossweight;
				str3+=list[i].sumTareweight;
				str4+=list[i].sumNetweight;
				$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].minemouthname||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].yardname||"")+'</td>')
						.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
						.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
						.append('<td>'+(list[i].sumTareweight||"")+'</td>')
						.append('<td>'+(list[i].sumNetweight||"")+'</td>')
						.appendTo('#RMg6');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+(str3.toFixed(2))+'</td>')
			.append('<td>'+(str4.toFixed(2))+'</td>')
			.appendTo('#RMg6');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}
	
	
	
//	逐车明细
		function queryData(pageNo){
			var index = layer.load(2, {
			  shade: [0.3,'#fff'] //0.1透明度的白色背景
			});
			var params = getParams();
			params.pageNo = pageNo;
//			逐车明细
			$.ajax({
				url:URL.commonUrl,
				data:params,
				async:true,
				cache:false,
				dataType:'json',
				type:'post',
				success:function(result){
					if(result.code == '000000'){
						renderHtml(result.data);
						var total = result.data.total;
						var pageNo = result.data.pageNo;
						var pageSize = result.data.pageSize;
						$('#total').html(total);
						$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
						$("#pagination").pagination(total, {
						    callback: function(pageNo){
								queryData(pageNo+1);
							},
						    prev_text: '上一页',
						    next_text: '下一页',
						    items_per_page:pageSize,
						    num_display_entries:4,
						    current_page:pageNo-1,
						    num_edge_entries:1,
						    maxentries:total,
						    link_to:"javascript:void(0)"
						});
					}else{
						layer.msg(result.error);
					}
					layer.close(index);
				}
			});
		}
		
		function renderHtml(data){
			$('#RMg1').empty();
			var list = data.list||[];
			if(list && list.length>0){
				var str1=0,str2=0,str3=0,str4=0;
				for(var i=0;i<list.length;i++){
					str1+=list[i].originalnetweight;
					str2+=list[i].grossweight;
					str3+=list[i].tareweight;
					str4+=list[i].netweight;
					var lightt,weightt;
					if(list[i].lighttime){
						lightt=new Date(list[i].lighttime).format("yyyy-MM-dd HH:mm:ss");
					}else{
						lightt="";
					}
					if(list[i].weighttime){
						weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
					}else{
						weightt="";
					}
					$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')
							.append('<td>'+(list[i].billcode||"")+'</td>')
							.append('<td>'+(list[i].suppliername||"")+'</td>')
							.append('<td>'+(list[i].minemouthname||"")+'</td>')
							.append('<td>'+(list[i].miningpointname||"")+'</td>')
							.append('<td>'+(list[i].yardname||"")+'</td>')
							.append('<td>'+(list[i].materialname||"")+'</td>')
							.append('<td>'+(list[i].vehicleno||"")+'</td>')
							.append('<td>'+(list[i].originalnetweight||"")+'</td>')
							.append('<td>'+(list[i].grossweight||"")+'</td>')
							.append('<td>'+(list[i].tareweight||"")+'</td>')
							.append('<td>'+(list[i].netweight||"")+'</td>')
							.append('<td>'+(lightt)+'</td>')
							.append('<td>'+(weightt)+'</td>')
							.append('<td>'+(list[i].remark||"")+'</td>')
							.appendTo('#RMg1');
				}
				$('<tr>').append('<td>'+("总计")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+(str1.toFixed(2))+'</td>')
				.append('<td>'+(str2.toFixed(2))+'</td>')
				.append('<td>'+(str3.toFixed(2))+'</td>')
				.append('<td>'+(str4.toFixed(2))+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.appendTo('#RMg1');
			}else{
//				layer.msg('暂无数据');
//				$('#dataMore').hide();
			}
		}

//		单位统计
		function queryData2(pageNo){
			var index = layer.load(2, {
			  shade: [0.3,'#fff'] //0.1透明度的白色背景
			});
			var params = getParams();
			params.pageNo = pageNo;
			$.ajax({
				url:URL.customUrl,
				data:params,
				async:true,
				cache:false,
				dataType:'json',
				type:'post',
				success:function(result){
					if(result.code == '000000'){
						renderHtml2(result.data);
						var total = result.data.total;
						var pageNo = result.data.pageNo;
						var pageSize = result.data.pageSize;
						$('#total').html(total);
						$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
						$("#pagination").pagination(total, {
						    callback: function(pageNo){
								queryData2(pageNo+1);
							},
						    prev_text: '上一页',
						    next_text: '下一页',
						    items_per_page:pageSize,
						    num_display_entries:4,
						    current_page:pageNo-1,
						    num_edge_entries:1,
						    maxentries:total,
						    link_to:"javascript:void(0)"
						});
					}else{
						layer.msg(result.error);
					}
					layer.close(index);
				}
			});
		}
		
		function renderHtml2(data){
			$('#RMg2').empty();
			var list = data.list||[];
			if(list && list.length>0){
				var str1=0,str2=0,str3=0,str4=0;
				for(var i=0;i<list.length;i++){
					str1+=list[i].countVehicleNo;
					str2+=list[i].sumGrossweight;
					str3+=list[i].sumTareweight;
					str4+=list[i].sumNetweight;
					$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
							.append('<td>'+(list[i].minemouthname||"")+'</td>')
							.append('<td>'+(list[i].materialname||"")+'</td>')
							.append('<td>'+(list[i].countVehicleNo||"")+'</td>')
							.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
							.append('<td>'+(list[i].sumTareweight||"")+'</td>')
							.append('<td>'+(list[i].sumNetweight||"")+'</td>')
							.appendTo('#RMg2');
				}
				$('<tr>').append('<td>'+("总计")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+("---")+'</td>')
				.append('<td>'+(str1.toFixed(2))+'</td>')
				.append('<td>'+(str2.toFixed(2))+'</td>')
				.append('<td>'+(str3.toFixed(2))+'</td>')
				.append('<td>'+(str4.toFixed(2))+'</td>')
				.appendTo('#RMg2');
			}else{
//				layer.msg('暂无数据');
//				$('#dataMore').hide();
			}
		}
	
////	收料统计
	function queryData3(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
		$.ajax({
			url:URL.receiveUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml3(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData3(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml3(data){
		$('#RMg3').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].originalnetweight;
				str2+=list[i].netweight;
				var signt,weightt;
				if(list[i].signtime){
					signt=new Date(list[i].signtime).format("yyyy-MM-dd HH:mm:ss");
				}else{
					signt="";
				}
				if(list[i].weighttime){
					weightt=new Date(list[i].weighttime).format("yyyy-MM-dd HH:mm:ss");
				}else{
					weightt="";
				}
				$('<tr>').append('<td>'+(list[i].poundcode||"")+'</td>')
						.append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].vehicleno||"")+'</td>')
						.append('<td>'+(list[i].minemouthname||"")+'</td>')
						.append('<td>'+(list[i].yardname||"")+'</td>')
						.append('<td>'+(list[i].signpersonname||"")+'</td>')
						.append('<td>'+(signt)+'</td>')
						.append('<td>'+(list[i].originalnetweight||"")+'</td>')
						.append('<td>'+(list[i].netweight||"")+'</td>')
						.append('<td>'+(weightt)+'</td>')
						.append('<td>'+(list[i].remark||"")+'</td>')
						.appendTo('#RMg3');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+("---")+'</td>')
			.appendTo('#RMg3');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}

	
//	物料统计
	function queryData4(pageNo){
		var index = layer.load(2, {
		  shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var params = getParams();
		params.pageNo = pageNo;
		$.ajax({
			url:URL.materUrl,
			data:params,
			async:true,
			cache:false,
			dataType:'json',
			type:'post',
			success:function(result){
				if(result.code == '000000'){
					renderHtml4(result.data);
					var total = result.data.total;
					var pageNo = result.data.pageNo;
					var pageSize = result.data.pageSize;
					$('#total').html(total);
					$('#jumpPageNo').attr('maxPageNo',parseInt((total+pageSize-1)/pageSize));
					$("#pagination").pagination(total, {
					    callback: function(pageNo){
							queryData4(pageNo+1);
						},
					    prev_text: '上一页',
					    next_text: '下一页',
					    items_per_page:pageSize,
					    num_display_entries:4,
					    current_page:pageNo-1,
					    num_edge_entries:1,
					    maxentries:total,
					    link_to:"javascript:void(0)"
					});
				}else{
					layer.msg(result.error);
				}
				layer.close(index);
			}
		});
	}
	
	function renderHtml4(data){
		$('#RMg4').empty();
		var list = data.list||[];
		if(list && list.length>0){
			var str1=0,str2=0,str3=0,str4=0;
			for(var i=0;i<list.length;i++){
				str1+=list[i].countVehicleNo;
				str2+=list[i].sumGrossweight;
				str3+=list[i].sumTareweight;
				str4+=list[i].sumNetweight;
				$('<tr>').append('<td>'+(list[i].suppliername||"")+'</td>')
						.append('<td>'+(list[i].materialname||"")+'</td>')
						.append('<td>'+(list[i].countVehicleNo||"")+'</td>')	
						.append('<td>'+(list[i].sumGrossweight||"")+'</td>')
						.append('<td>'+(list[i].sumTareweight||"")+'</td>')
						.append('<td>'+(list[i].sumNetweight||"")+'</td>')
						.append('<td>'+(list[i].remark||"")+'</td>')
						.appendTo('#RMg4');
			}
			$('<tr>').append('<td>'+("总计")+'</td>')
			.append('<td>'+("---")+'</td>')
			.append('<td>'+(str1.toFixed(2))+'</td>')	
			.append('<td>'+(str2.toFixed(2))+'</td>')
			.append('<td>'+(str3.toFixed(2))+'</td>')
			.append('<td>'+(str4.toFixed(2))+'</td>')
			.append('<td>'+("---")+'</td>')
			.appendTo('#RMg4');
		}else{
//			layer.msg('暂无数据');
//			$('#dataMore').hide();
		}
	}
})(jQuery, window);
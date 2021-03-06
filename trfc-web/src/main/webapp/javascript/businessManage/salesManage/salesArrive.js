;(function($, win){
	//请求路径
	var URL = {
		page:"/trfc/salesArrive/page",
		addView:"/trfc/salesArrive/addView",
		updateView:"/trfc/salesArrive/updateView",
		detailView:"/trfc/salesArrive/detailView",
		audit:"/trfc/salesArrive/audit",
		unaudit:"/trfc/salesArrive/unaudit",
		invalid:"/trfc/salesArrive/invalid",
		outfactory:"/trfc/salesArrive/outfactory",
		vehicleAutoCompleteSearch: "/trfc/vehicle/autoCompleteSearch",
		materielAutoCompleteSearch: "/trfc/materiel/autoCompleteSearch",
		driverAutoCompleteSearch: "/trfc/driver/autoCompleteSearch",
		customerAutoCompleteSearch: "/trfc/customer/autoCompleteSearch"
	};
	function str2Long(dateStr){
		if(dateStr){
			return Date.parseYMD_HMS(dateStr).getTime();
		}
		return '';
	}
	init();
	function init(){
		//初始化默认查询当天的数据
		var array = getTodayStr();
		$('#starttime').val(array[0]);
		$('#endtime').val(array[1]);

		//初始化autocomplete
		initAutoComplete();
		//初始化按钮
		bindEvent();
		//初始化页面
		getData($.trim($('#jumpPageNo').val()) || 1);
	}
	//autocomplete
	function initAutoComplete(){
		var cache = {};
	    $("#vehicle").autocomplete({
	    	source: function( request, response ) {
	    		var term = request.term;
	    		var vehicle = cache['vehicle'] || {};
	    		if ( term in vehicle ) {
	    			response( vehicle[ term ] );
	    			return;
	    		}
	    		$.post( URL.vehicleAutoCompleteSearch, request, function( data, status, xhr ) {
	    			vehicle[ term ] = data;
	    			response( data );
	    		});
	    	},
	    	response: function( event, ui ) {
	    		if(ui.content && ui.content.length > 0){
	    			ui.content.forEach(function(x,i,a){
	    				x.label = x.vehicleno;
	    				x.value = x.id;
	    			});
	    		}
	    	},
	    	select: function( event, ui ) {
	    		$(this).val(ui.item.vehicleno).attr('vehicleid', ui.item.id);
	    		return false;
	    	}
	    }).off('click').on('click',function(){
	    	$(this).autocomplete('search',' ');
	    }).on('input keydown',function(){
	    	$(this).removeAttr('vehicleid');
	    }).change(function(){
    		if(!$(this).attr('vehicleid')){
    			$(this).val('');
    		}
	    });
	    $("#driver").autocomplete({
	    	source: function( request, response ) {
	    		var term = request.term;
	    		var driver = cache['driver'] || {};
	    		if ( term in driver ) {
	    			response( driver[ term ] );
	    			return;
	    		}
	    		$.post( URL.driverAutoCompleteSearch, request, function( data, status, xhr ) {
	    			driver[ term ] = data;
	    			response( data );
	    		});
	    	},
	    	response: function( event, ui ) {
	    		if(ui.content && ui.content.length > 0){
	    			ui.content.forEach(function(x,i,a){
	    				x.label = x.name;
	    				x.value = x.id;
	    			});
	    		}
	    	},
	    	select: function( event, ui ) {
	    		$(this).val(ui.item.name).attr('driverid', ui.item.id);
	    		return false;
	    	}
	    }).off('click').on('click',function(){
	    	$(this).autocomplete('search',' ');
	    }).on('input keydown',function(){
	    	$(this).removeAttr('driverid');
	    }).change(function(){
    		if(!$(this).attr('driverid')){
    			$(this).val('');
    		}
	    });
	    $("#materiel").autocomplete({
	    	source: function( request, response ) {
	    		var term = request.term;
	    		var materiel = cache['materiel'] || {};
	    		if ( term in materiel ) {
	    			response( materiel[ term ] );
	    			return;
	    		}
	    		$.post( URL.materielAutoCompleteSearch, request, function( data, status, xhr ) {
	    			materiel[ term ] = data;
	    			response( data );
	    		});
	    	},
	    	response: function( event, ui ) {
	    		if(ui.content && ui.content.length > 0){
	    			ui.content.forEach(function(x,i,a){
	    				x.label = x.name;
	    				x.value = x.id;
	    			});
	    		}
	    	},
	    	select: function( event, ui ) {
	    		$(this).val(ui.item.name).attr('materielid', ui.item.id);
	    		return false;
	    	}
	    }).off('click').on('click',function(){
	    	$(this).autocomplete('search',' ');
	    }).on('input keydown',function(){
	    	$(this).removeAttr('materielid');
	    }).change(function(){
    		if(!$(this).attr('materielid')){
    			$(this).val('');
    		}
	    });
	    $("#customer").autocomplete({
	    	source: function( request, response ) {
	    		var term = request.term;
	    		var customer = cache['customer'] || {};
	    		if ( term in customer ) {
	    			response( customer[ term ] );
	    			return;
	    		}
	    		$.post( URL.customerAutoCompleteSearch, request, function( data, status, xhr ) {
	    			customer[ term ] = data;
	    			response( data );
	    		});
	    	},
	    	response: function( event, ui ) {
	    		if(ui.content && ui.content.length > 0){
	    			ui.content.forEach(function(x,i,a){
	    				x.label = x.name;
	    				x.value = x.id;
	    			});
	    		}
	    	},
	    	select: function( event, ui ) {
	    		$(this).val(ui.item.name).attr('customerid', ui.item.id);
	    		return false;
	    	}
	    }).off('click').on('click',function(){
	    	$(this).autocomplete('search',' ');
	    }).on('input keydown',function(){
	    	$(this).removeAttr('customerid');
	    }).change(function(){
    		if(!$(this).attr('customerid')){
    			$(this).val('');
    		}
	    });
	}
	//初始化按钮
	function bindEvent(){
		$('#refreshBtn').off('click').on('click',function(){
			getData(1);
			layer.closeAll('dialog');
		});
		$('#searchBtn').off('click').on('click',function(){
			getData(1);
		});
		$('#addBtn').off('click').on('click',function(){
			window.open(URL.addView, '_blank');
		});
		$('#update').off('click').on('click', function(e){
			e.stopPropagation();
			var obj = $('table.maintable tbody tr.active').data();
			if(!obj) {layer.msg('需要选中一行才能操作哦！'); return;}
			update(obj);
		});
		$('#audit').off('click').on('click', function(e){
			e.stopPropagation();
			var obj = $('table.maintable tbody tr.active').data();
			if(!obj) {layer.msg('需要选中一行才能操作哦！'); return;}
			audit(obj);
		});
		$('#unaudit').off('click').on('click', function(e){
			e.stopPropagation();
			var obj = $('table.maintable tbody tr.active').data();
			if(!obj) {layer.msg('需要选中一行才能操作哦！'); return;}
			unaudit(obj);
		});
		$('#invalid').off('click').on('click', function(e){
			e.stopPropagation();
			var obj = $('table.maintable tbody tr.active').data();
			if(!obj) {layer.msg('需要选中一行才能操作哦！'); return;}
			invalid(obj);
		});
		$('#outfactory').off('click').on('click', function(e){
			e.stopPropagation();
			var obj = $('table.maintable tbody tr.active').data();
			if(!obj) {layer.msg('需要选中一行才能操作哦！'); return;}
			outfactory(obj);
		});
		$('#jumpPageNoBtn').off('click').on('click',function(){
			var pageNo = $('input#jumpPageNo').val();pageNo = $.trim(pageNo);pageNo = parseInt(pageNo);
			var pageMaxNo = $('input#jumpPageNo').attr('maxpageno');pageMaxNo = $.trim(pageMaxNo);pageMaxNo = parseInt(pageMaxNo);
			if(!pageNo || !$.isNumeric(pageNo) || pageNo < 0 || pageNo > pageMaxNo){
				layer.msg('此处必须为1-'+pageMaxNo+'的数字');
				$('input#jumpPageNo').val('');
			}else{
				$('input#jumpPageNo').val(pageNo);
				getData(pageNo);
			}
		});
		$('#pageSize').change(function(){
			getData(1);
		});
		$('#readSearch').off('click').on('click',function(){
			readSearch();
		});
	}
	function readSearch() {
		if (initCardReader()) {
			//打开读卡器
			readerOpen();
			if (openCard()) {
				//开打卡片获取卡序号
				var vehicleno = getDataFromCard(2);
				//蜂鸣
				readerBeep();
				if(vehicleno){
					get({vehicleno:vehicleno});
				}
			}
			//关闭读卡器
			readerClose();
		}else{
			layer.msg('当前游览器不支持!(只兼容IE游览器)');
		}
	}
	//获取查询参数
	function getParams(){
		var billcode = $('#billcode').val() || ''; billcode = $.trim(billcode);
		var code = $('#code').val() || ''; code = $.trim(code);
		var auditstatus = $('#auditstatus').val() || ''; auditstatus = $.trim(auditstatus);
		var source = $('#source').val() || ''; source = $.trim(source);
		var status = $('#status').val() || ''; status = $.trim(status);
		var customerid = $('#customer').attr('customerid') || ''; customerid = $.trim(customerid);
		var vehicleid = $('#vehicle').attr('vehicleid') || ''; vehicleid = $.trim(vehicleid);
		var materielid = $('#materiel').attr('materielid') || ''; materielid = $.trim(materielid);
		var driverid = $('#driver').attr('driverid') || ''; driverid = $.trim(driverid);
		var starttime = $('#starttime').val() || ''; starttime = $.trim(starttime);
		var endtime = $('#endtime').val() || ''; endtime = $.trim(endtime);
		var pageSize = $('#pageSize').val() || ''; pageSize = $.trim(pageSize);
		var vehicleno = $('#vehicleno').val();vehicleno = $.trim(vehicleno);$('#vehicleno').val('');
		return {
			billcode:billcode,
			code:code,
			customerid:customerid,
			vehicleid:vehicleid,
			auditstatus:auditstatus,
			materielid:materielid,
			driverid:driverid,
			source:source,
			status:status,
			starttime:str2Long(starttime),
			endtime:str2Long(endtime),
			pageSize:pageSize,
			vehicleno: vehicleno
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
	
	function getData(pageNo){
		layer.closeAll();
		var params = getParams();
		params.pageNo = pageNo;
		get(params);
	}
	function get(params) {
		var index = layer.load(2, {
			  shade: [0.3,'#fff'] //0.1透明度的白色背景
			});
			$.ajax({
				url:URL.page,
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
						    	getData(pageNo+1);
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
						layer.msg(result.error, {icon: 5});
					}
					layer.close(index);
				}
			});
	}
	function renderHtml(data){
		$('#dataBody').empty();
		$('#dataMore').hide()
		var list = data.list;
		if(list && list.length>0){
			for(var i=0;i<list.length;i++){
				var obj = list[i] || '';
				var salesApplication = obj.listApplication.filter(function(x){
					return x.id == this;
				},obj.billid)[0];
				var salesApplicationDetail = salesApplication.list[0];
				var code = obj.code || '';
				var auditstatus = obj.auditstatus || '';
				//设置字体颜色 (LXY)
				var color = '';
				switch (auditstatus) {
				case '0': auditstatus = '未审核'; color = 'class="colorred"'; break;
				case '1': auditstatus = '已审核'; break;
				default: auditstatus = ''; break;
				}
				var source = obj.source || '';
				switch (source) {
				case '0': source = '业务平台'; break;
				case '1': source = '客商平台'; break;
				case '2': source = '客商APP'; break;
				default: source = ''; break;
				}
				var status = obj.status || '';
				switch (status) {
				case '0': status = '未入厂'; break;
				case '1': status = '空车'; break;
				case '2': status = '重车'; break;
				case '3': status = '作废'; break;
				case '4': status = '发卡'; break;
				case '5': status = '出厂'; break;
				case '6': status = '入厂'; break;
				case '7': status = '装车'; break;
				default: status = ''; break;
				}
				if (obj.validStatus == '1') {
					status = '作废中';
				}
				if (obj.forceOutFactory == '1') {
					status = '强制出厂';
				}
				var vehicleno = obj.vehicleno || '';
				var billcode = obj.billcode || '';
				var customername = salesApplication.customername || '';
				var materielname = salesApplicationDetail.materielname || '';
				var orgname = salesApplication.orgname||'';
				var billtimeStr = salesApplication.billtimeStr || '';
				var channelcode = salesApplication.channelcode || '';
				var makebillname = obj.makebillname || '';
				var makebilltimeStr = obj.makebilltimeStr || '';
				var abnormalpersonname = obj.abnormalpersonname || '';
				var abnormaltimeStr = obj.abnormaltimeStr || '';
				var remarks = obj.remarks || '';
				$('<tr>').append('<td>'+(i+1)+'</td>').append('<td>'+code+'</td>')
						.append('<td '+color+'>'+auditstatus+'</td>').append('<td>'+source+'</td>')
						.append('<td>'+status+'</td>').append('<td>'+vehicleno+'</td>')
						.append('<td>'+billcode+'</td>').append('<td>'+customername+'</td>')
						.append('<td>'+materielname+'</td>').append('<td>'+orgname+'</td>').append('<td>'+billtimeStr+'</td>')
						.append('<td>'+channelcode+'</td>').append('<td>'+makebilltimeStr+'</td>')
						.append('<td>'+makebillname+'</td>').append('<td>'+abnormalpersonname+'</td>')
						.append('<td>'+abnormaltimeStr+'</td>').append('<td>'+remarks+'</td>')
						.data(obj).appendTo('#dataBody');
			}
			$('#dataBody').find('tr').off('dblclick').on('dblclick',function(){
				var obj = $(this).closest('tr').data();
				window.open(URL.detailView+'?id='+obj.id, '_blank');
			});
			$('#dataBody').find('tr').off('click').on('click',function(){
				var obj = $(this).data();
				showMore(obj);
			});
		}else{
			layer.msg('暂无数据');
			$('#dataMore').hide();
		}
	}
	//显示更多
	function showMore(obj){
		var salesApplication = obj.salesApplication || {};
		var salesApplicationDetail = obj.salesApplicationDetail || {};
		var poundNote = obj.poundNoteResp || {};
		$('#dataMore').empty();
		var $tabDiv = $('<div class="cg_tabtit"><ul><li class="select">物料信息</li><li>订单信息</li><li>过磅信息</li></ul></div>').appendTo('#dataMore');
		var $tabCont = $('<div>').addClass('cg_tabbox').appendTo('#dataMore');
		$tabDiv.find('ul li').off('click').on('click',function(){
			$(this).addClass('select').siblings('li').removeClass('select');
			$tabCont.empty();
			switch ($(this).index()) {
			case 0:
				$('<table>').addClass('table table-bordered')
						.append('<thead><tr><th>车号</th><th>预提数量</th><th>司机</th><th>身份证号</th><th>制单日期</th></tr></thead>')
						.append('<tbody><tr><td>'+(obj.vehicleno || '')+'</td><td>'+(obj.takeamount || '')+'</td><td>'+(obj.drivername || '')+'</td><td>'+(obj.driveridentityno || '')+'</td><td>'+(obj.makebilltimeStr || '')+'</td></tr></tbody>')
						.appendTo($tabCont);
				break;
			case 1:
				var $tbody = $('<tbody>');
				obj.listApplication.forEach(function(x, i, a){
					$tbody.append('<tr><td>'+(i + 1)+'</td><td>'+(x.code || '')+'</td><td>'+(x.billtypename || '')+'</td><td>'+(x.customername || '')+'</td><td>'+(x.list[0].materielname || '')+'</td><td>'+(x.list[0].salessum || '')+'</td><td>'+(x.list[0].margin || 0)+'</td><td>'+(x.list[0].storagequantity || 0)+'</td><td>'+(x.list[0].unstoragequantity || 0)+'</td><td>'+(x.list[0].pretendingtake || 0)+'</td><td>'+(x.billtimeStr || '')+'</td><td>'+(x.makebillname || '')+'</td></tr>');
				});
				$('<table>').addClass('table table-bordered')
							.append('<thead><tr><th>序号</th><th>订单编号</th><th>类型</th><th>客户</th><th>物料</th><th>订单量</th><th>余量</th><th>出库占用量</th><th>未出库占用量</th><th>预提占用</th><th>订单日期</th><th>制单人</th></tr></thead>')
							.append($tbody).appendTo($tabCont);
				break;
			case 2:
				$('<table>').addClass('table table-bordered')
						.append('<thead><tr><th>磅单号</th><th>车号</th><th>毛重</th><th>皮重</th><th>净重</th><th>轻车时间</th><th>重车时间</th></tr></thead>')
						.append('<tbody><tr><td>'+(poundNote.code || '')+'</td><td>'+(obj.vehicleno || '')+'</td><td>'+(poundNote.grossweight || '')+'</td><td>'+(poundNote.tareweight || '')+'</td><td>'+(poundNote.netweight || '')+'</td><td>'+(poundNote.lighttimeStr || '')+'</td><td>'+(poundNote.weighttimeStr || '')+'</td></tr></tbody>')
						.appendTo($tabCont);
				break;
			default:
				break;
			}
		});
		$tabDiv.find('ul li:eq(0)').trigger('click');
		$('#dataMore').show();
	}
	function update(obj){
		if(obj.auditstatus == '1'){
			layer.msg('此单据已审核，无法继续编辑！', {icon: 5});
			return;
		}
		if(obj.status == '3'){
			layer.msg('此单据已作废，无法继续编辑！', {icon: 5});
			return;
		}else if(obj.status != '0'){
			layer.msg('此单据已使用，无法继续编辑！', {icon: 5});
			return;
		}else{
			window.open(URL.updateView+'?id='+obj.id, '_blank')
		}
	}
	function audit(obj){
		if(obj.auditstatus == '1'){
			layer.msg('此单据已审核，无法继续审核！', {icon: 5});
			return;
		}
		if(obj.status == '4'){
			layer.msg('此单据已发卡，无法审核操作！', {icon: 5});
			return;
		}
		if(obj.status == '5'){
			layer.msg('此单据已出厂，无法反审操作！', {icon: 5});
			return;
		}
		if(obj.status == '6'){
			layer.msg('此单据已入厂，无法审核操作！', {icon: 5});
			return;
		}
		if(obj.status == '7'){
			layer.msg('此单据已装货，无法审核操作！', {icon: 5});
			return;
		}
		if(obj.status == '3'){
			layer.msg('此单据已作废，无法审核操作！', {icon: 5});
			return;
		}
		if(obj.status == '1'){
			layer.msg('此单据已使用，无法审核操作！', {icon: 5});
			return;
		}
		if(obj.status == '2'){
			layer.msg('此单据已过重车，无法审核操作！', {icon: 5});
			return;
		}
		confirmOperation('您确定要审核吗？', URL.audit, {id: obj.id});
	}
	function unaudit(obj){
		if(obj.auditstatus == '0'){
			layer.msg('此单据未审核,无法继续反审!', {icon: 5});
			return;
		}
		if(obj.status == '4'){
			layer.msg('此单据已发卡,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '5'){
			layer.msg('此单据已出厂,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '6'){
			layer.msg('此单据已入厂,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '7'){
			layer.msg('此单据已装货,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '3'){
			layer.msg('此单据已作废,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '1'){
			layer.msg('此单据已过轻车,无法反审操作!', {icon: 5});
			return;
		}
		if(obj.status == '2'){
			layer.msg('此单据已过重车,无法反审操作!', {icon: 5});
			return;
		}
		confirmOperation('您确定要反审吗？',  URL.unaudit, {id: obj.id});
	}
	function invalid(obj){
		if(obj.status == '3'){
			layer.msg('数据已作废，不能进行作废操作！', {icon: 5});
			return;
		}
		if(obj.status == '5'){
			layer.msg('数据已出厂，不能进行作废操作！', {icon: 5});
			return;
		}
		if(obj.status == '2'){
			layer.msg('数据已过重车，不能进行作废操作！', {icon: 5});
			return;
		}
		if(obj.status != '0' && obj.status != '4'){
			layer.msg('数据已入厂，不能进行作废操作！', {icon: 5});
			return;
		}
		confirmOperation('您确定要作废吗？', URL.invalid, {id: obj.id});
	}
	function outfactory(obj){
		if(obj.status == '3'){
			layer.msg('数据已作废，不能进行出厂操作！', {icon: 5});
			return;
		}
		if(obj.status == '5'){
			layer.msg('数据已出厂，不能进行出厂操作！', {icon: 5});
			return;
		}
		if(obj.status != '2'){
			layer.msg('数据未过重车，不能进行出厂操作！', {icon: 5});
			return;
		}
		confirmOperation('您确定要出厂吗？', URL.outfactory, {id: obj.id});
	}
	function confirmOperation(confirmContent, url, params){
		var bn=layer.open({
			content: confirmContent,
			area: '600px',
			closeBtn:1,
			shadeClose:true,
			btn: ['确定', '取消'],
			yes: function(index, layero){
				//按钮【确定】的回调
				//数据存到服务器
				$.ajax({
					url:url,
					data:params,
					async:true,
					cache:false,
					dataType:'json',
					type:'post',
					success:function(result){
						if(result.code == '000000'){
							window.location.reload(true);
						}else{
							layer.msg(result.error, {icon: 5});
						}
					}
				});
				layer.close(bn);
			},btn2: function(index, layero){
				//按钮【取消】的回调
			}
			,cancel: function(){
				//右上角关闭回调
			}
		});
	}
})(jQuery, window);
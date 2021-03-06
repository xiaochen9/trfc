$(function() {
	URL = {	
			mainUrl:"/trfc/otherDYArrive/main",
			updateUrl:"/trfc/otherDYArrive/update",
			findOne:"/trfc/otherDYArrive/findOne",
			getCodeUrl:"/trfc/quality/sales/report/getCode",
			addVehicle: '/trfc/vehicle/add',
			addDriver: '/trfc/driver/add',
			vehicleAutoCompleteDYSearch: "/trfc/vehicle/autoCompleteDYSearch",
			yardAutoCompleteSearch: "/trfc/yard/autoCompleteSearch",
			materielAutoCompleteSearch: "/trfc/materiel/autoCompleteSearch",
	};
	//获取用户名
	var userid = $('.user').attr('userid');
	initAddData();

	$('#saveBtn').click(function() {
		saveEditAction();
	});

	$('#goback').click(function() {
		window.location.href = URL.mainUrl;
	});

	$('#refresh').click(function() {
		window.location.reload(true);
	});


	//日期字符串转为时间戳
	function str2Long(dateStr){
		if(dateStr){
			return Date.parseYMD_HMS(dateStr).getTime();
		}
		return '';
	}

	
	function getEditData() {
		var id = $('#add_code').attr('objid');
		var enteryard = $('#add_enteryard').attr('yardid');
		var leaveyard = $('#add_leaveyard').attr('yardid');
		var materielid = $('#add_materiel').attr('materielid');
		var receivedepartmentid = $('#add_receivedepartment').attr('orgid');
		var vehicleid = $('#add_vehicle').attr('vehicleid');
		var starttime = $('#add_starttime').val();
		var endtime = $('#add_endtime').val();
		var driverid = $('#add_driver').attr('driverid');
		var createtime = $('#add_createtime').val();
		var remark = $('#add_remark').val();
		return {
			id:id,
			enteryard:enteryard,
			leaveyard:leaveyard,
			materielid:materielid,
			receivedepartmentid:receivedepartmentid,
			vehicleid:vehicleid,
			starttime:str2Long(starttime),
			endtime:str2Long(endtime),
			createtime:str2Long(createtime),
			remark:remark
		};

	}

	function validata(params) {
		if(!params.enteryard){
			layer.msg('调入堆场不能为空!');return false;
		}
		if(!params.leaveyard){
			layer.msg('调出堆场不能为空!');return false;
		}
		if(!params.starttime){
			layer.msg('开始时间不能为空!');return false;
		}
		if(!params.endtime){
			layer.msg('截至时间不能为空!');return false;
		}
		if(!params.materielid){
			layer.msg('物料不能为空!');return false;
		}
		if(!params.vehicleid){
			layer.msg('车辆不能为空!');return false;
		}
		return true;
	}

	function saveEditAction() {
		var params = getEditData();
		if(params && validata(params)){
			layer.confirm('注：确定要保存吗？', {
				area: '600px',
				btn: ['确认','取消'] //按钮
			}, function(){
				$.ajax({
					url:URL.updateUrl,
					data:params,
					async:true,
					cache:false,
					dataType:'json',
					type:'post',
					success:function(result){
						if(result.code == '000000'){
							window.location.href = URL.mainUrl;
						}else{
							layer.msg(result.error, {icon: 5});
						}
					}
				});
			});
		}

	}



	function initAutoComplete() {
		var cache = {};
		$("#add_vehicle").autocomplete({
			source: function( request, response ) {
				var term = request.term;
				var vehicle = cache['vehicle'] || {};
				if ( term in vehicle ) {
					response( vehicle[ term ] );
					return;
				}
				$.post( URL.vehicleAutoCompleteDYSearch, request, function( data, status, xhr ) {
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
				$(this).val(ui.item.vehicleno).attr('vehicleid', ui.item.id).attr('vehiclecode',ui.item.code);
				$('#add_rfid').val(ui.item.rfid);
				return false;
			}
		}).off('click').on('click',function(){
			$(this).autocomplete('search',' ');
		}).on('input propertychange',function(){
			$(this).removeAttr('vehicleid').removeAttr('vehiclecode');
		}).change(function(){
			if(!$(this).attr('vehicleid') && !$(this).attr('vehiclecode')){
				$(this).val('');
			}
		});
		$(".yardSelect").autocomplete({
			source: function( request, response ) {
				var term = request.term;
				var yard = cache['yard'] || {};
				if ( term in yard ) {
					response( yard[ term ] );
					return;
				}
				$.post( URL.yardAutoCompleteSearch, request, function( data, status, xhr ) {
					yard[ term ] = data;
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
				$(this).val(ui.item.name).attr('yardid', ui.item.id);
				$('#add_identityno').val(ui.item.identityno);
				return false;
			}
		}).off('click').on('click',function(){
			$(this).autocomplete('search',' ');
		}).on('input propertychange',function(){
			$(this).removeAttr('yardid');
		}).change(function(){
			if(!$(this).attr('yardid')){
				$(this).val('');
			}
		});
		$("#add_materiel").autocomplete({
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
				$(this).val(ui.item.name).attr('materielid', ui.item.id).attr('packagetype',ui.item.packagetype);
				return false;
			}
		}).off('click').on('click',function(){
			$(this).autocomplete('search',' ');
		}).on('input propertychange',function(){
			$(this).removeAttr('materielid');
		}).change(function(){
			if(!$(this).attr('materielid')){
				$(this).val('');
			}
		});
		
		
	}

	function saveDriverData() {
		var name = $('#driver_name').val();
		var abbrname = $('#driver_abbrname').val();
		var address = $('#driver_address').val();
		var orgname = $('#driver_org').val();
		var orgid = $('#driver_org').attr('orgid');
		var telephone = $('#driver_telephone').val();
		var identityno = $('#driver_identityno').val();
		var isvalid = '0';
		if($('#driver_isvalid').get(0).checked){
			isvalid = '1';
		}
		var remarks = $('#driver_remarks').val();
		var params = {
				name:name,
				abbrname:abbrname,
				address:address,
				orgname:orgname,
				orgid:orgid,
				telephone:telephone,
				identityno:identityno,
				isvalid:isvalid,
				remarks:remarks
		}
		$.post(URL.addDriver,params,function(result) {
			if(result.code=='000000'){
				$('#driver_cancel').click();
			}else{
				layer.msg(result.error,{icon:5});
			}
		})

	}

	function saveVehicleData() {
		var vehicletype = $('#vehicle_vehicletype').val();
		var transportunit = $('#vehicle_transportunit').val();
		var maxweight = $('#vehicle_maxweight').val();
		var tareweight = $('#vehicle_tareweight').val();
		var owner = $('#vehicle_owner').val();
		var telephone = $('#vehicle_telephone').val();
		var address = $('#vehicle_address').val();
		var org = $('#vehicle_org').val();
		var isvalid = '0';
		if($('#vehicle_isvalid')[0].checked){
			isvalid = '1';
		}
		var remarks = $('#vehicle_remarks').val();
		var vehicleno = $('#vehicle_vehicleno').val();
		var params = {
				vehicletype:vehicletype,
				transportunit:transportunit,
				maxweight:maxweight,
				tareweight:tareweight,
				owner:owner,
				telephone:telephone,
				address:address,
				org:org,
				isvalid:isvalid,
				remarks:remarks,
				vehicleno:vehicleno
		}
		$.post(URL.addVehicle,params,function(result) {
			if(result.code == '000000'){
				$('#vehicle_cancel').click();
			}else{
				layer.msg(result.error,{icon:5});
			}
		})
	}

	function initVehicleModel() {

		//设置编码代号为FA
		var code = 'CL';
		//设置类型为编码
		var codeType = true;
		var param = {
				userid:userid,
				code:code,
				codeType:codeType
		};
		//获取编号,并赋值
		$.post(URL.getCodeUrl,param,function(result){
			if(result.code=='000000'){
				$('#vehicle_code').val(result.data);
			}else{
				layer.msg(result.error, {icon:5});
			}
		});
		$('#vehicle_vehicletype').val('');
		$('#vehicle_transportunit').val('');
		$('#vehicle_maxweight').val('');
		$('#vehicle_tareweight').val('');
		$('#vehicle_owner').val('');
		$('#vehicle_telephone').val('');
		$('#vehicle_address').val('');
		$('#vehicle_isvalid')[0].checked=false;
		$('#vehicle_remarks').val('');
		$('#vehicle_vehicleno').val('');

	}
	function initDriverModel() {
		//设置编码代号为FA
		var code = 'DR';
		//设置类型为编码
		var codeType = true;
		var param = {
				userid:userid,
				code:code,
				codeType:codeType
		};
		//获取编号,并赋值
		$.post(URL.getCodeUrl,param,function(result){
			if(result.code=='000000'){
				$('#driver_code').val(result.data);
			}else{
				layer.msg(result.error, {icon:5});
			}
		});
		param.codeType = false;
		//获取内码,并赋值
		$.post(URL.getCodeUrl,param,function(result){
			if(result.code=='000000'){
				$('#driver_internalcode').val(result.data);
			}else{
				layer.msg(result.error, {icon:5});
			}
		});
		$('#driver_name').val('');
		$('#driver_abbrname').val('');
		$('#driver_address').val('');
		$('#driver_telephone').val('');
		$('#driver_identityno').val('');
		$('#driver_isvalid').get(0).checked=false;
		$('#driver_remarks').val('');

	}
	function initAddData(){

		initAutoComplete();
		var href = window.location.href;
		hrefStrs = href.split('?id=');
		var id = hrefStrs[1];
		if(id){
			$.ajax({
				url:URL.findOne,
				data:{id:id},
				async:true,
				cache:false,
				dataType:'json',
				type:'post',
				success:function(result){
					if(result.code == '000000'){
						var obj = result.data;
						$('#add_code').val(obj.code).attr('objid',obj.id);
						$('#add_receivedepartment').val(obj.receivedepartmentname).attr('orgid',obj.receivedepartment);
						$('#add_creator').val(obj.creatorname);
						$('#add_createtime').val(getNowFormatDate(true,obj.createtime));

						var starttime = '';
						if(obj.starttime){
							starttime = getNowFormatDate(true, obj.starttime);
						}
						var endtime = '';
						if(obj.endtime){
							endtime = getNowFormatDate(true, obj.endtime);
						}
						$('#add_enteryard').val(obj.enteryerdname).attr('yardid',obj.enteryard);
						$('#add_leaveyard').val(obj.leaveyerdname).attr('yardid',obj.leaveyard);
						$('#add_materiel').val(obj.materielname).attr('materielid',obj.materielid);
						$('#add_vehicle').val(obj.vehicleno).attr('vehicleid',obj.vehicleid);
						$('#add_starttime').val(starttime);
						$('#add_endtime').val(endtime);
						$('#add_rfid').val(obj.rfid);
						$('#add_remark').val(obj.remark);
					}else{
						layer.msg(result.error, {icon: 5});
					}
				}
			});
		}
	}


	function getNowFormatDate(param,time) {
		var date ;
//		判断time参数是否存在
		if(time){
			date = new Date(time);
		}else{
			date = new Date();
		}
		var seperator1 = "-";
		var seperator2 = ":";
//		获取月份
		var month = date.getMonth() + 1;
//		获取日期
		var strDate = date.getDate();
//		月或者日 为个位数时前面加'0'
		if (month >= 1 && month <= 9) {
			month = "0" + month;
		}
		if (strDate >= 0 && strDate <= 9) {
			strDate = "0" + strDate;
		}
		var hours = date.getHours();
		var minutes = date.getMinutes();
		var seconds = date.getSeconds();
		if (hours >= 0 && hours <= 9) {
			hours = "0" + hours;
		}
		if (minutes >= 0 && minutes <= 9) {
			minutes = "0" + minutes;
		}
		if (seconds >= 0 && seconds <= 9) {
			seconds = "0" + seconds;
		}
//		判断返回结果
		if(param){
			var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
			+ " " + hours + seperator2 + minutes
			+ seperator2 + seconds;
		}else{
			var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
		}
		return currentdate;
	}



});
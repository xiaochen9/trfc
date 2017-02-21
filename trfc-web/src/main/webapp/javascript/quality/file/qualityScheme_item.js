$(function(){
	//整合url
	var URL = {
			selectorUrl:"/trfc/quality/sales/file/qualityScheme/itemSelector",
			inquireUrl:"/trfc/quality/sales/file/qualityScheme/inquire",
			deleteUrl:"/trfc/quality/sales/file/qualityScheme/deleteItem",
			updateUrl:"/trfc/quality/sales/file/qualityScheme/updateItem",
			saveUrl:"/trfc/quality/sales/file/qualityScheme/addItem",
			schemeData:"/trfc/quality/sales/file/qualityScheme/getSchemeData",
			addBatchUrl:"/trfc/quality/sales/file/qualityScheme/addBatchMain"
	};
	var TYPE = {0:'采购项目',1:'销售项目'};
	var editOD = {};
	var schemeid = getId();
	initPage();
	//加载列表
	ShowAction(1);
	//加载下拉框
	itemSelect();

	//绑定下拉框事件
//	$('.itemSelect').change(subval);
	//绑定刷新按钮
	$('#fresh').click(function(){ShowAction(1);});
	//绑定新增按钮
	$('#addBtn').click(initAddData);
	//绑定批量新增按钮
	$('#addBatch').click(initAddBatchData);
	//绑定新增界面确定按钮
	$('#add_sure').click(saveAction);
	//绑定修改页面确定按钮
	$('#edit_sure').click(editAction);
	//绑定删除按钮
	$('#list').on('click','tr [title="删除"]',deleteAction);
	//绑定编辑按钮
	$('#list').on('click','tr [title="编辑"]',initEditData);

	function initPage(){
		$.post(URL.schemeData,{id:schemeid},function(result){
			if(result.code=='000000'){
				var obj = result.data;
				$('#headline').html('质检方案项目 - '+obj.name);
				editOD.obj = obj;
			}else{
				layer.msg(result.error,{icon:5});
			}
		});

	}
	//
	function subval(){
		var option = $('#add_item option:selected');
		var msg = option.html();
		var index = msg.indexOf('|');
		option.html(msg.substr(msg.length-index));
		itemSelect();
	}
	//初始化批量新增数据
	function initAddBatchData(){

		$('#addBatch_name').val(editOD.obj.name);
		$('#addBatch_schemetype').val(TYPE[editOD.obj.type]);
		$('#addBatch_invalid').attr('checked','checked')
	}
	//初始化新增数据
	function initAddData(){
		//等待下拉框加载完成后,执行
		$.when($selector).done(function(){
			$('#add_item').val('').select2({ placeholder: "请选择",
				allowClear: false
			});
		});
		$('#add_name').val(editOD.obj.code);
		$('#add_schemetype').val(TYPE[editOD.obj.type]);


		$('#add_invalid').attr('checked','checked')
		$('#add_remark').val('');
	}
	//初始化编辑数据
	function initEditData(){
		//获取数据
		var obj = $(this).closest('tr').data('obj')
		editOD.data = obj;
		//设置等下拉框数据加载完成后 执行
		$.when($selector).done(function(){
			$('#edit_item').val(obj.itemid).select2({ placeholder: "请选择",
				allowClear: false
			});;
		});
		$('#edit_id').val(obj.id);
		$('#edit_name').val(editOD.obj.name);
		$('#edit_schemetype').val(TYPE[editOD.obj.type]);

		//为checkbox赋值
		$('#edit_invalid')[0].checked=true;
		if('1'==obj.invalid){
			$('#edit_invalid')[0].checked=false;
		}
		$('#edit_remark').val(obj.remark);
	}

//	新增数据
	function saveAction(){
		//获取新增页面的数据
		var param = getAddData();
		//若无参数,则不执行
		if(param){
			$.post(URL.saveUrl,param,function(result){
				if(result.code=='000000'){
					//重新加载列表
					ShowAction(1);
					//关闭新增页面
					$("#add_cancel").click();
				}else{
					layer.msg(result.error,{icon:5});
				}
			});
		}
	}
//	修改数据
	function editAction(){
		var param = getEditData();
		if(param){
			//修改后的和原数据相同的情况,不执行

			$.post(URL.updateUrl,param,function(result){
				if(result.code=='000000'){
					//加载列表
					ShowAction(1);
					//关闭编辑块
					$("#edit_cancel").click();
				}else{
					layer.msg(result.error,{icon:5});
				}
			});
		}
	}
//	获取新增数据
	function getAddData(){

		var itemid = $('#add_item').val();
		if(!itemid){
			alert("项目明细不能为空");
			return null;
		}


		var invalid = '1';
		if($('#add_invalid').prop('checked')){
			invalid='0';
		}
		var userid = $('.user').attr('userid');
		var remark = $('#add_remark').val();
		var userid = $('.user').attr('userid');
		var param = {
				schemeid:schemeid,
				itemid:itemid,
				invalid:invalid,
				remark:remark,
				user:userid
		};
		return param;
	}
//	获取修改数据
	function getEditData(){
		var id = $('#edit_id').val();
		var itemid = $('#edit_item').val();
		if(!itemid){
			alert("项目明细不能为空");
			return null;
		}


		var invalid = '1';
		if($('#edit_invalid').prop('checked')){
			invalid='0';
		}
		var userid = $('.user').attr('userid');
		var remark = $('#edit_remark').val();
		var userid = $('.user').attr('userid');
		var param = {
				id:id,
				schemeid:schemeid,
				itemid:itemid,
				invalid:invalid,
				remark:remark,
				user:userid
		};
		return param;
	}

	function deleteAction(){
		var id = $(this).closest('tr').data('obj').id;
		//弹出删除确认框
		var index = layer.confirm('你确定要删除吗?', {
			area: '600px', 
			btn: ['确定','取消'] //按钮
		}, function(){
			//提交删除的数据
			submitDelete(id);
			//关闭对话框
			layer.close(index);
		}, function(){
		});
	}
	function submitDelete(id){
		$.post(URL.deleteUrl,{id:id},function(result){
			if(result.code=='000000'){
				//重新加载当前页面
				ShowAction(1);
			}else{
				layer.msg(result.error, {icon:5});
			}
		});
	}
	function aditAction(){
		console.log(1);
	}
	//获取下拉框数据并填充
	function itemSelect(){
		//获取数据
		$selector = $.post(URL.selectorUrl,{pageSize:10,pageNo:1,invalid:"0"},function(result){
			if(result.code=='000000'){
				//填充数据
				fillContent(result.data.list);
			}else{
				layer.msg(result.error, {icon:5});
			}
		});
	}
//	填充数据
	function fillContent(list){
		var select = $('.itemSelect').html('');
		//设置默认值
		select.append("<option></option>");
		if(list){
			for(var i=0;i<list.length;i++){
				var obj = list[i];
				var msg = obj.name;
				msg = obj.code+'&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+obj.name;
				var option = '<option value='+obj.id+'>'+msg+'</option>';
				//追加数据
				select.append(option);
			}
		}
	}


//	展示数据列表
	function ShowAction(pageNo){
		//启动缓冲动画
		var index = layer.load(2, {
			shade: [0.3,'#fff'] //0.1透明度的白色背景
		});
		var url = URL.inquireUrl;
		//获取查询条件
		var params = {schemeid:schemeid };
		//获得当前页面标记
		$.post(url,params,function(result){
			if(result.code=='000000'){
				var list = result.data;
				if(list){
					showPageData(list);
				}
				//关闭缓冲图标
				layer.close(index);
			}else{
				alert(result.error);
			}
		});
	}
//	展示列表
	function showPageData(list){

		var tbody = $('#list').empty();
		for(var i=0;i<list.length;i++){
			var obj = list[i];
			var invalid = obj.invalid;
			var tr = '<tr>'
				+'<td>'+(i+1)+'</td>'
				+'<td>'+editOD.obj.code+'</td>'
				+'<td>'+editOD.obj.name+'</td>'
				+'<td>'+obj.itemcode+'</td>'
				+'<td>'+obj.itemname+'</td>'
				+'<td><input type="checkbox" '+("0"==invalid?'checked="true"':"")+' disabled="true"></td>'
				+'<td>'+TYPE[editOD.obj.type]+'</td>'
				+'<td>'+obj.remark+'</td>'
				+'<td><span> <a data-toggle="modal"'
				+'		data-target="#edit"><i class="iconfont"'
				+'			data-toggle="tooltip" data-placement="left" title="编辑">&#xe600;</i></a>'
				+'</span> <span> <a data-toggle="modal" data-target="#dele"><i'
				+'			class="iconfont" data-toggle="tooltip" data-placement="left"'
				+'			title="删除">&#xe63d;</i></a>'
				+'</span></td>'
				+'</tr>';
			//转换为jquery对象
			tr=$(tr);
			//追加
			tbody.append(tr);
			//将数据绑定到tr上
			tr.data('obj',obj);
		}
	}
	//获取id
	function getId(){
		var href = window.location.href;
		//获取id
		var strs = href.split('id=');
		var id = strs[1];
		return id;
	}

});
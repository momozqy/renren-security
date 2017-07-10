$(function () {
    $("#jqGrid").jqGrid({
        url: '../ctuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '', name: 'password', index: 'password', width: 80 }, 			
			{ label: '1 普通用户
            2 付费用户
            4 学校用户', name: 'type', index: 'type', width: 80 }, 			
			{ label: '0：未激活
            1：激活
            默认为未激活', name: 'status', index: 'status', width: 80 }, 			
			{ label: '', name: 'trueName', index: 'true_name', width: 80 }, 			
			{ label: '', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '0：男
            1：女', name: 'sex', index: 'sex', width: 80 }, 			
			{ label: '', name: 'age', index: 'age', width: 80 }, 			
			{ label: '0：身份证
            1：军官证
            2：学生证
            3：车本', name: 'cardType', index: 'card_type', width: 80 }, 			
			{ label: '', name: 'cardNumber', index: 'card_number', width: 80 }, 			
			{ label: '', name: 'city', index: 'city', width: 80 }, 			
			{ label: '', name: 'pic', index: 'pic', width: 80 }, 			
			{ label: '', name: 'picSmall', index: 'pic_small', width: 80 }, 			
			{ label: '', name: 'tel', index: 'tel', width: 80 }, 			
			{ label: '', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '', name: 'regTime', index: 'reg_time', width: 80 }, 			
			{ label: '', name: 'activeTime', index: 'active_time', width: 80 }, 			
			{ label: '', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '家长限制
            0：无限制
            ', name: 'parentsLimit', index: 'parents_limit', width: 80 }, 			
			{ label: '', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '', name: 'inviteCode', index: 'invite_code', width: 80 }, 			
			{ label: '', name: 'studentId', index: 'student_id', width: 80 }, 			
			{ label: '', name: 'level', index: 'level', width: 80 }, 			
			{ label: '', name: 'openId', index: 'open_id', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		ctUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ctUser = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var url = vm.ctUser.userId == null ? "../ctuser/save" : "../ctuser/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.ctUser),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../ctuser/delete",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(userId){
			$.get("../ctuser/info/"+userId, function(r){
                vm.ctUser = r.ctUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
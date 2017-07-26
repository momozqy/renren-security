$(function () {
    $("#jqGrid").jqGrid({
        url: '../ctuser/list',
        datatype: "json",
        colModel: [			
			{ label: '用户Id', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户名', name: 'userName', index: 'user_name', width: 80 },
			{ label: '昵称', name: 'nickname', index: 'nickname', width: 80 },
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 },
			{ label: '注册时间', name: 'regTime', index: 'reg_time', width: 80 }
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
		ctUser: {},
        userList:"",
        inputShow:false,
        batchShow:false
	},
	methods: {
		query: function () {
			vm.reload();
		},
        addBatch: function(event){

			$.get("../ctuser/saveBatch",{'userListStr':vm.userList,'isVip':true},
                function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                });
		},
        batchshow:function (event) {
            vm.title = "导入VIP用户";
        	vm.showList = false;
            vm.inputShow = false;
            vm.batchShow = true;
            vm.userList = "";
        },
        upateBatch:function (event) {
            $.get("../ctuser/saveBatch",{'userListStr':vm.userList,'isVip':false},
                function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                });
        },
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
			vm.batchShow = false;
			vm.inputShow = true;
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
			vm.inputShow = false;
			vm.batchShow = false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
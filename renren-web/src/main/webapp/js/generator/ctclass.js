function alarmFormatter(cellvalue, options, rowdata) {
	cellvalue  = "http://www.andotech.cn/pic" + cellvalue;
    return ' <img src="'+cellvalue+'" id="img' + rowdata.Id + '"  style="width:100px;height:75px;" />';
}
$(function () {
    $("#jqGrid").jqGrid({
        url: '../ctclass/list',
        datatype: "json",
        colModel: [
            { label: '绘本ID', name: 'classId', index: 'class_id', width: 80 },
			{ label: '绘本中文名字', name: 'classNameCn', index: 'class_name_cn', width: 80 },
			{ label: '绘本名字', name: 'className', index: 'class_name', width: 80 },
			{ label: '封面预览', name: 'frontcoverUrl', index: 'frontcover_url', width: 80,align: "center", sortable: false, editable: false, formatter: alarmFormatter },
            { label: '绘本类型', name: 'classTypeStr', index: 'class_type', width: 80},
            { label: '绘本等级', name: 'classLevelStr', index: 'class_level', width: 80},
            { label: '状态', name: 'statusStr', index: 'status', width: 80 }
        ],
		viewrecords: true,
        height: 960,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: false,
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
        q:{
            className: null
        },
        classLevelData:null,
        gradeData:null,
        pressData:null,
        seriData:null,
		showList: true,
		title: null,
		ctClass: {},
        ischecked:0
	},
	methods: {
		initData:function () {
            //获取等级
            $.get("../ctclasslevel/list", function(r){
                vm.classLevelData = r.classLevelList;
            });
			//获取出版社列表
			$.get("../ctpress/list", function(r){
                vm.pressData = r.pressList;
            });
			//获取系列列表
            $.get("../ctseri/list", function(r){
                vm.seriData = r.seriList;
            });
			//获取组别
            $.get("../ctgrade/list", function(r){
                vm.gradeData = r.gradeList;
            });
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增课程";
			vm.ctClass = {};
            $('#frontcover').show();
            $('#audiozip').show();
            $('#piczip').show();
            $('#frontcoverpre').hide();
		},
		update: function (event) {
			var rowId = getSelectedRow();
            var rowData = $("#jqGrid").jqGrid("getRowData",rowId);
			var classId = rowData.classId;
			if(classId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(classId);
            $('#frontcover').hide();
            $('#audiozip').hide();
            $('#piczip').hide();
            $('#frontcoverpre').show();
		},
		saveOrUpdate: function (event) {
			if(vm.ctClass.classId == null) {
				var loadDialog;
                $('#ClassForm').ajaxSubmit({
                    beforeSubmit:function(data){
                        for (temp in data){
                            if(data[temp].name=="megagame"){
                                data[temp].value = vm.ischecked;
                                flag = false;
                                break;
                            }
                        }
						loadDialog = layer.load(1, {shade: [0.5,'#9E9E9E']});
					},
                    success: function (r) {
                        layer.close(loadDialog);
                        if (r.code === 0) {
                            alert('操作成功', function (index) {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            }else{
                $.ajax({
                    type: "POST",
                    url: "../ctclass/update",
                    data: JSON.stringify(vm.ctClass),
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
			}
		},
        isMegagame:function () {
            vm.ischecked = vm.ischecked==1?0:1;
        },
		del: function (event) {
			var rowIds = getSelectedRow();
			if(rowIds == null){
				return ;
			}
			var classIds = new Array();
			//for(rowId in rowIds){
            var rowData = $("#jqGrid").jqGrid("getRowData",rowIds);
            classIds.push(rowData.classId)
			//}
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../ctclass/delete",
				    data: JSON.stringify(classIds),
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
		getInfo: function(classId){
			$.get("../ctclass/info/"+classId, function(r){
                vm.ctClass = r.ctClass;
                vm.ctClass.fullPath = "http://www.andotech.cn/pic"+vm.ctClass.frontcoverUrl;
            });
		},
		classLevelTree: function(){
			layer.open({
				type: 1,
				offset: '50px',
				skin: 'layui-layer-molv',
				title: "选择菜单",
				area: ['300px', '450px'],
				shade: 0,
				shadeClose: false,
				content: jQuery("#menuLayer"),
				btn: ['确定', '取消'],
				btn1: function (index) {
					var node = ztree.getSelectedNodes();
					//选择上级菜单
					vm.menu.parentId = node[0].menuId;
					vm.menu.parentName = node[0].name;

					layer.close(index);
				}
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'className': vm.q.className},
                page:page
            }).trigger("reloadGrid");
		}
	},
    created:function () {
        this.initData();
    }
});
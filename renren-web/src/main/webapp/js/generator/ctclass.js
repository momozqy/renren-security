function alarmFormatter(cellvalue, options, rowdata) {
    return ' <img src="'+cellvalue+'" id="img' + rowdata.Id + '"  style="width:100px;height:75px;" />';
}
$(function () {
    $("#jqGrid").jqGrid({
        url: '../ctclass/list',
        datatype: "json",
        colModel: [
            { label: '课程ID', name: 'classId', index: 'class_id', width: 80 },
			{ label: '课程中文名字', name: 'classNameCn', index: 'class_name_cn', width: 80 },
			{ label: '课程名字', name: 'className', index: 'class_name', width: 80 },
			{ label: '封面预览', name: 'frontcoverUrl', index: 'frontcover_url', width: 80,align: "center", sortable: false, editable: false, formatter: alarmFormatter },
			{ label: '状态', name: 'statusStr', index: 'status', width: 80 },
			{ label: '课程等级', name: 'classLevelStr', index: 'class_level', width: 80}
        ],
		viewrecords: true,
        height: 960,
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
		ctClass: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增课程";
			vm.ctClass = {};
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
            
            vm.getInfo(classId)
		},
		saveOrUpdate: function (event) {
			var url = vm.ctClass.classId == null ? "../ctclass/save" : "../ctclass/update";
			$.ajax({
				type: "POST",
			    url: url,
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
		},
		del: function (event) {
			var classIds = getSelectedRows();
			if(classIds == null){
				return ;
			}
			
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
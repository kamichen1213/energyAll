$(function () {
    /* ztree
    var ztree = new $ZTree("deptTree", "/dept/tree");
    ztree.init();
    */
    /**Bootstrap treeView 样式可调*/
    nodeLoad("#deptTreeView",0);
});
// 基于准备好的dom，初始化echarts实例
var barCharts = echarts.init(document.getElementById('bar_reports'));
var lineCharts = echarts.init(document.getElementById('line_reports'));
// 指定图表的配置项和数据
var barOption = {
    title: {
        text: '发电量检测'
    },
    tooltip: {},
    legend: {
        data:['实时值']
    },
    xAxis: {
        data: ["1","2","3","4","5","6"]
    },
    yAxis: {},
    series: [{
        name: '(kwh)',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};
lineOption = {
    xAxis: {
        type: 'category',
        data: ['7:00', '9:00', '11:00', '13:00', '15:00', '17:00', '19:00']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [1, 2, 5, 6, 20, 15, 5],
        type: 'line'
    }]
};

// 使用刚指定的配置项和数据显示图表。
barCharts.setOption(barOption);
lineCharts.setOption(lineOption);

/**
 * 加载组织树形结构
 * @param doment        加载div的选择器
 * @param pid   父类ID,若需要全部组织信息，则设传入值为0
 */
function nodeLoad(doment,pid){
    var data = {"pid" : pid};
    $.ajax({
        type: "Post",
        url: "/dept/getDptListByPid",
        dataType: "json",
        data: data,
        success: function (result) {
            if (result.status == 1){
                $(doment).treeview({
                    data: result.data,         // 数据源
                    showCheckbox: false,   //是否显示复选框
                    highlightSelected: true,    //是否高亮选中
                    showBorder:false,
                    collapseIcon:'glyphicon glyphicon-minus',
                    expandIcon:'glyphicon glyphicon-plus',
                    //nodeIcon: 'glyphicon glyphicon-user',    //节点上的图标
                    //nodeIcon: 'glyphicon glyphicon-globe',
                    emptyIcon: 'glyphicon',    //没有子节点的节点图标
                    multiSelect: false,    //多选
                    //点击选项事件
                    onNodeSelected: function (event, data) {
                        //$(_this).attr("value",data.text);
                        //$(_this).attr("data-type",data.dataId);
                        // $(doment).addClass("displayNone").removeClass("actived");
                    },
                    //勾选事件
                    /*onNodeChecked: function (event,data) {
                        alert("onNodeChecked" + data.dataId);
                    },*/
                    /*onNodeCollapsed: function (event,data) {
                        alert("onNodeCollapsed" + data.dataId);
                    },
                    onNodeDisabled: function (event,data) {
                        alert("onNodeDisabled" + data.dataId);
                    },
                    onNodeEnabled: function (event,data) {
                        alert("onNodeEnabled" + data.dataId);
                    },*/
                    //展开事件
                    onNodeExpanded: function (event,data) {
                        var nodes = data.nodes;
                        if(nodes.length == 0){
                            addNode(doment,data.nodeId, data.dataId);
                        }
                    },
                    /*onNodeSelected: function (event,data) {
                        alert("onNodeSelected" + data.dataId);
                    },
                    onNodeUnchecked: function (event,data) {
                        alert("onNodeUnchecked" + data.dataId);
                    },
                    onNodeUnselected: function (event,data) {
                        alert("onNodeUnselected" + data.dataId);
                    },
                    onSearchComplete: function (event,data) {
                        alert("onSearchComplete" + data.dataId);
                    },
                    onSearchCleared: function (event,data) {
                        alert("onSearchCleared" + data.dataId);
                    },*/
                });
            }else{
                alert('Error Msg get from backService!');
            }
        }
    });
}
function addNode(doment,nodeId, dataId){
    var data = {"pid" : dataId};
    $.ajax({
        type: "Post",
        url: "/dept/getDptListByPid",
        dataType: "json",
        data: data,
        success: function (result) {
            if (result.status == 1) {
                $(doment).treeview("addNode", [nodeId, {node : result.data} ]);
            }
        }
    });
}
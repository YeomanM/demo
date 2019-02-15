layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    var tableList = table.render({
        elem:"#demo",
        id : "userListTable",
        toolbar:"#toolbarDemo",
        url:"/userGroup/page",
        page:true,
        request:{
            pageName:'page',
            limitName:'rows'
        },
        parseData: function(res){
            // console.log(res);
            return {
                "code": res.errCode, //解析接口状态
                "msg": res.errMsg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.records //解析数据列表
            };
        },
        // height : "full",
        cols:[[
            {field:'id',type:"checkbox",width:50},
            // {field:'id',title:'ID',sort:true},
            {field:'groupName',title:'用户组名',sort:true},
            {field:'creator',title:'创建人',sort:true},
            {field:'createdTime',title:'创建时间',sort:true},
            {field:'updator',title:'更新人',sort:true},
            {field:'updatedTime',title:'更新人',sort:true}
        ]]
    });

    //添加用户
    function addGroup(edit){
        var index = layui.layer.open({
            title : "添加用户组",
            type : 2,
            content : "/groupEdit",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    window.sessionStorage.setItem("groupId",edit.groupId);
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }




    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        console.log(checkStatus)
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                addGroup();
                break;
            case 'delete':
                layer.msg('删除');
                break;
            case 'update':
                layer.msg('编辑');
                break;
        };
    });

    table.on('checkbox(test)', function(obj){
        console.log(obj)
    });
})
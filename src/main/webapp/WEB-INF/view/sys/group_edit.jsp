<%--
  Created by IntelliJ IDEA.
  User: yeoman
  Date: 2019/1/24
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<title>layui后台管理模板 2.0</title>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/public.css" media="all" />
</head>
<body class="childrenBody">
    <form class="layui-form">
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">用户组</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input userName" lay-verify="required" placeholder="请输入用户组">
            </div>
        </div>
        <div class="layui-form-item" id="permission">
            <ul id="permission" class="dtree" data-id="0"></ul>
        </div>
    </form>
</body>
<script type="text/javascript" src="layui/layui.js"></script>
<script>

    layui.config({
        base:"/extend/"
    }).extend({
        dtree:'dtree'
    });

    layui.use([ 'layer', 'jquery', 'form','dtree'], function() {

        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer
            , dtree = layui.dtree;

        dtree.render({
            elem:"#permission",
            method:"GET",
            url:"/right/group",
            checkbar: true
        });

    })

</script>
</html>

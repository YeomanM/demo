<%--
  Created by IntelliJ IDEA.
  User: yeoman
  Date: 2019/1/22
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
    <div>
        <table id="demo" class="layui-hide" lay-filter="test"></table>
    </div>
</body>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/group.js"></script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
    </div>
</script>


<style>
    .layui-table-cell .layui-form-checkbox[lay-skin=primary]{
        margin-top: 4px;
    }

    .layui-table, .layui-table-view {
        top: auto;
    }

</style>
</html>

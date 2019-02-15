<%--
  Created by IntelliJ IDEA.
  User: yeoman
  Date: 2019/1/21
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页--layui后台管理模板 2.0</title>
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
        <blockquote class="layui-elem-quote title">更新日志</blockquote>
        <div class="layui-elem-quote layui-quote-nm">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe756;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">
                            <h3 class="layui-inline">暂无</h3>
                            <%--<span class="layui-badge-rim">2018-01-31</span>--%>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

        <blockquote class="layui-elem-quote title">编程日志</blockquote>
        <div class="layui-elem-quote layui-quote-nm">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe756;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">
                            <h3 class="layui-inline">第一次改造完成</h3>
                            <span class="layui-badge-rim">2019-01-21</span>
                            <p>
                                左侧栏改造完成，使用http请求请求后台数据。
                                <br>主页改为时间轴，记录修改日志。
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
<%--<script type="text/javascript" src="layui/layui.js"></script>--%>
<%--<script type="text/javascript" src="js/main.js"></script>--%>

    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>
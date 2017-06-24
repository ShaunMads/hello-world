<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>管理系统登录</title>
	<link rel="stylesheet" href="/css/login.css">
    <script type="text/javascript" src="/js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div class="signin clearfix">
        <h1 class="title">管理系统登录</h1>
        <div class="pot"></div>
        <form class="signbox" id="form233" action="/user/login.do" method="post" autocomplete="off">
            <!-- 用户名 -->
            <div class="input-wrapper">
                <input name="username" type="text" placeholder="用户名"/>
            </div>
                <!-- 密码 -->
                <div class="input-wrapper">
                    <input name="password" type="password" placeholder="密码"/>
                </div>

                <!-- 登录按钮 -->
                <div class="button-wrapper">
                    <button type="submit">登录</button>
            </div>
            <p class="warn">${err_msg}</p>
        </form>
	</div>
</body>
</html>
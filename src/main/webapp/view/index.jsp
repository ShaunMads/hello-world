<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>销售系统</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/mainlayout.css" />
</head>
<body>
    <!-- header start -->
    <%@ include file="header.jsp" %>
    <!-- header end -->
	<div class="container-fluid">
		<div class="row">
		    <!-- 导航栏 -->
			<%@ include file="nav.jsp" %>
            <!-- 主要内容 -->
			<div class="col-md-10 col-md-offset-2 col-sm-9 col-sm-offset-3 main">
				<h1 class="page-header">舒心管理系统</h1>
			</div>
		</div>
	</div>
	<script src="/js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8">
	    $('#index').addClass('active');
	</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>账务信息</title>
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/mainlayout.css" />
	<link rel="stylesheet" type="text/css" href="/css/form.css" />
	<script src="/js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
    <!-- header start -->
    <%@ include file="header.jsp" %>
    <!-- header end -->
	<div class="container-fluid maincontainer">
		<div class="row">
		    <!-- 导航栏 -->
			<%@ include file="nav.jsp" %>
            <!-- 主要内容 -->
			<div class="col-md-6 col-md-offset-2 main">
				<div class="row">
					<div class="col-md-10">

					</div>
				</div>
				<div class="row">
					<div class="col-md-10">
						<table class="table table-msg" id="hospitaltable">
							<tr>
								<th>订单列表</th>
								<th></th>
							</tr>
						</table>
						<span id="total"></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8">
	    
	    var titleList = ${titleList};
	    var picList = ${picList};
	    var timeList = ${timeList};
	    var priceList = ${priceList};
	    var quantityList = ${quantityList};
	    var total = ${total};
		document.getElementById("total").innerHTML = '总金额：'+total+'元';
	</script>
	<script src="/js/hospitalmsg.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
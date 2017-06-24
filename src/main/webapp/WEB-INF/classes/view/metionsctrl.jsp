<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>术后提示</title>	
	<script src="/js/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" />
	<script src="/js/summernote.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/js/summernote-zh-CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="/css/summernote.css" />

	<link rel="stylesheet" type="text/css" href="/css/mainlayout.css" />
	<link rel="stylesheet" type="text/css" href="/css/form.css" />
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
			<div class="col-md-10 col-md-offset-2 main">


				<form id="purchase" class="form-horizontal" method="post" action="/cart/purchase.do" autocomplete="off"
					  accept-charset="utf-8" onsubmit="document.charset='utf-8'">
					<input name="cartContent" id="cartContent" type="hidden"  <%--value=${idList}--%>>
					<input name="quantityList" id="quantityList" type="hidden"  value=${quantityList}>
					<input  type="submit"  value="购买" class="btn btn-lg btn-primary">
					<%--<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button id="purchasebtn" type="button" class="btn btn-primary">
								购买
							</button>
						</div>
					</div>--%>
					<%--将变量传回服务端--%>
				</form>
				<%--<form id="addform" class="form-horizontal" method="post" autocomplete="off" style="display: none;"
						accept-charset="utf-8" onsubmit="document.charset='utf-8'">&lt;%&ndash;中文乱码&ndash;%&gt;

					<input name="nid" id="nid" type="hidden" >&lt;%&ndash;编辑时传id&ndash;%&gt;

				    <div class="form-group">
					    <label class="col-sm-2 control-label" for="days">术后天数:</label>
					    <div class="col-sm-6">
						    <input name="days" id="days" type="text" class="form-control">
					    </div>
				    </div>
				    <div class="form-group">
					    <label class="col-sm-2 control-label" for="days">提示内容:</label>
					    <div class="col-sm-10">
						    <div id="editor"></div>
						    <input name="content" id="content" type="text"  style="display: none;">
					    </div>
				    </div>
				    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-6">
					        <button id="submitbtn" type="button" class="btn btn-primary">提交</button>
					        <button id="cancelbtn" type="button" class="btn btn-primary">取消</button>
					    </div>
				    </div>
				</form>--%>
				<div class="row">
					<div class="col-md-6">
						<table class="table table-msg" id="metionstable">
							<tr>
								<th>购物清单</th>
								<th></th>
							</tr>
						</table>
						<%--<div class="pagecontainer">
							<a href="/admin/getTipList.do?page=${page-1}" class="btn btn-default btn-sm">上一页</a>
							第${page}/${totalPage}页
							<a href="/admin/getTipList.do?page=${page+1}" class="btn btn-default btn-sm">下一页</a>
						</div>--%>
						<div >
							<h2>总价：${total}</h2>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8">
		var tipsList = ${cartContent};
		var quantityList = ${quantityList};
	</script>
	<script src="/js/metionsctrl.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<title>资讯推送</title>
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
	<div class="container-fluid">
		<div class="row">
		    <!-- 导航栏 -->
			<%@ include file="sellerNav.jsp" %>
            <!-- 主要内容 -->
			<div class="col-md-10 col-md-offset-2 main">

				<%--<form id="addcontent" method="post" autocomplete="off" action="/cart/buyContent.do"
					  style="display: none;border: 1px solid;padding: 20px;margin-bottom: 20px;">
                      <p id="goodtitle"></p>
					  <image id="goodpic" style="margin-bottom: 10px"></image>
				</form>--%>

				<div id="addnews" type="button" class="btn btn-lg btn-primary" >发布</div>

				<form id="addform" class="form-horizontal" method="post" autocomplete="off" style="display: none;"
					  enctype="multipart/form-data"><%----%>
				    <div class="form-group">
					    <label class="col-sm-2 control-label" for="title">标题:</label>
					    <div class="col-sm-6">
						    <input name="title" id="title" type="text" class="form-control">
						    <input name="contentId" id="contentId" type="hidden" class="form-control">
					    </div>
				    </div>
				    <%--<div class="form-group">
					    <label class="col-sm-2 control-label" for="content">内容:</label>
					    <div class="col-sm-10">
						    <div id="editor"></div>
						    <input name="content" id="content" type="text" style="display: none;">
					    </div>
				    </div>--%>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="content">摘要:</label>
						<div class="col-sm-10">
							<input name="summary" id="summary" type="text" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="content">价格:</label>
						<div class="col-sm-3" >
							<input name="price" id="price" type="number" class="form-control" >
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="content">上传图片:</label>
						<div class="col-sm-10">
							<input name="imgfile" type="file" accept="image/gif, image/jpeg"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="content">内容:</label>
						<div class="col-sm-10">
							<textarea name="content" id="content" cols="30" rows="10"></textarea>

						</div>
					</div>
				    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-6">
					        <button id="submitbtn" type="button" class="btn btn-primary">
								提交
							</button>
					        <button id="cancelbtn" type="button" class="btn btn-primary">取消</button>
					    </div>
				    </div>
				</form>
				<div class="row">
					<div class="col-md-8">
						<table class="table table-msg" id="newstable">
							<tr>
								<th>资讯标题</th>
								<th></th>
							</tr>
						</table>
						<div class="pagecontainer">
							<a href="/content/getContentList.do?page=${page-1}&type=0" class="btn btn-default btn-sm">上一页</a>
							第${page}/${totalPage}页
							<a href="/content/getContentList.do?page=${page+1}&type=0" class="btn btn-default btn-sm">下一页</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script  type="text/javascript" charset="utf-8">
		var contentList = ${contentList};
	</script>
	<script src="/js/newsctrl.js" type="text/javascript" charset="utf-8">
	</script>
</body>
</html>
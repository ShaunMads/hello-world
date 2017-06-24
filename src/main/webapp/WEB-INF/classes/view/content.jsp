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
    <%@ include file="nav.jsp" %>
    <!-- 主要内容 -->
    <div class="col-md-10 col-md-offset-2 main">


    </div>
  </div>
</div>

<script  type="text/javascript" charset="utf-8">
  var title = ${title};
  console.log(title)
</script>
<script  type="text/javascript" charset="utf-8">
  var contentList = ${contentList};
</script>
<script src="/js/newsctrl.js" type="text/javascript" charset="utf-8">
</script>
</body>
</html>
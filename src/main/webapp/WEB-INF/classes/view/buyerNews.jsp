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
            <form id="addcontent" method="post" autocomplete="off" action="/cart/buyContent.do"
                  style="display: none;border: 1px solid;padding: 20px;margin-bottom: 20px;">
                <p id="goodtitle" ></p>
                <image id="goodpic" style="margin-bottom: 10px"></image>
             <div>
                 <input type="button" id="subnum" value="-"  style="width:30px;height:30px;background-color:#CCC;font-size:20px;text-align:center;line-height:30px;cursor:pointer;float:left;border:none" />
                 <input type="text" name="num" id="num"  style="width:45px;height:30px;fontSize:20px;text-align:center;line-height:30px;float:left"/>
                 <input type="button" id="addnum" value="+" style="width:30px;height:30px;background-color:#CCC;fontSize:20px;text-align:center;line-height:30px;cursor:pointer;float:left;border:none" />
                 <div style="clear:left"></div>
             </div>
                <div style="margin-top: 10px">
                    <input id="mai" type="submit" value="购买" style="marginTop:10px,backgroundColor:#337ab7,color:#FFF,borderColor:#2e6da4"}/>
                    <input id="quXiao" type="button" value="取消"/><input type="hidden" name="goodsID" id="goodsID" />
                </div>

            </form>

            <div id="nonBuy" type="button" class="btn btn-lg btn-primary" >
                <a href="/content/getNonBoughtList.do?page=1">未购买</a>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <table class="table table-msg" id="newstable">
                        <tr>
                            <th>内容列表</th>
                            <th></th>
                        </tr>
                    </table>
                    <div class="pagecontainer">
                        <a href="/content/getContentList.do?page=${page-1}&type=1" class="btn btn-default btn-sm">上一页</a>
                        <%--totalpage未更新--%>
                        第${page}/${totalPage}页
                        <a href="/content/getContentList.do?page=${page+1}&type=1" class="btn btn-default btn-sm">下一页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script  type="text/javascript" charset="utf-8">
    var contentList = null;
    var contentList = ${contentList};
</script>
<script src="/js/buyerNews.js" type="text/javascript" charset="utf-8">
</script>
</body>
</html>
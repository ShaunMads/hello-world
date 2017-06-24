<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-pills nav-stacked">
        <li id="newsctrl">
            <a href="/content/getContentList.do?page=1&type=1"><%--如何获取type--%>
                <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                <span class="nav-text">内容列表</span>
            </a>
        </li>
        <li id="hospitalmsg">
            <a href="/financial/getBoughtList.do">
                <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
			    <span class="nav-text">账务信息</span>
            </a>
        </li>
        <li id="metionsctrl"> 
            <a href="/cart/getCart.do">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			    <span class="nav-text">购物车</span>
            </a>
        </li>
	</ul>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
    	<div class="navbar-header">
            <a class="navbar-brand headicon" href="/view/index.jsp">通关大BOSS--销售系统</a>
        </div>
        <div class="navbar-collapse collapse">
        	<div class="navbar-nav navbar-right whitecolor"> 
		        <img src="/images/headimg.jpeg" alt="Loading" class="personLogo img-circle"/>
		        <span >Welcome,</span>
	        	<span class="dropdown-toggle" role="button" data-toggle="dropdown"><%= session.getAttribute("name")%><span class="caret"></span></span>
	            <ul class="dropdown-menu" role="menu">
	                <li><a href="/user/logout.do">退出</a></li>
	            </ul>
            </div>
        </div>
    </div>
</nav>
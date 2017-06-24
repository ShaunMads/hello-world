<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telphone=no, email=no"/>
    <title>Document</title>
    <style>
        body {
            background-color: #fafafa;
            padding: 0 2%;
        }
        .container {
            font-family: "Microsoft Yahei";
        }
        .header h1 {
            font-size: 28px;
            margin-bottom: 0;
        }
        .time {
            margin-top: 10px;
            color: #bbbbbb;
        }
        .content {
            margin-top: 10px;
            color:#000;
        }
        .content img {
            max-width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>${title}</h1>
    </div>
    <div class="time">
        ${time}
    </div>
    <div class="content">
        ${content}
    </div>
</div>
</body>
</html>
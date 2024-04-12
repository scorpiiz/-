<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <meta charset="utf-8">
    <link href="<%=path %>/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/fonts.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/style.css" rel="stylesheet">
    <script src="<%=path %>/admin/js/jquery.min.js"></script>
    <style>
        table{line-height:31px;font-size:13px;}
        input[type=text]{min-height:23px;}
        select{min-height:23px;}
    </style>
  

<script src="<%=path%>/layer/layer.js" type="text/javascript"></script>
<link href="<%=path%>/admin/css/pro.css" rel="stylesheet" type="text/css" />
  

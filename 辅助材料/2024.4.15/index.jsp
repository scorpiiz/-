<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 
    <meta charset="utf-8">
    <title>宠物救助服务平台</title>
    <link href="<%=path %>/admin/css/style.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/theme.css" rel="stylesheet">
    <link href="<%=path %>/admin/css/fonts.css" rel="stylesheet">
    <script src="<%=path %>/admin/js/jquery.min.js"></script>
    <script src="<%=path %>/admin/js/bootstrap.js"></script>
    <script src="<%=path %>/admin/js/jquery.cookie.js"></script>
    <script src="<%=path %>/admin/js/framework.js"></script>
    <style>
        .sele{
            text-decoration: none;
            color: #fff;
            background-color: #15c377;
        }
    </style>
     
 </head>
 
  <body class="theme-blue-gradient pace-done" style="overflow: hidden; ">


     <%   String adminLname=(String) session.getAttribute("adminLname");
		String role=(String) session.getAttribute("role");
         if(adminLname==null){ %>
            <script type="text/javascript" language="javascript">
		        alert("您还没有登录，请登录...");
	        	window.document.location.href="<%=path %>/toadminlogin.action";	
	        </script>	
  <%     return;} %>   
     
    <div id="theme-wrapper">
        <header class="navbar" id="header-navbar">
            <div class="container" style="padding-right: 0px;">
                <a class="navbar-brand" id="logo" href="#">宠物救助服务平台</a>
                <div class="clearfix">
                    <div class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
                        <ul class="nav navbar-nav pull-left">
                            <li>
                                <a id="make-small-nav">
                                    <div class="ftdms-aside-toggler">
                                        <span class="ftdms-toggler-bar"></span>
                                        <span class="ftdms-toggler-bar"></span>
                                        <span class="ftdms-toggler-bar"></span>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="nav-no-collapse pull-right" id="header-nav">
                        <ul class="nav navbar-nav pull-right">
                            <li class="dropdown profile-dropdown">
                                <a class="dropdown" href="#" data-toggle="dropdown">
                                    <span class="hidden-xs">当前用户：<%= adminLname%>&nbsp;&nbsp;&nbsp;&nbsp;角色：<%= role%></span>
                                </a>
                                <ul class="dropdown-menu pull-right">
                                    <li>
                                        <a  href="<%=path %>/index.action" data-id="rofile" data-index="100" target="_blank"><i class="ft ftsucai-home"></i>网站首页</a>
                                    </li>
                                    <li>
                                        <a class="submenuitem" href="<%=path %>/toadminpass.action" data-id="linkpwd" data-index="101"><i class="ft ftsucai-edit-2"></i>修改密码</a>
                                    </li>
                                    <li>
                                        <a href="<%=path %>/toquit.action"><i class="ft ftsucai-exit2"></i>安全退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <div class="container" id="page-wrapper">
            <div class="row">
                <div id="nav-col">
                    <section class="col-left-nano" id="col-left">
                        <div class="col-left-nano-content" id="col-left-inner">
                            <div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">
                                <ul class="nav nav-pills nav-stacked">
                                    <li>
                                        <a class="dropdown-toggle" href="#" data-id="a1">
                                            <i class="ft ftsucai-menu-fold"></i>
                                            <span>功能菜单</span>
                                        </a>
                                    </li>
                                    

                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>用户管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/userList.action" data-id="link1" data-index="1">管理用户</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>宠物领养管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/adoptList.action" data-id="link1" data-index="1">管理宠物领养</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>申请记录管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/applyList.action" data-id="link1" data-index="1">管理申请记录</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>宠物寻回管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/petlostList.action" data-id="link1" data-index="1">管理宠物寻回</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>寻回记录管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/petfindList.action" data-id="link1" data-index="1">管理寻回记录</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>宠物知识管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/zixunToAdd.action" data-id="link1" data-index="1">添加宠物知识</a>
    </li>
             <li>
       <a class="submenuitem" href="<%=path %>/zixunList.action" data-id="link1" data-index="1">管理宠物知识</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>活动管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/helpList.action" data-id="link1" data-index="1">管理活动</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>活动报名管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/baomingList.action" data-id="link1" data-index="1">管理活动报名</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>活动打卡管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/recordList.action" data-id="link1" data-index="1">管理活动打卡</a>
    </li>
    
                        </ul>
        </li>
                
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>消息管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/smsList.action" data-id="link1" data-index="1">管理消息</a>
    </li>
    
                        </ul>
        </li>
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>轮播图管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/picToAdd.action" data-id="link1" data-index="1">添加轮播图</a>
    </li>
             <li>
       <a class="submenuitem" href="<%=path %>/picList.action" data-id="link1" data-index="1">管理轮播图</a>
    </li>
    
                        </ul>
        </li>
                   
                    <li>
       <a class="dropdown-toggle" href="#" >
           <i class="ft ftsucai-UI"></i> <span>系统管理</span>  <i class="ft ftsucai-139 drop-icon"></i> </a>
        <ul class="submenu">
         <li>
       <a class="submenuitem" href="<%=path %>/toadminpass.action" data-id="link1" data-index="1">修改密码</a>
    </li>
    
                        </ul>
        </li>

                                 
                                </ul>
                            </div>
                        </div>
                    </section>
                </div>
                <div id="content-wrapper">
                    <div class="content-tabs" style="height:44px;border-bottom:2px solid #f0f0f0;">
                        <button class="roll-nav roll-left tabLeft">
                            <i class="ft ftsucai-backward2"></i>
                        </button>
                        <nav class="page-tabs menuTabs">
                            <div class="page-tabs-content" style="margin-left: 0px;">
                                <a class="menuTab active" href="javascript:;" data-id="home.html">欢迎首页</a>
                            </div>
                        </nav>
                        <button class="roll-nav roll-right tabRight">
                            <i class="ft ftsucai-forward3"></i>
                        </button>
                        <div class="btn-group roll-nav roll-right">
                            <button class="dropdown tabClose" data-toggle="dropdown">页签操作
                                <i class="ft caret" style="padding-top: 3px;"></i>
                            </button>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li>
                                    <a class="tabReload" href="javascript:void();"><i class="ft ftsucai-spinner3"></i>刷新当前页面</a>
                                </li>
                                <li>
                                    <a class="tabCloseCurrent" href="javascript:void();"><i class="ft ftsucai-close-3"></i>关闭当前页面</a>
                                </li>
                                <li>
                                    <a class="tabCloseAll" href="javascript:void();"><i class="ft ftsucai-77"></i>关闭全部页面</a>
                                </li>
                                <li>
                                    <a class="tabCloseOther" href="javascript:void();"><i class="ft ftsucai-120"></i>除此之外全关</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="content-iframe" style="background-color: #f9f9f9;">
                        <div class="mainContent" id="content-main" style="margin: 0px; padding: 0px; height: 1050px;">
                            <iframe name="main_iframe" width="100%" height="100%" class="NFine_iframe" id="default" src="<%=path %>/toright.action" frameborder="0" data-id="home.html"></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=path %>/admin/js/index.js"></script>
    <script src="<%=path %>/admin/js/indextab.js"></script>
    <script src="<%=path %>/admin/js/pace.min.js"></script>

<script>
    $(function(){
       //.submenu 下 超连接 获得焦点时加上active
        $('.submenu').find('a').on('focus',function(){
            $(this).parent().addClass('sele');
        });
        $('.submenu').find('a').on('blur',function(){
            $(this).parent().removeClass('sele');
        });

        //设置ifame的高度为自适应
        var height = $(window).height();
        $('.mainContent').height(height-84);
        $(window).resize(function(){
            var height = $(window).height();
            $('.main_iframe').height(height-84);
        });

    });
</script>



  </body>
</html>





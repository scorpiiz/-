<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 <jsp:include flush="true" page="${basePath}/admin/head.jsp"></jsp:include>     
 </head>
 
  <body>


        
     
<main class="ftdms-layout-content">

    <div class="container-fluid" style="margin-bottom:90px;">

        <div class="row" style="margin-top:15px;">
            <div class="col-lg-12">
                <div class="card">
                    <ul class="nav nav-tabs page-tabs">
                        <li class="active"> <a href="#">后台首页</a> </li>

                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active">

                            <style>
                    
                     tr{line-height: 30px;}
                  
                     table{line-height: 30px;font-size: 12px}
                  </style>
                 <table class="table" style="width:100%;text-align:center;">
                
                          <tr>
                                   <td>
                                       &nbsp;</td>
                               </tr>
                               <tr>
                                   <td>
                                       &nbsp;</td>
                               </tr>
                               <tr>
                                   <td>
                                       欢迎您的登录！</td>
                               </tr>
                               <tr>
                                   <td>
                                       您的登录IP为：<%=  request.getRemoteAddr() %></td>
                               </tr>
                       
                               <tr>
                                   <td>
                                       &nbsp;</td>
                               </tr>
                    
                </table>

                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>

</main>



  </body>
</html>



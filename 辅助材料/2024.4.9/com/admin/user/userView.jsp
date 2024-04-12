<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    <li class="active"> <a href="#">查看用户</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">

          
                 		
                 		 <table style="width:100%;" >
                     <tr>
	<td height="25" width="20%" align="right">用户名：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.uname}</td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">密码：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.upass}</td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">头像：</td>
	<td height="25" width="*" align="left" style="text-align:left"><img alt="" width="120" height="120" src='<%=path %>${user.pic}' /></td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">姓名：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.man}</td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">电话：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.tel}</td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">地址：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.address}</td>
	</tr>
<tr>
	<td height="25" width="20%" align="right">注册时间：</td>
	<td height="25" width="*" align="left" style="text-align:left">${user.addtime}</td>
	</tr>

                 
                     <tr>
                         <td>&nbsp;</td>
                         <td align="left">
                 		      <input type="submit" name="btnAdd" value="返 回"  onclick="history.go(-1);"   class="btn btn-primary" />
                             </td>
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

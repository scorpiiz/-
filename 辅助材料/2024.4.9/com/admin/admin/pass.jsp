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
	    <li class="active"> <a href="#">修改密码</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">	

                 		<form  action="<%=path %>/admin_Pass.action" method="post">
                 		 <table style="width:100%;" >
                     <tr>
        <td  style=" text-align:right; width:30%;"><font style='color:red'>*&nbsp;</font>原密码:</td>
        <td class="tbright"><div style="display:inline;float:left;"><input name="txt_pwd" id="txt_pwd" type="password" required /></div></td>
    </tr>
<tr>
        <td  style=" text-align:right; width:30%;"><font style='color:red'>*&nbsp;</font>新密码:</td>
        <td class="tbright"><div style="display:inline;float:left;"><input name="txt_pwd2" id="txt_pwd2" type="password" required /></div></td>
    </tr>
<tr>
        <td  style=" text-align:right; width:30%;"><font style='color:red'>*&nbsp;</font>确认密码:</td>
        <td class="tbright"><div style="display:inline;float:left;"><input name="txt_pwd3" id="txt_pwd3" type="password" required /></div></td>
    </tr>

                 
                     <tr>
                         <td>&nbsp;</td>
                         <td align="left">
                 		      <input type="submit" name="btnAdd" value="确 定" onclick="return jQuery.formValidator.PageIsValid('1');" id="btnAdd"    class="btn btn-primary" />
            
                             </td>
                     </tr>
                 </table>
                            </form>
                 	
                                 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

      
</body>
</html>



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

<script type="text/javascript" src="<%=path%>/admin/js/popup_shuaxin_no.js"></script>
	   <script language="javascript">     
		    
	       function up2(cc)
	       {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path%>/upfile/upload1.jsp?c="+cc);
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	       }
        </script>



 </head>

 <body>
       
<main class="ftdms-layout-content">

    
	 <div class="container-fluid" style="margin-bottom:90px;">
	 <div class="row" style="margin-top:15px;">   
	 <div class="col-lg-12">         
	 <div class="card">
	 <ul class="nav nav-tabs page-tabs">             
	    <li class="active"> <a href="#">编辑用户</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">
                       
                 			<form  action="<%=path %>/userEdit.action" method="post">
                 		 <table style="width:100%;" >
                     <tr>
<td  style=" text-align:right; width:20%;"><font style='color:red'>*&nbsp;</font>密码:</td>
<td class="tbright"><div style="display:inline;float:left;"><input name="upass" type="text" id="upass" style="width: 200px; " required value='${user.upass}' /></div>
</td></tr>
<tr>
<td  style=" text-align:right; width:20%;">头像:</td>
<td class="tbright"><div style="display:inline;float:left;"><img src='<%=path %>${user.pic}' width=100 height=100 /><input type="text" name="pic" id="pic" size="50" readonly="readonly" value='${user.pic}'  />
<input type="button" value="上传" onclick="up2('pic')" /></div>
</td></tr>
<tr>
<td  style=" text-align:right; width:20%;"><font style='color:red'>*&nbsp;</font>姓名:</td>
<td class="tbright"><div style="display:inline;float:left;"><input name="man" type="text" id="man" style="width: 200px; " required value='${user.man}' /></div>
</td></tr>
<tr>
<td  style=" text-align:right; width:20%;">电话:</td>
<td class="tbright"><div style="display:inline;float:left;"><input name="tel" type="text" id="tel" style="width: 200px; "  value='${user.tel}' /></div>
</td></tr>
<tr>
<td  style=" text-align:right; width:20%;">地址:</td>
<td class="tbright"><div style="display:inline;float:left;"><input name="address" type="text" id="address" style="width: 200px; "  value='${user.address}' /></div>
</td></tr>

                 
                     <tr>
                         <td>&nbsp;</td>
                         <td align="left">
                 		       <input name="id" type="hidden" id="id" value='<%= request.getParameter("id") %>'> 
                      <input type="submit" name="btnAdd" value="编 辑"  id="btnAdd"    class="btn btn-primary" />
                     <input name="btnReturn" type="button" value="返 回"  class="btn btn-danger"  onclick="location.href='<%=path %>/userList.action';"  />
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

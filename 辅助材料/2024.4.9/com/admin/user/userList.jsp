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
	    <li class="active"> <a href="#">管理用户</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">		


<table style="width: 100%;text-align: center">
    <tr>
        <td>
             <form action="<%=path %>/userList.action" method="post">
                  <strong> 用户名:</strong><input name="uname" type="text" id="uname" style="width: 150px; "  />
<strong> 姓名:</strong><input name="man" type="text" id="man" style="width: 150px; "  />

                  <input name="search" type="submit" border="0" class="btn btn-primary"	value='查询' />
                </form>
 
        </td>
    </tr>
    <tr>
        <td>   
            
    <table style="width:100%;text-align: center" id="show_tab">
	
                  <tr>
                  <th >用户名</th>
                  <th >头像</th>
                  <th >姓名</th><th >电话</th><th >注册时间</th>
                  <th scope="col">操作</th>
                  </tr>
                 <c:forEach items="${userList}" var="user" varStatus="status" >
                     <tr>
                      <td >${user.uname}</td>
                      <td ><img alt="" width="80" height="80" src='<%=path %>${user.pic}' /></td>
                      <td >${user.man}</td><td >${user.tel}</td><td >${user.addtime}</td>
                      <td >
                      <a href="<%=path %>/touserView.action?id=${user.id}" >详细</a>&nbsp;
<a href="<%=path %>/touserEdit.action?id=${user.id}" >编辑</a>&nbsp;
<a href="javascript:void(0)"  onclick="layer.confirm('您确定要删除吗？',{icon:3,title:'提示'},function(index){
            layer.close(index);
            window.location.href='<%=path %>/userDel.action?id=${user.id}';
        });">删除</a>&nbsp;

		              </td>
		             </tr>
                 </c:forEach>

 
    </table>

  </td>
    </tr>
    <tr>
        <td>
                                                                       <jsp:include page="../../common/page.jsp" flush="true" /> 
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


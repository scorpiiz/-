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
	    <li class="active"> <a href="#">管理活动</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">		


<table style="width: 100%;text-align: center">
    <tr>
        <td>
             <form action="<%=path %>/helpList.action" method="post">
                  <strong> 活动主题:</strong><input name="pname" type="text" id="pname" style="width: 150px; "  />
<strong> 用户:</strong><input name="uname" type="text" id="uname" style="width: 150px; "  />
<strong> 发布人:</strong><input name="man" type="text" id="man" style="width: 150px; "  />

                  <input name="search" type="submit" border="0" class="btn btn-primary"	value='查询' />
                </form>
 
        </td>
    </tr>
    <tr>
        <td>   
            
    <table style="width:100%;text-align: center" id="show_tab">
	
                  <tr>
                  <th >活动主题</th><th >用户</th>
                  <th >图片</th>
                  <th >查看</th><th >状态</th>
				  </th><th >添加时间</th>
                  <th scope="col">操作</th>
                  </tr>
                 <c:forEach items="${helpList}" var="help" varStatus="status" >
                     <tr>
                      <td >${help.pname}</td><td >${help.uname}</td>
                      <td ><img alt="" width="80" height="80" src='<%=path %>${help.pic}' /></td>
                      <td >${help.see}</td><td >${help.zt}</td>
					  <td >${help.addtime}</td>
                      <td >
                      <a href="<%=path %>/tohelpView.action?id=${help.id}" >详细</a>&nbsp;

<c:if test="${help.zt.equals('未审核')}">

<a href="<%=path %>/helpEdit.action?id=${help.id}&t=1" >审核通过</a>&nbsp;

<a href="<%=path %>/helpEdit.action?id=${help.id}&t=2" >审核不通过</a>&nbsp;
</c:if>

<a href="javascript:void(0)"  onclick="layer.confirm('您确定要删除吗？',{icon:3,title:'提示'},function(index){
            layer.close(index);
            window.location.href='<%=path %>/helpDel.action?id=${help.id}';
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


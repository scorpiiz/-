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
	    <li class="active"> <a href="#">管理宠物寻回</a> </li>           
	 </ul>
	 <div class="tab-content">            
	 <div class="tab-pane active">		


<table style="width: 100%;text-align: center">
    <tr>
        <td>
             <form action="<%=path %>/petlostList.action" method="post">
                  <strong> 主题:</strong><input name="pname" type="text" id="pname" style="width: 150px; "  />
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
                  <th >主题</th><th >用户</th>
                  <th >图片</th>
                  <th >查看</th><th >费用</th><th >状态</th>
                  <th >宠物年龄</th><th >添加时间</th>
                  <th scope="col">操作</th>
                  </tr>
                 <c:forEach items="${petlostList}" var="petlost" varStatus="status" >
                     <tr>
                      <td >${petlost.pname}</td><td >${petlost.uname}</td>
                      <td ><img alt="" width="80" height="80" src='<%=path %>${petlost.pic}' /></td>
                      <td >${petlost.see}</td><td >${petlost.fee}</td><td >${petlost.zt}</td>
                      <td >${petlost.age}</td><td >${petlost.addtime}</td>
                      <td >
                      <a href="<%=path %>/topetlostView.action?id=${petlost.id}" >详细</a>&nbsp;
<a href="javascript:void(0)"  onclick="layer.confirm('您确定要删除吗？',{icon:3,title:'提示'},function(index){
            layer.close(index);
            window.location.href='<%=path %>/petlostDel.action?id=${petlost.id}';
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


<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script src="<%=path%>/layer/jquery.min.js"></script>
<script src="<%=path%>/layer/layer.js" type="text/javascript"></script>
<html>
  <head>
       <script type="text/javascript">
         $(function() {      
		   <c:if test="${message!=null && !message.equals('') && path!=null && !path.equals('')}">
			  layer.ready(function() {
				  layer.msg('${message}', {icon: 1, time: 2000}, function () {
					  location.href = '<%=path %>/${path}';
				  });
			  });
		   </c:if>

		  <c:if test="${message!=null && !message.equals('') && (path==null || path.equals(''))}">
			  layer.ready(function() {
				  layer.msg('${message}', {icon: 2, time: 2000}, function () {
					  history.go(-1);
				  });
			  });
		   </c:if>

		   <c:if test="${path!=null && !path.equals('') && (message==null || message.equals(''))}">
			  document.location.href="<%=path%>/${path}";
		   </c:if>
        });    
       </script>
  </head>
  
  <body>
       
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <style>
 .page-more {
    height: 40px;
    line-height: 40px;
    margin: 0 auto;
    border: 1px solid #ccc;
    text-align: center;
    border-radius: 3px
}

.page-more
a {
    font-size: 18px;
    display: block;
    border-radius: 4px;
    box-shadow: inset 0px 2px 8px rgba(210, 205, 205, 0.8)
}

.page-more a:hover {
    background: -webkit-linear-gradient(top, rgba(255, 255, 255, 0.8) 1%, rgba(200, 200, 200, 0.2) 100%);
    box-shadow: inset 0px -1px 0px rgba(215, 215, 215, 0.4)
}

.tagsPageMain {
    padding: 20px 0;
    height: 77px;
    background: #fff;
    clear: both;
    width: 100%;
    overflow: hidden;
    zoom: 1;
    text-align: center;
    margin: 10px auto
}

.tagsPage {
    text-align: center;
    font-size: 14px;
    height: 37px;
    overflow: hidden
}

.tagsPage a, .tagsPage
span {
    transition: 0.3s ease-in-out;
    border: 1px solid #ccc;
    border-radius: 4px;
    background: #fff;
    box-shadow: inset 0px 1px 1px rgba(50, 50, 50, 0.05);
    width: 66px;
    display: inline-block;
    margin-right: 10px;
    height: 35px;
    line-height: 35px
}

.tagsPage
span {
    color: #c2c2c2;
    text-shadow: 1px 1px 0 #f2f2f2
}

.tagsPage
span.on {
    color: #fff;
    border: 1px solid #303e67;
    background: #303e67;
}

.tagsPage a:hover {
    color: #fff;
    border: 1px solid #303e67;
    background: #303e67;
    display: inline-block;
    height: 35px;
    line-height: 35px
}
 </style>
  
 <body>

 <c:if test="${pageTotal>0}">
<div class="tagsPageMain">
                            <div class="bl"></div>
                            <div class="br"></div>
                            <div class="tagsPage">
      
            共 <font color="red">${itemSize}</font>
            条记录   <font color="red">${curPage}</font>/${pageTotal} 页   
            
            <c:if test="${curPage==1}">
            <span>首页</span>
			<span>上一页</span>
			</c:if>

			<c:if test="${curPage>1}">
			<a class="num" href="${pUrl}">首页</a>
			<a class="num" href="${pUrl}&pager.offset=${(curPage-2)*pageItem}">上一页</a>
            </c:if>

            <c:forEach items="${pageList}" var="page" varStatus="status" >
            <c:if test="${page==curPage}"><span class="on">${page}</span></c:if>
			<c:if test="${page!=curPage}"><a class="num" href="${pUrl}&pager.offset=${(page-1)*pageItem}">${page}</a></c:if>
            </c:forEach>

			<c:if test="${curPage<pageTotal}">
			<a class="num" href="${pUrl}&pager.offset=${curPage*pageItem}">下一页</a>
			<a class="num" href="${pUrl}&pager.offset=${(pageTotal-1)*pageItem}">末页</a>
             </c:if>

			<c:if test="${curPage==pageTotal}">
            <span>下一页</span>
			<span>末页</span>
			</c:if>

       
    </div>                        </div>


  
     </c:if> 
      
</body>
</html>

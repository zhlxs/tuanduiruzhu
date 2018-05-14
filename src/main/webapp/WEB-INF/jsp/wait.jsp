<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="<%=basePath%>css/pulgin/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>css/common.css">
<link rel="stylesheet" href="<%=basePath%>css/wait.css">
<%-- <script type="text/javascript" src="<%=basePath%>js/jinyou.js"></script> --%>
<script type="text/javascript" src="<%=basePath%>js/base.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/pulgin/jquery-3.3.1.min.js"></script>

<title>等待页</title>
</head>
<body ondragstart="return false">
	<div class="waitbox">
		<!-- 轮播图 S -->
		<div id="carousel-example-generic" class="carousel slide waitpage"
			data-ride="carousel">
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
			<div class="item active">
					<img src="<%=basePath%>img/index_bj.png" alt="酒店详情">
				</div>
				<div class="item">
					<img src="<%=basePath%>img/index_bj2.png" alt="酒店详情">
				</div>
				<div class="item">
					<img src="<%=basePath%>img/index_bj3.png" alt="酒店详情">
				</div>
				
				<%--  <c:forEach items="${list}" var="ad" >
                <c:if test="${ad.id == 1}">
                    <div class="item active">
                        <img src="data:image/png;base64,${ad.imgStr}" alt="First slide">
                    </div>
                </c:if>
                <c:if test="${ad.id != 1}">
                    <div class="item">
                        <img  src="data:image/png;base64,${ad.imgStr}" alt="Second slide">
                    </div>
                </c:if> 
            </c:forEach>--%>
            
				
			</div>
		</div>
		<div class="center">
			<img src="<%=basePath%>img/puick.png" alt="">
		</div>
		<div class="btm">
			<p>扫描二维码</p>
			<p>可在酒店公众号进行订房</p>
			<img src="<%=basePath%>img/code.jpg" alt="">
		</div>
		<div class="real_btn">
			<img src="<%=basePath%>img/index_icon.png" alt="">
		</div>
	</div>
	<script src="<%=basePath%>js/pulgin/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/wait.js"></script>
</body>
</html>
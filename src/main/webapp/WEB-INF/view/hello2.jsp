<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
	<script type="text/javascript" src="${basePath }/static/js/jquery-1.8.3.min.js"></script>
	<style type="text/css">
	h1 {
		font-size: 12px;
		color: #c1c1c1;
	}
	</style>
	<script type="text/javascript">
	$(function(){
		$('h1').html('Hi JQuery');
	});
	</script>
</head>
<body>
<h1>-----</h1>
<c:forEach var="product" items="${productList }">
商品：<c:out value="${product.productName }"></c:out><br/>
</c:forEach>
</body>
</html>

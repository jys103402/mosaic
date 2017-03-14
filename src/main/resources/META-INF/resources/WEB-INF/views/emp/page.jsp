<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>list.jsp</title>
</head>
<body>
<c:set var="dept" value="${page.dept}"/>
<c:set var="paging" value="${page.paging}"/>
<h1>Emp page List pageNo = ${page.paging.pageNo}</h1>
<c:forEach var="emp" items="${dept}" varStatus="status">
	<b>${status.index+1}. </b> ${emp.empno} ${emp.ename} ${emp.job} ${emp.mgr} ${emp.hiredate} ${emp.deptno}<br>
</c:forEach>
<hr>

<c:if test="${page.paging.firstGroup==false}">
	<a href="/emp/page/1">First</a>
	<a href="/emp/page/${page.paging.firstPage-1}">Prev</a>
</c:if>

<c:forEach var="i" begin="${page.paging.firstPage}" end="${page.paging.lastPage}">
	<a href="/emp/page/${i}">${i}</a>
</c:forEach>

<c:if test="${page.paging.lastGroup==false}">
	<a href="/emp/page/${page.paging.lastPage+1}">Next</a>
	<a href="/emp/page/${page.paging.totalPage}">Last</a>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>item.jsp</title>
</head>
<body>
${error}<br>
${emp.empno} ${emp.ename} ${emp.job} ${emp.mgr} ${emp.hiredate} ${emp.deptno}<br>
</body>
</html>
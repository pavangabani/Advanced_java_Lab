<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <c:set var="val1" value="${param.op1}" />
        <c:set var="val2" value="${param.op2}" />
        <c:set var="opr"  value="${param.cmd}" />
        <c:set var="res"  scope="session" value="${0}" />

        <c:if test="${opr == '+'}">
            <c:set var="res" scope="session" value="${val1+val2}" />
        </c:if>

        <c:if test="${opr == '-'}">
            <c:set var="res" scope="session"  value="${val1-val2}" />
        </c:if>

        <c:if test="${opr == '*'}">
            <c:set var="res" scope="session" value="${val1*val2}" />
        </c:if>

        <c:if test="${opr == '/'}">
            <c:set var="res" scope="session" value="${val1/val2}" />		
        </c:if>

        <h1>
        <c:out value="${'OUTPUT : '}"/>

        <c:out value="${res}" />
        </h1>

    </body>
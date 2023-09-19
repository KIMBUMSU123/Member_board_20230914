<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-15
  Time: 오전 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        table {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>
<div class="container">
    <div id="member-detail">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>email</td>
                <td>name</td>
                <td>mobile</td>
                <td>profile</td>
            </tr>
            <tr>
                <td>${member.id}</td>
                <td>${member.memberEmail}</td>
                <td>${member.memberName}</td>
                <td>${member.memberMobile}</td>
                <td>${member.memberProfile}</td>
            </tr>
        </table>
        <a href="/memberPages/memberList">목록으로 돌아가기</a>
    </div>
</div>
<%@include file="../component/footer.jsp" %>
</body>
</html>

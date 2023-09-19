<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

    <style>
        #section {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="../component/header.jsp"%>
<%@include file="../component/nav.jsp"%>
<div id="memberList">
    <table class="table table-striped table-hover text-center">
        <tr>
            <th>맴버번호</th>
            <th>이메일</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td><a href="/memberPages/memberUpdate?id=${member.id}">${member.memberEmail}</a></td>
                <td>${member.memberName}</td>
                <td>${member.memberMobile}</td>
                <td>
                    <button class="btn btn-danger" onclick="detail_fn('${member.id}')">조회</button>
                </td>
                <td>
                    <button class= "btn btn-danger" onclick="delete_fn('${member.id}')">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../component/footer.jsp"%>
</body>
<script>
    const detail_fn = (id) => {
        location.href = "/memberPages/memberDetail?id=" + id;
    }
    const delete_fn = (id) => {
        location.href = "/memberPages/delete?id=" + id;
    }
</script>
</html>
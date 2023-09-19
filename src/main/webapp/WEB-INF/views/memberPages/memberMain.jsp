<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">

</head>
<body>
<%@include file="../component/header.jsp"%>
<%@include file="../component/nav.jsp"%>
<h2>
어서오십쇼"${sessionScope.loginEmail}" 님!!
</h2>

<button class="btn btn-primary" onclick="comment_fn()">댓글쓰기</button>
<button class="btn btn-primary" onclick="commentList_fn()">댓글목록</button>

<%-- 로그인 계정이 admin일 경우에만 회원목록 링크가 보임 --%>
<c:if test="${sessionScope.loginEmail == 'admin'}">
    <a href="/member/list">회원목록</a> <br>
</c:if>
<%@include file="../component/footer.jsp"%>

</body>
<script>
    const comment_fn = () => {
        location.href = "/board/save";
    }
    const commentList_fn = () => {
        location.href = "/board/list";
    }
</script>
</html>

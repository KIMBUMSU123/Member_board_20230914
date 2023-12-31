<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="../component/header.jsp" %>
<%@include file="../component/nav.jsp" %>
<div id="section">
    <form action="/board/save" method="post">
        <input type="text" name="boardWriter" value="${sessionScope.loginEmail}">
        <input type="text" name="boardTitle" placeholder="제목을 입력하세요"> <br>
        <textarea name="boardContents" cols="30" rows="10"></textarea> <br>
        <input type="submit" value="작성">
    </form>
</div>
<%@include file="../component/footer.jsp" %>
</body>
</html>

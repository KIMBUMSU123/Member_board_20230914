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
<%@include file="../component/header.jsp"%>
<%@include file="../component/nav.jsp"%>
<div id="section">
    <form action="/member/save" method="post" enctype="multipart/form-data">
        <input type="text" name="memberEmail" placeholder="이메일"> <br>
        <input type="text" name="memberPassword" placeholder="비밀번호"> <br>
        <input type="text" name="memberName" placeholder="이름"> <br>
        <input type="text" name="memberMobile" placeholder="전화번호"> <br>
        <input type="file" name="memberProfile" placeholder="프로필사진" multiple> <br>
        <input type="submit" value="회원가입">
    </form>
</div>
<%@include file="../component/footer.jsp"%>

</body>
<script>

</script>
</html>
<%--
  Created by IntelliJ IDEA.
  User: nb
  Date: 18-12-11
  Time: 下午2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/user/create">
        <input type="hidden" id="csrf" >
        <label>昵称：</label>
        <input name="nickname">
        <label><span>用户名：</span></label>
        <input name="username">
        <label><span>密码</span></label>
        <input name="password">
        <button type="submit" value="提交">提交</button>
    </form>
<script>

    var xhr = new XMLHttpRequest();
    xhr.timeout = 3000;
    xhr.open('get','http://localhost:8081/system/csrf');
    xhr.send()
    xhr.onreadystatechange = function () {
        if ( xhr.readyState == 4 && xhr.status == 200 ) {
            var json = JSON.parse(xhr.responseText);
            document.getElementById("csrf").setAttribute("name", json.name);
            document.getElementById("csrf").value = json.token;
        } else {
            alert( xhr.statusText );

        }
    }
</script>
</body>
</html>

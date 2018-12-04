<%--
  Created by IntelliJ IDEA.
  User: nb
  Date: 18-11-29
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title1111</title>

</head>
<body>
<iframe src="http://localhost:8080/sites/xuhui/test.jsp"></iframe>
<button onclick="ajax()">发送消息</button>
<script type="text/javascript">


    var popup = window.open('http://localhost:8080/sites/xuhui/test.jsp', 'title');


    function ajax(){
        popup.postMessage('Hello World!', 'http://bbb.com');
        var xhr = new XMLHttpRequest();
        xhr.timeout = 3000;
        xhr.open('get','http://localhost:8089/dream/test/home');
        xhr.send()
        xhr.onreadystatechange = function () {
            if ( xhr.readyState == 4 && xhr.status == 200 ) {

                alert( xhr.responseText );

            } else {

                alert( xhr.statusText );

            }
        }
        xhr.ontimeout = function(event){

            alert('请求超时！');

        }
    }

</script>
</body>
</html>

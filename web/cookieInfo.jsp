<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All Cookies</title>
</head>
<body>

    <%
        if(request.getCookies()!=null){
            for (Cookie c:request.getCookies()){
                %>
                <%=c.getName() + " : " + c.getValue()%>
            <br>
    <%
            }
        }
    %>


    <a href="CookieServlet?cookie=print">Refresh Page</a>
    <br>
    <a href="index.jsp">Homepage</a>
</body>
</html>

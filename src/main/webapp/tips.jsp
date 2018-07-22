<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Juzi
  Date: 2018/7/20
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>提示</title>
        <link rel="stylesheet" href="css/tips.css">
        <META HTTP-EQUIV="refresh" CONTENT="3;URL=/main.jsp">
    </head>
    <body>
        <div class="tips">
            <%
                List<String> info = (List<String>) request.getAttribute("info");
                if (info != null) {
                    Iterator iter = info.iterator();
            %>
            <span><%=iter.next()%></span>
            <%
            } else {
            %><span>这是默认提示</span><%
            }
        %>
        </div>
    </body>
</html>

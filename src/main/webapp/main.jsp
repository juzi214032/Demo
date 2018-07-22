<%@ page import="bean.StudentBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Juzi
  Date: 2018/7/20
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>学生信息管理系统</title>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/buttons.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/delete.js"></script>
        <script type="text/javascript" src="js/edit.js"></script>
    </head>
    <body>
        <div class="find">
            <form action="/find" method="post">
                <div class="find-box">
                    <span class="span1">查找类型</span>
                    <select name="kind" id="kind">
                        <option>显示全部</option>
                        <option>姓名</option>
                        <option>学号</option>
                        <option>性别</option>
                        <option>班级</option>
                        <option>专业号</option>
                        <option>专业名</option>
                        <option>学院</option>
                    </select>
                </div>
                <div class="keyword">
                    <span>输入关键字</span>
                    <input type="text" name="keyword" id="keyword">
                </div>
                <input type="button" value="添加" id="button-add"
                       class="button button-glow button-border button-rounded button-primary"
                       onclick="javascrtpt:window.location.href='/insert.html'">
                <input type="submit" value="查询" id="button-find"
                       class="button button-glow button-rounded button-raised button-primary">
            </form>
        </div>

        <div class="result">
            <table id="table-3">
                <th>查询结果</th>
                <tr>
                    <td>No.</td>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>班级</td>
                    <td>专业号</td>
                    <td>专业名</td>
                    <td>学院</td>
                    <td>年级</td>
                    <td>学籍状态</td>
                    <td>操作</td>
                </tr>
                <%
                    int i = 1;
                    List<StudentBean> result = (List<StudentBean>) request.getAttribute("result");
                    if (result != null) {
                        Iterator iter = result.iterator();
                        while (iter.hasNext()) {
                            StudentBean student = (StudentBean) iter.next();

                %>
                <tr>
                    <td><%=i++%>
                    </td>
                    <td><%=student.getStudent_id()%>
                    </td>
                    <td><%=student.getName()%>
                    </td>
                    <td><%=student.getSex()%>
                    </td>
                    <td><%=student.getClass_1()%>
                    </td>
                    <td><%=student.getProfessional_no()%>
                    </td>
                    <td><%=student.getProfessional_name()%>
                    </td>
                    <td><%=student.getCollege()%>
                    </td>
                    <td><%=student.getGrade()%>
                    </td>
                    <td><%=student.getXj()%>
                    </td>
                    <td>
                        <div class="operation">
                            <%--<a id="delete" href="#" onclick="delete1(this)"><img src="/img/delete.png" alt="删除" title="删除"></a>--%>
                            <a id="delete" href="#" onclick="delete1(this)" name="<%=student.getStudent_id()%>"><img src="/img/delete.png" alt="删除" title="删除"></a>
                            <a id="edit" href="#" onclick="edit(this)" name="<%=student.getStudent_id()%>"><img src="/img/edit.png" alt="修改" title="修改"></a>
                        </div>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
    </body>
</html>

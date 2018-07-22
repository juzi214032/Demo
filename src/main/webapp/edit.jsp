<%@ page import="bean.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: Juzi
  Date: 2018/7/21
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>编辑资料</title>
        <link rel="stylesheet" href="css/buttons.css">
        <link rel="stylesheet" href="css/add.css">
    </head>

    <body>
        <%
            StudentBean student = (StudentBean) request.getAttribute("student");
            if (student == null) {
                response.sendRedirect("/tips.jsp");
            }
        %>
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
                       class="button button-glow button-border button-rounded button-primary">
                <input type="submit" value="查询" id="button-find"
                       class="button button-glow button-rounded button-raised button-primary">
            </form>
        </div>

        <div class="add">
            <form action="/insert" method="post">
                <div class="info">
                    <div class="info-1">
                        <div class="info-1-1"><span>学　号</span><input value="<%=student.getStudent_id()%>" type="text"
                                                                     name="student_id" id="studentId"></div>
                        <div class="info-1-2"><span>姓　名</span><input value="<%=student.getName()%>" type="text"
                                                                     name="name" id="name"></div>
                        <div class="info-1-3"><span>性　别</span><input value="<%=student.getSex()%>" type="text"
                                                                     name="sex" id="sex"></div>
                    </div>
                    <div class="info-2">
                        <div class="info-1-1"><span>班　级</span><input value="<%=student.getClass_1()%>" type="text"
                                                                     name="class" id="class"></div>
                        <div class="info-1-2"><span>专业号</span><input value="<%=student.getProfessional_no()%>"
                                                                     type="text"
                                                                     name="professional_no" id="professionalNo"></div>
                        <div class="info-1-3"><span>专业名</span><input value="<%=student.getProfessional_name()%>"
                                                                     type="text"
                                                                     name="professional_name" id="professionalName">
                        </div>
                    </div>
                    <div class="info-3">
                        <div class="info-1-1"><span>学　院</span><input value="<%=student.getCollege()%>" type="text"
                                                                     name="college" id="college"></div>
                        <div class="info-1-2"><span>年　级</span><input value="<%=student.getGrade()%>" type="text"
                                                                     name="grade" id="grade"></div>
                        <div class="info-1-3"><span>学　籍</span><input value="<%=student.getXj()%>" type="text"
                                                                     name="xj" id="xj"></div>
                    </div>
                </div>
                <div class="ok">
                    <input type="submit" value="OK" id="ok" class="button button-caution button-box button-jumbo">
                </div>
            </form>
        </div>
    </body>
</html>

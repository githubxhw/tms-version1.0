<%@ page import="java.util.List" %>
<%@ page import="com.lover.web.pojo.Course" %>
<%@ page import="com.lover.web.utils.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath();%>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程信息列表</title>
    <!--引入student.css-->
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/student.css">
    <!--引入datacheck.js-->
    <script type="text/javascript" src="<%=contextPath%>/js/datacheck.js"></script>
    <!--bootstrap核心文件-->
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bootstrap.css">
    <script type="text/javascript" src="<%=contextPath%>/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bootstrap.js"></script>
</head>
<body>
<hr>
<table align="center" style="width: 85%;padding-left: 15%">
    <!--header-->
    <tr>
        <td colspan="6" align="center" style="background: #0078B7;">
            <span style="font-size: large;">课程信息列表</span>
        </td>
    </tr>
    <!--/header-->

    <!--h-->
    <tr style="height: 20px;background: gainsboro">
        <td>名称</td>
        <td>性质</td>
        <td>学分</td>
        <td>开设年级</td>
        <td>开设专业</td>
        <td>操作</td>
    </tr>
    <!--h/-->

    <!--content-->
    <tbody id="tbody">
    <%
        PageInfo<Course> pageInfo = (PageInfo<Course>) request.getAttribute("pageInfo");
        List<Course> courses = pageInfo.getObjects();
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
    %>
    <tr>
        <td hidden="hidden" index="<%=i%>" id="courseId_<%=i%>"></td>
        <td id="courseName_<%=i%>"><%=course.getCourseName()%>
        </td>
        <td id="type_<%=i%>"><%=course.getTypeStr()%>
        </td>
        <td id="credit_<%=i%>"><%=course.getCredit()%>
        </td>
        <td id="grade_<%=i%>"><%=course.getGrade()%>
        </td>
        <td id="major_<%=i%>"><%=course.getMajorStr()%>
        </td>
        <td>
            <button index="<%=i%>" courseId="<%=course.getCourseId()%>" type="button" onclick="fillModal(this);"
                    style="background: #5bc0de"
                    data-toggle="modal" data-target="#myModal_<%=i%>">
                编辑
            </button>
            <!--模态框-->
            <div index="0" style="padding-left: 40%;padding-top: 15%" class="modal fade" id="myModal_<%=i%>"
                 tabindex="-1"
                 role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">修改记录</h4>
                        </div>
                        <div class="modal-body">
                            <form id="xg_form_<%=i%>">
                                <table width="100%" style="border-collapse:separate; border-spacing:0px 5px;">
                                    <tr>
                                        <td>名称：</td>
                                        <td>
                                            <input id="xg_courseId_<%=i%>" name="courseId" hidden="hidden" type="text">
                                            <input id="xg_courseName_<%=i%>" name="courseName" type="text">
                                        </td>
                                        <td>性质：</td>
                                        <td>
                                            <select id="xg_type_<%=i%>" name="type">
                                                <option value="1">公共基础必修课</option>
                                                <option value="2">公共选修课</option>
                                                <option value="3">学科基础课</option>
                                                <option value="4">专业必修课</option>
                                                <option value="5">专业选修课</option>
                                                <option value="6">集中性实践教学环节</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>学分：</td>
                                        <td>
                                            <input id="xg_credit_<%=i%>" name="credit" type="text">
                                        </td>
                                        <td>开设年级：</td>
                                        <td>
                                            <input id="xg_grade_<%=i%>" name="grade" type="text">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>开设专业：</td>
                                        <td>
                                            <select id="xg_major_<%=i%>" name="major">
                                                <option value="1">软件工程</option>
                                                <option value="2">空间信息</option>
                                                <option value="3">大数据</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>开设专业：</td>
                                        <td>
                                       <textarea id="xg_detail_<%=i%>" name="detail">

                                       </textarea>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" onclick="updateById(this)" index="<%=i%>" class="btn btn-primary"
                                    data-dismiss="modal">修改
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <button onclick="deleteById(this)" courseId="<%=course.getCourseId()%>" type="button"
                    style="background: yellow">
                删除
            </button>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
    <!--/content-->

    <!--工具-->
    <!--工具-->
    <tr>
        <td colspan="4">
            <button type="button" class="btn-sm" style="background: #5bc0de" data-toggle="modal" data-target="#myModal">
                添加
            </button>
            <!--模态框-->
            <div style="padding-left: 40%;padding-top: 15%;" class="modal fade" id="myModal" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">添加记录</h4>
                        </div>
                        <div class="modal-body" style="padding-left:10%;padding-right: 10%">
                            <form id="add_form">
                                <table width="100%" style="border-collapse:separate; border-spacing:0px 5px;">
                                    <tr>
                                        <td>名称：</td>
                                        <td>
                                            <%--<input name="courseId" hidden="hidden" type="text">--%>
                                            <input name="courseName" type="text">
                                        </td>
                                        <td>性质：</td>
                                        <td>
                                            <select name="type">
                                                <option value="1">公共基础必修课</option>
                                                <option value="2">公共选修课</option>
                                                <option value="3">学科基础课</option>
                                                <option value="4">专业必修课</option>
                                                <option value="5">专业选修课</option>
                                                <option value="6">集中性实践教学环节</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>学分：</td>
                                        <td>
                                            <input name="credit" type="text">
                                        </td>
                                        <td>开设年级：</td>
                                        <td>
                                            <input name="grade" type="text">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>开设专业：</td>
                                        <td>
                                            <select name="major">
                                                <option value="1">软件工程</option>
                                                <option value="2">空间信息</option>
                                                <option value="3">大数据</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>开设专业：</td>
                                        <td>
                                       <textarea name="detail">

                                       </textarea>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="button" class="btn btn-primary" onclick="add(this)" data-dismiss="modal">添加
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </td>
        <td colspan="2">
            <button onclick="refresh(this)" class="btn-sm" type="button" style="background: #5bc0de">
                刷新数据列表
            </button>
        </td>
    </tr>
    <!--/工具-->
    <tr>
        <td>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=1&pageSize=<%=pageInfo.getPageSize()%>">首页</a></li>
                    <li>
                        <a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()-1 >= 1 ? pageInfo.getPageNum()-1 : pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <%
                        //总页数少于5个
                        if(pageInfo.getPages() <= 5){
                            for (int i = 1; i <= pageInfo.getPages();i++){
                            %>
                                <li><a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=i%>&pageSize=<%=pageInfo.getPageSize()%>"><%=i%></a></li>
                            <%
                            }
                        }else {//多于5个
                            if(pageInfo.getPageNum()+4 <= pageInfo.getPages()){
                                for (int i = pageInfo.getPageNum(); i <= pageInfo.getPageNum()+4;i++){
                                %>
                                    <li><a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=i%>&pageSize=<%=pageInfo.getPageSize()%>"><%=i%></a></li>
                                <%
                                }
                            }else if(pageInfo.getPageNum()+4 > pageInfo.getPages()){
                                    for (int i = pageInfo.getPages()-4; i <= pageInfo.getPages();i++){
                                    %>
                                        <li><a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=i%>&pageSize=<%=pageInfo.getPageSize()%>"><%=i%></a></li>
                                    <%
                                }
                             }
                        }
                    %>
                    <li>
                        <a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()+1 <= pageInfo.getPages() ? pageInfo.getPageNum()+1 : pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPages()%>&pageSize=<%=pageInfo.getPageSize()%>">尾页</a></li>
                </ul>
            </nav>
            <span style="font-size: small" id="count">当前页:总页<%=pageInfo.getPageNum()%>/<%=pageInfo.getPages()%>，共<%=pageInfo.getTotalCount()%>条记录</span>
        </td>
    </tr>
</table>
<script>

    //点击 编辑按钮 填充modal
    function fillModal(x) {
        var $x = $(x);
        var index = $x.attr("index");
        var courseId = $x.attr("courseId");
        $.ajax({
            url: "<%=contextPath%>/CourseServlet?method=findByCourseId",
            type: "get",
            data: {"courseId": courseId},
            dataType: "json",
            async: true,
            success: function (data) {
                var course = data;
                $("#xg_courseId_" + index).attr("value", course.courseId);
                $("#xg_courseName_" + index).attr("value", course.courseName);
                $("#xg_type_" + index + " option").each(function () {
                    var optionVal = $(this).attr("value");
                    if (optionVal == course.type) {
                        $(this).attr("selected", "selected");
                    }
                });
                $("#xg_credit_" + index).attr("value", course.credit);
                $("#xg_grade_" + index).attr("value", course.grade);
                $("#xg_major_" + index + " option").each(function () {
                    var optionVal = $(this).attr("value");
                    if (optionVal == course.major) {
                        $(this).attr("selected", "selected");
                    }
                });
                document.getElementById("xg_detail_" + index).innerText = course.detail;
            },
            error: function () {
                alert("查询异常!")
            }
        });
    }

    //点击 编辑模态框中的修改按钮，ajax请求更新数据，成功就更新数据
    function updateById(x) {
        if (confirm("是否确认修改此条数据?") == true) {
            var index = $(x).attr("index");
            var params = $("#xg_form_" + index).serialize();
            $.ajax({
                url: "<%=contextPath%>/CourseServlet?method=updateByCourseId",
                type: "post",
                data: params,
                dataType: "text",
                async: true,
                success: function (data) {
                    if (data == 1) {
                        alert("修改成功！");
                        window.location.href = "<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>";
                    } else {
                        alert("修改失败！");
                    }
                },
                error: function () {
                    alert("修改异常！")
                }
            });
        }
    }

    //点击 编辑模态框中的删除按钮触发
    function deleteById(x) {
        if (confirm("警告：是否删除改此条数据?") == true) {
            var courseId = $(x).attr("courseId");
            $.ajax({
                url: "<%=contextPath%>/CourseServlet?method=deleteByCourseId",
                type: "get",
                data: {"courseId": courseId},
                dataType: "text",
                async: true,
                success: function (data) {
                    if (data == 1) {
                        alert("删除成功！");
                        window.location.href = "<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>";
                    } else {
                        alert("删除失败！");
                    }
                },
                error: function () {
                    alert("删除异常！")
                }
            });
        }
    }

    //点击 添加按钮触发
    function add(x) {
        if (confirm("请确认信息无误后，是否添加？") == true) {
            var params = $("#add_form").serialize();
            $.ajax({
                url: "<%=contextPath%>/CourseServlet?method=saveOne",
                type: "post",
                data: params,
                dataType: "text",
                async: true,
                success: function (data) {
                    if (data == 1) {
                        alert("添加成功！");
                        window.location.href = "<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>";
                    } else {
                        alert("添加失败！");
                    }
                },
                error: function () {
                    alert("添加异常！")
                }
            });
        }
    }

    //点击 刷新按钮触发
    function refresh(x) {
        window.location.href = "<%=contextPath%>/CourseServlet?method=findAllByPage&pageNum=<%=pageInfo.getPageNum()%>&pageSize=<%=pageInfo.getPageSize()%>";
    }

</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String contextPath = request.getContextPath();
  String name=(String)request.getSession().getAttribute("loginName");
  int flag=1;
  if(!name.equals("admin")) {
    flag=0;
  }
%>
<html>
<head>
  <meta charset="UTF-8">
  <title>index</title>
  <!--引入student.css-->
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/student.css">
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/index.css">
  <!--引入datacheck.js-->
  <script type="text/javascript" src="<%=contextPath%>/js/datacheck.js"></script>
  <!--bootstrap核心文件-->
  <link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/bootstrap.css">
  <script type="text/javascript" src="<%=contextPath%>/js/jquery-1.11.0.js"></script>
  <script type="text/javascript" src="<%=contextPath%>/js/bootstrap.js"></script>
</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" title="logoTitle" href="<%=contextPath%>/index.jsp">管理系统首页</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li role="presentation">
          <a href="#">当前用户：<span class="badge"><%=(String) request.getSession().getAttribute("loginName")%></span></a>
        </li>
        <li>
          <a href="<%=contextPath%>/api/loginServlet?method=loginOut">
            <span class="glyphicon glyphicon-lock"></span>退出登录</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- 中间主体内容部分 -->
<div class="pageContainer">
  <!-- 左侧导航栏 -->
  <div class="pageSidebar" style="font-weight: bold">
    <ul class="nav nav-stacked nav-pills">
      <li role="presentation">
        <a href="<%=contextPath%>/index.jsp" style="background-color: #5bc0de;">首页</a>
      </li>
      <li  role="presentation">
        <a id="uu" onclick="return check()" href="<%=contextPath%>/api/userServlet?method=findAllByPage" <%--target="mainFrame"--%>>用户信息管理</a>
      </li>
      <li role="presentation">
        <a href="<%=contextPath%>/api/teacherServlet?method=findAllByPage" style="background-color: #5bc0de;">教师信息管理</a>
      </li>
      <li role="presentation">
        <a href="<%=contextPath%>/api/scoreServlet?method=findAllByPage">成绩管理</a>
      </li>
      <li role="presentation">
        <a href="<%=contextPath%>/api/tcServlet?method=findAllByPage" style="background-color: #5bc0de;">授课信息管理</a>
      </li>
      <li role="presentation">
        <a href="<%=contextPath%>/api/studentServlet?method=findAllByPage">学生信息管理</a>
      </li>
      <li role="presentation">
        <a href="<%=contextPath%>/jsp/student/search.jsp" style="background-color: #5bc0de;">学生选课管理</a>
      </li>
      <li role="presentation" >
        <a href="<%=contextPath%>/api/courseServlet?method=findAllByPage">课程信息管理</a>
      </li>
      <%--<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="" target="mainFrame">
          个人设置<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
          <li>
            <a href="#" &lt;%&ndash;target="mainFrame"&ndash;%&gt;>修改密码</a>
          </li>
          <li>
            <a href="#" &lt;%&ndash;target="mainFrame"&ndash;%&gt;>退出系统</a>
          </li>
          <li>
            <a href="#" &lt;%&ndash;target="mainFrame"&ndash;%&gt;>个人信息</a>
          </li>
        </ul>
      </li>--%>
    </ul>
  </div>

  <!-- 左侧导航和正文内容的分隔线 -->
  <div class="splitter"></div>

  <!-- 正文内容部分 -->
  <div class="pageContent">
    <img src="<%=contextPath%>/image/index2.jpg" style="width: 100%;height: 100%" alt="图片1">
  </div>
</div>
<!-- 底部页脚部分 -->
<div class="footer">
  <p class="text-center">
    <span style="font-weight: bold">2020 &copy; copy right XXX</span>
  </p>
</div>

<script type="text/javascript">
  $(".nav li").click(function() {
    $(".active").removeClass('active');
    $(this).addClass("active");
  });
  function check(){
      var flag="<%=flag%>";
      if(flag==0){
          alert('您不是管理员，不能进行该操作！');
          return false;
      }
      return true;
  }
</script>
</body>
</html>

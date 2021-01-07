<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>Order | 用户</title>
    <jsp:include page="../../../includes/header.jsp"/>
</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">

<div class="wrapper" style="height: auto; min-height: 100%;">

    <jsp:include page="../../../includes/top_navigation_reception.jsp"/>

    <!-- Full Width Column -->
    <div class="content-wrapper" style="min-height: 471px;">
        <div class="container">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <br>
                <h1>
                    个人信息 | show
                    <small>个人信息展示</small>
                </h1>
                <ol class="breadcrumb">
                    <br>
                    <li><a href="/user/personal"><i class="fa fa-user"></i> 个人信息</a></li>
                    <li><a href="#">SHOW</a></li>
                </ol>
            </section>
            <br>
            <%--侧边栏--%>
            <jsp:include page="../../../includes/user_saidbar.jsp"/>

            <%--信息--%>
            <section class="content col-lg-10 left">
                <%--信息页面--%>
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">订单信息详情</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <jsp:include page="../../../includes/msg_alert.jsp"/>
                    <%--<img src="${path}/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                    <div class="box-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <div class="col-sm-5"></div>
                                <div class="col-lg-5">
                                    <img src="${user.upic}" style="height: 150px;width: 150px;border: rgba(121,121,121,0.52) 5px solid" class="img-circle" alt="User Image">
                                </div>
                            </div>
                            <div>
                                <p style="color: #0b58a2">
                                    <strong>暂无任何订单信息哦~</strong>
                                </p><br>
                                <a href="../../../index" style="color: red">
                                    <i>去往首页预订！</i>
                                </a>
                            </div>

                        </form>
                    </div>
                </div>
            </section>
            <br>
        </div>
        <!-- /.container -->
    </div>
    <!-- /.content-wrapper -->
    <%--版权--%>
    <jsp:include page="../../../includes/copyright.jsp"/>
</div>
<!-- ./wrapper -->
<%--js--%>
<jsp:include page="../../../includes/footer.jsp"/>
</body>
</html>
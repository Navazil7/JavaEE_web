<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>TrafficsOrder | 用户</title>
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

                            <%--订单类型--%>
                            <%--                            <p>--%>
                            <%--                                <button class="btn-foursquare" onclick="showOrderOfAttractions()">景点订单</button>--%>
                            <%--                                <button class="btn-foursquare" onclick="showOrderOfHotel()">酒店订单</button>--%>
                            <%--                                <button class="btn-foursquare" onclick="showOrderOfTraffic()">交通订单</button>--%>
                            <%--                            </p>--%>
                            <%--uid--%>
                            <div class="center-block">
                                <c:forEach var="traffic" items="${traffics}">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="post-preview">
                                            <br>
                                            <a href="#">
                                                <p>订单号：${traffic.traffic_orderId}</p>
                                                <p>订单用户Id：${traffic.traffic_uid}</p>
                                                <p>交通类型：${traffic.traffic_type}</p>
                                                <p>订单用户邮箱：${traffic.traffic_uemail}</p>
                                                <p>订单用户手机号码：${traffic.traffic_uphone}</p>
                                                <p>出发地：${traffic.traffic_depart}</p>
                                                <p>目的地：${traffic.traffic_des}</p>
                                                <p>出发时间：${traffic.traffic_departDate}  ${traffic_departTime}</p>
                                                <p>到达时间：${traffic.traffic_desDate}  ${traffic_desTime}</p>
                                                <p>订单金额：￥${traffic.traffic_cost}元</p>
                                                <p>订单创建时间：${traffic.traffic_createDate}  ${traffic.traffic_createTime}</p>
                                            </a>

                                            <div class="tags">

                                            </div>
                                        </div>
                                        <div>
                                                <%--左边--%>
                                            <div class="col-lg-11">

                                            </div>
                                                <%--右边--%>
                                            <div class="col-lg-1">
                                                <a href="/order/orderDelete?tp_oid=${traffic.traffic_orderId}&uid=${user.uid}" class="btn btn-danger  btn-xs">
                                                    <i class="fa fa-trash"></i>删除
                                                </a>
                                            </div>
                                            <br>
                                        </div>
                                        <br>
                                        <hr>
                                    </div>
                                </c:forEach>

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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>Order | 订单生成</title>
    <jsp:include page="../../../includes/header.jsp"/>
<%--    <link rel="stylesheet" href="../../../../static/assets/js/jquery-input-calendar-datetime/css/dateTime.css">--%>
<%--    <script type="text/javascript" src="../../../../static/assets/js/My97DatePicker/WdatePicker.js"></script>--%>
    <script type="text/javascript" src="../../../../static/assets/js/user/login.js"></script>
    <script type="text/javascript"
            src="../../../../static/assets/js/jquery-input-calendar-datetime/js/jquery.min.js"></script>
<%--    <script type="text/javascript"--%>
<%--            src="../../../../static/assets/js/jquery-input-calendar-datetime/js/dateTime.min.js"></script>--%>


</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">
<%--<script type="text/javascript">--%>
<%--    $(window).load(l())--%>
<%--    function l() {--%>
<%--        $("#booktime").datetime({--%>
<%--            type: "date",--%>
<%--            value: [2019, 9, 31],--%>
<%--            success: function (res) {--%>
<%--                console.log(res)--%>
<%--            }--%>
<%--        })--%>
<%--    }--%>
<%--</script>--%>
<div class="wrapper" style="height: auto; min-height: 100%;">

    <jsp:include page="../../../includes/top_navigation_reception.jsp"/>

    <!-- Full Width Column -->
    <div class="content-wrapper" style="min-height: 471px;">
        <div class="container">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <br>
                <h1>
                    订单生成 | show
                    <small>订单详情</small>
                </h1>
                <ol class="breadcrumb">
                    <br>
                    <li><a href="#"><i class="fa fa-user"></i> 订单生成</a></li>
                    <li><a href="#">SHOW</a></li>
                </ol>
            </section>
            <br>
            <%--侧边栏--%>
            <%--            <jsp:include page="../../../includes/user_saidbar.jsp"/>--%>

            <%--信息--%>
            <section class="content col-lg-10 left">
                <%--信息页面--%>
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">订单信息显示</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <jsp:include page="../../../includes/msg_alert.jsp"/>
                    <%--<img src="${path}/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                    <div class="box-body">
                        <form class="form-horizontal" action="/order/commit?key=attraction" id="form" method="post">
                            <%--                            <div class="form-group">--%>
                            <%--                                <div class="col-sm-5"></div>--%>
                            <%--                                <div class="col-lg-5">--%>
                            <%--                                    <img src="${user.upic}" style="height: 150px;width: 150px;border: rgba(121,121,121,0.52) 5px solid" class="img-circle" alt="User Image">--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>

                            <%--orderid--%>
                            <div class="form-group">
                                <label for="orderId" class="col-sm-2 control-label">订单ID</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly name="oid" value="${order.attr_orderId}"
                                           class="form-control"
                                           id="orderId" placeholder="${order.attr_orderId}">
                                </div>
                            </div>

                            <%--uid--%>
                            <div class="form-group">
                                <label for="uId" class="col-sm-2 control-label">用户ID</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly name="uid" value="${order.attr_uid}"
                                           class="form-control"
                                           id="uId" placeholder="${order.attr_uid}">
                                </div>
                            </div>

                            <%--ordername--%>
                            <div class="form-group">
                                <label for="orderName" class="col-sm-2 control-label">景点名称</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly name="oname" value="${order.attr_name}"
                                           class="form-control"
                                           id="orderName" placeholder="${order.attr_name}">
                                </div>
                            </div>

                            <%--orderplace--%>
                            <div class="form-group">
                                <label for="orderPlace" class="col-sm-2 control-label">景点地点</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly name="oplace" value="${order.attr_place}"
                                           class="form-control"
                                           id="orderPlace" placeholder="${order.attr_place}">
                                </div>
                            </div>

                            <%--email--%>
                            <div class="form-group">
                                <label for="inputEmail"
                                       class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>

                                <div class="col-sm-10">
                                    <input type="text" readonly name="uemail" value="${order.attr_uemail}"
                                           class="form-control" id="inputEmail"
                                           placeholder="${order.attr_uemail}">
                                </div>
                            </div>

                            <%--PHONE--%>
                            <div class="form-group">
                                <label for="inputPhone"
                                       class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>

                                <div class="col-sm-10">
                                    <input type="text" readonly name="uphone" value="${order.attr_uphone}"
                                           class="form-control" id="inputPhone"
                                           placeholder="${order.attr_uphone}">
                                </div>
                            </div>

                            <%--cost--%>
                            <div class="form-group">
                                <label for="ocost"
                                       class="col-sm-2 control-label">金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额</label>

                                <div class="col-sm-10">
                                    <input type="text" readonly name="cost" value="${order.attr_cost}"
                                           class="form-control" id="ocost"
                                           placeholder="${order.attr_cost}">
                                </div>
                            </div>

                            <%--createtime--%>
                            <div class="form-group">
                                <label for="createtime"
                                       class="col-sm-2 control-label">创建时间</label>

                                <div class="col-sm-10">
                                    <input type="text" readonly name="time"
                                           value="${order.attr_createDate} ${order.attr_createTime}"
                                           class="form-control" id="createtime"
                                           placeholder="${order.attr_createDate} ${order.attr_createTime}">
                                </div>
                            </div>

                            <%--booktime--%>
                                <div class="form-group ">
                                    <label for="booktime"
                                           class="col-sm-2 control-label">预约日期</label>

                                    <div class="col-sm-10">
                                        <%--                                    <input type="text" readonly name="booktime" value="${order.attr_time}" class="form-control" id="booktime"--%>
                                        <%--                                           placeholder="${order.attr_time}">--%>
                                        <%--                                    <input type="text" id="booktime" name="booktime" class="form-control Wdate" value="<%=java.text.DateFormat.getDateInstance().format(new java.util.Date())%>"--%>
                                        <%--                                           οnfοcus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="highLineWeekDay: true;width: 200px"  />--%>
<%--                                        <input type="text" id="booktime" placeholder="请选择日期">--%>
                                        <input class="form-control" type="date" name="booktime" id="booktime" value="2021-01-06" style="line-height: inherit">


                                        <%--                                    <c:set var="booktime"> $('#booktime').val().trim()</c:set>--%>
                                    </div>
                                </div>

                            <div class="form-group" style="height: 40px;line-height: 40px">
                                <p>
                                    <%--                                    <a href="/view/submit?key=attraction&booktime=${booktime}">--%>
                                    <input type="button"
                                            style="border-radius: 7px;width: 80px;position: absolute;left: 300px;color:white;background-color: red"
                                            onclick="submitOrder(1)"
                                            value="提交订单">

                                    <input type="button"
                                            style="border-radius: 7px;width: 80px;position: absolute;left: 600px;color: white;background-color: gray"
                                            onclick="cancelOrder()"
                                            value="取消订单">



                                </p>

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
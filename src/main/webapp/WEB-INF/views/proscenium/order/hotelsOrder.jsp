<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>HotelsOrder | 用户</title>
    <jsp:include page="../../../includes/header.jsp"/>

    <script type="text/javascript"
            src="../../../../static/assets/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="../../../../static/assets/js/layer/layer.js"></script>
    <script type="text/javascript" src="../../../../static/assets/js/user/login.js"></script>
    <script type="text/javascript"
            src="../../../../static/assets/js/qrcode.js"></script>
    <style>
        .demo{

            /*display: table-cell;*/
            /*display: none;*/
            vertical-align: middle;
            text-align: center;
            position: relative;
            left:50%;
            top: 50%;
            margin-left: -100px;
            z-index: 999;

        }

    </style>

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
                                <c:forEach var="hotel" items="${hotels}" varStatus="status">
                                    <c:set var="total" value="${status.count}"></c:set>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="post-preview">
                                            <br>
                                            <c:if test="${hotel.hotel_status=='未使用'}" var="judge">
                                                <c:set var="color" value="red"></c:set>
                                            </c:if>
                                            <c:if test="${!judge}">
                                                <c:set var="color" value="green"></c:set>
                                            </c:if>
                                            <h3 style="color: ${color}" id="state${status.count}">${hotel.hotel_status}！</h3>
                                            <a href="/hotel/content?hid=${hotel.hotel_hid}">
                                                <p id="oid${status.count}">订单号:${hotel.hotel_orderId}</p>
                                                <p id="uid${status.count}">订单用户Id:${hotel.hotel_uid}</p>
                                                <p id="name${status.count}">酒店名称:${hotel.hotel_name}</p>
                                                <p id="place${status.count}">酒店地点:${hotel.hotel_place}</p>
<%--                                                <p>房间号：${hotel.hotel_room}</p>--%>
                                                <p id="email${status.count}">订单用户邮箱:${hotel.hotel_uemail}</p>
                                                <p id="phone${status.count}">订单用户手机号码:${hotel.hotel_uphone}</p>
                                                <p id="cost${status.count}">订单金额:￥${hotel.hotel_cost}元</p>
                                                <p id="time${status.count}">订单创建时间:${hotel.hotel_createDate}  ${hotel.hotel_createTime}</p>
                                                <p id="day${status.count}">订单时效:${hotel.hotel_time}</p>
                                                <p id="num${status.count}">订单数量:${hotel.hotel_num}</p>
                                            </a>

                                            <div class="tags">

                                            </div>
                                        </div>
                                        <div>
                                                <%--左边--%>
                                            <div class="col-lg-11">
                                                <br>
                                                <input type="button" id="display${status.count}" value="显示二维码" style="color: white;background-color: #0b58a2;width: 100px;height: 40px;border-radius: 20px;text-align: center;position: relative;top: 50%" >

                                                <div class="demo" style="display: none;width: 200px" id="shareDiv${status.count}">
                                                    <c:if test="${color=='red'}" var="r">
                                                        <div id="qrimg&${status.count}" style="margin-left: 36px;width: 128px;height: 128px;left:36px;text-align: center"></div>
                                                        <script type="text/javascript">
                                                            // var qrcode=new QRCode(document.getElementById("qrimg"),"https://www.alipay.com/");
                                                            var qrcode = new QRCode(document.getElementById("qrimg&${status.count}"), {
                                                                text: "http://www.alipay.com",
                                                                width: 128,
                                                                height: 128,
                                                                colorDark : "#000000",
                                                                colorLight : "#ffffff",
                                                                correctLevel : QRCode.CorrectLevel.H
                                                            });
                                                        </script>
<%--                                                        <img width="200px" height="200px" id="qrimg" alt="" src="../../../../static/upload/img/payQrcode.png"/>--%>
                                                    </c:if>
                                                    <c:if test="${!r}">

                                                        <h3 style="vertical-align: middle;color: #0b3e6f;height: 100px">订单已核销！</h3>

                                                    </c:if>
                                                    <i class="btn btn-danger btn-xs fa" id="usebtn${status.count}" style="background-color: ${color}">使用</i>
                                                </div>
                                                <script type="text/javascript">
                                                    window.onload=function () {
                                                        document.onclick = function (e) {
                                                            const dom = e.target;
                                                            var click_name = dom.id;

                                                            if (click_name !== "" && click_name.length == 8) {
                                                                const cpnt = click_name.slice(0, 7);
                                                                const fig = click_name.slice(7, 8);
                                                                const divid = "shareDiv".concat(fig);
                                                                const type = document.getElementById(divid).style.display;
                                                                if (cpnt == "display" && type == "none") {
                                                                    document.getElementById(divid).style.display = "block";
                                                                    document.getElementById(click_name).value = '关闭二维码';

                                                                }
                                                                if (cpnt == "display" && type == "block") {
                                                                    document.getElementById(divid).style.display = "none";
                                                                    document.getElementById(click_name).value = '显示二维码';
                                                                }
                                                            }

                                                            if (click_name != "" && click_name.length == 7) {
                                                                const cpnt = click_name.slice(0, 6);
                                                                const fig = click_name.slice(6, 7);
                                                                const divid = "shareDiv".concat(fig);
                                                                const type = document.getElementById(divid).style.display;

                                                                if (cpnt == "usebtn") {
                                                                    //提交订单
                                                                    var color = document.getElementById("state" + fig).style.color;
                                                                    if (color === 'red') {
                                                                        document.getElementById("state" + fig).style.color = 'green';
                                                                        document.getElementById("state" + fig).textContent = "已使用！";
                                                                        // document.getElementById("usebtn"+index).disabled=true;
                                                                        //订单状态更新到数据库
                                                                        var oid = document.getElementById("oid" + fig).innerText.split(":")[1];
                                                                        var uid = document.getElementById("uid" + fig).innerText.split(":")[1];
                                                                        // alert(oid+"  "+uid);
                                                                        layer.alert("使用成功！", {icon: 1}, function () {
                                                                            window.location.href = '/order/update?key=hotel&tpoid=' + oid + '&tpuid=' + uid;
                                                                        });


                                                                    }
                                                                    else{
                                                                        layer.alert("订单不能重复使用！", {icon: 2});
                                                                    }

                                                                }


                                                            }
                                                            ;

                                                        };
                                                    }
                                                </script>
                                            </div>
                                                <%--右边--%>
                                            <div class="col-lg-1">
                                                <i class="btn btn-danger btn-xs fa fa-trash" onclick="isDelete('${hotel.hotel_uid}','${hotel.hotel_orderId}')"></i>
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
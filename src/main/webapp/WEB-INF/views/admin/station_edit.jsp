<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
    <title>交通站点管理|Hotel</title>
    <jsp:include page="../../includes/header.jsp"/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=i6MgTgAPWXcrrde4GosOGu3ngUSUIoWz"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
    <!--这是引用个jq-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <style>
        .modal-dialog{
            right:50px;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <%--顶部导航--%>
    <jsp:include page="../../includes/top_navigate_backstage.jsp"/>
    <%--侧边菜单--%>
    <jsp:include page="../../includes/leftside_menu_navigate.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <br>
                站点管理|
                <small>操作</small>
            </h1>

            <ol class="breadcrumb">
                <br>
                <li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
                <li class="active">Stations</li>
            </ol>
        </section>

        <br/><br/>
        <div class="col-xs-12">
            <%--danger alert--%>
            <c:if test="${msg.msg != null}">
                <div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>${msg.msg}</h4>
                </div>
            </c:if>
            <%--danger alert--%>
            <div class="box">
                <%--用户表单--%>
                <div class="box box-info">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">站点编辑</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/admin/stationedithandle" method="post">
                            <div class="box-body">

                                <%--uid--%>
                                <div class="form-group">
                                    <label for="tpSid" class="col-sm-2 control-label">编码</label>
                                    <div class="col-sm-10">
                                        <input type="text" readonly name="tpSid" value="${station.tpSid}"
                                               class="form-control" id="tpSid" placeholder="${station.tpSid}">
                                    </div>
                                </div>

                                <%--name--%>
                                    <div class="form-group">
                                        <label for="tpSname" class="col-sm-2 control-label">名称</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="tpSname" value="${station.tpSname}"
                                                   class="form-control" id="tpSname" placeholder="${station.tpSname}">
                                        </div>
                                    </div>

                                    <%--tpStype--%>
                                    <div class="form-group">
                                        <label for="tpStype" class="col-sm-2 control-label">站点类型</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="tpStype" value="${station.tpStype}"
                                                   class="form-control" id="tpStype" placeholder="${station.tpStype}">
                                        </div>
                                    </div>



                                <%--city--%>
                                <div class="form-group">
                                    <label for="tpScity" class="col-sm-2 control-label">城市</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="tpScity" value="${station.tpScity}" class="form-control" id="tpScity"
                                               placeholder="${station.tpScity}">
                                    </div>
                                </div>


                                <%--详细地址--%>
                                <div class="form-group">
                                    <label for="tpSlocal" class="col-sm-2 control-label">详细地址</label>

                                    <div class="col-sm-3">
                                        <input type="text" name="tpSlocal" value="${station.tpSlocal}"
                                               class="form-control" id="tpSlocal" placeholder="${station.tpSlocal}">
                                    </div>

                                    <label for="tpSlongitude" class="col-sm-1 control-label">经度</label>

                                    <div class="col-sm-1">
                                        <input type="text" name="tpSlongitude" value="${station.tpSlongitude}"
                                               class="form-control" id="tpSlongitude" placeholder="${station.tpSlongitude}">
                                    </div>

                                    <label for="tpSlatitude" class="col-sm-1 control-label">纬度</label>

                                    <div class="col-sm-1">
                                        <input type="text" name="tpSlatitude" value="${station.tpSlatitude}"
                                               class="form-control" id="tpSlatitude" placeholder="${station.tpSlatitude}">
                                    </div>

                                    <div class="col-sm-1">
                                    </div>

                                    <div class="col-sm-2" style="position: relative;z-index: 100000;">
                                        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" type="button">打开地图……</button>
                                        <!-- 模态框（Modal） -->
                                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" >
                                                <div class="modal-content" style="width: 1000px;height: 600px;">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        <h4 class="modal-title" id="myModalLabel">选择一个地点</h4>
                                                    </div>
                                                    <div class="modal-body" style="position: relative;z-index: 100000;">
                                                        <!--这是地图的div-->
                                                        <div id="allmap" style="width: 100%;height: 500px;"></div>
                                                        <!--这是地址详情框-->
                                                        <input type="text" id="zip2">
                                                        <!--这是 经度-->
                                                        <input type="text" id="vlongitude">
                                                        <!--这是 维度-->
                                                        <input type="text" id="vlatitude">

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                                                        <%--													<button type="button" class="btn btn-primary" type="button">确定</button>--%>
                                                    </div>
                                                </div><!-- /.modal-content -->
                                            </div><!-- /.modal -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">提交
                                </button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
        <!-- /.content-wrapper -->
    </div>
    <%--版权--%>
    <jsp:include page="../../includes/copyright.jsp"/>

    <%--css--%>
    <jsp:include page="../../includes/footer.jsp"/>
    <!-- page script -->

</body>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(120.04866799134317,30.2350180723955);//当前坐标经纬可改

    map.centerAndZoom(point,12);//显示级数越大越细
    map.addOverlay(new BMap.Marker(point));//定点坐标红点覆盖
    map.enableScrollWheelZoom(true);
    var geoc = new BMap.Geocoder();

    map.addEventListener("click", function(e){
        //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
        var pt = e.point;
        geoc.getLocation(pt, function(rs){
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;
            var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
            //将对应的HTML元素设置值
            $("#zip2").val(site);
            $("#vlongitude").val(pt.lng);
            $("#vlatitude").val(pt.lat);

            $("#tpSlocal").val(site);
            $("#tpSlongitude").val(pt.lng);
            $("#tpSlatitude").val(pt.lat);

        });
    });
</script>
</html>

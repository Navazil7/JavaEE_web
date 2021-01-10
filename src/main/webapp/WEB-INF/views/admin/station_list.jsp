<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
    <title>站点管理 | View</title>
    <jsp:include page="../../includes/header.jsp"/>

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
                <li><a href="#"><i class="fa fa-users"></i> Stations </a></li>
                <li class="active">列表</li>
            </ol>
        </section>

        <br/><br/>
        <div class="col-xs-12">
            <%--Denger alert--%>
            <c:if test="${msg.msg != null}">
                <div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="closeMsg()">&times;</button>
                        <%--${msg}--%>
                    <h4>${msg.msg}</h4>
                </div>
            </c:if>
                <% session.removeAttribute("msg");%>
            <%--/.alert--%>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">站点列表</h3>
                    <div class="row" style="padding-left: 12px; padding-top: 10px;">
                        <a href="/admin/stationInsert" type="button" class="btn-primary btn-sm"><i class="fa fa-plus"></i>站点新增</a>&nbsp;&nbsp;
                        <span style="cursor: pointer" type="button" class="btn-primary btn-sm stationMutiDelete">
							<i class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
                    </div>
                    <div class="box-tools">
                        <form action="/admin/stationPointSearch" method="get">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="keyword" class="form-control pull-right" placeholder="搜索...">

                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="box-body table-responsive">
                    <table id="myuserstable" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>
                                <label>
                                    <input type="checkbox" class="minimal icheck_master">
                                </label>
                            </th>
                            <th>编码|Id</th>
                            <th>站点名|Name</th>
                            <th>城市|City</th>
                            <th>地址|Address</th>
                            <th>类型|Type</th>
                            <th>经度|Longitude</th>
                            <th>纬度|Latitude</th>
                            <th>操作|operate</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${stations}" var="stations">
                            <tr>
                                <td>
                                    <label>
                                        <input name="stations" value="${stations.tpSid}" type="checkbox" class="minimal minimal-myminor">
                                    </label>
                                </td>
                                <td>${stations.tpSid}</td>
                                <td><span class="label label-primary">${stations.tpSname}</span></td>
                                <td>${stations.tpScity}</td>
                                <td>${stations.tpSlocal}</td>
                                <td><span class="label label-primary">${stations.tpStype}</td>
                                <td>${fn:substring(stations.tpSlongitude,0,8)}</td>
                                <td>${fn:substring(stations.tpSlatitude,0,8)}</td>

                                <td>
                                    <a href="/admin/stationedit?tpSid=${stations.tpSid}" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑
                                    </a>
                                    <a href="/admin/stationDelete?tpSid=${stations.tpSid}" class="btn btn-danger  btn-xs"><i
                                            class="fa fa-trash"></i>删除
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <br>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>
    <!-- /.content-wrapper -->
    <%--版权--%>


</div>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>
<!-- page script -->
<script>
    $(function () {
        // 前端分页
        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        // 前端复选框选择器
        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        // 复选框选择传数组到后台,处理完成后前台接收
        $(".stationMutiDelete").click(function () {
            var tpSids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for(var i=0;i<seletes.length;i++){
                if($(seletes[i]).prop("checked")){
                    tpSids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "stationMutiDelete",
                type: "GET",
                data: {
                    "tpSids": tpSids
                },
                traditional: true,
                success: function (message) {
                    if(message == "1"){
                        window.location.href = "/admin/stationList";
                    }
                }
            });
        });
    })
</script>
</body>
</html>

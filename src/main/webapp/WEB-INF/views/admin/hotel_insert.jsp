<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>酒店管理|Hotel</title>
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
				酒店管理|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
				<li class="active">Hotel</li>
			</ol>
		</section>

		<br/><br/>
		<div class="col-xs-12">
			<%--danger alert--%>
			<c:if test="${msg.msg != null}" >
				<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true" onclick="closeMsg()">×</button>
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
				<% session.removeAttribute("msg");%>
			<%--danger alert--%>
			<div class="box">
				<%--用户表单--%>
				<div class="box box-info">
				<div class="box box-info">
					<div class="box-header with-border">
						<br>
						<h3 class="box-title">酒店新增</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="/admin/hotelInsert" method="post">
						<div class="box-body">

							<%--图片上传组件--%>
							<div class="form-group">
								<label for="imgUrl" class="col-sm-2 control-label">略图上传</label>

								<div class="col-sm-10">
									<input type="text" readonly name="imgUrl" value="${hotel.imgUrl}"
									       class="form-control" id="imgUrl" placeholder="${hotel.imgUrl}">
									<div id="dropz" class="dropzone"></div>
								</div>
							</div>

							<%--uid--%>
							<div class="form-group">
								<label for="hid" class="col-sm-2 control-label">编码</label>
								<div class="col-sm-10">
									<input type="text" readonly name="hid" value="${hotel.hid}"
									       class="form-control" id="hid" placeholder="${hotel.hid}">
								</div>
							</div>

							<%--uname--%>
							<div class="form-group">
								<label for="local" class="col-sm-2 control-label">城市</label>
								<div class="col-sm-2">
									<select class="form-control" id="city" name="city">
										<c:forEach items="${cities}" var="city">
											<option value="${city.tpCname}">${city.tpCname}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-8"></div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">标题</label>

								<div class="col-sm-10">
									<input type="text" name="title" class="form-control" id="title"
									       placeholder="${hotel.title}">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="houseType" class="col-sm-2 control-label">房屋类型</label>

								<div class="col-sm-10">
									<input type="text" name="houseType" class="form-control" id="houseType"
									       placeholder="${hotel.houseType}">

								</div>
							</div>

							<%--pwd--%>
							<div class="form-group">
								<label for="bedType" class="col-sm-2 control-label">床类型</label>

								<div class="col-sm-10">
									<input type="text" name="bedType" class="form-control" id="bedType"
									       placeholder="${hotel.bedType}">
								</div>
							</div>

							<%--age--%>
							<div class="form-group">
								<label for="phone" class="col-sm-2 control-label">联系电话</label>

								<div class="col-sm-10">
									<input type="text" name="phone" class="form-control" id="phone"
									       placeholder="${hotel.phone}">
								</div>
							</div>


							<%--详细地址--%>
								<div class="form-group">
									<label for="local" class="col-sm-2 control-label">详细地址</label>

									<div class="col-sm-2">
										<input type="text" name="local" class="form-control" id="local" placeholder="${hotel.local}">
									</div>

									<label for="longitude" class="col-sm-1 control-label">经度</label>

									<div class="col-sm-1">
										<input type="text" name="longitude" class="form-control" id="longitude" placeholder="${hotel.longitude}">
									</div>

									<label for="latitude" class="col-sm-1 control-label">纬度</label>

									<div class="col-sm-1">
										<input type="text" name="latitude" class="form-control" id="latitude" placeholder="${hotel.latitude}">
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
														<input type="text" id="local2">
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

							<%--PHONE--%>
							<div class="form-group">
								<label for="houseSize" class="col-sm-2 control-label">房屋大小</label>

								<div class="col-sm-10">
									<input type="text" name="houseSize" class="form-control" id="houseSize"
									       placeholder="${hotel.houseSize}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="price" class="col-sm-2 control-label">价格</label>

								<div class="col-sm-10">
									<input type="text" name="price" class="form-control" id="price"
									       placeholder="${hotel.price}">
								</div>
							</div>
							<%--Content Edit--%>
							<div class="form-group" >
								<label for="content" class="col-sm-2 control-label" >内容编辑</label>

								<div class="col-sm-10">

									<input type="text" name="content" id="content" class="form-control"
									       placeholder="编辑">

									<%--wangEditor编辑--%>
									<div id="editor" >
										${hotel.content}
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

<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>
<!-- page script -->
</body>
<script>
    $(function () {
        // wangEditor
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload/hotelContentUpload';

        // 将图片大小限制为 3M 默认为5MB
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
        // 限制一次最多上传 20 张图片
        editor.customConfig.uploadImgMaxLength = 20;
        // 自定义 fileName
        editor.customConfig.uploadFileName = 'dropFile';
        editor.create();

        editor.customConfig.uploadImgHooks = {
            before: function (xhr, editor, files) {

            }
        };

        // 按钮绑定事件
        $("#btnSunmit").bind("click", function () {
            var contentHtml = editor.txt.html();
            console.log(contentHtml);//有内容的
            $("#content").val(contentHtml);
            // return false;
        });
    });

    Dropzone.options.dropz = {
        url: "/upload/hotelAvatar",
        method: "post",
        autoQueue: true,
        dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
        paramName: "dropFile",// 传到后台的参数名称
        init: function () {
            this.on("success", function (file, data) {
                $("#imgUrl").val(data.fileName);
                // 上传成功触发的事件
            });
        }
    };
</script>
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
			$("#local2").val(site);
			$("#vlongitude").val(pt.lng);
			$("#vlatitude").val(pt.lat);

			$("#local").val(site);
			$("#longitude").val(pt.lng);
			$("#latitude").val(pt.lat);

		});
	});
</script>

</html>

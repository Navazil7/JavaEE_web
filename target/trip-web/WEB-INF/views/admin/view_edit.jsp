<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>用户管理 | UserInfo</title>
	<jsp:include page="../../includes/header.jsp"/>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=3.0&ak=i6MgTgAPWXcrrde4GosOGu3ngUSUIoWz"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
	<!--这是引用个jq-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<style>
		.modal-dialog{
			right:50px;
			z-index: 200000;
			position: relative;
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
				景点管理|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
				<li class="active">Users</li>
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
							<h3 class="box-title">景点编辑</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal" action="/admin/viewedithandle" method="post">
							<div class="box-body">

								<%--图片上传组件--%>
								<div class="form-group">
									<label for="tpPrice" class="col-sm-2 control-label">略图上传</label>

									<div class="col-sm-10">
										<input type="text" readonly name="tpVpic" value="${viewPoint.tpVpic}"
										       class="form-control" id="tpVpic" placeholder="${viewPoint.tpVpic}">
										<div id="dropz" class="dropzone"></div>
									</div>
								</div>

								<%--uid--%>
								<div class="form-group">
									<label for="tpVid" class="col-sm-2 control-label">景点编码</label>
									<div class="col-sm-10">
										<input type="text" readonly name="tpVid" value="${viewPoint.tpVid}"
										       class="form-control" id="tpVid" placeholder="${viewPoint.tpVid}">
									</div>
								</div>

								<%--uname--%>
								<div class="form-group">
									<label for="tpLocation" class="col-sm-2 control-label">景点归属</label>
									<div class="col-sm-10">
										<input type="text" name="tpLocation" class="form-control" id="tpLocation"
										       placeholder="${viewPoint.tpLocation}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpTitle" class="col-sm-2 control-label">景点标题</label>

									<div class="col-sm-10">
										<input type="text" name="tpTitle" class="form-control" id="tpTitle"
										       placeholder="${viewPoint.tpTitle}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpTitle" class="col-sm-2 control-label">景点名称</label>

									<div class="col-sm-10">
										<input type="text" name="tpVname" class="form-control" id="tpVname"
										       placeholder="${viewPoint.tpVname}">

									</div>
								</div>

								<%--pwd--%>
								<div class="form-group">
									<label for="tpVtype" class="col-sm-2 control-label">景点类型</label>

									<div class="col-sm-10">
										<input type="text" name="tpVtype" class="form-control" id="tpVtype"
										       placeholder="${viewPoint.tpVtype}">
									</div>
								</div>

								<%--age--%>
								<div class="form-group">
									<label for="tpVphone" class="col-sm-2 control-label">联系电话</label>

									<div class="col-sm-10">
										<input type="text" name="tpVphone" class="form-control" id="tpVphone"
										       placeholder="${viewPoint.tpVphone}">
									</div>
								</div>

								<%--gender--%>
								<div class="form-group">
									<label for="tpLevel" class="col-sm-2 control-label">景点等级</label>

									<div class="col-sm-10">
										<input type="text" name="tpLevel" class="form-control" id="tpLevel"
										       placeholder="${viewPoint.tpLevel}">
									</div>
								</div>

								<%--PHONE--%>
								<div class="form-group">
									<label for="tpPrice" class="col-sm-2 control-label">景点价格</label>

									<div class="col-sm-10">
										<input type="text" name="tpPrice" class="form-control" id="tpPrice"
										       placeholder="${viewPoint.tpPrice}">
									</div>
								</div>

								<%--PHONE--%>
									<div class="form-group">
										<label for="tpZip" class="col-sm-2 control-label">详细地址</label>

										<div class="col-sm-2">
											<input type="text" name="tpZip" class="form-control" id="tpZip" placeholder="${viewPoint.tpLocation}">
										</div>

										<label for="tpVlongitude" class="col-sm-1 control-label">经度</label>

										<div class="col-sm-1">
											<input type="text" name="tpVlongitude" class="form-control" id="tpVlongitude" placeholder="${viewPoint.tpVlongitude}">
										</div>

										<label for="tpVlatitude" class="col-sm-1 control-label">纬度</label>

										<div class="col-sm-1">
											<input type="text" name="tpVlatitude" class="form-control" id="tpVlatitude" placeholder="${viewPoint.tpVlatitude}">
										</div>

										<div class="col-sm-1">
										</div>

										<div class="col-sm-2">
											<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" type="button">打开地图……</button>
											<!-- 模态框（Modal） -->
											<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content" style="width: 1000px;height: 600px;">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
															<h4 class="modal-title" id="myModalLabel">选择一个地点</h4>
														</div>
														<div class="modal-body">
															<!--这是地图的div-->
															<div id="allmap" style="width: 100%;height: 500px;"></div>
															<!--这是地址详情框-->
															<input type="text" id="zip">
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

								<%--Content Edit--%>
								<div class="form-group">
									<label for="tpPrice" class="col-sm-2 control-label">内容编辑</label>

									<div class="col-sm-10">

										<input type="text" name="tpVcontent" id="tpVcontent" class="form-control"
										placeholder="编辑">

										<%--wangEditor编辑--%>
										<div id="editor">
											${viewPoint.tpVcontent}
										</div>

									</div>
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
								<button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">提交</button>
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

	<script>
		$(function () {
            // wangEditor
            var E = window.wangEditor;
            var editor = new E('#editor');

            // 配置服务器端地址
            editor.customConfig.uploadImgServer = '/upload/viewContentUpload';

            // 将图片大小限制为 3M 默认为5MB
            editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
            // 限制一次最多上传 20 张图片
            editor.customConfig.uploadImgMaxLength = 20;
            // 自定义 fileName
            editor.customConfig.uploadFileName = 'dropFile';
            editor.create();

            editor.customConfig.uploadImgHooks = {
                before: function (xhr, editor, files) {
                    // 图片上传之前触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

                    // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
                    // return {
                    //     prevent: true,
                    //     msg: '放弃上传'
                    // }
                }
            };


            //在编辑器中追加内容
            // editor.txt.html('<p>用 JS 设置的内容</p>');

            // 按钮绑定事件
            $("#btnSunmit").bind("click",function () {
                var contentHtml = editor.txt.html();
                console.log(contentHtml);//有内容的
                $("#tpVcontent").val(contentHtml);
                // return false;
            });
        });

        Dropzone.options.dropz = {
            url: "/upload/viewAvatar",
            method: "post",
            autoQueue: true,
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropFile",// 传到后台的参数名称
            init: function () {
                this.on("success", function (file, data) {
                    $("#tpVpic").val(data.fileName);
                    // 上传成功触发的事件
                });
            }
        };

        // var myDropzone = new Dropzone("#dropz", {
        //     url: "/upload/useravatar", // 文件提交地址
        //     method: "post",  // 也可用put
        //     paramName: "file", // 默认为file
        //     maxFiles: 1,// 一次性上传的文件数量上限
        //     maxFilesize: 2, // 文件大小，单位：MB
        //     acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        //     addRemoveLinks: true,
        //     parallelUploads: 1,// 一次上传的文件数量
        //     //previewsContainer:"#preview", // 上传图片的预览窗口
        //     dictDefaultMessage: '拖动文件至此或者点击上传',
        //     dictMaxFilesExceeded: "您最多只能上传1个文件！",
        //     dictResponseError: '文件上传失败!',
        //     dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg。",
        //     dictFallbackMessage: "浏览器不受支持",
        //     dictFileTooBig: "文件过大上传文件最大支持.",
        //     dictRemoveLinks: "删除",
        //     dictCancelUpload: "取消",
        //     init: function () {
        //         this.on("addedfile", function (file) {
        //             // 上传文件时触发的事件
        //         });
        //         this.on("success", function (file, data) {
        //             // 上传成功触发的事件
        //         });
        //         this.on("error", function (file, data) {
        //             // 上传失败触发的事件
        //         });
        //         this.on("removedfile", function (file) {
        //             // 删除文件时触发的方法
        //         });
        //     }
        // });

	</script>
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
			$("#zip").val(site);
			$("#vlongitude").val(pt.lng);
			$("#vlatitude").val(pt.lat);

			$("#tpZip").val(site);
			$("#tpVlongitude").val(pt.lng);
			$("#tpVlatitude").val(pt.lat);

		});
	});
</script>

</html>

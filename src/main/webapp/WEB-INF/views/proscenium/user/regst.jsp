<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Info | 用户注册</title>
	<jsp:include page="../../../includes/header.jsp"/>
</head>
<style>
	#box {overflow:hidden; background-color:#EEE;}
	#box ul {position:absolute; top:0; left:0; }
	#box ul li {float:left; }
</style>
<script src="/static/assets/js/move.js"></script>
<script src="/static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<body class="hold-transition register-page" >

<div class="register-box" style="z-index: 99;">
	<div class="register-logo">
		<b>Register</b>用户注册
	</div>

	<div class="register-box-body">
		<%--danger alert--%>
		<c:if test="${msg.msg != null}">
			<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h5>${msg.msg}</h5>
				<c:if test="${msg.status == 200}">
					<div style= "text-align:left">
						恭喜，注册成功！ <br><b id="show"></b>秒钟之后，自动登陆跳转<br>
					</div>
					<script>
						var time = 3;
						function tiaozhuan()
						{

							$('#show').text(time);
							if(time==0)
								location.href="/user/index.action";
							time--;
						}
						setInterval("tiaozhuan()",1000);
						window.onLoad=tiaozhuan();
					</script>
				</c:if>
			</div>
		</c:if>
		<%--danger alert--%>
		<p class="login-box-msg">注册一个新用户</p>
		<form action="/user/regstform" method="post">

			<div class="form-group has-feedback">
				<input name="uname" type="text" class="form-control" placeholder="用户名">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="uemail" id="email" type="email" class="form-control" placeholder="邮箱">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="upwd" type="password" class="form-control" placeholder="密码">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="reupwd" type="password" class="form-control" placeholder="重复密码">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="phone" type="text" class="form-control" placeholder="手机号">
				<span class="glyphicon glyphicon-phone form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="captcha" type="text" id="captcha" class="form-control" placeholder="验证码">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				<div id="captcha-tips"></div><div style="display: none"><input value="false" id="captcha-check"></div>
				<input class="btn btn-info" type="button" value="获取验证码" id="get-captcha">
			</div>
			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="button" class="btn btn-primary btn-block btn-flat" onclick="window.location.href='/index'">首页</button>
				</div>
				<div class="col-xs-4">
					<button type="reset" class="btn btn-primary btn-block btn-flat">重置</button>
				</div>
				<div class="col-xs-4">
					<button type="button" class="btn btn-primary btn-block btn-flat" id="submit-btn">注册</button>
				</div>

				<!-- /.col -->
			</div>
		</form>

		<a href="/index" class="text-center">已有账号?</a>
	</div>
	<!-- /.form-box -->
	<%--版权--%>
</div>

<!-- /.register-box -->
<!-- ./wrapper -->
<jsp:include page="../../../includes/footer.jsp"/>
<script>
	// iCheck
	$(function () {
		$('input').iCheck({
			checkboxClass: 'icheckbox_square-blue',
			radioClass: 'iradio_square-blue',
			increaseArea: '20%' /* optional */
		});
		$("#get-captcha").click(function () {
			if($("#email").val()==""){
				alert("邮箱不能为空");
				$("#email").focus();
				return false;
			} else if($("#email").val().indexOf('@')=='-1'||$("#email").val().indexOf('.com')=='-1'){
				alert("请检查邮箱格式是否正确")
			} else{
							$("#get-captcha").attr("disabled", true);
							$("#get-captcha").val("发送中...");
							var flat=true;
							$.ajax({
								url:'/user/sendcaptcha',
								type : "post",
								// sync:false,
								data:{
									email:$("#email").val()
								},
								success:function (res) {
									console.log(res);
									flat=res;
								}
							});
				if(flat){
					var count = 60;
					var countdown = setInterval(CountDown, 1000);
					function CountDown() {
						$("#get-captcha").attr("disabled", true);
						$("#get-captcha").val(count + "s");
						if (count == 0) {
							$("#get-captcha").val("重新获取验证码").removeAttr("disabled");
							clearInterval(countdown);
							$.ajax({//超时5分钟删除session中验证码
								url : "/user/deletecaptcha",
								type : "post",
								// sync:false,
								data:{
								},
								success:function () {
									alert("获取验证码失效，请重新获取");
								}
							})
						}
						count--;
					}
				}
			}
		});
	});
	$("#submit-btn").click(function () {
		var cpt=$("#captcha").val();
		$.ajax({
			url: "/user/checkcaptcha",
			data: {
				captcha: cpt,
			},
			type: "post",
			success: function (res) {
				if (res == false) {
					alert("验证码不正确");
					return false;
				} else {
					$("form").submit();
				}
			}
		});
	})

</script>

</body>
<%--js--%>
</html>
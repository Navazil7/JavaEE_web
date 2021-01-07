<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>MyShop | 登录</title>
	<jsp:include page="../includes/header.jsp"/>
</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">

<%--<form action="/user/yyytest" method="post">--%>
<%--	<button type="submit">123123123213</button>--%>
<%--</form>--%>

<div class="wrapper" style="height: auto; min-height: 100%;">

	<jsp:include page="../includes/top_navigation_reception.jsp"/>

	<!-- Full Width Column -->
	<div class="content-wrapper" style="min-height: 471px;">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					首页 | Show
					<small>轮播展示</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/index"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">SHOW</a></li>
				</ol>

			</section>
			<hr>

			<%--内容开始--%>
			<!-- Main content -->
			<section class="content">
				<div id="myCarousel" class="carousel slide ">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0"
							class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="/static/assets/img/test/city.png" alt="First slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>Closing WebApplicationContext for namespace
								'springServlet-servlet': startup date [Thu May 02 10:23:29
							</div>
						</div>
						<div class="item">
							<img src="/static/assets/img/test/sky.png" alt="Second slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>Closing WebApplicationContext for namespace
								'springServlet-servlet': startup date [Thu May 02 10:23:29
							</div>
						</div>
						<div class="item">
							<img src="/static/assets/img/test/sea.png" alt="Third slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>Closing WebApplicationContext for namespace
								'springServlet-servlet': startup date [Thu May 02 10:23:29
							</div>
						</div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</section>
			<!-- /.content -->
			<br>
			<section class="content-header">
				<h1>
					景点 | VIEW
					<small>概略一览</small>
				</h1>
				<br>
				<%--自定义内容--%>
				<div class="row">
					<c:forEach items="${viewPoints}" var="viewPoint">
						<%--自定义内容--%>
						<div class="col-sm-6 col-md-4 col-lg-3 viewpages">
							<div class="thumbnail" style="height: 420px;">
								<a href="/view/content?tpVid=${viewPoint.tpVid}">
									<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">
								</a>
								<div class="caption">
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-12">
												<h3>${fn:substring(viewPoint.tpTitle,0,30)}</h3>
												<h5>
													[${viewPoint.tpVname}&nbsp;<small>| ${viewPoint.tpLocation}</small>
													]
												</h5>
												<strong>等级: ${viewPoint.tpLevel}</strong>|
												<strong>开放时间: ${viewPoint.tpOpentime}</strong>|
												<strong>景点价格: ${viewPoint.tpPrice}</strong>|
												<strong>类型: ${viewPoint.tpVtype}</strong><br>
												详细地址:${fn:substring(viewPoint.tpZip,0,7)}...<br/>
												电话: ${viewPoint.tpVphone}
												<div class="form-group" style="text-align: right;">
													<a class="btn" style="color: #0b93d5"
													   href="/view/content?tpVid=${viewPoint.tpVid}">查看更多 »</a>
												</div>
												<div align="center">
													<button style="width: 60px" class="btn-google" onclick="isLogin(1,${viewPoint.tpVid},${user.uid})">预订</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
			<%--酒店--%>
			<section class="content-header">
				<h1>
					酒店 | Hotel
					<small>概略一览</small>
				</h1>
				<br>
				<hr>
				<br>
				<%--自定义内容--%>
				<div class="row">
					<c:forEach items="${hotels}" var="hotel">
						<!-- ITEM -->
						<div class="col-lg-1"></div>
						<div class="col-sm-6 col-md-4 col-lg-5">
							<div class="thumbnail"  style="height: 450px;">
								<a href="/hotel/content?hid=${hotel.hid}">
										<%--<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">--%>
									<img src="${hotel.imgUrl}" alt="...">
								</a>
								<div class="caption">
									<h3>${hotel.title}</h3>
									<ol>
										<li><p style="color: #ffa309">城市：${hotel.local}|房屋类型：${hotel.houseType}|床类型：${hotel.bedType}</p> </li>
										<li><p style="color: #0b93d5">价格：￥${hotel.price} | 详细地址：${hotel.zip}</p></li>
									</ol>
								</div>
								<div class="form-group" style="text-align: right;">
									<a class="btn" style="color: #0b97c4"
									   href="/hotel/content?hid=${hotel.hid}">查看详情»</a>
								</div>
								<div align="center">
									<button style="width: 60px" class="btn-google" onclick="isLogin(2,${hotel.hid},${user.uid})">预订</button>
								</div>
							</div>
						</div>
						<!-- END / ITEM -->
					</c:forEach>
				</div>
			</section>
			<%--文章--%>
			<section class="content-header">
				<h1>
					论坛 | FORUM
					<small>概略一览</small>
				</h1>
				<br>
				<hr>
				<br>
				<%--自定义内容--%>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="thumbnail">
						<div class="caption">
							<div class="container-fluid">
								<div class="row">
									<%--danger alert--%>
									<c:if test="${msg.msg != null}">
										<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
													aria-hidden="true">×
											</button>
											<h4>${msg.msg}</h4>
										</div>
									</c:if>
									<%--danger alert--%>

									<%--发点什么?--%>
									<div class="box-header">
										<div class="col-lg-2" style="padding-left: 12px; padding-top: 10px;">
											<a href="/forum/issue?uid=${user.uid}" type="button"
											   class="btn btn-block btn-primary btn-lg">发点什么?</a>
										</div>
									</div>
									<%--遍历帖子--%>
									<c:forEach items="${forums}" var="forum">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<div class="post-preview">
												<br>
												<a href="/forum/content?tpFid=${forum.tpFid}">
													<h2 class="post-title">${forum.tpTitle}</h2>
													<h4 class="post-subtitle" style="font-style: italic">
															${fn:substring(forum.tpSubTitle,0,20)}...
													</h4>

												</a>
												<p class="post-meta" style="margin: 10px 0; color: #0b93d5;">
													作者:${forum.tpAuthor} Create By
													<fmt:formatDate value="${forum.tpIssueTime}" pattern="yyyy-MM-dd:HH:mm:dd"/>
												</p>
												<div class="tags">
														${forum.tpTag}
												</div>
												<div class="form-group" style="text-align: right;">
													<a class="btn" style="color: #0b97c4"
													   href="/forum/content?tpFid=${forum.tpFid}">查看详情»</a>
												</div>
												<hr>
											</div>
											<!-- 如果开启评论功能 -->
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</
					div>
				</div>
			</section>
		</div>
		<!-- /.container -->
	</div>
	<!-- /.content-wrapper -->

	<%--版权--%>
	<jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- ./wrapper -->
<%--js--%>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
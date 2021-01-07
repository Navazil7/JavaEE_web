<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--侧边导航栏--%>
<section class="content col-lg-2">
	<%--侧边栏--%>
	<div>
		<a href="/user/info?uid=${user.uid}" class="list-group-item">个人信息</a>
		<a href="/user/edit" class="list-group-item">编辑信息</a>
		<a href="/user/forum?uid=${user.uid}" class="list-group-item" >我的发表</a>
		<div class="dropdown">
			<button class="list-group-item" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				我的订单
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<li><a href="/order/attractionsOrder?uid=${user.uid}">景点订单</a></li>
				<li><a href="/order/trafficsOrder?uid=${user.uid}">交通订单</a></li>
				<li><a href="/order/hotelsOrder?uid=${user.uid}">酒店订单</a></li>
			</ul>
		</div>
	</div>
</section>
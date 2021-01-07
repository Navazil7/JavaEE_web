<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>

<head>
	<title>回复信息 | Reply</title>
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
				回复信息|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Reply </a></li>
				<li class="active">列表</li>
			</ol>
		</section>

		<br/><br/>
		<div class="col-xs-12">

			<%--Denger alert--%>
			<c:if test="${msg.msg != null}">
				<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<%--${msg}--%>
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
			<%--/.alert--%>

			<div class="box">
				<div class="box-header">
					<h3 class="box-title">回复列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm usersectiondelete"><i
								class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<%--模糊搜索框--%>
						<form action="/admin/replyPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="模糊搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<table id="myuserstable" class="table table-bordered table-striped">

					<thead>
					<tr>
						<th>
							<label>
								<input type="checkbox" class="minimal icheck_master">
							</label>
						</th>
						<th>回复编号|Rid</th>
						<th>回复人|User</th>
						<th>回复时间|Date</th>
						<th>回复内容|Content</th>
						<th>给谁回复|User</th>
						<th>回复留言实体|Words</th>
						<%--给哪条回复信息回复的--%>
						<th>回复回复实体|Reply</th>
						<th>回复景点|View</th>
						<th>回复酒店|Hotel</th>
						<th>回复论坛|Forum</th>
						<th>操作|Edit</th>
					</tr>
					</thead>
					<tbody>

					<c:forEach items="${replys}" var="reply">
						<tr>
							<td>
								<label>
									<input name="tp_rid" value="${reply.tp_rid}" type="checkbox"
										   class="minimal minimal-myminor">
								</label>
							</td>
							<td>${reply.tp_rid}</td>
							<td><span class="label label-primary">${reply.tp_rname}</span></td>
							<td>${reply.tp_rdate}</td>
							<td>${reply.tp_rcontent}</td>
							<td>${reply.tp_r_for_name}</td>
							<td>${reply.tp_r_for_words}</td>
							<td>${reply.tp_r_for_reply}</td>
							<td>${reply.tp_r_viewpointId}</td>
							<td>${reply.tp_r_hotelId}</td>
							<td>${reply.tp_r_forumId}</td>
							<td>
								<a href="/admin/replyDelete?tp_rid=${reply.tp_rid}" class="btn btn-danger  btn-xs"><i
										class="fa fa-trash"></i>删除
								</a>
							</td>
						</tr>
					</c:forEach>

					</tbody>
				</table>
				<br>
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
        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        $(".usersectiondelete").click(function () {
            var tp_rids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for (var i = 0; i < seletes.length; i++) {
                if ($(seletes[i]).prop("checked")) {
                    tp_rids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "replyMutiDelete",
                type: "GET",
                data: {
                    "tp_rids": tp_rids
                },
                traditional: true,
                success: function (message) {
                    if (message == "1") {
                        window.location.href = "/admin/replyList";
                    }
                }
            });
        });
    })
</script>
</body>
</html>

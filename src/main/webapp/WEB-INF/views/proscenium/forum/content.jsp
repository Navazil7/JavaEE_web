<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Date date = new Date();
	String nowDate = sdf.format(date);
%>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>word | 文章</title>
	<jsp:include page="../../../includes/header.jsp"/>
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
					文章 | Word
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/view/point"><i class="fa fa-dashboard"></i>文章</a></li>
					<li><a href="#">SHOW</a></li>

				</ol>
			</section>
			<br>
			<section class="content">
				<div class="row">
					<div class="thumbnail">
						<div class="caption">
							<div class="container-fluid">
								<div class="row">
									<br>

									<div class="col-md-12 col-lg-12">
										<div class="right" style="float: right;">
											<small>发布日期:<fmt:formatDate value="${forum.tpIssueTime}"
											                            pattern="yyyy-MM-dd:HH:mm:ss"/></small>
										</div>
										<h3>${forum.tpTitle}</h3>
										<h4 class="post-subtitle" style="font-style: italic">
											${forum.tpSubTitle}
										</h4>
										<strong>编码:${forum.tpFid}</strong>|<strong>作者: ${forum.tpAuthor}</strong>
										<br><strong>标签: ${forum.tpTag}</strong>
										<br>
										<hr>
										<br>
										${forum.tpTcontent}

									</div>
								</div>
								<hr>
							</div>
						</div>
						<%--留言功能--%>
						<div style="margin:0 2% 0 2%;">
							<br/>
							<!-- 留言的表单 -->
							<form class="layui-form" action="/article/saveforumWords" method="post">
								<input name="tp_wname" value="${user.uname}" hidden="hidden"/>
								<input name="tp_wdate" value="<%=nowDate%>" hidden="hidden"/>
								<input name="tp_w_forumId" value="${forum.tpFid}" hidden="hidden"/>
								<div class="layui-input-block" style="margin-left: 0;">
								<textarea id="tp_wcontent" name="tp_wcontent" placeholder="请输入你的留言" class="layui-textarea"
								          style="height: 150px;"></textarea>
								</div>
								<br/>
								<div class="layui-input-block" style="text-align: left;margin-left: 0;">
									<input type="submit" class="btn btn-primary" value="留言">
								</div>
							</form>
							<br/>

							<!-- 留言信息列表展示 -->
							<div>
								<ul>
									<!-- 先遍历留言信息（一条留言信息，下面的全是回复信息） -->
									<c:forEach items="${lw_list}" var="words">
										<!-- 如果留言信息是在本文章下的才显示 -->
										<c:if test="${words.tp_w_forumId eq forum.tpFid}">
											<li style="border-top: 1px dotted #01AAED">
												<br/>
												<div style="text-align: left;color:#444">
													<div>
														<span style="color:#01AAED">${words.tp_wname}</span>
													</div>
													<div>${words.tp_wcontent}</div>
												</div>
												<div>
													<div class="comment-parent"
													     style="text-align:left;margin-top:7px;color:#444">
														<span>${words.tp_wdate}</span>
														&nbsp;&nbsp;&nbsp;&nbsp;
														<p>
															<a href="javascript:;" style="text-decoration: none;"
															   onclick="btnReplyClick(this)">回复</a>
														</p>
													</div>

													<%--<!-- 回复表单默认隐藏 -->--%>
													<div class="replycontainer layui-hide" style="margin-left: 61px;">
														<form action="/article/saveForumReply" method="post"
														      class="layui-form">
															<input name="tp_r_forumId" id="tp_r_forumId"
															       value="${forum.tpFid}" hidden="hidden"/>
															<input name="tp_rname" id="tp_rname"
															       value="${user.uname}"
															       hidden="hidden"/>
															<input name="tp_rdate" id="tp_rdate" value="<%=nowDate%>"
															       hidden="hidden"/>
															<input name="tp_r_for_name" id="tp_r_for_name"
															       value="${words.tp_wname}" hidden="hidden"/>
															<input name="tp_r_for_words" id="tp_r_for_words"
															       value="${words.tp_wid}" hidden="hidden"/>
															<input name="tp_r_for_reply" id="tp_r_for_reply"
															       value="${reply.tp_rid}" hidden="hidden"/>
															<div class="layui-form-item">
															<textarea name="tp_rcontent" id="tp_rcontent"
															          lay-verify="replyContent" placeholder="请输入回复内容"
															          class="layui-textarea"
															          style="min-height:80px;"></textarea>
															</div>
															<div class="layui-form-item">
																<button id="replyBtn" class="btn btn-primary"
																        lay-submit="formReply" lay-filter="formReply">提交
																</button>
															</div>
														</form>
													</div>
												</div>

												<!-- 以下是回复信息 -->
												<c:forEach items="${lr_list}" var="reply">
													<!-- 每次遍历出来的留言下存在回复信息才展示（本条回复信息是本条留言下的就显示在当前留言下） -->
													<c:if test="${reply.tp_r_forumId eq forum.tpFid && reply.tp_r_for_words eq words.tp_wid}">
														<div style="text-align: left;margin-left:61px;color: #444">
															<div>
																<span style="color:#5FB878">${reply.tp_rname}&nbsp;&nbsp;</span>
															</div>
															<div>
																@${reply.tp_r_for_name}:&nbsp;&nbsp; ${reply.tp_rcontent}</div>
														</div>
														<div>
															<div class="comment-parent"
															     style="text-align:left;margin-top:7px;margin-left:61px;color:#444">
																<span>${reply.tp_rdate}</span>
																&nbsp;&nbsp;&nbsp;&nbsp;
																<p>
																	<a href="javascript:;"
																	   style="text-decoration: none;"
																	   onclick="btnReplyClick(this)">回复</a>
																</p>
																<hr style="margin-top: 7px;"/>
															</div>
															<!-- 回复表单默认隐藏 -->
															<div class="replycontainer layui-hide"
															     style="margin-left: 61px;">
																<form action="/article/saveForumReply"
																      method="post" class="layui-form">
																	<input name="tp_r_forumId"
																	       id="tp_r_forumId"
																	       value="${forum.tpFid}" hidden="hidden"/>
																	<input name="tp_rname" id="tp_rname"
																	       value="${user.uname}"
																	       hidden="hidden"/>
																	<input name="tp_rdate" id="tp_rdate"
																	       value="<%=nowDate%>"
																	       hidden="hidden"/>
																	<input name="tp_r_for_name" id="tp_r_for_name"
																	       value="${words.tp_wname}" hidden="hidden"/>
																	<input name="tp_r_for_words" id="tp_r_for_words"
																	       value="${words.tp_wid}" hidden="hidden"/>
																	<input name="tp_r_for_reply" id="tp_r_for_reply"
																		   value="${reply.tp_rid}" hidden="hidden"/>
																	<div class="layui-form-item">
                                                    <textarea name="tp_rcontent" id="tp_rcontent"
                                                              lay-verify="replyContent" placeholder="请输入回复内容"
                                                              class="layui-textarea" style="min-height:80px;">
                                                      @${words.tp_wname}:&nbsp;&nbsp;
                                                  </textarea>
																	</div>
																	<div class="layui-form-item">
																		<button id="replyBtn"
																		        class="layui-btn layui-btn-mini"
																		        lay-submit="formReply"
																		        lay-filter="formReply">提交
																		</button>
																	</div>
																</form>
															</div>
														</div>
													</c:if>
												</c:forEach>
											</li>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</section>
			<br>
			<!-- /.container -->
		</div>
		<!-- /.content-wrapper -->

	</div>

	<%--版权--%>
	<jsp:include page="../../../includes/copyright.jsp"/>
	<!-- ./wrapper -->
	<%--js--%>
	<jsp:include page="../../../includes/footer.jsp"/>

	<%--回复--%>
	<script>
        function btnReplyClick(elem) {
            if ($(this)) {
            } else if (!$(this)) {
                $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-show');
            }
            $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
            if ($(elem).text() == '回复') {
                $(elem).text('收起')
            } else {
                $(elem).text('回复')
            }
        }

        $("#replyBtn").click(function () {
            var tp_r_forumId = $("#tp_r_forumId").val();
            var tp_rname = $("#tp_rname").val();
            var tp_rdate = $("#tp_rdate").val();
            var tp_r_for_name = $("#tp_r_for_name").val();
            var tp_rcontent = $("#tp_rcontent").val();
            var tp_r_for_words = $("#tp_r_for_words").val();
            $.ajax({
                url: '/article/saveForumReply',
                type: 'POST',
                data: [{
                    tp_r_forumId: tp_r_forumId,
                    tp_rname: tp_rname,
                    tp_rdate: tp_rdate,
                    tp_r_for_name: tp_r_for_name,
                    tp_rcontent: tp_rcontent,
                    tp_r_for_words: tp_r_for_words
                }],
                success: function (data) {
                    layer.open({
                        title: '提示信息',
                        content: '留言成功',
                        btn: ['确定'],
                        btn1: function (index) {
                            $("body").html(data);
                        }
                    });
                },
                error: function () {
                    layer.open({
                        title: '提示信息',
                        content: '出现未知错误'
                    });
                }
            });
        });
	</script>

</body>
</html>
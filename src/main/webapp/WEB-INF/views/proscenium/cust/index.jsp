<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Hotel | 酒店</title>
	<jsp:include page="../../../includes/header.jsp"/>
</head>
<style>
	.traffic-choose,.hotel-choose{
		position: absolute;
		display: inline-block;
		border: 1px solid #2c2c2c;
		width:13px;
		height:13px;
		border-radius: 3px;
	}
	.view-choose{
		position: absolute;
		display: inline-block;
		border: 1px solid #2c2c2c;
		width:13px;
		height:13px;
		border-radius: 3px;
	}
	.view,.hotel{
		margin: 20px;
	}
	input[type="radio"] {
		appearance: none;
		-webkit-appearance: none;
		outline: none;
		margin: 0;
	}
	input[type="radio"]:after {
		display: inline-block;
		position: absolute;
		content:"";
		background-color: transparent;
	}
	input[type="radio"]:checked:after {
	/*content:"\2714";*/
	/*text-align: center;*/
		font-weight:bold;
		font-size:13px;
		font-family:Sans-serif;
		background: transparent;
		top: -4px;
		left: 2px;
		content:"L";
		transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);
		-webkit-transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);
	}
	input[type="checkbox"] {
		appearance: none;
		-webkit-appearance: none;
		outline: none;
		margin: 0;
	}
	input[type="checkbox"]:after {
		display: inline-block;
		position: absolute;
		content:"";
		background-color: transparent;
	}
	input[type="checkbox"]:checked:after {
		/*content:"\2714";*/
		/*text-align: center;*/
		font-weight:bold;
		font-size:13px;
		font-family:Sans-serif;
		background: transparent;
		top: -4px;
		left: 2px;
		content:"L";
		transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);
		-webkit-transform:matrix(-0.766044,-0.642788,-0.642788,0.766044,0,0);
	}
	/*订单块固定屏幕*/
	#order{
		position: fixed;
		top: 100px;
		left: 0px;
		right: 0px;
		bottom: 100px;
		margin:  0 auto;
		z-index: 99;
		width: 500px;
		height: auto;
		min-height: 300px;
		max-height: 600px;
		background: white ;
		opacity:0.9;
		border: 1px solid #5a6268;
	}
	.close {
		background: white;
		color: red;
		border-radius: 12px;
		line-height: 20px;
		text-align: center;
		height: 20px;
		width: 20px;
		font-size: 18px;
		padding: 1px;
		top: 5px;
		right: 5px;
		position: absolute;
	}
	/* use cross as close button */
	.close::before {
		content: "\2716";
	}
</style>
<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">
<%--<div id="order">--%>
<%--	<div class="container">--%>
<%--		<p class="btn bg-orange btn-flat margin" style="cursor: default">请确认你的订单</p>--%>
<%--		<span class="close" style="float: right"></span>--%>
<%--	</div>--%>
<%--	<hr>--%>
<%--	<div class="container  col-lg-12"style="width:100%;height: 400px;overflow:scroll;">--%>
<%--			<table id="order_table" class="table table-bordered table-striped">--%>
<%--				<thead>--%>
<%--				<tr>--%>
<%--					<th>编号</th>--%>
<%--					<th>类型</th>--%>
<%--					<th>内容</th>--%>
<%--					<th>数量</th>--%>
<%--					<th>价格</th>--%>
<%--				</tr>--%>
<%--				</thead>--%>
<%--				<tbody>--%>

<%--				</tbody>--%>
<%--			</table>--%>
<%--		</div>--%>
<%--	<hr>--%>
<%--	<div class="container" >--%>
<%--		<div style="width: 200px ;display: inline-block" ><p>总价:<label id="total"></label></p></div><button class="btn btn-primary"  >提交订单</button>--%>
<%--	</div>--%>
<%--</div>--%>
<div class="wrapper" style="height: auto; min-height: 100%;">

	<jsp:include page="../../../includes/top_navigation_reception.jsp"/>

	<!-- Full Width Column -->
	<div class="content-wrapper" style="min-height: 471px;">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					定制 | Cust
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/hotel/index"><i class="fa fa-dashboard"></i>定制</a></li>
					<li><a href="#">Hotel</a></li>

				</ol>
			</section>
			<br>
			<hr>
			<br>
			<section>
				<div class="box box-info">
					<%--交通--%>
					<div class="container">
						<br>
						<p class="btn bg-orange btn-flat margin" style="cursor: default">选择您的出行</p>
						<div style="display: inline-block;width: 150px;border-right:50px ">交通工具:<select style="float: right" id="traffic-type">
							<option value="火车">火车</option>
							<option value="飞机">飞机</option>
							<option value="大巴">大巴</option>
							<option value="ALL" selected>ALL</option></select></div>
						<div style="display: inline-block;width: 200px">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp定制方案:<select  style="float: right" id="diy-type">
							<option value="1">时间优先</option>
							<option value="2">价格优先</option>
							<option value="3">奢华定制</option>
							<option value="4" selected>无要求</option></select></div>
						<div style="float: right;padding-right: 50px;">
						<button class="btn btn-primary" onclick="ajax_city(currentCity,desCity);" >查询</button>
							<div style="width: 20px;display: inline-block"></div>
						<button class="btn btn-primary" >一键定制</button>
						</div>
						<br>
						<br>
						<%--出发地--%>
						<div class="docs-methods">
							<form class="form-inline">
								<div>
									<%--出发地--%>
									<div class="form-group" data-toggle="distpicker" id="current_city">
										出发地：
											<select class="form-control" data-province="-- 选择省 --"></select>
											<select class="form-control" data-city="-- 选择市 --"></select>
											<select class="form-control" data-district="-- 选择区 --" style="display: none"></select>
										<div class="form-group">
											<button class="btn btn-primary" id="reset1" type="reset">重置</button>
										</div>
									</div>
									<%--目的地--%>
									<div class="form-group" data-toggle="distpicker" id="des_city">
										目的地：
										<select class="form-control" data-province="-- 选择省 --"></select>
										<select class="form-control" data-city="-- 选择市 --"></select>
										<select class="form-control" data-district="-- 选择区 --" style="display: none"></select>
										<div class="form-group">
											<button class="btn btn-primary" id="reset2" type="reset">重置</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<br>

					<%--交通查询表单--%>
					<div class="container col-lg-12">
						<table id="traffic_table" class="table table-bordered table-striped">
							<thead>
							<tr>
								<th></th>
								<th>类型</th>
								<th>出发地</th>
								<th>目的地</th>
								<th>出发时间</th>
								<th>到达时间</th>
								<th>花费时间</th>
								<th>价格</th>
							</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>

					<%--景点选择--%>
					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">目的景点</p>
					</div>
					<div class="container" id="view_cust"></div>

						<br>
						<br>
						<hr>

					<%--酒店选择--%>
					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">目的酒店</p>
					</div>
					<%--结果--%>
					<div class="container" id="hotel_cust"></div>
						<br>
						<br>
						<hr>
						<div class="container" style="text-align: center;padding: 20px">
							<button class="btn btn-primary" onclick="produce_order()" >生成订单</button>
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

		<%--省市区联动插件--%>
<%--		<script src="/static/assets/plugins/jQueryDistpicker20160621/js/distpicker.data.js"></script>--%>
<%--		<script src="/static/assets/plugins/jQueryDistpicker20160621/js/distpicker.js"></script>--%>
		<script src="https://cdn.bootcdn.net/ajax/libs/distpicker/2.0.6/distpicker.js"></script>

	<script>

        $.fn.distpicker.setDefaults({
            autoSelect:false
        });

        var currentCity= "";
        var desCity="";
        $("#current_city select").on("change", function () {
			$("#traffic_table tbody").empty();
			$("#view_cust").empty();
			$("#hotel_cust").empty();
            $this = $(this);
            currentCity = $this.children("option:selected").val();
            if(currentCity==""){
                currentCity = $this.prev().children("option:selected").val();
                if(typeof currentCity == "undefined"){
                    currentCity = "";
                }
            }
            console.log(currentCity,desCity);
        });

        $("#des_city select").on("change", function () {
			$("#traffic_table tbody").empty();
			$("#view_cust").empty();
			$("#hotel_cust").empty();
            $this = $(this);
            desCity = $this.children("option:selected").val();
            if(desCity==""){
                desCity = $this.prev().children("option:selected").val();
                if(typeof desCity == "undefined"){
                    desCity = "";
                }
            }
            console.log(currentCity,desCity);
        });
		$("#traffic-type").on("change", function (){
			ajax_city(currentCity,desCity);
		});
		// 交通表异步加载
        function ajax_city(currentCity, desCity) {
            $("#traffic_table tbody").empty();
            $("#view_cust").empty();
            $("#hotel_cust").empty();
            var traf=$("#traffic-type").val();
            console.log(traf);

            if (currentCity != "" && desCity != ""&&traf=="ALL") {
                // console.log(currentCity);
                // console.log(desCity);
                $.ajax({
                    url: '/traffic/selectByCurrentAndDestination',
                    type: 'GET',
                    data: {
                        currentCity: currentCity,
                        desCity: desCity,
						trafic:traf
                    },
                    success: function (data) {
                        console.log(data);
                        var tpDestination;
                        for (var i = 0; i < data.length; i++) {
                            var tpCurrentTime = new Date(data[i].tpCurrentTime).Format("yyyy-MM-dd:hh:mm:ss");
                            var tpArriveTime = new Date(data[i].tpArriveTime).Format("yyyy-MM-dd:hh:mm:ss");
                            console.log(data[i].tpArriveTime - data[i].tpCurrentTime);
                            var tpSpendTime = new Date(data[i].tpArriveTime - data[i].tpCurrentTime).Format("hh:mm:ss");
                            $("#traffic_table tbody").append(
                                '<tr>'
									+ '<td><label class = "traffic"><input type="radio" name = "traffic-choose" class = "traffic-choose"  value = "'+data[i].tpTid+'">'+'</label></td>'
                                + '<td><span class="label label-primary">' + data[i].tpType + '</span></td>'
                                + '<td>' + data[i].tpCurrent + '</td>'
                                + '<td>' + data[i].tpDestination + '</td>'
                                + '<td>' + tpCurrentTime + '</td>'
                                + '<td>' + tpArriveTime + '</td>'
                                + '<td>' + tpSpendTime + '</td>'
                                + '<td><span class="label label-primary">￥' + data[i].tpTprice + '</span></td>'
                                + '</tr>'
                            );
                            tpDestination = data[i].tpDestination;
                        }
                        ajax_viewPoint_cust(desCity);
                        ajax_hotel_cust(desCity);
                    }
                });
            }
            else if(currentCity != "" && desCity != ""&&traf!="ALL"){
				$.ajax({
					url: '/traffic/selectByCurrentAndDestination',
					type: 'GET',
					data: {
						currentCity: currentCity,
						desCity: desCity,
						trafic:traf
					},
					success: function (data) {
						console.log(data);
						var tpDestination;
						for (var i = 0; i < data.length; i++) {
							var tpCurrentTime = new Date(data[i].tpCurrentTime).Format("yyyy-MM-dd:hh:mm:ss");
							var tpArriveTime = new Date(data[i].tpArriveTime).Format("yyyy-MM-dd:hh:mm:ss");
							console.log(data[i].tpArriveTime - data[i].tpCurrentTime);
							var tpSpendTime = new Date(data[i].tpArriveTime - data[i].tpCurrentTime).Format("hh:mm:ss");
							$("#traffic_table tbody").append(
									'<tr>'
									+ '<td><label><input type="radio" name = "traffic-choose" class = "traffic-choose"  value = "'+data[i].tpTid+'">'+'</label></td>'
									+ '<td><span class="label label-primary">' + data[i].tpType + '</span></td>'
									+ '<td>' + data[i].tpCurrent + '</td>'
									+ '<td>' + data[i].tpDestination + '</td>'
									+ '<td>' + tpCurrentTime + '</td>'
									+ '<td>' + tpArriveTime + '</td>'
									+ '<td>' + tpSpendTime + '</td>'
									+ '<td><span class="label label-primary">￥' + data[i].tpTprice + '</span></td>'
									+ '</tr>'
							);
							tpDestination = data[i].tpDestination;
						}
						ajax_viewPoint_cust(desCity);
						ajax_hotel_cust(desCity);
					}
				});
			}
        }

        // 景点AJAX
        function ajax_viewPoint_cust(tpDestination) {
            var _checkbox = App.getCheckbox();
            console.log(_checkbox.length);
            $.ajax({
                url: '/cust/viewPoint',
                type: 'GET',
                data: {
                    tpLocation: tpDestination
                },
                success: function (data) {
                    // console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        var title = data[i].tpTitle.substring(0, 9);

                        $("#view_cust").append(
                            '<div class="col-sm-6 col-md-4 col-lg-3 viewpages">'
                            + '<div class="thumbnail" style="height: 400px;">'
								+ '<label class = "view"><input type="checkbox" name = "view-choose" class = "view-choose"  value = "'+data[i].tpVid+'">'+'</label>'
                            + '<a href="/view/content?tpVid= ' + data[i].tpVid + ' ">'
                            + '<img src="/static/upload/viewavatar/' + data[i].tpVpic + ' " alt="..." class="img-rounded">'
                            + '</a>'
                            + '<div class="col-md-12">'
                            + '<h3> ' + title + ' ...</h3>'
                            + '<h5> [ ' + data[i].tpVname + ' &nbsp;<small>| ' + data[i].tpLocation + ' </small>] </h5>'
                            + '<strong>等级: ' + data[i].tpLevel + ' </strong>| '
                            + '<strong> 开放时间:  ' + data[i].tpOpentime + ' </strong>|'
                            + '<strong>类型:  ' + data[i].tpVtype + ' </strong>'
                            + '<br> 详细地址:  ' + data[i].tpZip + ' '
                            + '<br/> 电话:  ' + data[i].tpVphone + ' '
                            + '<div class="form-group" style="text-align: right;">'
                            + '<a class="btn" style="color: #0b93d5" href="/view/content?tpVid=  ' + data[i].tpVid + ' ">查看更多 »</a>'
                            + '</div> </div> </div> </div> '
                        );
                    }
                }
            });
        }

        // 酒店ajax
        function ajax_hotel_cust(tpDestination) {
            var _checkbox = App.getCheckbox();
            console.log(_checkbox.length);
            $.ajax({
                url: '/cust/hotel',
                type: 'GET',
                data: {
                    local: tpDestination
                },

                success: function (data) {
                     console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        var title = data[i].title.substring(1, 9);

                        $("#hotel_cust").append(

                            '<div class="col-sm-6 col-md-4 col-lg-5">'
	                        + '<div class="thumbnail"  style="height: 450px;">'
								+ '<label class = "hotel"><input type="checkbox" name = "hotel-choose" class = "hotel-choose"  value = "'+data[i].hid+'">'+'</label>'
                            + '<a href="/hotel/content?hid=' + data[i].hid + '">'
                            + '<img src="' + data[i].imgUrl + '">'
                            + '</a>'
                            + '<div class="caption">'
                            + '<h3>' + data[i].title + '</h3>'
                            + '<ol>'
                            + '<li><p style="color: #ffa309">城市：' + data[i].local + '|房屋类型：' + data[i].houseType + '|床类型：' + data[i].bedType + '</p> </li>'
                            + '<li><p style="color: #0b93d5">价格：￥' + data[i].price + '| 详细地址：' + data[i].zip + '</p></li>'
                            + '</ol>'
                            + '</div>'
                            + '<div class="form-group" style="text-align: right;">'
                            + '<a class="btn" style="color: #0b97c4" href="/hotel/content?hid=' + data[i].hid + '">查看详情»</a>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
	                        + '<div class="col-lg-1"></div>'
                        );
                    }
                }
            });
        }
		//×
		$(".close").on("click",function () {
				$(this).parent().parent().remove();
		});
        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1,                  //月份
                "d+": this.getDate(),                       //日
                "h+": this.getHours(),                      //小时
                "m+": this.getMinutes(),                    //分
                "s+": this.getSeconds(),                    //秒
                "q+": Math.floor((this.getMonth() + 3) / 3),//季度
                "S": this.getMilliseconds()                 //毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }
        function produce_order(){
        	// 获取得都是各自得id值，只传入id 通过后台获取所需数据
        	var traf=$("input[name='traffic-choose']:checked").val();
        	console.log(traf);
			var hotels=new Array();
			$('input[name="hotel-choose"]:checked').each(function(index, element) {
				console.log($(this).val());
				hotels.push($(this).val());
			});
			var views=new Array();
			$('input[name="view-choose"]:checked').each(function(index, element) {
				console.log($(this).val());
				views.push($(this).val());
			});
			if(traf==''){
				alert("交通工具未选择");
			}
			else if(views[0]==''){
				alert("景点未选择");
			}
			else if(hotels[0]==''){
				alert("旅馆未选择");
			}
			else{
				$("body").append("<div id=\"order\">\n" +
						"\t<div class=\"container\">\n" +
						"\t\t<p class=\"btn bg-orange btn-flat margin\" style=\"cursor: default\">请确认你的订单</p>\n" +
						"\t\t<span class=\"close\" style=\"float: right\"></span>\n" +
						"\t</div>\n" +
						"\t<hr>\n" +
						"\t<div class=\"container  col-lg-12\"style=\"width:100%;height: 400px;overflow:scroll;\">\n" +
						"\t\t\t<table id=\"order_table\" class=\"table table-bordered table-striped\">\n" +
						"\t\t\t\t<thead>\n" +
						"\t\t\t\t<tr>\n" +
						"\t\t\t\t\t<th>编号</th>\n" +
						"\t\t\t\t\t<th>类型</th>\n" +
						"\t\t\t\t\t<th>内容</th>\n" +
						"\t\t\t\t\t<th>数量</th>\n" +
						"\t\t\t\t\t<th>价格</th>\n" +
						"\t\t\t\t</tr>\n" +
						"\t\t\t\t</thead>\n" +
						"\t\t\t\t<tbody>\n" +
						"\n" +
						"\t\t\t\t</tbody>\n" +
						"\t\t\t</table>\n" +
						"\t\t</div>\n" +
						"\t<hr>\n" +
						"\t<div class=\"container\" >\n" +
						"\t\t<div style=\"width: 200px ;display: inline-block\" ><p>总价:<label id=\"total\"></label></p></div><button class=\"btn btn-primary\" onclick='sub_order()' >提交订单</button>\n" +
						"\t</div>\n" +
						"</div>");
					$(".close").on("click",function () {
						$(this).parent().parent().remove();
					});
						ajax_traffic_cart(traf);
				        ajax_hotel_cart(hotels);
				        ajax_viewPoint_cart(views);

			}

		}
		function ajax_traffic_cart(traffic_id) {
				$.ajax({
					url: '/traffic/selectTrafficByid',
					type: 'GET',
					data: {
						traffic_id: traffic_id,
					},
					success: function (data) {
						console.log(data);
						var tpDestination;
						for (var i = 0; i < data.length; i++) {
							var tpCurrentTime = new Date(data[i].tpCurrentTime).Format("yyyy-MM-dd:hh:mm:ss");
							var tpArriveTime = new Date(data[i].tpArriveTime).Format("yyyy-MM-dd:hh:mm:ss");
							console.log(data[i].tpArriveTime - data[i].tpCurrentTime);
							$("#order_table tbody").append(
									'<tr>'
									+ '<td class="ID" ">' + data[i].tpTid + '</td>'
									+ '<td><span class="label label-primary kind">交通出行</span></td>'
									+ '<td>' + data[i].tpType +'---'+ data[i].tpCurrent+'---'+data[i].tpDestination +'<br>'+tpCurrentTime+'---'+tpArriveTime+ '</td>'
									+ '<td><div style="display: width: 15px"><input class="plus" style="width:15px" type="button" value="+" onclick="plus(this)"/></div><div style="display: width: 15px"><span class="quantity" type="text" style="width: 15px;"  >0</span></div><div style="width: 15px;"><input class="minus" style="width:15px" type="button" value="-" onclick="minus(this)"/></div></td>'
									+ '<td><span class="label label-primary">' + data[i].tpTprice + '</span></td>'
									+ '</tr>'
							);
							tpDestination = data[i].tpDestination;
						}
					}
				});
		}
		function ajax_hotel_cart(hotels) {
			$.ajax({
				url: '/cust/hotels',
				type: 'POST',
				data: {
					hotels_id:hotels
				},
				traditional: true,
				success: function (data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var title = data[i].title.substring(0, 9);
						$("#order_table tbody").append(
								'<tr>'
								+ '<td class="ID">' + data[i].hid + '</td>'
								+ '<td><span class="label label-primary kind">住宿</span></td>'
								+ '<td>' + data[i].title +'---'+data[i].houseType+'---'+ data[i].bedType+'<br>'+data[i].zip + '</td>'
								+ '<td><div style="display: width: 15px"><input class="plus" style="width:15px" type="button" value="+"onclick="plus(this)" /></div><div style="display: width: 15px"><span class="quantity" type="text" style="width: 15px;" >0</span></div><div style="width: 15px;"><input class="minus" style="width:15px" type="button" value="-" onclick="minus(this)"/></div></td>'
								+ '<td><span class="label label-primary">' + data[i].price + '</span></td>'
								+ '</tr>'
						);
					}
				}
			});
		}
		function ajax_viewPoint_cart(views) {
			$.ajax({
				url: '/cust/viewPointCart',
				type: 'POST',
				data: {
					views: views
				},
				traditional: true,
				success: function (data) {
					// console.log(data);
					for (var i = 0; i < data.length; i++) {
						var title = data[i].tpTitle.substring(0, 9);
						$("#order_table tbody").append(
								'<tr>'
								+ '<td class="ID">' + data[i].tpVid + '</td>'
								+ '<td><span class="label label-primary kind">景点</span></td>'
								+ '<td>' + data[i].tpTitle +'---'+data[i].tpVtype+'---'+ data[i].tpLevel+'星级<br>'+data[i].tpZip + '</td>'
								+ '<td><div style="display: width: 15px"><input class="plus" style="width:15px" type="button" value="+" onclick="plus(this)"/></div><div style="display: width: 15px"><span class="quantity" type="text" style="width: 15px;">0</span></div><div style="width: 15px;"><input class="minus" style="width:15px"  type="button" value="-" onclick="minus(this)"/></div></td>'
								+ '<td><span class="label label-primary price">'+data[i].tpPrice+'</span></td>'
								+ '</tr>'
						);
					}
				}
			});
		}
		// 计算总价
		function Total() {
			var tol=0;
			var p=0;
			var n=0;

			$(".quantity").each(function (index,item) {
					 p=parseInt($(this).parent().parent().next().find("span").text());
					 n=parseInt($(this).parent().parent().find("span").text());
					 tol=tol+p*n;
			});
			$("#total").text(tol);
		}
		function plus(obj){
			var num = $(obj).parent().parent().find("span");//单品数量增加
			num.text(parseInt(num.text())+1);
			Total();
		};
		function minus(obj) {
			var num = $(obj).parent().parent().find("span");
			if (parseInt(num.text())) {
				num.text(parseInt(num.text()) - 1);
				Total();
			} else {
				num.text("0");
			}
		}
		function sub_order() {
			var IDs=new Array();
			var Type=new Array();
			var Num=new Array();
			var totalPrice=$("#total");
			$("#order_table tbody .ID").each(function (index,element) {
				IDs.push($(this).text());
				alert($(this).text());
				Type.push($(this).next().find("span").text());
				alert($(this).next().find("span").text());
				Num.push($(this).next().next().next().find("span").text());
				alert($(this).next().next().next().find("span").text());
			});

			$.ajax({
				url: '/cust/HandleOrder',
				type: 'GET',
				data: {
					IDs:IDs,
					Num:Num,
					Type:Type,
					totalPrice:totalPrice,
				},
				success: function (data) {

				}
			});
		}
	</script>
</body>
</html>
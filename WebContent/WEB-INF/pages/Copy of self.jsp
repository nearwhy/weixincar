<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>自助保养</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<meta content="" name="description" />
<meta content="" name="author" />

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Optional Bootstrap Theme -->
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">


<link href="bootstrap-3.3.0/docs/assets/css/patch.css" rel="stylesheet">

<!-- Documentation extras -->
<link href="bootstrap-3.3.0/docs/asstes/css/src/docs.min.css"
	rel="stylesheet">


<!-- Favicons -->
<link rel="apple-touch-icon" href="/apple-touch-icon.png">
<link rel="icon" href="/favicon.ico">
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">

	<div class="jumbotron " style="background-color: #428bca">
		<h3 style="color: #ffffff">自助保养方式</h3>
		<span style="color: #ffffff; font-size: medium;">请在下方选择你想要做的保养项目</span><br>
		<span style="color: #ffffff">您也可以选择其他保养方式</span> <br>
		<div class="container" style="witdh: 100%">
			<div class="btn-group btn-group-justified" role="group"
				aria-label="...">
				<div class="btn-group" role="group">
					<a href="index.html" type="button" class="btn btn-lg btn-danger">深度保养</a>
				</div>
				<div class="btn-group" role="group">
					<a href="carBrand.html" type="button" class="btn btn-info btn-lg">大保养</a>
				</div>
				<div class="btn-group" role="group">
					<a href="self.html" type="button" class="btn btn-success btn-lg">常规保养</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<table style="width: 100%">
			<tr>
				<td style="width: 30%;"><span style="color: #428bca">保养类型</span></td>
				<td style="width: 50%"><span style="color: #428bca">项目</span></td>
				<td style="width: 20%" align="right"><span
					style="color: #428bca">工时费</span></td>
			</tr>
		</table>
		<div class="row">
			<table style="width: 100%">
				<tr>
					<td style="width: 30%" valign="top">
						<ul id="upkeepCategory" class="nav nav-pills nav-tabs nav-stacked"
							role="tablist">
							<!-- <li role="presentation" class="active"><a href="#home"
								id="home-tab" role="tab" data-toggle="tab" aria-controls="home"
								aria-expanded="true"><span style="font-size: small"><b>燃油系统</b></span><span
									class="badge">3</span></a></li>
							<li role="presentation"><a href="#profile" role="tab"
								id="profile-tab" data-toggle="tab" aria-controls="profile"><span
									style="font-size: small"><b>润滑系统</b></span></a></li>
							<li role="presentation"><a href="#profile" role="tab"
								id="#dropdown1" data-toggle="tab" aria-controls="dropdown1"><span
									style="font-size: small"><b>空调系统</b></span></a></li>
							<li role="presentation"><a href="#profile" role="tab"
								id="#dropdown2" data-toggle="tab" aria-controls="dropdown2"><span
									style="font-size: small"><b>变速箱</b></span></a></li> -->
						</ul>
					</td>
					<td style="width: 70%; background-color: #ffffff" valign="top">
						<div  class="tab-content" id="upkeepItems">
							<!-- <div role="tabpanel" class="tab-pane fade in active" id="home"
								aria-labelledBy="home-tab">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td width="70%" onclick="check();"><input
												type="checkbox" value="" id="check1" /><span>&nbsp;&nbsp;更换空气滤清器</span></td>
											<td width="30%" align="right">￥50</td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;节气门阀体清洗</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;油箱除水</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;更换火花塞</span></td>
											<td width="30%"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="profile"
								aria-labelledBy="profile-tab">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td width="70%" onclick="check();"><input
												type="checkbox" value="" id="check1" /><span>&nbsp;&nbsp;更换空气滤清器</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;节气门阀体清洗</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;油箱除水</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;更换火花塞</span></td>
											<td width="30%"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="dropdown1"
								aria-labelledBy="dropdown1-tab">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td width="70%" onclick="check();"><input
												type="checkbox" value="" id="check1" /><span>&nbsp;&nbsp;更换空气滤清器</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;节气门阀体清洗</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;油箱除水</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;更换火花塞</span></td>
											<td width="30%"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="dropdown2"
								aria-labelledBy="dropdown2-tab">
								<table class="table table-striped">
									<tbody>
										<tr>
											<td width="70%" onclick="check();"><input
												type="checkbox" value="" id="check1" /><span>&nbsp;&nbsp;更换空气滤清器</span></td>
											<td width="30%">￥50</td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;节气门阀体清洗</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;油箱除水</span></td>
											<td width="30%"></td>
										</tr>
										<tr>
											<td width="70%"><input type="checkbox" value=""
												id="check1" /><span>&nbsp;&nbsp;更换火花塞</span></td>
											<td width="30%"></td>
										</tr>
									</tbody>
								</table>
							</div> -->
						</div>
					</td>
				</tr>
			</table>
		</div>

	</div>
	<br>
	<br>
	<nav class="navbar navbar-default navbar-fixed-bottom"
		role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" style="background-color: #eeeeee">
			<h4>工时费明细</h4>
			<ul class="nav navbar-nav">
				<li>
					<div class="row">
						<div class="col-xs-8">
							<span>&nbsp;&nbsp;发动机抗磨保护服务</span>
						</div>
						<div class="col-xs-4" align="right">
							<span>￥50&nbsp;&nbsp;</span>
						</div>
					</div>
				</li>
				<li>
					<div class="row">
						<div class="col-xs-8">
							<span>&nbsp;&nbsp;发动机油泥清洗服务</span>
						</div>
						<div class="col-xs-4" align="right">
							<span>￥50&nbsp;&nbsp;</span>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="container-fluid row" style="height: 50px">
			<table style="width: 100%; height: 100%">
				<tr>
					<td
						style="background-color: #428bca; width: 50%; text-align: center">
						<a href="#" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1"> <span
							class="glyphicon glyphicon-chevron-up" style="color: #ffffff">工时费:￥100</span></a>
					</td>
					<td
						style="width: 50%; text-align: center; background-color: #d9534f">
						<div>
							<!-- 							<a href="order.html" type="button" -->
							<!-- 					class="btn btn-lg btn-danger">下一步</a> -->
							<a href="order.html" style="color: #ffffff">下一步</a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</nav>

	<!-- Bootstrap core JavaScript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>


	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>



	<script src="bootstrap-3.3.0/docs/asstes/js/docs.min.js"></script>




	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="bootstrap-3.3.0/docs/asstes/js/ie10-viewport-bug-workaround.js"></script>



	<!-- Analytics
================================================== -->
	<script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
			: " http://");
	document
			.write(unescape("%3Cscript src='"
					+ _bdhmProtocol
					+ "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));
		
	/* $(document).ready(function(){  
		$.ajax({
			async : false,
			url : "querySelf.html",
			type : "get",
			dataType : "json",
			success : function(data) {
				$.each(data, function(index, value) {
					var categoryid = "category"+value.id;
					var li = "<li role='presentation' class=''><a href='#"+categoryid+"' id='"+categoryid+"' role='tab' data-toggle='tab' aria-controls='home' aria-expanded='true'><span style='font-size: small'><b>"+
					value.name+"</b></span><span class='badge'>3</span></a></li>";
					var divClass = "tab-pane fade";
					if(index==0){
						divClass+=" in active";
					}
					var categoryDiv = "<div role='tabpanel' class='"+divClass+"' id='"+
					categoryid+"' aria-labelledBy='"+categoryid+"-tab'>";
					$.each(value.items, function(index2, item) {
						var itemdiv =  "<div><input type='checkbox' value='' id='check1' /><span>&nbsp;&nbsp;"+
						item.name+"</span></div>";
	 					categoryDiv+=itemdiv+"</div>";
					});
					$("#upkeepItems").append(categoryDiv);
					$("#upkeepCategory").append(li);
				});
			}
		});
	});  */
	
		
		function carModel() {
			window.location.href = "carModel.html"
		}

		function check() {
			if ($("#check1").prop("checked")) {
				$("#check1").prop("checked", false);
			} else {
				$("#check1").prop("checked", true);
			}
		}
		function regular() {
			window.location.href = "maintenance.html";
		}
	</script>
</body>
</html>
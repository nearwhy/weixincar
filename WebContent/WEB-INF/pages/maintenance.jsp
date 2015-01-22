<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>常规保养</title>
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


<!-- BEGIN THEME STYLES -->
<!--    <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css"/> -->
<!--[if lt IE 9]><script src="bootstrap-3.3.0/docs/asstes/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="bootstrap-3.3.0/docs/asstes/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicons -->
<link rel="apple-touch-icon" href="/apple-touch-icon.png">
<link rel="icon" href="/favicon.ico">
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">

	<div class="page-container">

		<div class="jumbotron" style="background-color: #428bca">
			<h1 style="color: #ffffff">帮您节省￥200</h1>
			<p style="color: #ffffff">
				目前行驶10000公里，我们建议您进行<a href="#" tabindex="0"
					class="btn btn-danger bs-docs-popover" role="button"
					data-toggle="popover" data-trigger="focus"
					title="Dismissible popover"
					data-content="And here's some amazing content. It's very engaging. Right?"><u>常规保养</u></a>
			</p>

			<span style="color: #ffffff">您也可以选择其他保养方式</span> <br>
			<div class="btn-group">
				<button type="button" class="btn btn-danger">
					<span class="glyphicon glyphicon-wrench">深度保养</span>
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-zoom-in">大保养</span>
				</button>
				<button type="button" class="btn btn-warning" onclick="self();">
					<span class="glyphicon glyphicon-cog">自助保养</span>
				</button>
			</div>
		</div>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">润滑系统保养</div>
			<!-- List group -->
			<ul class="list-group">
				<li class="list-group-item">
					<div>
						<table style="width: 100%">
							<tr>
								<td width="5%" style="vertical-align: center">
									 <label> <input type="checkbox"
										value="">
									</label>
								</td>
								<td width="45%" style="vertical-align: center">
								<img src="img/qiaopai.jpg" width="100%" class="img-responsive"
									alt="Responsive image" /></td>
								<td width="50%">
									<h4 class="media-heading">更换发动机机油</h4>
									<p>工时费:￥50</p> <span style="color: red; font-size: large">￥138.0</span>
								<del>￥168.0</del>
									<div>
										建议购买:
										<div class="btn-group">
											<button type="button" class="btn btn-default btn-xs">
												<span class="glyphicon glyphicon-plus"></span>
											</button>
											<button type="button" class="btn btn-default btn-xs">
												<b>1</b>
											</button>
											<button type="button" class="btn btn-default btn-xs">
												<span class="glyphicon glyphicon-minus"></span>
											</button>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>

					<div>
						<a href="productDetail.html"><span>壳牌（Shell）黄壳黄喜力HX5
								10W-40 4L 矿物油 润滑油 SN级</span></a>

					</div>
					<div align="right">
						<span style="color:red">还有5件同类商品，您可以选择</span>
						<button type="button" class="btn btn-primary" onclick="change();">更换</button>

					</div>
				</li>
				<li class="list-group-item">
					<div>
						<table style="width: 100%">
							<tr>
								<td width="5%" style="vertical-align: center">
									 <label> <input type="checkbox"
										value="">
									</label>
								</td>
								<td width="45%" style="vertical-align: center">
								<img src="img/baohuji.jpg" width="100%" class="img-responsive"
									alt="Responsive image" /></td>
								<td width="50%">
									<h4 class="media-heading">发动机油泥清洗</h4>
									<p>工时费:￥20</p> <span style="color: red; font-size: large">￥138.0</span>
								<del>￥168.0</del>
									<div>
										建议购买:
										<div class="btn-group">
											<button type="button" class="btn btn-default btn-xs">
												<span class="glyphicon glyphicon-plus"></span>
											</button>
											<button type="button" class="btn btn-default btn-xs">
												<b>1</b>
											</button>
											<button type="button" class="btn btn-default btn-xs">
												<span class="glyphicon glyphicon-minus"></span>
											</button>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>

					<div>
						<a href="productDetail.html"><span style="font-size:medium;">发动机曲轴箱&油底壳清洗油 (赠送滤芯)</span></a>

					</div>
					<div align="right">
						<span style="color:red">还有3件同类商品，您可以选择</span>
						<button type="button" class="btn btn-primary" onclick="change();">更换</button>

					</div>
				</li>
			</ul>
		</div>
		<br> <br>
	</div>

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
						style="background-color: #428bca; width: 60%; text-align: center">
						<a href="#" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1"> <span
							class="glyphicon glyphicon-chevron-up" style="color: #ffffff">总价:1100，工时费:￥100</span></a>
					</td>
					<td
						style="width: 40%; text-align: center; background-color: #d9534f">
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
			function self(){
				window.location.href="self.html";
			}
			
			function change(){
				window.location.href="change.html";
			}
		</script>
</body>
</html>
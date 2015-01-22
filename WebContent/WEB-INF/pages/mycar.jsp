<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>我的车型库</title>
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
		<div class="list-group">
			<a href="#" class="list-group-item active">我的车型库</a> <a href="#"
				class="list-group-item" data-toggle="modal"
				data-target=".bs-example-modal-sm">
				<div class="row">
					<div class="col-xs-4 col-md-4">
						<img src="img/mini.jpg" alt="" width="100" height="80"></img>
					</div>
					<div class="col-xs-7 col-md-6">
						<h5>Mini Cooper clubman自动1.6 2010cheer</h5>
					</div>
					<div class="col-xs-1 col-md-2">
						<span class="glyphicon glyphicon-ok"></span>
					</div>
				</div>
			</a> <a href="#" class="list-group-item" data-toggle="modal"
				data-target=".bs-example-modal-sm">
				<div class="row" align="right">
					<div class="col-xs-4 col-md-4">
						<img src="img/macan.jpg" alt="" width="100" height="70"></img>
					</div>
					<div class="col-xs-8 col-md-8">
						<h5>2014款 3.6L Macan Turbo</h5>
					</div>
				</div>
			</a>
		</div>
		
		<div class="container-fluid">
			<div align="center">
				<a href="carBrand.html" type="button" class="btn btn-primary btn-lg btn-block">新增一种车型</a>
			</div>
			<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
	
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="mySmallModalLabel">mini cooper</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-6" align="center">
									<button type="button" class="btn btn-lg btn-success">设为当前车型</button>
								</div>
								<div class="col-xs-6" align="center">
									<button type="button" class="btn btn-lg btn-danger">移除此车型</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		<!-- /.modal -->
		</div>
	</div>

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
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>
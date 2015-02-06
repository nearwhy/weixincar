<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script
	src="bootstrap-3.3.0/docs/asstes/js/ie-emulation-modes-warning.js"></script>

<link rel="apple-touch-icon" href="/apple-touch-icon.png">
<link rel="icon" href="/favicon.ico">
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<div class="page-container">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<br>
			<div class="container">
				<div class="btn-group btn-group-justified" role="group"
					aria-label="...">
					<div class="btn-group" role="group">
						<a href="index.html" type="button" class="btn btn-lg btn-default">返回首页</a>
					</div>
					<div class="btn-group" role="group">
						<a href="carBrand.html" type="button"
							class="btn btn-primary btn-lg">新增一种车型</a>
					</div>
				</div>
			</div>
		</nav>
		<br>
		<div class="list-group">
			<a href="#" class="list-group-item disabled">我的车型库</a>

			<c:forEach items="${cars}" var="car">
				<a href="#" onclick="choose('${car.model}','${car.id}');"
					class="list-group-item" data-toggle="modal"
					data-target=".bs-example-modal-sm">
					<div class="row">
						<div class="col-xs-4 col-md-4">
							<img src="img/mini.jpg" alt="" width="100" height="80"></img>
						</div>
						<div class="col-xs-7 col-md-6">
							<p>${car.type}</p>
							<h5>${car.model}</h5>
						</div>
						<c:if test="${car.isused==1}">
							<div class="col-xs-1 col-md-2">
								<span class="glyphicon glyphicon-ok"></span>
							</div>
						</c:if>
					</div>
				</a>
			</c:forEach>
		</div>

		<div class="container-fluid">
			<div class="modal fade bs-example-modal-sm" tabindex="-1"
				role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="mySmallModalLabel"></h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<input type="hidden" id="carId" name="carId" value="" />
								<div class="col-xs-6" align="center">
									<button type="button" class="btn btn-lg btn-success"
										onclick="setMyCar();">设为当前车型</button>
								</div>
								<div class="col-xs-6" align="center">
									<button type="button" class="btn btn-lg btn-danger"
										onclick="removeMyCar();">移除此车型</button>
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
		document.addEventListener("WeixinJSBridgeReady", function() {
			WeixinJSBridge.call("showToolbar")
		});

		function choose(model, id) {
			$("#carId").val(id);
			$("#mySmallModalLabel").text(model);
		}

		function setMyCar() {
			// 			$("#setForm").submit();
			$.ajax({
				type : "POST",
				url : "setMyCar.html",
				data : "carId=" + $("#carId").val(),
				success : function(msg) {
					window.location.reload();
				}
			});
		}

		function removeMyCar() {
			$.ajax({
				type : "POST",
				url : "removeMyCar.html",
				data : "carId=" + $("#carId").val(),
				success : function(msg) {
					window.location.reload();
				}
			});
		}
	</script>
</body>
</html>
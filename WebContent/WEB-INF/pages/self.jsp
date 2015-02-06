<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div class="list-group">
			<c:forEach items="${upkeeps}" var="category">
				<a href="#" class="list-group-item disabled">${category.name}</a>
				
				<c:forEach items="${category.items}" var="item">
				
							<a href="#"  class="list-group-item" data-toggle="modal" onclick="check('check${item.id}')"
								data-target=".bs-example-modal-sm">
					<div class="row">
						<div class="col-xs-8" align="left"><input
												type="checkbox" value="${item.id}" id="check${item.id}" name="${item.name}"/><span>&nbsp;&nbsp;${item.name}</span>
						</div>
						<div class="col-xs-4" align="right">
							<span>工时费：￥50</span>
						</div>
					</div>
					</a>
				</c:forEach>
			</c:forEach>
		</div>
	<br>
	<br>
	<nav class="navbar navbar-default navbar-fixed-bottom"
		role="navigation">
		<div class="container-fluid row" style="height: 50px">
			<table style="width: 100%; height: 100%">
				<tr>
					<td
						style="background-color: #428bca; width: 50%; text-align: center">
						<span  style="color: #ffffff;font-size: large">工时费:￥0</span>
					</td>
					<td
						style="width: 50%; text-align: center; background-color: #d9534f">
						<div>
							<!-- 							<a href="order.html" type="button" -->
							<!-- 					class="btn btn-lg btn-danger">下一步</a> -->
							<a href="order.html" ><span  style="color: #ffffff;font-size: large">下一步</span></a>
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
		
		function carModel() {
			window.location.href = "carModel.html"
		}

		function check(id) {
			if ($("#"+id).prop("checked")) {
				$("#"+id).prop("checked", false);
			} else {
				$("#"+id).prop("checked", true);
			}
		}
		function regular() {
			window.location.href = "maintenance.html";
		}
		
	</script>
</body>
</html>
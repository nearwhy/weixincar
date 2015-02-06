<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>新增车型</title>
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

		<!-- 		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"> -->
		<!-- 			<br> -->
		<!-- 			<div class="container"> -->
		<!-- 				<div class="input-group input-group-lg"> -->

		<!-- 					<input type="text" class="form-control" placeholder="车型搜索" id="keyword" -->
		<!-- 						aria-describedby="sizing-addon1"><span -->
		<!-- 						class="input-group-btn"><button data-toggle="collapse" -->
		<!-- 						data-target="#bs-example-navbar-collapse-1" -->
		<!-- 						class="btn btn-lg btn-primary" type="button" onclick="search();"> <span -->
		<!-- 							class="glyphicon glyphicon-search" id="sizing-addon1"></span> -->
		<!-- 					</button> </span> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 			<div class="collapse navbar-collapse" -->
		<!-- 				id="bs-example-navbar-collapse-1" style="background-color: #fff"> -->
		<!-- 				<div class="list-group" id="result"> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 			<br> -->
		<!-- 		</nav> -->
		<!-- 		<br> <br> <br> <br> -->
		<div class="list-group">
			<a href="#" class="list-group-item disabled">常见品牌</a>
			<div class="list-group-item" data-toggle="modal"
				data-target=".bs-example-modal-sm" align="center">
				<table style="width: 100%">
					<tr>
						<td width="25%"><a href="#"><img
								src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4045731028,2567955621&fm=58"
								width="30" height="30" /> <span style="font-size: small;">大众</span>
						</a></td>
						<td width="25%"><a href="#"> <img
								src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3848676162,2275127538&fm=58"
								width="30" height="30" /> <span style="font-size: small;">宝马</span>
						</a></td>
						<td width="25%"><a href="#"> <img
								src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4046265244,2439220531&fm=58"
								width="30" height="30" /> <span style="font-size: small;">奔驰</span>
						</a></td>
						<td width="25%"><a href="#"> <img
								src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3922137418,2189335648&fm=58"
								width="30" height="30" /> <span style="font-size: small;">奥迪</span>
						</a></td>
					</tr>
				</table>
			</div>

			<c:forEach items="${letters }" var="letter">
				<a href="#" class="list-group-item disabled"><b>${letter.key}</b></a>
				<c:forEach items="${letter.value}" var="brand" varStatus="i">
					<c:if test="${i.index % 3 == 0}">
						<div class="list-group-item" data-toggle="modal"
							data-target=".bs-example-modal-sm" align="center">
							<table style="width: 100%">
								<tr>
									</c:if>

									<td width="33%" onclick="carType('${brand}');"><img
										src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3922137418,2189335648&fm=58"
										width="30" height="30" /><span>&nbsp;&nbsp;${brand}</span></td>

									<c:if test="${i.index % 3 == 2 or i.last}">
								</tr>
							</table>
						</div>
					</c:if>
				</c:forEach>
			</c:forEach>
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
		var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cscript src='"
						+ _bdhmProtocol
						+ "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));

		function carType(brand) {
			window.location.href = "carType.html?brand=" + brand;
		}

		function search() {
			$("#result").empty();
			$.ajax({
				async : false,
				url : "searchCar.html?keyword=" + $("#keyword").val(),
				type : "get",
				dataType : "json",
				success : function(data) {
					$.each(data, function(index, value) {
						product = value.product;
						var item = "<a href='#' class='list-group-item'>"
								+ value.type + value.model + "</a>";
						$("#result").append(item);
					});

				}
			});
		}
	</script>
</body>
</html>
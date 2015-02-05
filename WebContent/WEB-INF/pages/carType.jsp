<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>选择车型</title>
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
		<c:forEach items="${firms}" var="firm">
				<a href="#" class="list-group-item disabled">${firm.key}</a>
				
				<c:forEach items="${firm.value}" var="type">
					<a href="#" onclick="carModel('${type}');" class="list-group-item" data-toggle="modal"
						data-target=".bs-example-modal-sm"> <img
						src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3922137418,2189335648&fm=58"
						width="30" height="30" /><span>&nbsp;&nbsp;${type}</span></a>
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
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));

	function carModel(type){ 
		window.location.href="carModel.html?type="+type; 
	} 
</script>
</body>
</html>
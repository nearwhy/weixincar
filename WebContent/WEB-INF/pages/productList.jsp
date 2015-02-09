<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>更换商品</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional Bootstrap Theme -->
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="bootstrap-3.3.0/docs/assets/css/patch.css" rel="stylesheet">
<!-- Documentation extras -->
<link href="bootstrap-3.3.0/docs/asstes/css/src/docs.min.css" rel="stylesheet">
<!-- BEGIN THEME STYLES --> 
<!--    <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css"/> -->
<!--[if lt IE 9]><script src="bootstrap-3.3.0/docs/asstes/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="bootstrap-3.3.0/docs/asstes/js/ie-emulation-modes-warning.js"></script>
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
	  <ul class="list-group" id="list">
		  <c:if test="${type == 'upkeepItem' }">
		    <li class="list-group-item disabled" >
		    	<h4 class="media-heading">更换发动机机油</h4>	
		    </li>
		  </c:if>
		  <c:forEach items="${products }" var="product" varStatus="p">
		  	<li class="list-group-item" onclick="productDetail('${product.id}');">	
		    		<div class="media">
					  <a class="media-left" href="#">
					    <img src="img/qiaopai.jpg" width="100px"  alt="...">
					  </a>
					  <div class="media-body">
						<span style="color:#428bca">${product.name }</span><br>
					    <span style="color:red;font-size: large">￥${product.price }&nbsp;&nbsp;</span><del>￥:${product.oldPrice }</del>
					  </div>
		    		</div>
		    </li>
		  </c:forEach>
	  </ul>
	  <!-- 
	  <div align="center">
	  	<a href="#new"><span class="glyphicon glyphicon-menu-down" onclick="more();">显示更多</span></a>
	  </div> 
	   --> 
	  <br>
</div>
	
	<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.0/docs/asstes/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap-3.3.0/docs/asstes/js/ie10-viewport-bug-workaround.js"></script>
<!-- Analytics================================================== -->
<script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));

	function productDetail(productId){
		window.location.href="productDetail.html?productId=" + productId;
	}
	
</script>
</body>
</html>
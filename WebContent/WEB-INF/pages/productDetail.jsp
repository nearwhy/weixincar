<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>商品详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
<link rel="stylesheet" href="assets/plugins/revolution_slider/css/rs-style.css" media="screen">
<link rel="stylesheet" href="assets/plugins/revolution_slider/rs-plugin/css/settings.css" media="screen">
<link href="assets/plugins/bxslider/jquery.bxslider.css" rel="stylesheet" />
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
<link href="assets/css/themes/blue.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="media/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="media/css/style.css" rel="stylesheet" type="text/css" />
<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
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
		<!-- BEGIN REVOLUTION SLIDER -->
		<div class="fullwidthbanner-container slider-main" style="height:200px">
			<div class="fullwidthabnner" >
				<ul id="revolutionul" style="display: none;">
					<li data-transition="fade" data-slotamount="7" data-masterspeed="700" data-delay="3400">
						<img src="img/qiaopai.jpg" alt="" height="200" width="100%">
					</li>
					<li data-transition="fade" data-slotamount="7" data-masterspeed="300" data-delay="3400">
						<img src="assets/img/posts/img1.jpg" alt="" height="200px" width="100%">
					</li>
				</ul>
			</div>
		</div>
		<div class="well row">
			<p style="color:#428bca">${product.name }</p>
			<table width="100%">
				<tr>
					<td width="30%">
						<span style="color:red;font-size: large">￥${product.price }</span></td>
					<td width="40%">
						<span>4S店:￥${product.oldPrice }</span></td>
					<td width="30%">
						<span>已售120件</span></td>
				</tr>
			</table>
		</div>	
				<span  class="glyphicon glyphicon-pushpin" ></span>
				<p class="bg-info">
					<span style="font-size: small;">&nbsp;&nbsp;${product.description }</span>
				</p>
		<table class="table table-striped">
			<thead>
		        <tr>
		          <th><span>规格参数</span></th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:forEach items="${params }" var="productParam" >
		    		<tr>
						<td width="40%" style="text-align: left">
							<span>${productParam.paramKey }</span>
						</td>
						<td width="60%" style="text-align: right">
							<span>${productParam.paramValue }</span>
						</td>
					</tr>
		    	</c:forEach>
		    </tbody>
		</table>
		<div align="center">
			<a href="#bottom" id="check"><span class="glyphicon glyphicon-hand-down" onclick="detail();">查看详情</span></a>
		</div>
		<div id="detail" name="bottom">
		
		</div>
		<br>
		<br>
	</div>		
	<!-- END COPYRIGHT -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->
	<script src="assets/plugins/jquery-1.10.2.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="assets/plugins/hover-dropdown.js"></script>
	<script type="text/javascript" src="assets/plugins/back-to-top.js"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS(REQUIRED ONLY FOR CURRENT PAGE) -->
	<script type="text/javascript"
		src="assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
	<script type="text/javascript"
		src="assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"
		src="assets/plugins/bxslider/jquery.bxslider.min.js"></script>
	<script src="assets/scripts/app.js"></script>
	<script src="assets/scripts/index.js"></script>

	<script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();    
            App.initBxSlider();
            Index.initRevolutionSlider();                    
        });
        
        function detail(){
        	$("#check").hide();
        	$('<img src="img/detail.jpg" class="img-responsive" alt="Responsive image">').appendTo("#detail");
        	$("#detail").focus();
        }
    </script>
</body>
</html>
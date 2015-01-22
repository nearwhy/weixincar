<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Aero商圈管理</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

   <!-- BEGIN GLOBAL MANDATORY STYLES -->          
   <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
   <!-- END GLOBAL MANDATORY STYLES -->
   
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet" />              
   <link rel="stylesheet" href="assets/plugins/revolution_slider/css/rs-style.css" media="screen">
   <link rel="stylesheet" href="assets/plugins/revolution_slider/rs-plugin/css/settings.css" media="screen"> 
   <link href="assets/plugins/bxslider/jquery.bxslider.css" rel="stylesheet" />                
   <!-- END PAGE LEVEL PLUGIN STYLES -->

   <!-- BEGIN THEME STYLES --> 
   <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/themes/blue.css" rel="stylesheet" type="text/css" id="style_color"/>
   <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
   <!-- END THEME STYLES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

   <link rel="shortcut icon" href="favicon.ico" />
   
   <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen" type="text/css">

<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://v3.bootcss.com/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://v3.bootcss.com/docs-assets/css/docs.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/highlight.js/7.3/styles/github.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<div class="page-container">
	<!-- BEGIN REVOLUTION SLIDER -->    
        <div class="fullwidthbanner-container slider-main">
            <div class="fullwidthabnner">
                <ul id="revolutionul" style="display:none;">            
                        <!-- THE FIRST SLIDE -->
                        <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="3400" data-thumb="assets/img/sliders/revolution/thumbs/thumb2.jpg">
                            <!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
                            
                            <img src="assets/img/pics/img1-medium.jpg" alt="">
                            
                        </li>

                        <!-- THE SECOND SLIDE -->
                        <li data-transition="fade" data-slotamount="7" data-masterspeed="300" data-delay="3400" data-thumb="assets/img/sliders/revolution/thumbs/thumb2.jpg">                        
                            <img src="assets/img/posts/img1.jpg" alt="">
                            

                        </li>
                        
                        
                </ul>
            </div>
        </div>
        <!-- END REVOLUTION SLIDER -->
        <p>
        <div class="container-fluid">
        	  <div class="bs-example bs-example-control-sizing">
			    <form role="form">
			      <div class="controls">
			        <input class="form-control input-lg" type="text" placeholder=".input-lg">
			        <input type="text" class="form-control" placeholder="Default input">
			        <input class="form-control input-sm" type="text" placeholder=".input-sm">
			
			        <select class="form-control input-lg">
			          <option value="">.input-lg</option>
			        </select>
			        <select class="form-control">
			          <option value="">Default select</option>
			        </select>
			        <select class="form-control input-sm">
			          <option value="">.input-sm</option>
			        </select>
			      </div>
			    </form>
			  </div><!-- /.bs-example -->
	        <div class="row">
			  <div class="col-xs-6 col-md-6" align="right">
			  	<div class="tile bg-white selected">
			  	<a href="mycar.html">
						<div class="tile-body">
							<img src="img/mini.jpg" class="color-img" alt="" />
						</div>
						<div class="tile-object">
							<div class="name">
								<h5><span style="color: #000000">Mini cooper</span></h5>
							</div>
							<div class="number">
								121
							</div>
						</div>
						</a>
					</div>
					<div class="tile bg-red"> 
						<div class="tile-body">
							<i class="fa fa-tags"></i>
						</div>
						<div class="tile-object">
							<div class="name">
								<h4>优惠</h4>
							</div>
						</div>
					</div>
              </div>
			  <div class="col-xs-6 col-md-6" align="center">
						<a href="regular.html" class="icon-btn">
										<i class="fa fa-wrench"></i>
										<div><h5>常规保养</h5></div>
										<span class="badge badge-important">2</span>
									</a>
									<a href="#" class="icon-btn span4">
										<i class="fa fa-cogs"></i>
										<div><h5>大保养</h5>s</div>
										<span class="badge badge-success">4</span>
									</a>
									<a href="#" class="icon-btn span3">
										<i class="fa fa-search"></i>
										<div><h5>深度保养</h5></div>
									</a>
									<a href="#" class="icon-btn span3">
										<i class="fa fa-coffee"></i>
										<div><h5>自助保养</h5></div>
									</a>
									
			  </div>
			</div>
		</div>
    </div>
	
	<nav class="navbar navbar-inverse navbar-fixed-bottom" >
<!--   <div class="container-fluid" style="background-color: #000000"> -->
<!--       <ul class="nav navbar-nav" style="width:100%;text-align: center"> -->
<!--         <li class="active"><a href="#"><i class="fa fa-home"></i><span>首页</span></a></li> -->
<!--         <li ><a href="#"><i class="fa fa-coffee"></i><span>配件</span></a></li> -->
<!--         <li ><a href="#"><i class="fa fa-shopping-cart"></i><span>购物车</span></a></li> -->
<!--         <li style="background-color: #e3e3e3"><a href="#"><i class="fa fa-user"></i><span>我</span></a></li> -->
<!--       </ul> -->
<!--     </div> -->

  <div class="container-fluid" style="height:50px">
	<table  style="width:100%;height:100%">
		<tr>
			<td style="background-color:#ffffff;width:25%;text-align: center"><div><i class="fa fa-home" style="color:#000000"></i></div><div><span style="color:#000000">首页</span></div></td>
			<td style="width:25%;text-align: center"><div><i class="fa fa-tags" style="color:#ffffff"></i></div><div><span style="color:#ffffff">特惠</span></div></td>
			<td style="width:25%;text-align: center"><div><i class="fa fa-shopping-cart" style="color:#ffffff"></i></div><div><span style="color:#ffffff">购物车</span></div></td>
			<td style="width:25%;text-align: center"><div><i class="fa fa-user" style="color:#ffffff"></i></div><div><span style="color:#ffffff">我</span></div></td>
		</tr>
	</table>
	</div>
</nav>
     <!-- END COPYRIGHT -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->  
    <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script type="text/javascript" src="assets/plugins/hover-dropdown.js"></script>
    <script type="text/javascript" src="assets/plugins/back-to-top.js"></script>    
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS(REQUIRED ONLY FOR CURRENT PAGE) -->
    <script type="text/javascript" src="assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>  
    <script type="text/javascript" src="assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="assets/plugins/revolution_slider/rs-plugin/js/jquery.themepunch.revolution.min.js"></script> 
    <script type="text/javascript" src="assets/plugins/bxslider/jquery.bxslider.min.js"></script>
    <script src="assets/scripts/app.js"></script>
    <script src="assets/scripts/index.js"></script> 
    
    <script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();    
            App.initBxSlider();
            Index.initRevolutionSlider();                    
        });
    </script>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>BBS</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../../bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../../../bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">

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
<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>


<style>

.container {
	width: 100%;
}
</style>
</head>
<body>

	<div class="container-fluid alert alert-info" >
		
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
							<button type="button" class="navbar-toggle navbar-brand" data-toggle="collapse" 
							data-target="#bs-example-navbar-collapse-10">
					            <span class="icon-bar"></span>
					            <span class="icon-bar"></span>
					            <span class="icon-bar"></span>
					          </button>
						<h4 style="color:#ffffff" class="navbar-brand ">班级论坛</h4>
						<button type="button" class="navbar-toggle navbar-brand" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-9">
							<span style="color:#ffffff" class="glyphicon glyphicon-pencil"></span>
						</button>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-10">
					<ul class="nav navbar-nav">
							<li><a href="javascript:photo()">班级相册</a></li>
							<li><a href="javascript:bbs()">班级论坛</a></li>
							<li><a href="#" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-news">我的消息&nbsp;<span class="badge pull-right">3</span></a></li>
					</ul>
			</div>
			
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-news">
					<ul class="nav navbar-nav">
							<li><a href="#">明天上午8点开会...</a></li>
							<li><a href="#">发送短信到....</a></li>
							<li><a href="#">好好学学，天天向上</a></li>
					</ul>
			</div>
			
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<form aciton="/subject.do" method="POST" id="sub_form">
					<ul class="nav navbar-nav">
						<li><input name="title" type="text" class="form-control"
							placeholder="标题（必填）"></li>
							<br>
						<li><textarea name="text" class="form-control" rows="10"></textarea>
						</li><br>
						<input type="hidden" id="openId" name="openId"
							value=" ${param.openId}">
						<li>
							<div class="btn-group btn-group-justified">
								<a href="#" id="sub_btn" class="btn btn-primary btn-lg"
									role="button">提交</a>
							</div>
						</li>
					</ul>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
		<div id="bbs">
		
		</div>
		<div id="photo">
		
		</div>
	</div>

	<script type="text/javascript" src="../../../bootstrap/js/holder.js"></script>

	<script type="text/javascript">
		$(function(){
			bbs();
		});
		function bbs() {
			$.getJSON(
							"http://app.airport360.com.cn/subList.do",
							function(data) {
								if (data != null) {
									$("#bbs").empty();
									$("#photo").empty();
									$
											.each(
													data,
													function(n, value) {

														var sub = "<div class='panel panel-default'><div class='panel-body'><a href='http://app.airport360.com.cn/test.do?jsp=demo/detail.jsp&sid="
																+ value.sid
																+ "&openId=${param.openId}'><h5><strong>"
																+ value.title
																+ "</strong></h5><p>"
																+ value.text
																+ "</p></div></a><div class='panel-footer'><div class='row'><div class='col-xs-6 col-md-6'><a href='#'><span class='glyphicon glyphicon-user'>&nbsp;</span></a><small class='text-primary'>"
																+ value.user
																+ "</small></div><div class='col-xs-6 col-md-6 text-right'><small class='text-primary'>评论</small>&nbsp;<span class='badge'>"
																+ value.count
																+ "</span></div></div></div></div>";
														$("#bbs").append(sub);
													});
								}
							});
		}
		$("#sub_btn").click(
				function() {
					$("#sub_form").attr("action",
							"http://app.airport360.com.cn/subject.do");
					$("#sub_form").submit();
				});
		
		function photo(){
			$("#bbs").empty();
			$("#photo").empty();
			$.getJSON("http://app.airport360.com.cn/show.do",function(data){
				$.each(data,function(n,value){
					var img = "<a href='#' class='list-group-item'><img src='"+value.pic+"' style='max-width:100%;'><span>"+value.content+"</span></a>";
					$("#photo").append(img);
				});
			});
		}
	</script>
</body>
</html>
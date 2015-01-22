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
</style>
</head>
<body>
	<div class="container-fluid" id="body">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-inner">
				<div class="container">
				<h4 style="color:#FFFFE0" id="title"></h4>
				</div>
			</div>

		</nav>
		<nav class="navbar navbar-inverse navbar-fixed-bottom"
			role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->

			<div class="navbar-inner">
				<div class="container">

					<div class="row">
						<div class='col-xs-9 col-md-6'>
							<form class="navbar-search pull-left" id="sub_form"  method="POST">
								<input type="text" name="text" class="form-control input-lg"
									placeholder="说点什么..."> <input type="hidden" id="openId"
									name="openId" value=" ${param.openId}"> <input
									type="hidden" id="sid" name="sid" value=" ${param.sid}">
							</form>
						</div>
						<div class='col-xs-3 col-md-6'>
							<ul class="nav pull-right">
								<button id="sub_btn" type="submit"
									class="btn btn-default btn-lg">回复</button>
							</ul>
						</div>
					</div>
				</div>
			</div>

		</nav>
		<br>
		<br>
		<div class="container">
		<span style="color:#000000" class='glyphicon glyphicon-user' id="user">&nbsp;</span><small>
				</small><small style="color:#000000">2014 05-23:12:13</small>
				<br>
		<span id="sub"></span></div>
		
		<br>
		<hr/>
		<div id="review" style="text-align:center;">
		
		</div>
		<script type="text/javascript" src="../../../bootstrap/js/holder.js"></script>
		<script type="text/javascript">
			$(function() {
				var url = "http://app.airport360.com.cn/subDetail.do?sid="
						+ "${param.sid}";
				$.getJSON(url,function(data) {
									if (data != null) {
										$("#title").append(data.sub.title);
										$("#user").append(data.sub.user);
										$("#sub").append(data.sub.text);
										var table = "<table class='table'><tbody>";
										var size = "0";
										if (data.review != null) {
											size = data.review.length;
											var tr = "";
											$.each(data.review,	function(n, value) {
																tr += "<div class='row' ><div class='col-xs-6 col-md-6'>&nbsp;<a href='#'><span class='glyphicon glyphicon-user '>&nbsp;</span></a><small class='text-primary'>"
																		+ value.user
																		+ "</small></div><div class='col-xs-6 col-md-6 text-right'><span class='label label-default'>"+n+"楼&nbsp</span></div></div><div><span>"
																		+ value.text
																		+ "</span></div><hr/>";
															});
											tr+="<br><br>";
											$("#body").append(tr);
											table += tr;
											
										}
										table += "</tbody></table>";
										var review = "<div class='panel panel-info'><div class='panel-heading'><small class=''>评论</small>&nbsp;<span class='badge'>"
												+ size
												+ "</span></div><div class='panel-body'><div class='bs-example-type'>"
												+ table + "</div></div></div>";
									}
								});
			});

			$("#sub_btn").click(function(){
				$("#sub_form").attr("action","http://app.airport360.com.cn/review.do");
				$("#sub_form").submit();
			});
		</script>
</body>
</html>
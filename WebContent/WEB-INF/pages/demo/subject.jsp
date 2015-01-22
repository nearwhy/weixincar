<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>发表主题</title>
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
.navbar-default {
	background-color: #fff;
}
</style>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="navbar-inner text-center">
				<h3>发表主题</h3>
			</div>
		</nav>
		<br> 
		
		<form class="well" aciton="/subject.do" method="POST" id="sub_form">
		<input name="title" type="text" class="form-control" placeholder="标题（必填）">
		<br>
		<textarea name="text" class="form-control" rows="8"></textarea>
		<br>
    <input type="hidden" id="openId" name="openId" value=" ${param.openId}">
		<div class="btn-group btn-group-justified">
		<a href="#" id="sub_btn" class="btn btn-primary btn-lg"  role="button">提交</a>
		</div>
		</form>
		
	<script type="text/javascript">
		$("#sub_btn").click(function(){
			$("#sub_form").attr("action","http://app.airport360.com.cn/subject.do");
			$("#sub_form").submit();
		});
	</script>
	</div>

	<script type="text/javascript" src="../../../bootstrap/js/holder.js"></script>

</body>
</html>
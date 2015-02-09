<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>配件分类</title>
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
<style type="text/css">
	a{color:#000}
</style>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<div class="page-container">
		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<c:forEach items="${categorys }" var="category" varStatus="i">
					<div class="panel panel-default">
					<c:choose>
						<c:when test="${i.index  == 0}">
							<div class="panel-heading" role="tab" id="heading${i.index }">
								<table data-toggle="collapse" data-parent="#accordion" href="#collapse${i.index }"  aria-expanded="true" aria-controls="collapse${i.index }">
									<tr>
										<td width="20%"><img src="img/client_1.png" width="100%" alt="..."></td>
										<td width="5%"></td>
										<td width="75%"><h5 class="media-heading">${category.pCategoryName }</h5> <span>${category.hotCategory }</span></td>
									</tr>
								</table>
							</div>
							<div id="collapse${i.index }" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${i.index }">
								<ul class="list-group">
									<c:forEach items="${category.childCategorys }" var="chilCcategory" >
										<li class="list-group-item"><a href="#" onclick="javascript:showProducts('${chilCcategory.pCategoryId}')">${chilCcategory.pCategoryName }</a></li>
									</c:forEach>
								</ul>
							</div>
						</c:when>
						<c:otherwise>
							<div class="panel-heading" role="tab" id="heading${i.index }">
								<table class="collapsed"  data-toggle="collapse" data-parent="#accordion" href="#collapse${i.index }"  aria-expanded="false" aria-controls="collapse${i.index }">
									<tr>
										<td width="20%"><img src="img/client_1.png" width="100%" alt="..."></td>
										<td width="5%"></td>
										<td width="75%"><h5 class="media-heading">${category.pCategoryName }</h5> <span>${category.hotCategory }</span></td>
									</tr>
								</table>
							</div>
							<div id="collapse${i.index }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${i.index }">
								<ul class="list-group">
									<c:forEach items="${category.childCategorys }" var="chilCcategory" >
										<li class="list-group-item"><a href="#" onclick="javascript:showProducts('${chilCcategory.pCategoryId}')">${chilCcategory.pCategoryName }</a></li>
									</c:forEach>
								</ul>
							</div>
						</c:otherwise>
					</c:choose>
					</div>
				</c:forEach>
				
				
			
		</div>
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
		document.write(unescape("%3Cscript src='" + _bdhmProtocol+ "hm.baidu.com/h.js%3Fbdb993b828cbe079a7fbc1a951f44726' type='text/javascript'%3E%3C/script%3E"));
		
		function showProducts(categoryId){
			window.location.href="showProducts.html?categoryId="+categoryId;
		}
	</script>
</body>
</html>
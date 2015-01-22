<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<script src='<s:url value="/media/js/jquery-1.10.1.min.js"></s:url>' type="text/javascript"></script>
<script src='<s:url value="/media/js/jquery-migrate-1.2.1.min.js"></s:url>' type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src='<s:url value="/media/js/jquery-ui-1.10.1.custom.min.js"></s:url>' type="text/javascript"></script>
<script src='<s:url value="/media/js/bootstrap.min.js"></s:url>' type="text/javascript"></script>
<!--[if lt IE 9]>
<script src='<s:url value="/media/js/html5shiv.js"></s:url>'></script>
<script src='<s:url value="/media/js/excanvas.min.js"></s:url>'></script>
<script src='<s:url value="/media/js/respond.min.js"></s:url>'></script> 
<![endif]-->  
<!--[if !IE]><!--> 
<html lang="en" class="no-js"> 
<!--<![endif]--> 
<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  
<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="media/js/index.js" type="text/javascript"></script>
<script src="media/js/app.js" type="text/javascript"></script>      
<!-- END PAGE LEVEL SCRIPTS -->  
<script type="text/javascript">
jQuery(document).ready(function() {    
	   App.init(); // initlayout and core plugins
	   Index.init();
});
</script>
<!-- END JAVASCRIPTS -->
<script type="text/javascript">
	var _gaq = _gaq || [];  
	_gaq.push(['_setAccount', 'UA-37564768-1']);  
	_gaq.push(['_setDomainName', 'keenthemes.com']);  
	_gaq.push(['_setAllowLinker', true]);  
	_gaq.push(['_trackPageview']);  
	(function() {    
		var ga = document.createElement('script'); 
		ga.type = 'text/javascript'; 
		ga.async = true;    
	//	ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  
	})();
</script>



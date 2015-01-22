<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src='<s:url value="/media/js/jquery-1.10.1.min.js"></s:url>' type="text/javascript"></script>
<script type="text/javascript">
var	_menus = null;
$(function(){
	$.ajax({
		type: "post", //以post方式与后台沟通 
    	url : 'menu/getMenus.html',
    	dataType:'json',
    	data: 'mainMenu=menus', //参数
    	success: function(json){//如果调用服务成功
    		var str = json[0].menus;
			_menus = jQuery.parseJSON(str);
			InitMenu();
    	}
	});
	
	function InitMenu(){
    	var menulist ='';
		menulist +='<ul class="page-sidebar-menu">';
		//menulist +='	<li></li>';
		menulist += '	<li class="start active "> <a href="#"> <i class="icon-home"></i>  <span class="title">首页</span> </a> </li>';
		for(var menu in _menus.menus){
			menulist += '<li class=""> <a href="javascript:;">';
			menulist += '	<span class="title">' + _menus.menus[menu].menuname + '</span>';
			menulist += '	<span class="arrow"></span> </a>';
			var menuItems=_menus.menus[menu].menus;
			if(menuItems.length>0){
				menulist+='<ul class="sub-menu">';
				for(var items in menuItems){
					var divId = menuItems[items].url.substring(menuItems[items].url.lastIndexOf("/") + 1,menuItems[items].url.indexOf("."));
					menulist+='<li id="' + divId + '_list_menu">';
					menulist+='<a href="' + menuItems[items].url + '">' + menuItems[items].menuname + '</a>';
					menulist+='</li>';
				}
				menulist+='</ul></li>';
			}
		}
		menulist+="</ul>";
		$("#menu").append(menulist);
	}
	
	//菜单
	
});
</script>
<div id="menu" class="page-sidebar nav-collapse collapse">
			
</div>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xml:lang="ja" lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>明るい部屋</title>
		<link href="<html:rewrite page="./css/cart.css" />" rel="stylesheet" type="text/css" />	  
		<link href="<html:rewrite page="./css/base.css" />" rel="stylesheet" type="text/css" />	  
		<script src="<html:rewrite page="/js/prototype.js" />" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/scriptaculous.js" />" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/common.js" />" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/tabs.js"/>" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/searchform.js"/>" type="text/javascript"></script>
		<tiles:get name="head" ignore="true" />
	</head>
	<body onload="common_on_load(); if(window['on_load']){on_load();} return false;" onunload="if(window['on_unload']){ on_unload(); }; return false;" class="yui-skin-sam"  >
			<div id="wrapper">

						<div id="header">
						<h1><img src="images/cartlogo.gif" alt="MALTA" width="850" height="48" />
						
						</h1>
							<ul class="clearfix">
							<li id="n01"><a href="#" class="overImg"><img src="images/icons/navi_01.gif" alt="WELCOME" width="121" height="14" /></a></li>
							<li id="n02"><a href="#" class="overImg"><img src="images/icons/navi_02.gif" alt="PRODUCT" width="118" height="14" /></a></li>
							<li id="n03"><a href="#" class="overImg"><img src="images/icons/navi_03.gif" alt="GUIDE" width="78" height="14" /></a></li>
							<li id="n04"><a href="#" class="overImg"><img src="images/icons/navi_04.gif" alt="My PAGE" width="112" height="14" /></a></li>
							<li id="n05"><a href="#"><img src="images/icons/navi_05_on.gif" alt="CART" width="70" height="14" /></a></li>
							<li id="n06"><a href="#" class="overImg"><img src="images/icons/navi_06.gif" alt="CONTACT" width="116" height="14" /></a></li>
							<li id="n07"><a href="#" class="overImg"><img src="images/icons/navi_07.gif" alt="BLOG" width="76" height="14" /></a></li>
							<li id="n08"><a href="#" class="overImg"><img src="images/icons/navi_08.gif" alt="ATELIER" width="112" height="14" /></a></li>
							</ul>
							
				<tiles:get name="header" />
			</div>
			<div id="contentsArea" >
				<tiles:get name="content" />
		     </div>
		    
			<%--<div id="status">
				<ul>
					<tiles:useAttribute name="status" />
					<logic:iterate id="item" name="status" >
						<tiles:insert beanName="item" flush="false" />
					</logic:iterate>
				</ul>
			</div>
			<div id="content">
				<table class="layout" border="0">
				<tbody>
				<tr>
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<td>
						<tiles:get name="content" />
		     </div>
			<div class="pubbottom">&nbsp;</div>
					</td>
				</tr>
				</tbody>
				</table>
			</div>
			<div id="footer_push">
			</div>
		</div>
		<div id="footer" align="center">
			<tiles:get name="footer" />
				<div align="center">
				<table cellspacing="0" cellpadding="0" border="0" align="center" style="margin-bottom:10px">
					<tr>
						<td style="padding-right:10px">
							Copyright(c) 2008 Numabooks. All Rights Reserved.
						</td>
					</tr>
				</table>		
			</div>--%>
			
		</div>
	</body>
</html>

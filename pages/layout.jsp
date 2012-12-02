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
		<title><tiles:get name="title" /></title>
		<link href="<html:rewrite page="/base.css" />" rel="stylesheet" type="text/css" />	  
		<link href="<html:rewrite page="/css/lightbox.css" />" rel="stylesheet" type="text/css" />
		<script src="<html:rewrite page="/js/prototype.js" />" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/scriptaculous.js?load=effects,builder" />" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/tabs.js"/>" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/searchform.js"/>" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/lightbox.js"/>" type="text/javascript"></script>
		<script src="<html:rewrite page="/js/common.js" />" type="text/javascript"></script>
		<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-8036873-1");
pageTracker._trackPageview();
} catch(err) {}</script>
		
		
		
		<tiles:get name="head" ignore="true" />
	</head>
	<body  class="yui-skin-sam"  >
			<div id="wrapper">

						<div id="header">
						<h1><img src="images/logo.gif"  /></h1>
						<%--<h1><img src="images/logo.gif" alt="MALTA" width="850" height="108" /></h1>--%>
						<p id="logout"><input name="" type="button" value="ログアウト" /></p>
						<ul class="clearfix">
						<li class="first"><a href="Products.do">商品一覧</a></li>
						<li><a href="PostProductDetail.do">商品登録</a></li>
						<li><a href="PostCarriageDetail.do">送料設定</a></li>
						<li><a href="Purchases.do">購入履歴一覧</a></li>
						<li><a href="PublicUsers.do">顧客一覧</a></li>
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

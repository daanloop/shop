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
<html xmlns="
	
	











<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
<meta charset="UTF-8" />
<title>africaandleo</title>
<link rel="profile" href="http://gmpg.org/xfn/11" />
<link href="/shop/style.css" rel="stylesheet" type="text/css" />
<link rel="pingback" href="http://africaandleo.com/xmlrpc.php" />
<link rel="alternate" type="application/rss+xml" title="africaandleo &raquo; Feed" href="http://africaandleo.com/?feed=rss2" />
<link rel="alternate" type="application/rss+xml" title="africaandleo &raquo; Comments Feed" href="http://africaandleo.com/?feed=comments-rss2" />
<link rel="alternate" type="application/rss+xml" title="africaandleo &raquo; Home Comments Feed" href="http://africaandleo.com/?feed=rss2&#038;page_id=2" />
<link rel='stylesheet' id='login-with-ajax-css'  href='http://africaandleo.com/wp-content/plugins/login-with-ajax/widget/widget.css?ver=3.4.2' type='text/css' media='all' />
<link rel='stylesheet' id='simplr-forms-style-css'  href='http://africaandleo.com/wp-content/plugins/simplr-registration-form/simplr_reg.css?ver=3.4.2' type='text/css' media='all' />
<script type='text/javascript' src='http://africaandleo.com/wp-includes/js/jquery/jquery.js?ver=1.7.2'></script>
<script type='text/javascript' src='http://africaandleo.com/wp-content/plugins/login-with-ajax/widget/login-with-ajax.js?ver=3.4.2'></script>
<script type='text/javascript' src='http://africaandleo.com/wp-includes/js/comment-reply.js?ver=3.4.2'></script>
<link rel="EditURI" type="application/rsd+xml" title="RSD" href="http://africaandleo.com/xmlrpc.php?rsd" />
<link rel="wlwmanifest" type="application/wlwmanifest+xml" href="http://africaandleo.com/wp-includes/wlwmanifest.xml" /> 
<link rel='next' title='About Us' href='http://africaandleo.com/?page_id=7' />
<meta name="generator" content="WordPress 3.4.2" />
<link rel='canonical' href='http://africaandleo.com/' />
 <!-- Add 27 Nov -->
    <link href="/shop/contents.css" rel="stylesheet" type="text/css" />
<!-- End -->
<script src="http://africaandleo.com/wp-content/themes/africaandleo/js2/jquery-1.6.js" type="text/javascript"></script>
<script src="http://africaandleo.com/wp-content/themes/africaandleo/js2/jquery.jqzoom-core.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://africaandleo.com/wp-content/themes/africaandleo/css/jquery.jqzoom.css" type="text/css">

<style type="text/css">
   .clearfix:after{clear:both;content:".";display:block;font-size:0;height:0;line-height:0;visibility:hidden;}
.clearfix{display:block;zoom:1}

ul#thumblist {
    display: block;
    margin: 10px 0 0;
}
ul#thumblist li{float:left;margin-right:2px;list-style:none;}
ul#thumblist li a{display:block;}
ul#thumblist li a.zoomThumbActive{
   
}

.jqzoom{

    text-decoration:none;
    float:left;
}		
	
		
</style>
<script type="text/javascript">

$(document).ready(function() {
    $('.jqzoom').jqzoom({
            zoomType: 'standard',
            lens:true,
            preloadImages: false,
            alwaysOn:false
        });
    
});


</script>
</head>

<body>
<div id="wrapper" class="hfeed">
	<div id="header">
		<div id="masthead">
			<div id="branding" role="banner">
				<div id="logo">
						<a href="http://africaandleo.com/" title="africaandleo" rel="home"><img src="http://africaandleo.com/wp-content/themes/africaandleo/images/logo.jpg" alt="africaandleo"/></a>
					</div>
				
  <div id="leftMenu">     
 <!-- <div id="topMenu" class="menu-top-container"> 
 <ul id="menu-top" class="menu">
<li id="menu-item-102" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-102"><a href="http://africaandleo.com/?page_id=97">Shopping Bag</a></li>
<li id="menu-item-103" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-103"><a href="http://africaandleo.com/?page_id=99">Check Out</a></li>
</ul></div> -->

             <!--     <div class="search"><form role="search" method="get" id="searchform" action="http://africaandleo.com/">
    <div><label class="screen-reader-text" for="s">Search for:</label>
        <input type="text" value="" name="s" id="s" />
        <input type="submit" id="searchsubmit" value="Search" />
    </div>
</form></div>-->
                
 </div>
			</div><!-- #branding -->
            <div id="access" role="navigation">
              <div class="menu-header">
						<ul class="clearfix">
						<li><a href="Purchases.do">購入履歴一覧</a></li>
						<li><a href="PublicUsers.do">顧客一覧</a></li>
						</ul>

			</div>
	</div>
             
			<!-- #access -->
		</div><!-- #masthead -->
	</div><!-- #header -->




				<tiles:get name="header" />
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

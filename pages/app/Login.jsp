<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page isELIgnored="false" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<link href="base.css" rel="stylesheet" type="text/css">
</head>

<body id="toppage">
                <div id="log_in_form">

<c:if test="${!empty message}">
<font color="red">
<!-- ${message} -->
${message}
</font><br>
</c:if>
			        <html:form action="/Login.do" method="post">
					<table width="100%" border="0" cellspacing="5" cellpadding="0">
					  <tr>
					    <td><p class="summary">account</p></td>
					  </tr>
					  <tr>
					    <td><input name="account" type="text" size="45"></td>
					  </tr>
					  <tr>
					    <td><p class="summary">パスワード</p></td>
					  </tr>
					  <tr>
					    <td><input name="password" type="password" size="45"></td>
					  </tr>
					  <tr>
					    <td><img src="img/spacer.gif" alt="" width="1" height="20"></td>
					  </tr>
					  <tr>
					    <td><p align="center">
					        <input type="submit" name="Submit" value="　ログイン　">
							<img src="img/spacer.gif" alt="" width="15" height="1">
							<input name="リセット" type="reset" value="　リセット　">
					        </p>	</td>
					  </tr>
					</table>
					</html:form>
			    </div>

</div>

</body>
</html:html>



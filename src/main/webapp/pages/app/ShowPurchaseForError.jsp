<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/formtag.tld" prefix="formtag" %> 
<%@ taglib uri="/clientsidevalidation.tld" prefix="f" %> 
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page isELIgnored="false" %>

<tiles:insert definition=".publicLayout">
	<tiles:put name="title" value="##japanese##" direct="true" />
	<tiles:put name="content" direct="true">
		<div id="errorContentsArea" class="clearfix">
			<h2><img src="images/error.gif" alt="ERROR"></h2>
			<c:if test="${!empty error}">
			<p class="upper">
				${error}			
			</p>
			</c:if>
			<p class="under">
				<a href="#contact"><img src="images/bt_contact.gif" alt="CONTACT" class="left"></a>
				<a href="index.html#"><img src="images/bt_netshop.gif" alt="NETSHOP"></a>
			</p>
		</div>
		<!-- contentsArea end -->	
	</tiles:put>
</tiles:insert>
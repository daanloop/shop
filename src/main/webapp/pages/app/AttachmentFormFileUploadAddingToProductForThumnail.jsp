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


<tiles:insert definition=".layout">
	<tiles:put name="title" value="配送料" direct="true" />
	<tiles:put name="content" direct="true">
			<form method="POST" action="AttachmentFormFileUploadAddingToProduct.do" enctype="multipart/form-data">
		  		<input type="file" name="formFile" />
				<input type="hidden" name="product" value="${form.id}" />
				<html:submit value="追加"/>
			</form>
	</tiles:put>
</tiles:insert>
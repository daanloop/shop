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
<?xml version="1.0" encoding="UTF-8" ?>
<prml version="2.0.0" type="text/prml">
   <product>
       <id>${item.product.id}
       <name>${item.product.name}</name>
   </product>
   <name>${item.name}</name>
   <maindetailimage>ShowImage.do?id=${item.defaultattachment.id}</maindetailimage>
   <detailedimages>
   <c:forEach items="${item.detailed}" var="detailed">
      <detailedimage>ShowImage.do?id=${detailed.id}</detailimage
      </c:forEach> 
   </detailedimages>
	<price>${item.pricewithtax}</price>
   <size>
	${item.size}
	</size>
	<material>
	${item.size}
	</material>
</prml>

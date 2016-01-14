<?xml version="1.0" encoding="UTF-8" ?>
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
<%@ taglib uri="http://www.enclosing.net/tags/storyteller" prefix="st" %>
<%@ page isELIgnored="false" %>
<%@ page import="net.malta.model.*" %>

<%@ page import="net.malta.web.utils.MainItem" %>
<prml version="2.0.0" type="text/prml">
<%--<bean:define id="product"  name="${product}"></bean:define>--%>
<c:forEach items="${mainitem.product.items}" var="item" >
<scene id="${item.id}" name="image${item.id}" cls="maltavdotsec.ImageScene" >
<stock num="${item.stocknum}">${item.name}</stock>
<c:choose>
<c:when test="${item.main}">
<main>1</main>
</c:when>
<c:otherwise>
<main>0</main>
</c:otherwise>
</c:choose>
<productNo>${item.no}</productNo>
<productName>${mainitem.product.name}</productName>
<category>${mainitem.product.category.name}</category>
<detailedimages>
<c:if test="${!empty item.defaultattachment}">
<detailedimage>ShowImage.do?id=${item.defaultattachment.id}</detailedimage>
</c:if>
<c:forEach items="${item.detailed}" var="detailed">
<detailedimage>ShowImage.do?id=${detailed.id}</detailedimage>
</c:forEach>
</detailedimages>
<variationList>
<c:forEach items="${mainitem.product.items}" var="item2">
<variation name="image${item2.id}">${item2.name}</variation>
</c:forEach>
</variationList>
<price>￥${item.pricewithtax}</price>
<size>${item.size}</size>
<material>${item.material}</material>
<body>${item.description}</body>
<caption>${item.note}</caption>
</scene>
</c:forEach>
</prml>








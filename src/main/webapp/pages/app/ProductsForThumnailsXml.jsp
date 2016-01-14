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

<thumbnailList>
<c:forEach items="${products}" var="product">
<c:set var="product" value="${product}"></c:set>
<jsp:useBean id="product" class="net.malta.model.ProductImpl" />
<c:set var="mainItem" value='<%= MainItem.Of(product,application) %>' />
<thumbnail id="${mainItem.id}" name="image${mainItem.id}" >
<c:choose>
<c:when test="${mainItem.stocknum eq 0}">
<category>SOLDOUT</category>
</c:when>
<c:otherwise>
<category>${product.category.name}</category>
</c:otherwise>
</c:choose>
<c:choose>
<c:when test="${!empty product.thumnail}">
<imageurl>ShowImage.do?id=${product.thumnail.id}</imageurl>
</c:when>
<c:otherwise>
<imageurl>ShowImage.do?id=</imageurl>
</c:otherwise>
</c:choose>
</thumbnail>
</c:forEach>
</thumbnailList>

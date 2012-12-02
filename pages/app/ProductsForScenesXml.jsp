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

<%--<?xml version="1.0" encoding="UTF-8" ?>--%>
<prml version="2.0.0" type="text/prml">
	<c:forEach items="${products}" var="product">
	<%--<bean:define id="product"  name="${product}"></bean:define>--%>
	
		<c:forEach items="${product.items}" var="item" >
		<scene id="${item.id}" name="image${item.id}" cls="maltavdotsec.ImageScene" >
		<c:choose>
			<c:when test="${item.main}">
			  <main>1</main>
			</c:when>
			<c:otherwise>
			  <main>0</main>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
		<c:when test="${!empty product.slideshow}">
					<slideshowurl>ShowImage.do?id=${product.slideshow.id}</slideshowurl>
		</c:when>
		<c:otherwise>
					<slideshowurl>ShowImage.do?id=</slideshowurl>
		</c:otherwise>
		</c:choose>
			
			<productNo>${item.no}</productNo>
			<productName>${product.name}</productName>
<%--			
			<c:set var="product" value="${product}"></c:set>
			<jsp:useBean id="product" class="net.malta.model.ProductImpl" />
			<c:set var="mainItem" value='<%= MainItem.Of(product,application) %>' />
--%>			<%--<stocknum><%= product.getName() %>${mainItem.name}</stocknum>--%>
	<%--		<c:choose>
				<c:when test="${mainItem.stocknum eq 0}">
							<category>SOLDOUT</category>
				</c:when>
				<c:otherwise>
	--%>					<category>${product.category.name}</category>
		<%--		</c:otherwise>
			</c:choose>
--%>
			
			
		<c:choose>
		<c:when test="${!empty product.thumnail}">
					<imageurl>ShowImage.do?id=${product.thumnail.id}</imageurl>
		</c:when>
		<c:otherwise>
					<imageurl>ShowImage.do?id=</imageurl>
		</c:otherwise>
		</c:choose>
			
			

			<!-- 画像まわり -->
			<%--<maindetailimage>ShowImage.do?id=${item.defaultattachment.id}</maindetailimage>--%>
 		    <detailedimages>
						<c:if test="${!empty item.defaultattachment}">
						<detailedimage>ShowImage.do?id=${item.defaultattachment.id}</detailedimage>
						</c:if>
				<c:forEach items="${item.detailed}" var="detailed">
			        <detailedimage>ShowImage.do?id=${detailed.id}</detailedimage>
				</c:forEach>
		    </detailedimages>
		   <zoomimage>ShowImage.do?id=${item.zoom.id}</zoomimage>
			
			
		    <!-- バリエーション -->
		    <variationList>
			<c:forEach items="${product.items}" var="item2">
			   <variation name="image${item2.id}">${item2.name}</variation>
			</c:forEach>
            </variationList>
            
            
            <!-- 表示項目 -->
			<price>￥${item.pricewithtax}</price>
			<size>${item.size}</size>
			<material>${item.material}</material>
			<body>${item.description}</body>
			<caption>${item.note}</caption>
		</scene>
		</c:forEach>
	</c:forEach>
</prml>

		
<%--			<mainitem>
			   <name>${mainItem.name}</name>
				<maindetailimage>ShowImage.do?id=${mainItem.defaultattachment.id}</maindetailimage>
	 		    <detailedimages>
					<c:forEach items="${mainItem.detailed}" var="detailed}">
				        <detailedimage>ShowImage.do?id=${detailed.id.id}</detailimage>
					</c:forEach>
			    </detailedimages>
			   <zoomimage>ShowImage.do?id=${mainItem.zoom.id}</zoomimage>
			</mainitem>
--%>









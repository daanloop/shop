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
<%@ taglib uri="/formtag.tld" prefix="formtag" %> 
<%@ taglib uri="/clientsidevalidation.tld" prefix="f" %> 
<%@ page isELIgnored="false" %>
<%@ page import="net.malta.web.utils.MainItem" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="製品" direct="true" />
	<tiles:put name="content" direct="true">
		<div>
			<p><img src="categoryimgs/${param.category}.jpg" alt="" width="939" height="216" /></p>
		</div>
		<div id="mainContents">
	
			<div class="categoryBox">
				<c:forEach var="row" items="${products}">
					<div class="shopEntry">
						<div>
								<c:set var="product" value="${row}"></c:set>
								<jsp:useBean id="product" class="net.malta.model.ProductImpl" />
								<c:set var="mainItem" value='<%= MainItem.Of(product,application) %>' />
							<p class="englishName">${row.name}</p>
							<p class="photo"><a href="ShowProduct.do?id=${row.id}"><img src="ShowImage.do?id=${row.thumnail.id}" alt="" width="147" height="148" /></a></p>
							<p>${mainItem.name}</p>
							<p>
								￥<fmt:formatNumber value="${mainItem.pricewithtax}" pattern="###,###,###"/>（税込）
							</p>
						</div>
					</div>
				</c:forEach>
			</div><!-- categoryBox end -->
			<p class="ordermade">オーダーメイドのご注文はこちら<a href="information/order/index.html"><img src="images/akarui/bt_go (2).gif" alt="Go" width="67" height="22" /></a></p>
		</div><!-- mainContents end -->

	</tiles:put>
</tiles:insert>



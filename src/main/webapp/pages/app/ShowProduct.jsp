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
<%@ page import="net.malta.web.utils.MainItem" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="##japanese##" direct="true" />
	<tiles:put name="content" direct="true">

		<div id="detailContents">
			<c:set var="mainItem" value='<%= MainItem.Of(request.getAttribute("product"),application)%>' />			
			<div class="detailEntry clearfix">
				<div class="leftBox">
					<p><img src="ShowImage.do?id=${mainItem.defaultattachment.id}" id="placeholder" alt="" width="390" height="390" /></p>
					<div class="controlArea clearfix">
					<p id="imagegallery" class="icon clearfix">
						<c:forEach var="row" items="${mainItem.detailed}">
							<a href="ShowImage.do?id=${row.id}" class="overImg">
								<img src="images/akarui/bt_ico.gif" alt="" width="18" height="18" />
							</a>
						</c:forEach>
					<p>
					<p class="link">
						<c:if test="${!empty prev}">					
							<a href="ShowProduct.do?id=${prev.id}">
								<img src="images/akarui/bt_prev (2).gif" alt="PREV" width="25" height="41" />
							</a>
						</c:if>
						<a href="ProductList.do?category=${product.category.id}">
							<img src="images/akarui/bt_menu.gif" alt="MENU" width="33" height="41" />
						</a>
						<c:if test="${!empty next}">
							<a href="ShowProduct.do?id=${next.id}">
								<img src="images/akarui/bt_next (2).gif" alt="NEXT" width="25" height="41" />
							</a>
						</c:if>		
					</p>
					</div>
				</div><!-- leftBox end -->
				<div class="rightBox">
					<p>${product.no}</p>
					<p class="title"><strong> ${product.name}/ ${mainItem.name}</strong></p>
					
					<p class="price"><strong>￥<fmt:formatNumber value="${mainItem.pricewithtax}" pattern="###,###,###"/></strong></p>
					<table border="0" id="shopdetail">
					<tr>
					<th>サイズ</th>
					<td>${mainItem.size}</td>
					</tr>
					<tr>
					<th>花　材</th>
					<td>${mainItem.material}</td>
					</tr>
					<tr>
					<th>配送料</th>
					
					<td>全国一律<fmt:formatNumber value="${mainItem.carriage.value}" pattern="###,###,###"/>円</td>
					</tr>
					</table>
					<p class="catchcopy"><strong>${mainItem.catchcopy}</strong></p>
					<p class="story">${mainItem.description}</p>
					<form name="form1" action="PostChoiseVP.do?item=${mainItem.id}" method="post">
                    <c:if test="${mainItem.stocknum >= 1}">
					<p class="cart">数量
                    <select name="ordernum" id="select">
                    	<c:forEach var="i" begin="1" end="${mainItem.stocknum}" step="1">
                        	<option value="${i}">${i}</option>
        	            </c:forEach>
                    </select>
					<a onclick="document.form1.submit();"><img src="images/akarui/bt_cart.gif" alt="カートに入れる" width="107" height="25" /></a>
					</c:if>
					</p>
					</form>
					<p class="caption">
					${mainItem.note}<br />
<%--					※この商品には別途【箱代＋配送料】がかかります。（全国一律800円）<br />
					
					※使用する花材・器およびサイズは、イメージ写真と若干異なる場合がございますので、予めご了承下さい。<br />
					※生花を使ったアレンジメントをできるだけ長くお楽しみいただく為のお手入れ法を記載した「お手入れの栞」をおつけいたします。<br />
					※ご希望の方には、明るい部屋オリジナルのクリスマスカードを無料でお付けいたします。</p>
--%>				</div><!-- rightBox end -->
			</div><!-- detailEntry end -->
		</div><!-- detailContents end -->


	</tiles:put>
</tiles:insert>

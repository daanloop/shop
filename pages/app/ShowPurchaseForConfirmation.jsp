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
<%@ page import="net.malta.web.utils.DeliveryAddressItem"%>
<%@ taglib uri="http://www.enclosing.net/tags/storyteller" prefix="st" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="net.malta.model.DeliveryAddress"%>
<%@ page import="net.malta.model.Purchase"%>
<%@ page isELIgnored="false" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="明るい部屋" direct="true" />
	<tiles:put name="content" direct="true">

<%@ include file="/pages/PurchaseBoxTop.jsp" %>
	
	<div class="cartTxt clearfix">
	<c:if test="${!empty error}">
		<font color="red">
			<st:error key="error"/>
		</font><br>
	</c:if>
	<p class="change"><a href="PostPublicUserDetail.do?id=${u.id}">お客様情報変更</a></p>
	<p>お客様情報をご確認ください。</p>
	</div>

		<table class="formArea">
			<thead>
			<tr>
				<th colspan="6" class="fontSmaller">お客様情報</th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<th>お名前＊</th>
					<td>${u.name}</td>
				</tr>
				<tr>
					<th>フリガナ＊</th>
				<td>${u.kana}</td>
				</tr>
			<tr>
			<th>郵便番号＊</th>
			<td>${u.zipfour}</td>
			</tr>
			<tr>
			<th>都道府県＊</th>
			<td>${u.prefecture.name}</td>
			</tr>
			<tr>
			<th>住所１＊</th>
			<td>${u.address}</td>
			</tr>
			<tr>
			<th>住所2</th>
			<td>${u.buildingname}</td>
			</tr>
			<tr>
			<th>メールアドレス＊</th>
			<td>${u.mail}</td>
			</tr>
			<tr>
			<th>電話番号＊</th>
			<td>${u.phone}</td>
			</tr>
			<tr>
			<th>FAX 番号</th>
			<td>${u.fax}</td>
			</tr>
			</tbody>
			</table>
			
			
			<c:if test="${deliverymethod eq 1}">
			<table class="formArea">
			<thead>
			<tr>
				<th colspan="6" class="fontSmaller">&nbsp;</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<th>ギフトカードの有無</th>
				<td>
					<c:choose>
						<c:when test="${u.hasgiftcard}">
							ギフトカード有	
						</c:when>
						<c:otherwise>
							ギフトカード無
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
			<th>ギフトカードの種類</th>
			<td>${u.giftCard.name}</td>
			</tr>
			<tr>
			<th>配達希望日</th>
			<td><p><st:date date="${u.preferreddatedate}" /></p>
			</td>
			</tr>
			<tr>
			<th>配達希望時間</th>
			<td>${u.preferredtime}</td>
			</tr>
			<tr>
			<th>備考欄</th>
			<td>${u.pref}</td>
			</tr>
			</c:if>
			</tbody>
		</table>
	
	
<div class="cartTxt">
<p>決済方法をお選び下さい。</p>
</div>

    <html:form method="GET" action="/PostPurchaseVPChoosingPaymentMethod">
    <input type="hidden" name="deliverymethod" value="${param.deliverymethod}" />
     <table>
     	<thead>
				<tr>
				<th class="fontSmaller">&nbsp;</th>
				<th class="fontSmaller">決済名</th>
				<th class="fontSmaller">備考</th>
				</tr>
				</thead>	
     	<c:forEach var="paymentMethod" items="${PaymentMethods}">	
     			<tbody>
					<tr>
					<td class="price" width="5px" ><input type="radio" name="paymentMethod" value="${paymentMethod.id}"  id="card" /></td>
					<td style="padding-top:6px"><label for="card">${paymentMethod.name}</label></td>
					<td ><a href="./terms/index.html#pay" target="_blank">${paymentMethod.note}</a></td>
					</tr>
				</tbody>
		</c:forEach>
	</table>
		<div class="action">
			<p class="caption">※銀行振込については注文完了になります</p>
			<!-- <ul class="clearfix">-->
			<!--<li class="rev">-->
			<input name="" type="button" onclick="location.href='PostPublicUserDetail.do'" value="前へ戻る" />
			<!-- </li>-->
			<!--<li class="nxt">--><input name="" type="submit" value="先に進む" /><!--</li>-->
			<!-- </ul>-->
		</div>				
	
		    		<%--<c:forEach var="paymentMethod" items="${PaymentMethods}">
			    		<input type="radio" name="paymentMethod" value="${paymentMethod.id}" />${paymentMethod.name}<br />
					</c:forEach>
          		<html:submit value="save"/>
--%>			</html:form>
		
  <div class="paypal_btn">
		     <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" name="frm2" target="_blank" >
             <input type="hidden" name="cmd" value="_cart">
             <input type="hidden" name="upload" value="1">
             <input type="hidden" name="business" value="ppp_1353760180_biz@hotmail.com">
             <input type="hidden" name="currency_code" value="US">
             <c:forEach items="${purchase.choises}" var="choise" varStatus="loop"> 
             <input type="hidden" name="item_name_${loop.index+1}" value="${choise.item.product.name}">
             <input type="hidden" name="quantity_${loop.index+1}" value="1">
             <input type="hidden" name="amount_${loop.index+1}" value="${choise.pricewithtax}">
              </c:forEach> 
             <input type="hidden" name="return" value="http://africaandleo.com/shop/ShowPurchaseForThanks.do">
             &nbsp;<input type="image" src="http://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" onclick="document.frm2.submit();" height="22" alt="Paypal CheckOut">
             </form>
  </div>
		
		
<!-- 	<div id="sslTxt" class="clearfix"> -->
<!-- 		<p class="seal"><span id="ss_img_wrapper_100-50_flash_ja"> -->
<!-- 		<a href="http://jp.globalsign.com/" target=_blank> -->
<!-- 		<img alt="SSL　グローバルサインのサイトシール" border=0 id="ss_img" src="//seal.globalsign.com/SiteSeal/images/gs_noscript_100-50_ja.gif"></a></span> -->
<!-- 		<script type="text/javascript" src="//seal.globalsign.com/SiteSeal/gs_flash_100-50_ja.js"></script></p> -->
<!-- 		<p class="txt">当サイトでは、実在性の証明とプライバシー保護のため、グローバルサインのSSLサーバ証明書を使用し、SSL暗号化通信を実現しています。サイトシールのクリックにより、サーバ証明書の検証結果をご確認ください。</p> -->
<!-- 	</div> -->

    

	</tiles:put>
</tiles:insert>

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

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="配送先" direct="true" />
	<tiles:put name="content" direct="true">
	
	
<div id="mainContents" class="clearfix">
<div id="leftContents">
<h3><img src="images/step_title.gif" alt="Shopping Cart" width="153" height="23" /></h3>
<ul>
<li><img src="images/step_01.gif" alt="STEP1.カートの確認" width="100" height="43" /></li>
<li><img src="images/step_02.gif" alt="STEP2.お客様情報の入力" width="121" height="43" /></li>
<li><img src="images/step_03_on.gif" alt="STEP3.お届け先の入力・設定" width="145" height="43" /></li>
<li><img src="images/step_04.gif" alt="STEP4.ご注文内容の確認/お支払い方法の設定" width="145" height="60" /></li>
<li><img src="images/step_05.gif" alt="STEP5.完了" width="145" height="43" /></li>
</ul>
</div><!-- leftContents end -->
<div id="rightContents">

	<c:if test="${!empty purchase}">
		<div class="cartTxt clearfix">
		<p class="txt">現在、カートには以下の商品が入っています。ご確認ください。
		<ul class="clearfix">
		<li class="change"><a href="ShowPurchase.do">カート内容の変更</a></li>
		<li><a href="index.jsp">お買い物を続ける</a></li>
		</ul>
		</p>
		</div>
		<table>
			<thead>
			<tr>
				<th colspan="2" class="fontSmaller">商品</th>
				<th class="fontSmaller">単価（税込）</th>
				<th class="fontSmaller">数量</th>
				<th class="fontSmaller">小計（税込）</th>
				
			</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${purchase.choises}" var="choise">
				<tr>
					<td class="photo"><img src="ShowImage.do?id=${choise.item.defaultattachment.id}" alt="" width="60" height="60" /></td>
					<td class="price">${choise.item.name}</td>
				
					<td class="price">￥<fmt:formatNumber value="${choise.pricewithtax}" pattern="###,###,###"/></td>
					<td class="price">${choise.ordernum}</td>
					<td class="price">￥<fmt:formatNumber value="${choise.item.pricewithtax}" pattern="###,###,###"/></td>
				</tr>
			</c:forEach>
			<tr class="total">
					<td colspan="4" class="title">商品合計（税込）</td>
					<td class="price">￥<fmt:formatNumber value="${purchase.total}" pattern="###,###,###"/></td>
			</tr>
			</tbody>
		</table>
	</c:if>	
		<div class="cartTxt clearfix">
			<h2><strong>お届け先の入力・設定</strong></h2>
			<p class="txt">送付先一覧</p>
		</div>
		
		<table>
			<thead>
			<tr>
<%--				<th class="fontSmaller">No.</th>
--%>			<th class="fontSmaller">お名前</th>
			<th class="fontSmaller">住所</th>
			<th class="fontSmaller">電話番号</th>
			<th class="fontSmaller">処理</th>
			</tr>
			</thead>
			<tbody>
				<c:choose>
				<c:when test="${!empty deliveryAddresss}">
				<c:forEach var="row" items="${deliveryAddresss}">
					<tr>
	<%--					<td class="price">${row.id}</td>
	--%>					<td>${row.name}</td>
						<td>${row.address}</td>
						<td>${row.phone}</td>
					<form method="post" action="PostDeliveryAddressDetail.do?id=${row.id}">
						<input type="hidden" name="edit" value="y"/>
						<td class="price"><input type="submit" name="button" id="button" value="変更" />
						<input type="button" name="button" id="button" onclick="location.href='DeleteDeliveryAddress.do?id=${row.id}'" value="削除" /></td>
					</form>	
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<tr>
					<td colspan="5" class="price">送付先が登録されていません</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		

		<div class="action">
			<p><input name="" type="button" onclick="location.href='PostDeliveryAddressDetail.do'" value="お届け先の追加" /></p>
			<ul class="clearfix">
				<li class="rev"><input name="" type="button" onclick="location.href='PostPublicUserDetail.do'" value="前へ戻る" /></li>
				<li class="nxt"><input name="" type="button" onclick="location.href='DeliveryAddressChoiseList.do'" value="商品振り分け画面へ" /></li>
			</ul>
		</div>
		
		</form>
<div id="sslTxt" class="clearfix">
		<p class="seal"><span id="ss_img_wrapper_100-50_flash_ja">
		<a href="http://jp.globalsign.com/" target=_blank>
		<img alt="SSL　グローバルサインのサイトシール" border=0 id="ss_img" src="//seal.globalsign.com/SiteSeal/images/gs_noscript_100-50_ja.gif"></a></span>
		<script type="text/javascript" src="//seal.globalsign.com/SiteSeal/gs_flash_100-50_ja.js"></script></p>
		<p class="txt">当サイトでは、実在性の証明とプライバシー保護のため、グローバルサインのSSLサーバ証明書を使用し、SSL暗号化通信を実現しています。サイトシールのクリックにより、サーバ証明書の検証結果をご確認ください。</p>
</div>
		
</div><!-- rightContents end -->
</div><!-- mainContents end -->
	</tiles:put>
</tiles:insert>



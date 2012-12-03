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

   <tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="content" direct="true">

<c:if test="${!empty param.zerostock}">
    <p style="color:red"><b>その商品は売り切れです。</b></p>
</c:if>

<h2></h2>
<p>ご注文内容をご確認の上、[購入手続きへ進む]ボタンをクリックしてください。<br />
他の商品もご注文されるお客さまは、[お買い物を続ける]をクリックして前のページに戻ってお選びください。</p>


	<table class="purchaseTbl">
		<thead>
		<tr>
			<th colspan="2" class="fontSmaller">商品</th>
			<th class="fontSmaller">単価（税込）</th>
			<th class="fontSmaller">数量</th>
			<th class="fontSmaller">送料</th>
			<th class="fontSmaller">小計（税込）</th>
			<th class="del fontSmaller">削除</th>
		</tr>
		</thead>
		<form action="UpdatePurchaseForTotal.do" method="get" name="frm">
		<tbody>
		<c:forEach items="${purchase.choises}" var="choise">
			<tr>
				<td class="photo"><img src="${choise.img}" alt="" width="60" height="60" /></td>
				<td>&npsp;<br/>${choise.name}</td>
			
				<td>￥<fmt:formatNumber value="${choise.pricewithtax}" pattern="###,###,###"/></td>
				<td>

				</td>
				<td>￥<fmt:formatNumber value="${choise.item.carriage.value}" pattern="###,###,###"/></td>
				<td>￥<fmt:formatNumber value="${choise.pricewithtax}" pattern="###,###,###"/></td>
				<td>
					<a href="#" onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeleteChoise.do?id=${choise.id}';}">
					<img src="images/bt_delete.gif" alt="削除" width="51" height="20" /></a>
			    </td>
			</tr>
		</c:forEach>
		<tr class="total">
				<td colspan="5" class="title">商品合計（税込）</td>
				<td >￥<fmt:formatNumber value="${purchase.total}" pattern="###,###,###"/></td>
				<td><!--<a href="#" onclick="document.frm.submit();"><img src="images/bt_sum.gif" alt="再計算" width="51" height="20" class="total" />再計算</a>--></td>
			</tr>
		</tbody>
		</form>
	</table>
	
	<div class="action clearfix">
		<a href="http://africaandleo.com/?page_id=2"> お買い物を続ける</a>
		<c:choose>
			<c:when test="${empty purchase.choises}">
				お買い物を続ける				
			</c:when>
			<c:otherwise>
					<a href="PostPublicUserDetail.do">購入手続きに進む</a>			
			</c:otherwise>
		</c:choose>
		
		</ul></div>
		</form>


<p class="catch fontSmaller">※商品をショッピングカートから削除する場合は、一番右の削除欄にある[削除]ボタンをクリックしてください。<br />
※数量を変更した場合は、[再計算]ボタンをクリックしてください。<br />
</p>

<!-- 
<div id="sslTxt">
		<p class="seal"><span id="ss_img_wrapper_100-50_flash_ja">
		<a href="http://jp.globalsign.com/" target=_blank>
		<img alt="SSL　グローバルサインのサイトシール" border=0 id="ss_img" src="//seal.globalsign.com/SiteSeal/images/gs_noscript_100-50_ja.gif"></a></span>
		<script type="text/javascript" src="//seal.globalsign.com/SiteSeal/gs_flash_100-50_ja.js"></script></p>
		<p class="txt">当サイトでは、実在性の証明とプライバシー保護のため、グローバルサインのSSLサーバ証明書を使用し、SSL暗号化通信を実現しています。サイトシールのクリックにより、サーバ証明書の検証結果をご確認ください。</p>
		</div>

-->
	</tiles:put>
</tiles:insert>

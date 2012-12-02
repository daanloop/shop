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
<%@ page import="net.malta.web.utils.Choises" %>
<%@ page import="net.malta.web.utils.DeliveryAddressChoises" %>

<%@ page isELIgnored="false" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="配送先選択" direct="true" />
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
			<h2><strong>お届け先の振り分け</strong></h2>
			<p class="txt">カート内の商品一覧</p>
		</div>
		
						<%--※お名前が入力されていません--%>
					<c:if test="${!empty param.notfixed}">
					<div class="errorTxt">
					  <em>
						<font color="red">
						すべての商品の振り分けが完了していません。
						</font>	
					   </em>
   					</div>
				</c:if>
		
		
		<form method="post" action="UpdateDeliveryAddressChoise.do">
		<table>
			<thead>
				<tr>
					<td colspan="2" class="fontSmaller">お届け先選択</td>
					<td colspan="3" class="fontSmaller">
                    <c:choose>
                        <c:when test="${empty DeliveryAddresss}">
                             <select name="deliveryAddress" id="select3" disabled="disabled"/>
                        </c:when>
                        <c:otherwise>
                            <select name="deliveryAddress" id="select3">
                                <c:forEach var="valueLabel" items="${DeliveryAddresss}">
                                    <c:choose>
                                        <c:when test="${valueLabel.id eq model.deliveryAddress.id}">
                                            <option value="${valueLabel.id}" selected="selected">${valueLabel.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${valueLabel.id}">${valueLabel.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </c:otherwise>
                    </c:choose>					
					さま にお届けする 商品</td>
				</tr>
				
				<tr>
					<th colspan="2" class="fontSmaller">商品</th>
					<th class="fontSmaller">購入数量</th>
					<th class="fontSmaller">残り数量</th>
					<th class="fontSmaller">振り分け数量</th>
				</tr>
			</thead>
			<tbody>
				<!--//商品行-->
				<c:forEach var="row" items="${purchase.choises}">
				<tr>
					<!--商品行-->
					<c:set var="choise" value="${row}"/>
					<jsp:useBean id="choise" type="net.malta.model.Choise" />
					<td class="photo"><img src="ShowImage.do?id=${row.item.defaultattachment.id}" alt="" width="60" height="60" /></td>
					<td>
						${row.item.no}<br />
						${row.item.name}</td>
						<td class="price">${row.ordernum}</td>
						<td class="price"><%= Choises.remaining(choise) %></td>
						<td class="price"><select name="${row.id}" id="select2">
							<c:forEach begin="0" end="<%= Choises.remaining(choise) %>" varStatus="status">
								<option value="${status.count-1}">${status.count-1}</option>
							</c:forEach>						
						</select>
					</td>
				</tr>
				</c:forEach>
				<!--//商品行-->
			</tbody>
		</table>
		<div class="action">
		<p><input name="" type="submit" value="上記内容で振り分け" /></p>
		</div>
		</form>
		
		<div class="cartTxt clearfix">
		<p class="txt">振り分け状況</p>
		</div>
		
		<table>
		<thead>
			<tr>
<%--				<th class="fontSmaller">No.</th>
--%>				<th class="fontSmaller">お名前</th>
				<th class="fontSmaller">商品名</th>
				<th class="fontSmaller">数量</th>
				<th class="fontSmaller">処理</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${DeliveryAddresss}">
			<c:set var="deliveryAddressObject" value="${row}"/>
			<jsp:useBean id="deliveryAddressObject" type="net.malta.model.DeliveryAddress" />
			<bean:size id="s" collection="<%= DeliveryAddressChoises.Of((net.malta.model.Purchase)request.getSession().getAttribute("purchase"),deliveryAddressObject,application) %>"/>
			
			<c:set var="size" value="${s}"/>
			<c:if test="${size eq 0}">	<c:set var="size" value="1"/></c:if>
			<c:set var="filter" value=""/>
			<tr>
	<%--			<td rowspan="${size}" class="price">${row.id}</td>--%>
				<td rowspan="${size}">${row.name}</td>
				<c:forEach var="subrow" items="<%= DeliveryAddressChoises.Of((net.malta.model.Purchase)request.getSession().getAttribute("purchase"),deliveryAddressObject,application) %>" varStatus="status">
				<c:if test="${subrow.choise.purchase.id == purchase.id}">
					<c:if test="${subrow.ordernum ne 0}">
					<c:set var="filter" value="y"/>
						<c:if test="${status.index ne 0}">
								<tr>
							</c:if>
							<td>${subrow.choise.item.name}</td>
							<td class="price">${subrow.ordernum}</td>
							<c:if test="${status.index eq 0}">
							<td rowspan="${size}" class="price"><input type="button" name="button2" id="button2" onclick="location.href='UpdateDeliveryAddressChoise.do?deliveryAddress=${row.id}&reset=y'" value="リセット" /></td>							
						</c:if>
					</tr>
					</c:if>
				</c:if>
			</c:forEach>
			<c:if test="${s eq 0 || empty filter}">
					<td>振り分けられていません</td>
					<td class="price">&nbsp;</td>
					<td class="price">&nbsp;</td>
					</tr>
			</c:if>
			</c:forEach>
		</tbody>
		</table>
		<div class="action">
		
		<ul class="clearfix">
		<li class="rev"><input name="" type="button" onclick="location.href='DeliveryAddressList.do'" value="前へ戻る" /></li>
		<li class="nxt"><input name="" type="button" onclick="location.href='ShowPurchaseForConfirmation.do'" value="商品振り分け確定" /></li>
		</ul></div>
		
		</div><!-- rightContents end -->
</div><!-- mainContents end -->
		
		
	</tiles:put>
</tiles:insert>



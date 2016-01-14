<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<%@ taglib uri="http://www.enclosing.net/tags/storyteller" prefix="st" %>


<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>


<%@ page isELIgnored="false" %>
<%@ page import="org.apache.commons.lang.time.DateUtils" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.malta.beans.*" %>

<tiles:insert definition=".akaruiPublicLayout">
<tiles:put name="head" direct="true">
<script>
<%--$(function(){
	$(".gonext").click(function(){
		if($("#sendType").val() == "done"){
			location.href="DeliveryAddressList.do";
			return  false;	
		}else{
			$("#form").submit();
			return  false;
		}
	});
});
--%>


</script>
		
	</tiles:put>
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
	
	<div class="cartTxt clearfix">
<p class="txt"><em>◆ 現在、カートには以下の商品が入っています。ご確認ください。</em></p>
<ul class="clearfix">
<li class="change"><a href="ShowPurchase.do"><img src="images/bt_cartchange.gif" alt="カート内容の変更" width="125" height="22" /></a></li>
<li><a href="index.jsp"><img src="images/bt_shopping.gif" alt="お買い物を続ける" width="125" height="22" /></a></li>
</ul>
</div>
						<%@ include file="/src/main/webapp/pages/PurchaseBoxTop.jsp" %>
	
	 <form method="POST" action="PostDeliveryAddressVP.do" id="form">
	 <input type="hidden" value="${param.deliverymethod}"  name="deliverymethod" />
	<input  type="hidden" name="from" value="PostDeliveryAddressDetail">
	<c:choose>
		<c:when test="${deliverymethod eq '3'}">
			<div class="cartTxt clearfix">
			<h2><img src="images/title_03.gif" alt="お届け先の入力・設定" width="250" height="19" /></h2>
				<p class="txt">送付先の情報を入力してください。</p>
<%--				<ul class="clearfix">
				<li><select name="sendType" id="sendType">
					<option value="add">注文者</option>
					<option value="done" selected>情報を</option>
                    </select></li>
				<li><input class="gonext" type="button" value="入力" /></li>
				</ul>
--%>		</div>
					<c:if test="${!empty error}">
					<div class="errorTxt">
					  <em>
						<font color="red">
						${error}
						</font>	
					   </em>
   					</div>
				</c:if>
			
		</c:when>	
		<c:when test="${deliverymethod eq '2'}">
			<div class="cartTxt"><br />
			<h2><img src="images/title_03.gif" alt="お届け先の入力・設定" width="250" height="19" /></h2>
				<p><em>送付先の情報を入力してください。</em></p>
				</div>
					<c:if test="${!empty error}">
					<div class="errorTxt">
					  <em>
						<font color="red">
						${error}
						</font>	
					   </em>
   					</div>
				</c:if>
				<table class="formArea">
				<thead>
<%--				<tr>
					<th colspan="6" class="fontSmaller"><p><a href="#">プライバシーポリシー</a></p>お届け先</th>
				</tr>	
--%>		</c:when>
<%--		<c:when test="${param.deliverymethod ne '1'}">
			<div class="cartTxt clearfix">
				<h2><strong>お届け先の入力・設定</strong></h2>
				<p class="txt">送付先の情報を入力してください。</p>
				<ul class="clearfix">
				<li><select name="sendType" id="sendType"><option  value="add">注文者</option>
				<option value="done">情報を</option>
				</select>情報を</li>
				<li><input  class="gonext" type="button" value="入力" /></li>
				</ul>
			</div>
		</c:when>
--%>	</c:choose>
	
<%--</c:if>	--%>

 <html:hidden name="form" property="id"/>
	<table class="formArea">
		<thead>
		<tr>
			<th colspan="6" class="fontSmaller"><p><a href="#">プライバシーポリシー</a></p>お届け先</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<th>お名前＊</th>
				<td><html:text size="40"  name="form" property="name" styleClass="shortForm"/>
		<span class="fontSmaller">例）木咲　豊　</span></td>
			</tr>
			<tr>
				<th>フリガナ＊</th>
				<td><html:text size="40"  name="form" property="kana" styleClass="shortForm" />
		<span class="fontSmaller">例）キザキ　ユタカ</span></td>
			</tr>
		<tr>
		<th>郵便番号＊</th>
		
					<c:choose>
					<c:when test="${form.zipfour eq 0}">
					<td><input type="text" size="20" name="zipfour" value="" styleClass="shortForm" onkeyup="AjaxZip2.zip2addr(this,'prefecture','address',null,'address');"/><span class="fontSmaller">例）1410031</span></td>
					</c:when>
					<c:otherwise>
					<td><html:text size="20"  name="form" property="zipfour" styleClass="shortForm" onkeyup="AjaxZip2.zip2addr(this,'prefecture','address',null,'address');" /><span class="fontSmaller">例）1410031</span></td>
					</c:otherwise>
					</c:choose>
		
		
		<%--<td><html:text size="40"  name="form" property="zipfour" styleClass="shortForm"  onkeyup="AjaxZip2.zip2addr(this,'prefecture','address',null,'address');"/>--%>
<%--		<span class="fontSmaller">例）1410031</span></td>--%>
		</tr>
		<tr>
		<th>都道府県＊</th>
		<td>
		<c:choose>
		    <c:when test="${empty Prefectures}">
		         <select name="prefecture" disabled="disabled"/>
		    </c:when>
		    <c:otherwise>
		        <select name="prefecture" >
				<option value="0">選択してください</option>
		            <c:forEach var="valueLabel" items="${Prefectures}">
		                <c:choose>
		                    <c:when test="${valueLabel.id eq form.prefecture}">
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
          </td>
		</tr>
		<tr>
		<th>住所１＊</th>
		<td><html:text size="40"  name="form" property="address" styleClass="longForm"/>
		<span class="fontSmaller">市区町村、番地等</span></td>
		</tr>
		<tr>
		<th>住所2</th>
		<td><html:text size="40"  name="form" property="buildingname" styleClass="longForm" />
		<span class="fontSmaller">アパート、マンション名、部屋番号等</span></td>
		</tr>
<%--		<tr>
		<th>メールアドレス</th>
		<td>
			<input type="text" value="${u.mail}" disabled class="shortForm">
		</td>
		</tr>
--%>		<tr>
		<th>電話番号＊</th>
		<td><html:text size="40"  name="form" property="phone" styleClass="shortForm" />
		<span class="fontSmaller">例）0334915030（携帯電話でも可）</span></td>
		</tr>
		</td>
		</tr>
		
		<tr>
<th>ギフトカードの有無</th>
<td><input name="hasgiftcard" type="radio" id="gift01" value="true" checked="checked" />
<label for="gift01">ギフトカード有</label>
<input type="radio" name="hasgiftcard" id="gift02" value="false" />
<label for="gift02">ギフトカード無</label></td>
</tr>
<tr>
<th>ギフトカードの種類</th>
<td>
                       <c:choose>
                                    <c:when test="${empty GiftCards}">
                                         <select name="giftCard" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="giftCard" ><option value="（無題）" selected="selected">（無題）</option>
                                            <c:forEach var="valueLabel" items="${GiftCards}">
                                                <c:choose>
                                                    <c:when test="${valueLabel.id eq form.giftCard}">
                                                        <option value="${valueLabel.id}" selected="selected">${valueLabel.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel.id}">${valueLabel.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose><br />



</td>
</tr>

<tr>
<th>配達希望日</th>
<td><select name="preferreddatedateAsString">
<option value="<%=new SimpleDateFormat("yyyy/MM/dd").format(new Date(0))%>" selected="selected">選択なし</option>
<% int i = 1; %>
<c:forEach begin="1" end="60">
<%
 Date today = new Date();
 Date date =  DateUtils.addDays(today,i);
 i++;
%>
<option value="<%=new SimpleDateFormat("yyyy/MM/dd").format(date)%>" <% if(DateUtils.isSameDay(((DeliveryAddressForm)request.getAttribute("form")).getPreferreddatedate(),date)){ %>selected<%}%>><%=new SimpleDateFormat("MM月dd日").format(date)%></option>
</c:forEach>
</select>


<p class="fontSmaller">配達日時をご指定いただけます。(お届けのご指定は最長60日先までとさせていただきます。）<br />
<br />
ご指定が無い場合は最速にて配達させていただきます。<br />
<br />
お届けは店舗休業日以外の12時までのご注文の場合、基本的に当日配送いたします。<br />
<br />
（花材の入荷状況などの都合により、翌日発送となる場合もございます）</p><br />
<p><a href="./terms/index.html#delivery" target="_blank"><img src="images/bt_deli.gif" height="21" alt="配送についての詳細" width="148" /></a>　<span class="fontSmaller">別ウインドウが開きます</span></p>

</td>
</tr>					
					
					
					<tr>
					<th>配達希望時間</th>
					<td>
					<%--	<html:text size="40"  name="form" property="preferredtime" styleClass="shortForm"/>--%>
			<select name="preferredtime" >
				<option value="" selected="selected">選択なし</option>
				<option value="午　前 	9:00～12:00頃" <c:if test="${form.preferredtime eq '午　前 	9:00～12:00頃'}">selected</c:if>>午　前 	9:00～12:00頃</option>
				<option value="午後1	12:00～14:00頃" <c:if test="${form.preferredtime eq '午後1	12:00～14:00頃'}">selected</c:if>>午後1	12:00～14:00頃</option>
				<option value="午後2	14:00～17:00頃" <c:if test="${form.preferredtime eq '午後2	14:00～17:00頃'}">selected</c:if>>午後2	14:00～17:00頃</option>
				<option value="夕　方 	17:00～19:00頃" <c:if test="${form.preferredtime eq '夕　方 	17:00～19:00頃'}">selected</c:if>>夕　方	17:00～19:00頃</option>
				<option value="夜　間 	19:00～21:00頃" <c:if test="${form.preferredtime eq '夜　間 	19:00～21:00頃'}">selected</c:if>>夜　間	19:00～21:00頃 </option>
			</select>
					</td>
					</tr>
		<tr>
		<th>備考欄</th>
		<td><html:textarea   styleClass="longFormEx"  name="form" property="pref" styleId="textfield"  /></textarea></td>
		</tr>
		</tbody>
		</table>
		<div class="action">
		<ul class="clearfix">
		<li class="rev"><input name="" type="button" value="前へ戻る" onclick="location.href='PostPublicUserDetail.do';"/></li>
		<c:choose>
			<c:when test="${!empty param.new}">
				<li class="nxt"><li class="nxt"><input name="" type="button" value="送付先追加" onclick="location.href='PostPublicUserDetail.do';" /></li></li>			
			</c:when>
			<c:when test="${!empty param.edit}">
				<li class="nxt"><input name="" type="submit" value="更新" /></li>			
			</c:when>
			<c:otherwise>
				<li class="nxt"><input class="gonext" type="submit" value="先に進む"  /></li>			
			</c:otherwise>
		</c:choose>
		
		</ul></div>
</form>		
		


</div><!-- rightContents end -->
</div><!-- mainContents end -->









		</tiles:put>
</tiles:insert>

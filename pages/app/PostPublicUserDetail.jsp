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
<%@ page import="net.malta.beans.PublicUserForm" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="一般ユーザー" direct="true" />
	<tiles:put name="head" direct="true">
	<script>
	if($("#deliverymethod").val() != "1"){
		$("#deliveryRelated").hide();				
	}else{
		$("#deliveryRelated").show();
	}
	function disable(){
		$("#gift01").attr("disabled", "disabled");
		$("#gift02").attr("disabled", "disabled");
		$("#giftCard").attr("disabled", "disabled");
		$("#preferreddatedateAsString").attr("disabled", "disabled");
		$("#preferredtime").attr("disabled", "disabled");
		$("#textfield").attr("disabled", "disabled");
	}
	function enable(){
		$("#gift01").attr("disabled", "");
		$("#gift02").attr("disabled", "");
		$("#giftCard").attr("disabled", "");
		$("#preferreddatedateAsString").attr("disabled", "");
		$("#preferredtime").attr("disabled", "");
		$("#textfield").attr("disabled", "");
	}
	
	</script>
	</tiles:put>

	<tiles:put name="content" direct="true">


	
			<div class="cartTxt" style="margin-left:10px">
			<c:if test="${!empty error}">
			<font color="red">
				<st:error key="error"/>
			</font><br>
		    </c:if>
			</div>

	   
			<html:form method="POST" action="/PostPublicUserVP" >
			<html:hidden name="form" property="id"/>
				<table class="formArea">
					<thead>
					<tr>
						<th colspan="6" class="fontSmaller"><p><a href="http://africaandleo.com/?page_id=257">プライバシーポリシー</a></p>お客様情報の入力</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<th>お名前＊</th>
							<td><html:text   name="form" property="name" styleClass="shortForm"/>
					<span class="fontSmaller">例）山田　太郎</span></td>
						</tr>
						<tr>
							<th>フリガナ＊</th>
							<td><html:text   name="form" property="kana" styleClass="shortForm"/>
					<span class="fontSmaller">例）ヤマダ　タロウ</span></td>
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
					</tr>
								
					
					<tr>
					<th>都道府県＊</th>
						<td>
												 <select name="prefecture" >
												<option value="0">選択してください</option>
													<c:forEach var="valueLabel" items="${Prefectures}">
													<c:choose>
													<c:when test="${valueLabel.id eq form.prefecture}">
															<option value="${valueLabel.id}" selected>${valueLabel.name}</option>
													</c:when>
													<c:otherwise>
														<option value="${valueLabel.id}">${valueLabel.name}</option>
													</c:otherwise>
													</c:choose>
													</c:forEach>
												</select>
						</td>
					</tr>
					<tr>
					<th>住所１＊</th>
					<td><html:text size="40"  name="form" property="address" styleClass="longForm"/>
					<span class="fontSmaller">市区町村、番地等</span></td>
					</tr>
					<tr>
					<th>住所2</th>
					<td><html:text size="40"  name="form" property="buildingname" styleClass="longForm"/>
					<span class="fontSmaller">アパート、マンション名、部屋番号等</span></td>
					</tr>
					<tr>
					<th>メールアドレス＊</th>
					<td><html:text size="40"  name="form" property="mail" styleClass="longForm"/></td>
					</tr>
					<tr>
					<th>メールアドレス<br />
					（確認用）＊</th>
					<td><html:text size="40"  name="form" property="mailforconfirm" styleClass="longForm"/></td>
					</tr>
					<tr>
					<th>電話番号＊</th>
					<td><html:text size="40"  name="form" property="phone" styleClass="shortForm"/>
					<span class="fontSmaller">例）0334915030（携帯電話でも可）</span></td>
					</tr>
					<tr>
					<th>FAX 番号</th>
					<td><html:text size="40"  name="form" property="fax" styleClass="shortForm"/>
					<span class="fontSmaller">例）0334915030</span></td>
					</tr>
					
					</tbody>
					</table>
					
<!--					
					
									<div class="cartTxt">
				<p>ご送付先について、以下からお選び下さい。</p>
				</div>
			
				<table class="formArea">
					<thead>
					<tr>
						<th colspan="6" class="fontSmaller">ご送付先の設定</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<th>ご送付先</th>
							<td><label for="zip01"><input type="radio" class="deliverymethod" name="deliverymethod" value="1" checked onclick="enable();">上記の住所と同じ。</label><br />
							<label for="zip02"><input type="radio"  id="deliverymethod" name="deliverymethod" value="2" onclick="disable();">別の住所に送付する。（宛先一つ）</label><br />
							<label for="zip03"><input type="radio"  class="deliverymethod" name="deliverymethod" value="3" onclick="disable();">複数の住所に送付する。</label></td>
						</tr>
					</tbody>
				</table>

					<table class="formArea" id="deliveryRelated">
					<thead>
					<tr>
						<th colspan="6" class="fontSmaller">▼上記住所にお届けする場合は以下もご記入ください。</th>
					</tr>
					</thead>
					<tbody>
					
					

					
					<tr>
<th>ギフトカードの有無</th>
<td><input name="hasgiftcard"  type="radio" id="gift01" value="true" />
<label for="gift01">ギフトカード有</label>
<input type="radio" name="hasgiftcard" id="gift02" value="false" />
<label for="gift02">ギフトカード無</label></td>
</tr>
<tr>
<th>ギフトカードの種類</th>
<td>
                       <c:choose>
                                    <c:when test="${empty GiftCards}">
                                         <select name="giftCard" id="giftCard" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="giftCard" id="giftCard" ><option value="" selected="selected">（選択なし）</option>
                                            <c:forEach var="valueLabel" items="${GiftCards}">
                                                <c:choose>
                                                    <c:when test="${valueLabel.id eq form.giftCard}">
                                                        <option value="${valueLabel.id}">${valueLabel.name}</option>
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
					<th>備考欄</th>
					<td><html:textarea   styleClass="longFormEx"  name="form" property="pref" styleId="textfield"  /></textarea></td>
					</tr>
					</tbody>
				</table>
	
	 
				<c:if test="${(empty u || u.temp )&& !u.registed}">				
				<div class="cartTxt">
				<p></p>
				</div>
				
  				<table class="formArea">
					<thead>
					<tr>
						<th colspan="6" class="fontSmaller">ユーザー登録</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<th>ユーザ登録の有無</th>
							<td><label for="useryes">
							<input type="radio" name="registed" value="1" >ユーザ登録する</label>
							<label for="userno"><input type="radio" name="registed" value="0" checked>ユーザ登録しない</label>
							<%--<a href="GiftCardList.do" class="fontSmaller">ユーザ登録のメリット</a>--%>
							<p class="catch fontSmaller">
								※ユーザー登録して頂きますと、次回ログイン後、お客様情報の入力の手間を除くことができます。 	
							</p>
							</td>
						</tr>
						<tr>
							<th>パスワードの設定</th>
							<td><html:text size="40"  name="form" property="password" styleClass="shortForm"/>
					<span class="fontSmaller">3～12文字の英数字で、ご指定ください。</span></td>
						</tr>
					</tbody>
				</table>
				</c:if>
	-->				
		
				<div class="action">
					<input type="button" value="前へ戻る" onclick="location.href='ShowPurchase.do';" />
					<c:if test="${empty form.id || form.id eq 0}">
						<input type="hidden" name="new" value="y"/>
					</c:if>
					<html:submit value="先に進む"/>
				</div>
				<!-- contentsArea end -->
			</html:form>
			
			<!-- 
			<div id="sslTxt" class="clearfix">
					<p class="seal"><span id="ss_img_wrapper_100-50_flash_ja">
					<a href="http://jp.globalsign.com/" target=_blank>
					<img alt="SSL　グローバルサインのサイトシール" border=0 id="ss_img" src="//seal.globalsign.com/SiteSeal/images/gs_noscript_100-50_ja.gif"></a></span>
					<script type="text/javascript" src="//seal.globalsign.com/SiteSeal/gs_flash_100-50_ja.js"></script></p>
					<p class="txt">当サイトでは、実在性の証明とプライバシー保護のため、グローバルサインのSSLサーバ証明書を使用し、SSL暗号化通信を実現しています。サイトシールのクリックにより、サーバ証明書の検証結果をご確認ください。</p>
				</div>
			 -->	

</div>	
	</tiles:put>
</tiles:insert>

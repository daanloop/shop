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

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="一般ユーザーaaa" direct="true" />

	<tiles:put name="content" direct="true">

<div id="mainContents" class="clearfix">
<div id="leftContents">
<h3><img src="images/step_title.gif" alt="Shopping Cart" width="153" height="23" /></h3>
<ul>
<li><img src="images/step_01.gif" alt="STEP1.カートの確認" width="100" height="43" /></li>
<li><img src="images/step_02_on.gif" alt="STEP2.お客様情報の入力" width="121" height="43" /></li>
<li><img src="images/step_03.gif" alt="STEP3.お届け先の入力・設定" width="145" height="43" /></li>
<li><img src="images/step_04.gif" alt="STEP4.ご注文内容の確認/お支払い方法の設定" width="145" height="60" /></li>
<li><img src="images/step_05.gif" alt="STEP5.完了" width="145" height="43" /></li>
</ul>
</div><!-- leftContents end -->
<div id="rightContents">



        <div id="log_in_form">
			<c:if test="${!empty purchase}">
				<div class="cartTxt clearfix">
					<p class="txt">現在、カートには以下の商品が入っています。ご確認ください。</p>
					<ul class="clearfix">
					<li class="change"><a href="ShowPurchase.do">カート内容の変更</a></li>
					<li><a href="index.jsp">お買い物を続ける</a></li>
					</ul>
					</div>
					<%@ include file="/src/main/webapp/pages/PurchaseBoxTop.jsp" %>
			</c:if>	

			<c:if test="${(empty u || u.temp) && !u.registed}">
				<div class="cartTxt">
				<h2><strong>お客様情報の入力</strong></h2>
				<p>ユーザー登録をされている方は、ログインして下さい。</p>
				</div>
				
				<c:if test="${!empty authenticationerr}">
					<font color="red">
						<st:error key="authenticationerr"/>
					</font>
				</c:if>
		
				<html:form action="/Login.do" method="post">
					<table class="formArea">
						<thead>
						<tr>
							<th colspan="6" class="fontSmaller">ログイン</th>
						</tr>
						</thead>
						<tbody>
							<tr>
								<th>メールアドレス</th>
								<td><html:text   name="form" property="mail" styleClass="shortForm"/></td>
							</tr>
							<tr>
								<th>パスワード</th>
								<td><html:password   name="form" property="password" styleClass="shortForm"/>
								<a href="ShowPublicUserForPassword.do" class="fontSmaller">パスワードを忘れた方はこちら</a></td>
							</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" name="submit" id="button" value="ログイン" />
							</td>
						</tr>
						</tbody>
					</table>
				</html:form>
			</c:if>		
		
			<div class="cartTxt">
			<p>初めてご利用いただく方、ユーザ登録されていない方は、以下のフォームにご入力ください。<br />
			（＊必須項目）</p><c:if test="${!empty error}">
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
						<th colspan="6" class="fontSmaller"><p><a href="privacy/index.html">プライバシーポリシー</a></p>お客様情報の入力</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<th>お名前＊</th>
							<td><html:text   name="form" property="name" styleClass="shortForm"/>
					<span class="fontSmaller">例）木咲　豊</span></td>
						</tr>
						<tr>
							<th>フリガナ＊</th>
							<td><html:text   name="form" property="kana" styleClass="shortForm"/>
					<span class="fontSmaller">例）キザキ　ユタカ</span></td>
						</tr>
					<tr>
					<th>郵便番号＊</th>
					<c:choose>
					<c:when test="${form.zipfour eq 0}">
					<td><input type="text" size="20" name="zipfour" value="" styleClass="shortForm"/><span class="fontSmaller">例）1410031</span></td>
					</c:when>
					<c:otherwise>
					<td><html:text size="20"  name="form" property="zipfour" styleClass="shortForm"/><span class="fontSmaller">例）1410031</span></td>
					</c:otherwise>
					</c:choose>
					</tr>
								
					
					<tr>
					<th>都道府県＊</th>
						<td><c:choose>
									<c:when test="${empty Prefectures}">
												<select name="prefecture" disabled="disabled"/>
											</c:when>
											<c:otherwise>
												<select name="prefecture" >
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
											</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
					<th>住所１＊</th>
					<td><html:text size="40"  name="form" property="address" styleClass="shortForm"/>
					<span class="fontSmaller">市区町村、番地等</span></td>
					</tr>
					<tr>
					<th>住所2</th>
					<td><html:text size="40"  name="form" property="buildingname" styleClass="shortForm"/>
					<span class="fontSmaller">アパート、マンション名、部屋番号等</span></td>
					</tr>
					<tr>
					<th>メールアドレス＊</th>
					<td><html:text size="40"  name="form" property="mail" styleClass="shortForm"/></td>
					</tr>
					<tr>
					<th>メールアドレス<br />
					（確認用）＊</th>
					<td><html:text size="40"  name="form" property="mailforconfirm" styleClass="shortForm"/></td>
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
					<tr>
					<th>配達希望時間</th>
					<td>
					<%--	<html:text size="40"  name="form" property="preferredtime" styleClass="shortForm"/>--%>
						<select name="pref" >
							<option value="" selected="selected">選択なし</option>
							<option value="午　前 	9:00-12:00頃">午　前 	9:00～12:00頃</option>
							<option value="午後1	12:00-14:00頃">午後1	12:00～14:00頃</option>
							<option value="午後2	14:00- 17:00頃">午後2	14:00～17:00頃</option>
							<option value="夕　方 	17:00-19:00頃">夕　方	17:00～19:00頃</option>
							<option value="夜　間 	19:00-21:00頃">夜　間	19:00～21:00頃 </option>
						</select>
					</td>
<%--					<tr>
					<th>お客様情報の入力</th>
					<td><html:text size="40"  name="form" property="pref" styleClass="shortForm"/>
					</td>
					</tr>
--%>					</tbody>
				</table>
	
				<c:if test="${empty u || u.temp || !u.registed}">				
				<div class="cartTxt">
				<p></p>
				</div>
				
				<table class="formArea">
					<thead>
					<tr>
						<th colspan="6" class="fontSmaller">ログイン</th>
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
							<td><label for="zip01"><input type="radio" name="deliverymethod" value="1" checked>上記の住所と同じ。</label><br />
							<label for="zip02"><input type="radio" name="deliverymethod" value="2">別の住所に送付する。（宛先一つ）</label><br />
							<label for="zip03"><input type="radio" name="deliverymethod" value="3">複数の住所に送付する。</label></td>
						</tr>
					</tbody>
				</table>
				<div class="action">
					<ul class="clearfix">
					<li class="rev"><input type="button" value="前へ戻る" onclick="location.href='ShowPurchase.do';" /></li>
					<c:if test="${empty form.id || form.id eq 0}">
						<input type="hidden" name="new" value="y"/>
					</c:if>
					<li class="nxt"><html:submit value="先に進む"/></li>
					</ul>
				</div>
				<!-- contentsArea end -->
			</html:form>
<div id="sslTxt" class="clearfix">
		<p class="seal"><span id="ss_img_wrapper_100-50_flash_ja">
		<a href="http://jp.globalsign.com/" target=_blank>
		<img alt="SSL　グローバルサインのサイトシール" border=0 id="ss_img" src="//seal.globalsign.com/SiteSeal/images/gs_noscript_100-50_ja.gif"></a></span>
		<script type="text/javascript" src="//seal.globalsign.com/SiteSeal/gs_flash_100-50_ja.js"></script></p>
		<p class="txt">当サイトでは、実在性の証明とプライバシー保護のため、グローバルサインのSSLサーバ証明書を使用し、SSL暗号化通信を実現しています。サイトシールのクリックにより、サーバ証明書の検証結果をご確認ください。</p>
	</div>
	
	
</div><!-- rightContents end -->
</div><!-- mainContents end -->

</div>	
	</tiles:put>
</tiles:insert>

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
<%@ taglib uri="http://www.enclosing.net/tags/storyteller" prefix="st" %>

<tiles:insert definition=".akaruiPublicLayout">
	<tiles:put name="title" value="パスワード再設定" direct="true" />
	<tiles:put name="content" direct="true">
	<div id="mainContents" class="clearfix">
<div id="leftContents">
<h3><img src="images/step_title.gif" alt="Shopping Cart" width="153" height="23" /></h3>
<ul>
<li><img src="images/step_01.gif" alt="STEP1.カートの確認" width="100" height="43" /></li>
<li><img src="images/step_02.gif" alt="STEP2.お客様情報の入力" width="121" height="43" /></li>
<li><img src="images/step_03.gif" alt="STEP3.お届け先の入力・設定" width="145" height="43" /></li>
<li><img src="images/step_04.gif" alt="STEP4.ご注文内容の確認/お支払い方法の設定" width="145" height="60" /></li>
<li><img src="images/step_05.gif" alt="STEP5.完了" width="145" height="43" /></li>
</ul>
</div><!-- leftContents end -->
<div id="rightContents">
	
	
	
		<form id="form1" name="form1" method="post" action="MailAboutPublicUserForPassword.do">
		<div class="cartTxt">
		<h2><strong>パスワード再設定</strong></h2>
					<p><em>
					<c:choose>
						<c:when test="${!empty error}">
							<div class="alertTxt"><em><st:error key="error"/></em></div>
						</c:when>
						<c:otherwise>
								◆ ご登録いただいているメールアドレスにパスワード再設定のご案内をお送りします
						</c:otherwise>
					</c:choose>
						</em>
					</p>
		</div>
				
				<table class="formArea">
					<thead>
						<tr>
							<th colspan="6" class="fontSmaller">パスワード再設定</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>メールアドレス</th>
							<td><input type="text" name="mail" id="textfield" class="longForm" /></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<input type="submit" name="button" id="button" value="送信" />
							</td>
						</tr>
					</tbody>
				</table>
		</form>
		
		</div><!-- rightContents end -->
</div><!-- mainContents end -->
		
			
	</tiles:put>
</tiles:insert>

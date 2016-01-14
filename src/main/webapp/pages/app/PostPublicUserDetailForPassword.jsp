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
	<tiles:put name="title" value="一般ユーザー" direct="true" />
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
<div class="cartTxt">
<h2><strong>パスワード再設定</strong></h2>
<p><em>◆ 新しいパスワードをご指定ください。</em></p>
</div>

<table class="formArea">
<thead>
<tr>
	<th colspan="6">パスワード再設定</th>
</tr>
</thead>
<tbody>
	<tr>
		<th>新しいパスワード</th>
		
	<c:if test="${!empty msg}">
		<font color="green">
			<st:error key="msg"/>
		</font>
	</c:if>
	<html:form method="POST" action="/PostPublicUserVPForPassword">
	<input type="hidden" name="id" value="${model.id}" />
          <html:hidden name="form" property="id"/>
			<td><html:password size="40"  name="form" property="password" styleClass="shortForm"/>
	        <span class="fontSmaller">3～12文字の英数字で、ご指定ください。</span></td>
	</tr>
<tr>
<td colspan="2" align="right"><input type="submit" name="button" id="button" value="登録" /></td>
</tr>
</tbody>
</table>

<p id="copyright">Copyright (C)  Akaruiheya Inc. all rights reserved.</p>
</div><!-- rightContents end -->

	</html:form>	
	
	
	</div>
	<!-- contentsArea end -->
	</form>
	<%--<div id="footer">
	</div>--%><!-- footer end -->
	
<%--<span id="subform">
		<html:form method="POST" action="/PostPublicUserVP">
          <html:hidden name="form" property="id"/>

パスワード<br />
<html:text size="40"  name="form" property="password" /><br />




          <html:submit value="save"/>
		</html:form>
</span>--%>
</div>

	</tiles:put>
</tiles:insert>

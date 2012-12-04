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
	<tiles:put name="title" value="##japanese##" direct="true" />
	<tiles:put name="content" direct="true">

<div class="cartFinish">
<div class="cartTxt">
<!--<h2>完了</h2>-->
</div>
<p class="finishTitle">お申し込み完了<p>
<p class="thanksTxt">この度は、AFRICA & LEOネットショップをご利用頂きまして誠にありがとうございます。<br />
ご注文のご確認の自動配信メールを、お客様に設定して頂きましたメールアドレスに配信させて頂いております。<br />
万が一、自動配信メールが届いていない場合は、お手数でございますが、 <a href="mailto:info@africaandleo.com;">info@africaandleo.com</a>へ<br />
ご連絡頂きますようお願い申し上げます。</p>
<p class="actionLink"><a href="http://africaandleo.com/?page_id=2">Net Shop</a><a href="/index.html"></a></p>
</div>

	</tiles:put>
</tiles:insert>
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
<div id="mainContents" class="clearfix">
<div id="leftContents">
<h3><img src="images/step_title.gif" alt="Shopping Cart" width="153" height="23" /></h3>
<ul>
<li><img src="images/step_01.gif" alt="STEP1.カートの確認" width="100" height="43" /></li>
<li><img src="images/step_02.gif" alt="STEP2.お客様情報の入力" width="121" height="43" /></li>
<li><img src="images/step_03.gif" alt="STEP3.お届け先の入力・設定" width="145" height="43" /></li>
<li><img src="images/step_04.gif" alt="STEP4.ご注文内容の確認/お支払い方法の設定" width="145" height="60" /></li>
<li><img src="images/step_05_on.gif" alt="STEP5.完了" width="145" height="43" /></li>
</ul>
</div><!-- leftContents end -->
<div id="rightContents">

<div class="cartFinish">
<div class="cartTxt">
<h2><img src="images/title_05.gif" alt="完了" /></h2>
</div>
<p class="finishTitle"><img src="images/cart_finish_title.gif" alt="お申し込み完了" /><p>
<p class="thanksTxt">この度は、【明るい部屋】ネットショップをご利用頂きまして誠にありがとうございます。<br />
ご注文のご確認の自動配信メールを、お客様に設定して頂きましたメールアドレスに配信させて頂いております。<br />
万が一、自動配信メールが届いていない場合は、お手数でございますが、 <a href="mailto:inquiry@akaruiheya.com;">inquiry@akaruiheya.com</a>へ<br />
ご連絡頂きますようお願い申し上げます。</p>
<p class="actionLink"><a href="/ProductList.do?category=1"><img src="images/bt_netshop.gif" alt="NetShop" width="83" height="22" class="leftImg" /></a><a href="/index.html"><img src="../images/bt_top.gif" alt="TopPage" width="83" height="22" /></a></p>
</div>

</div><!-- rightContents end -->
</div><!-- mainContents end -->
	</tiles:put>
</tiles:insert>
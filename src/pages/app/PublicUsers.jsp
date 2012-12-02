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

<%@ taglib uri="http://www.enclosing.net/tags/storyteller" prefix="st" %>
<%@ page import="net.malta.web.utils.PurchaseDateSorter"%>
<%@ page import="net.malta.model.PublicUser"%>

<%@ page isELIgnored="false" %>
<tiles:insert definition=".layout">
	<tiles:put name="title" value="一般ユーザー一覧" direct="true" />
	<tiles:put name="content" direct="true">
		 <div class="cartTxt clearfix">
				<h2 class="txt"><strong>顧客一覧</strong></h2>
				
			
			   </div>   
		<%--<form action="" method="post" enctype="multipart/form-data" name="form1" id="form1">
		<table >
			<thead>
				<tr>
				<th class="fontSmaller">最終購入日</th>
				<th class="fontSmaller">顧客名</th>
				<th class="fontSmaller">メールアドレス</th>
				<th class="fontSmaller">住所</th>
				<th class="fontSmaller">TEL</th>
				<th class="fontSmaller">パスワード</th>
				<th class="fontSmaller">ユーザー登録</th>
				<th class="fontSmaller">削除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="0" items="${publicUsers}" var="publicUser">
					<tr>
					<td   class="price">${publicUser.date}</td>
					<td class="price">${publicUser.name}</td>
					<td class="price">${publicUser.mail}</td>
					<td class="price">${publicUser.address}</td>
					<td class="price">${publicUser.phone}</td>
					<td class="price">${publicUser.password}</td>
					<td class="price">${publicUser.registed}</td>
					<td class="price"><input type="submit" name="button" id="button" value="削除" 
						onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeletePublicUser.do?id=${publicUser.id}';}"/>
					</td>
					</tr>
				</c:forEach>
		  </tbody>
		</table>
</form>		
	--%>
		
                   
                       <%--<display:column media="html" sortable="false" title="s">
                        <a href="ShowPublicUser.do?id=${row.id}">Show</a> | 
                        <a href="PostPublicUserDetail.do?id=${row.id}"><img src="images/icons/table_edit.png"></a>
                        <a onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeletePublicUser.do?id=${row.id}';}">
                        <img src="images/icons/table_delete.png">
                        </a>
                      </display:column>--%>
   <display:table name="${publicUsers}" id="row" requestURI="PublicUsers.do"
                            requestURIcontext="false"
                            export="false" pagesize="20" sort="list">                   
                  
 <display:column media="html" sortable="false" title="最終購入日" >
	<nobr >
	<bean:define id="publicUser" name="row"  type="PublicUser"></bean:define>
	<%= PurchaseDateSorter.dateSorter(publicUser, application) %>
	</nobr>
</display:column>                       
                       
 <display:column media="html" sortable="false" title="顧客名">
<nobr>
${row.name}
</nobr>
</display:column>


<display:column media="html" sortable="false" title="メールアドレス" >
<nobr>
${row.mail}
</nobr>
</display:column>

 <display:column media="html" sortable="false" title="住所">
<nobr>
${row.address} ${row.buildingname}
</nobr>
</display:column>

<display:column media="html" sortable="false" title="TEL">
<nobr>
${row.phone}
</nobr>
</display:column>

<display:column media="html" sortable="false" title="パスワード">
<nobr>
${row.password}
</nobr>
</display:column>

 <display:column media="html" sortable="false" title="ユーザー登録">
<nobr>
<c:choose>
	<c:when test="${row.registed eq 'true'}">登録</c:when>
	<c:otherwise>非登録</c:otherwise>
</c:choose>
<%--${row.registed}--%>
</nobr>
</display:column>
	<display:column media="html" sortable="false" title="削除">
                        
                        <input type="submit" name="button" id="button" value="削除" 
						onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeletePublicUser.do?id=${row.id}';}"/>
                        </display:column>                     
 <%--<display:column media="html" sortable="true" title="購入">
<nobr>
${row.purchases}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="名前">
<nobr>
${row.name}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="アドレス">
<nobr>
${row.address}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="メール">
<nobr>
${row.mail}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="登録済み">
<nobr>
${row.registed}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="パスワード">
<nobr>
${row.password}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="電話番号">
<nobr>
${row.phone}
</nobr>
</display:column>
--%>
<%--<display:column property="purchases"  sortable="true" sortName="firstName" title="Username (e-mail)"  />
--%>
<%--<display:column title="name"  sortProperty="row.purchases.date" sortable="true" >
      <c:out value="${row.purchases}"/>
      
    </display:column>
--%>


</display:table>


	</tiles:put>
</tiles:insert>

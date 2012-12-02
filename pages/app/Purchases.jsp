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


<%@ page isELIgnored="false" %>
<tiles:insert definition=".layout">
	<tiles:put name="title" value="購入一覧" direct="true" />
	<tiles:put name="content" direct="true">
<%--<table align="right">
	<tr>
	<div>	
		<td>
			<form action="GrepPurchase.do">
				<input type="text" name="str"/>
				<input type="submit" value="search"/>
			</form>
		</td>
	</div>
	</tr>
	</table>
	<br />--%>

<div>
<%--<form action="Purchases.do">
	      <input type="text" name="startdate"/>yyyy/mm/dd  -   <input type="text" name="enddate"/>yyyy/mm/dd &nbsp;



		                     &nbsp;一般ユーザー
			<c:choose>
				<c:when test="${empty PublicUsers}">
					<select name="publicUser" disabled="disabled"/>
				</c:when>
				<c:otherwise>
				<select name="publicUser" ><option value="">All</option>
				<c:forEach var="valueLabel" items="${PublicUsers}">
					<option value="${valueLabel.id}">${valueLabel.name}</option>
				</c:forEach>
				</select>
				</c:otherwise>
			</c:choose>









<input type="submit" value="Go" onclick="document.publicusers1.action='PublicUsers.do'"> 

</form>
--%><%--</div>
		<div class="cartTxt clearfix" >
				<h2 class="txt"><strong>購入履歴一覧</strong></h2>
				<div align="right">
				<display:table name="${purchases}" id="row" requestURI="Purchases.do"
                            requestURIcontext="false"
                            export="false" pagesize="20" sort="list"> 
                            	</div>
		</div>--%>
		<h2 class="txt"><strong>購入履歴一覧</strong></h2>
			<display:table name="${purchases}" id="row" requestURI="Purchases.do"
                            requestURIcontext="false"
                            export="false" pagesize="20" sort="list"> 
<%--<display:setProperty
 name="paging.banner.placement" value="top" />--%>

			<!-- One item found -->
			<%-- <display:setProperty
			 name="paging.banner.one_item_found" value="<table width=\"99%\" 
			 cellspacing=0><tr class=\"text-size-small-gray\"><td
			 align=\"left\">&nbsp;&nbsp;One {0} found. </td>"/>--%>
			
			
			 <!-- All items found -->
			<%-- -<display:setProperty
			 name="paging.banner.all_items_found" value="<table width=\"99%\"
			 cellspacing=0><tr class=\"text-size-small-gray\"><td
			 align=\"left\">&nbsp;&nbsp;{0} {1} found, displaying
			 all {2}. </td>"/>
			 <display:setProperty name="paging.banner.onepage"
			 value="<td align=\"right\">Page
			 {0}</td></tr></table>"/>--%>
			
			 
			 <!-- Some items found -->
			<%-- <display:setProperty
			 name="paging.banner.some_items_found" value="<table width=\"99%\"
			 cellspacing=\"0\" border=\"0\"><tr class=\"text-size-small-gray\"><td
			 align=\"left\">&nbsp;&nbsp;{0} {1} found, displrrraying
			 [{2}] to [{3}]. </td>"/>
			 <display:setProperty name="paging.banner.full"
			 value="<td align=\"right\"> [<a
			 href=\"{1}\">Fiwwrst</a>
			 / <a href=\"{2}\">Prev</a>] [{1}][{2}]{0} [ <a
			 href=\"{3}\">Next</a> / <a href=\"{4}\">Last
			</a>]</td></tr></table>"/>
--%>			 
			
			 <!-- First page -->
			<%-- <display:setProperty name="paging.banner.first"
			 value="<td align=\"right\">[First/ Prev][ {0}] [ <a 
			 href=\"{3}\">Next</a> / <a href=\"{4}\">Last</a>]</td></tr></table>"/>
			 --%>
			 <!-- Last page -->
			<%-- <display:setProperty name="paging.banner.last"
			 value="<td align=\"right\">[ <a
			 href=\"{1}\">First</a>
			 / <a href=\"{2}\">Prev</a>][ {0}] [Next/ Last]</td></tr></table>"/>
			 
			 <!-- Incl first/last -->
			 <display:setProperty name="paging.banner.include_first_last" 
			value="true" />
			 <display:setProperty name="paging.banner.page.separator" 
			value="[" />
			<display:setProperty name="paging.banner.page.separator" value="]" />--%>


                   <%--<display:table name="${purchases}" id="row" requestURI="Purchases.do"
                            requestURIcontext="false"
                            export="false" pagesize="20" sort="list">
                    --%>   <%-- <display:column media="html" sortable="false">
                        <a href="ShowPurchase.do?id=${row.id}">Show</a> | 
                        <a href="PostPurchaseDetail.do?id=${row.id}"><img src="images/icons/table_edit.png"></a>
                        <a onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeletePurchase.do?id=${row.id}';}">
                        <img src="images/icons/table_delete.png">
                        </a>
                        </display:column>--%>
 <display:column media="html" sortable="true" title="受注日"><nobr>
<st:date date="${row.date}" /> </nobr>
</display:column>

<display:column media="html" sortable="true" title="顧客名"><nobr>
${row.publicUser.name}</nobr>
</display:column>

<display:column media="html" sortable="true" title="商品No"><nobr>
	<c:forEach var="ch" items="${row.choises}" varStatus="status">
		<c:if test="${status.index ne 0}">
			,
		</c:if>
		${ch.item.no}
	</c:forEach>
	</nobr>
</display:column>

<display:column media="html" sortable="true" title="購入金額"><nobr>
${row.total}</nobr>
</display:column>

<display:column media="html" sortable="true" title="決済方法"><nobr>
${row.paymentMethod.name}</nobr>
</display:column>

<display:column media="html" sortable="true" title="削除"><nobr>
<input type="submit" name="button" id="button" value="削除" 
onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeletePurchase.do?id=${row.id}';}"/>
</display:column>
<%--<display:column media="html" sortable="true" title="削除"><nobr>
${row.totalordernum}</nobr>
</display:column>


 <display:column media="html" sortable="true" title="ID" property="id" >

</display:column>
 <display:column media="html" sortable="true" title="一般ユーザー">
<nobr>
${row.publicUser.id}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="合計">
<nobr>
${row.total}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="選択">
<nobr>
${row.choises}
</nobr>
</display:column>
--%>
                    </display:table>


	</tiles:put>
</tiles:insert>

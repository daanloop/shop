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
<%@ page import="net.malta.web.utils.MainItem" %>

<%@ page isELIgnored="false" %>

<tiles:insert definition=".layout">
	<tiles:put name="title" value="製品一覧" direct="true" />
	<tiles:put name="content" direct="true">
<%--		<table align="right">
			<tr>
			<div>	
				<td>
					<form action="GrepProduct.do">
						<input type="text" name="str"/>
						<input type="submit" value="search"/>
					</form>
				</td>
			</div>
			</tr>
			</table>
		<br />

		<div>
			<form action="Products.do">&nbsp;カテゴリー
				<c:choose>
					<c:when test="${empty Categorys}">
						<select name="category" disabled="disabled"/>
					</c:when>
					<c:otherwise>
						<select name="category" ><option value="">All</option>
							<c:forEach var="valueLabel" items="${Categorys}">
								<option value="${valueLabel.id}">${valueLabel.name}</option>
							</c:forEach>
						</select>
					</c:otherwise>
				</c:choose>

                公開 
                <select name="pub" >
					 <option value=""></option>
					 <option value="true"></option>
				     <option value="false"></option>
			    </select>
    			&nbsp;
				<input type="submit" value="Go" onclick="document.publicusers1.action='PublicUsers.do'"> 
			</form>
		</div>
--%>		
		<%--<h3>商品一覧</h3>--%>
		<div class="cartTxt clearfix">
				<h2 class="txt"><strong>商品一覧</strong></h2>
		 </div>  
		
        <display:table name="${products}" id="row" requestURI="Products.do"
                requestURIcontext="false"
                export="false" pagesize="30" sort="list">
			<display:column media="html" sortable="true" title="商品ID" property="id" >
			</display:column>
			<display:column media="html" sortable="true" title="商品No">
				<nobr> 
				<c:set var="mainItem" value='<%= MainItem.Of(row,application)%>' />
					${mainItem.no}
				</nobr>
			</display:column>
			<display:column media="html" sortable="true" title="商品名">
				<nobr>
					${row.name}
				</nobr>
			</display:column>
			<display:column media="html" sortable="true" title="カテゴリー">
				<nobr>
					${row.category.name}
				</nobr>
			</display:column>
			<display:column media="html" sortable="true" title="単価（税込）">
				<nobr>
					 ￥<fmt:formatNumber value="${mainItem.pricewithtax}" pattern="###,###,###"/>
				</nobr>
			</display:column>
			<display:column media="html" sortable="true" title="数量">
				<nobr class="price">
					<c:choose>
						<c:when test="${mainItem.stocknum eq 0}">
							<font color="#990000">
								${mainItem.stocknum}								
							</font>
						</c:when>
						<c:otherwise>
							${mainItem.stocknum}
						</c:otherwise>
					</c:choose>
				</nobr>
			</display:column>
			<display:column media="html" sortable="true" title="公開">
				<nobr>
					<c:choose>
						<c:when test="${row.pub eq 'true'}">登録</c:when>
						<c:otherwise>非登録</c:otherwise>
					</c:choose>
					
				</nobr>
			</display:column>
			
			   <display:column media="html" sortable="false" title="編集">
		    	<input type="submit" name="button" id="button" value="編集" 
							onClick="{location.href='PostProductDetail.do?id=${row.id}';}"/>
			  <%--  <a href="PostProductDetail.do?id=${row.id}"><img src="images/icons/table_edit.png"></a>
--%>		    </display:column>
		    <display:column media="html" sortable="false" title="削除">
				<a onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeleteProduct.do?id=${row.id}';}">
				    <img src="images/icons/bt_delete.gif">
			    </a>
			</display:column>
		</display:table>
	</tiles:put>
</tiles:insert>

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

<table>
		<thead>
		<tr>
			<th colspan="2" class="fontSmaller">商品</th>
			<th class="fontSmaller">単価（税込）</th>
			<th class="fontSmaller">数量</th>
			<!-- <th class="fontSmaller">送料</th> -->
			<th class="fontSmaller">小計（税込）</th>
			
		</tr>
		</thead>
		<tbody>
		<c:set var="purchase" value="<%= request.getSession().getAttribute(\"purchase\") %>"></c:set>
		<c:forEach items="${purchase.choises}" var="choise">
			<tr>
				<td class="photo"><img src="${choise.img}" alt="" width="155"  /></td>
				<td><br/>${choise.name}</td>
				<td >￥<fmt:formatNumber value="${choise.pricewithtax}" pattern="###,###,###"/></td>
				<td >1</td>
				<!-- <td></td> -->
				<td >￥<bean:write name="choise" property="pricewithtax" format="###,###,###"/></td>
			</tr>
		</c:forEach>
		￥<fmt:formatNumber value="${choise.carriage}" pattern="###,###,###"/>
		<tr class="total">
				<td colspan="5" class="title">送料</td>
				<td >￥<fmt:formatNumber value="${purchase.carriage}" pattern="###,###,###"/></td>
		</tr>
		<tr class="total">
				<td colspan="5" class="title">商品合計（税込）</td>
				<td >￥<fmt:formatNumber value="${purchase.total}" pattern="###,###,###"/></td>
		</tr>
		</tbody>
	</table>

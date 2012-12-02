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
			<th class="fontSmaller">送料</th>
			<th class="fontSmaller">小計（税込）</th>
			
		</tr>
		</thead>
		<tbody>
		<c:set var="purchase" value="<%= request.getSession().getAttribute(\"purchase\") %>"></c:set>
		<c:forEach items="${purchase.choises}" var="choise">
			<tr>
				<td class="photo"><img src="ShowImage.do?id=${choise.item.defaultattachment.id}" alt="" width="60" height="60" /></td>
				<td>${choise.item.no}<br/>${choise.item.product.name}/${choise.item.name}</td>
				<td >￥<fmt:formatNumber value="${choise.item.pricewithtax}" pattern="###,###,###"/></td>
				<td >${choise.ordernum}</td>
				<td>￥<fmt:formatNumber value="${choise.item.carriage.value}" pattern="###,###,###"/></td>
				<td >￥<bean:write name="choise" property="pricewithtax" format="###,###,###"/></td>
			</tr>
		</c:forEach>
		<tr class="total">
				<td colspan="5" class="title">商品合計（税込）</td>
				<td >￥<fmt:formatNumber value="${purchase.total}" pattern="###,###,###"/></td>
		</tr>
		</tbody>
	</table>

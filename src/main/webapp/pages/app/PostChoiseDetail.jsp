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

<tiles:insert definition=".layout">
	<tiles:put name="title" value="選択" direct="true" />
	<tiles:put name="content" direct="true">

<span id="subform">
		<html:form method="POST" action="/PostChoiseVP">
          <html:hidden name="form" property="id"/>

注文数<br />
<html:text size="40"  name="form" property="ordernum" styleClass="shortForm"/><br />

税込み<br />
<html:text size="40"  name="form" property="pricewithtax" styleClass="shortForm"/><br />

ラッピングあり<br />
<html:checkbox name="form" property="wrapping" /><br />

                                購入<br />
                                <c:choose>
                                    <c:when test="${empty Purchases}">
                                         <select name="purchase" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="purchase" ><option value=""></option>
                                            <c:forEach var="valueLabel" items="${Purchases}">
                                                <c:choose>
                                                    <c:when test="${valueLabel.id eq model.purchase.id}">
                                                        <option value="${valueLabel.id}" selected="selected">${valueLabel.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel.id}">${valueLabel.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose><br />


                                アイテム<br />
                                <c:choose>
                                    <c:when test="${empty Items}">
                                         <select name="item" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="item" ><option value=""></option>
                                            <c:forEach var="valueLabel" items="${Items}">
                                                <c:choose>
                                                    <c:when test="${valueLabel.id eq model.item.id}">
                                                        <option value="${valueLabel.id}" selected="selected">${valueLabel.name}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel.id}">${valueLabel.name}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose><br />





          <html:submit value="save"/>
		</html:form>
</span>
</div>

	</tiles:put>
</tiles:insert>

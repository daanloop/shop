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
	<tiles:put name="title" value="配送料" direct="true" />
	<tiles:put name="content" direct="true">
	
	
	<html:form method="POST" action="/PostCarriageVP">
	
			<div class="cartTxt clearfix">
			<h2 class="txt"><strong>送料設定</strong></h2>
			</div>
			
				<table class="formArea">
				<tbody>
				<tr>
				<th>送料</th>
				<td><p>A：<input type="text" size="60"  name="a" value="${carriagea.value}" class="shortForm" /></p>
				<p>B：<input type="text" size="60"  name="b" value="${carriageb.value}" class="shortForm"/></p>
				<p>C：<input type="text" size="60"  name="c" value="${carriagec.value}" class="shortForm"/></p></td>
				</tr>
				</tbody>
				</table>
				<div class="action">
				<ul>
				<li></li>
				</ul>
				<p><%--<input  type="reset"  value="キャンセル" />--%>
				<input  type="submit" value="登　録" /></p>
				</div>
	
	</html:form>	
<%--<span id="subform">
		<html:form method="POST" action="/PostCarriageVP">
          <html:hidden name="form" property="id"/>

名前<br />
<html:text size="40"  name="form" property="name" /><br />

値<br />
<html:text size="40"  name="form" property="value" /><br />

値<br />
<html:text size="40"  name="form" property="value" /><br />



          <html:submit value="save"/>
		</html:form>
</span>--%>
</div>

	</tiles:put>
</tiles:insert>

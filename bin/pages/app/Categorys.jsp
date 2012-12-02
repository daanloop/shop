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
	<tiles:put name="title" value="カテゴリー一覧" direct="true" />
	<tiles:put name="content" direct="true">
<%--<table align="right">
	<tr>
	<div>	
		<td>
			<form action="GrepCategory.do">
				<input type="text" name="str"/>
				<input type="submit" value="search"/>
			</form>
		</td>
	</div>
	</tr>
	</table>
	<br />

<div>
<form action="Categorys.do">







<input type="submit" value="Go" onclick="document.publicusers1.action='PublicUsers.do'"> 

</form>
</div>
--%>
                    <display:table name="${categorys}" id="row" requestURI="Categorys.do"
                            requestURIcontext="false"
                            export="false" pagesize="30" sort="list">
                        <display:column media="html" sortable="false">
            <%--            <a href="ShowCategory.do?id=${row.id}">Show</a> |--%> 
                        <a href="PostCategoryDetail.do?id=${row.id}"><img src="images/icons/table_edit.png"></a>
                        <%--<a onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeleteCategory.do?id=${row.id}';}">
                        <img src="images/icons/table_delete.png">
                        </a>--%>
                        </display:column>
 <display:column media="html" sortable="true" title="ID" property="id" >

</display:column>
 <display:column media="html" sortable="true" title="製品数">
<nobr>
<bean:size id="size"  collection="${row.products}"/>
${size}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="名前">
<nobr>
${row.name}
</nobr>
</display:column>

                    </display:table>


	</tiles:put>
</tiles:insert>

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
	<tiles:put name="title" value="配送料一覧" direct="true" />
	<tiles:put name="content" direct="true">

                    <display:table name="${carriages}" id="row" requestURI="Carriages.do"
                            requestURIcontext="false"
                            export="false" pagesize="30" sort="list">
                        <%--<display:column media="html" sortable="false">
                        <a href="PostCarriageDetail.do?id=${row.id}"><img src="images/icons/table_edit.png"></a>
                        <a onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeleteCarriage.do?id=${row.id}';}">
                        <img src="images/icons/table_delete.png">
                        </a>
                        </display:column>
--%> <display:column media="html" sortable="true" title="ID" property="id" >

</display:column>
 <display:column media="html" sortable="true" title="アイテム数">
<nobr>
<bean:size id="size" collection="${row.items}"/>
${size}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="名前">
<nobr>
${row.name}
</nobr>
</display:column>
 <display:column media="html" sortable="true" title="値">
<nobr>
${row.value}
</nobr>
</display:column>
 <display:column media="html" sortable="false" title="編集">
		    	<input type="submit" name="button" id="button" value="編集" 
							onClick="{location.href='PostCarriageDetail.do?id=${row.id}';}"/>
			    </display:column>

                    </display:table>


	</tiles:put>
</tiles:insert>

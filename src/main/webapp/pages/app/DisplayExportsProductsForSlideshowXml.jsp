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
<%@ page isELIgnored="false" %>
                    <display:table name="${products}" id="row" requestURI="Products.do"
                            requestURIcontext="false"
                            export="true" pagesize="30" sort="list">
                        <display:column media="xml csv excel pdf" sortable="false" property="id" />
<display:column media="xml csv excel pdf" property="note" title="注釈"/>
<display:column media="xml csv excel pdf" property="id" title="id"/>
<display:column media="xml csv excel pdf" property="removed" title="削除済み"/>
<display:column media="xml csv excel pdf" property="no" title="商品No"/>
<display:column media="xml csv excel pdf" property="category" title="カテゴリー"/>
<display:column media="xml csv excel pdf" property="items" title="アイテム"/>
<display:column media="xml csv excel pdf" property="pricewithtax" title="税込み"/>
<display:column media="xml csv excel pdf" property="material" title="素材"/>
<display:column media="xml csv excel pdf" property="catchcopy" title="キャッチコピー"/>
<display:column media="xml csv excel pdf" property="stocknum" title="在庫数"/>
<display:column media="xml csv excel pdf" property="pub" title="公開"/>
<display:column media="xml csv excel pdf" property="thumnail" title="thumnail"/>
<display:column media="xml csv excel pdf" property="slideshow" title="スライドショー"/>
<display:column media="xml csv excel pdf" property="name" title="名前"/>
<display:column media="xml csv excel pdf" property="size" title="サイズ"/>
<display:column media="xml csv excel pdf" property="description" title="説明"/>
<display:column media="xml csv excel pdf" property="date" title="日付"/>
<display:column media="xml csv excel pdf" property="mainitemname" title="mainitemname"/>

                    </display:table>



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
<%@ page import="net.malta.web.utils.MainItem" %>

<tiles:insert definition=".layout">

	<tiles:put name="title" value="商品登録" direct="true" />

	<tiles:put name="content" direct="true">
		
	<html:form enctype="multipart/form-data" method="POST" action="/PostItemVP">
          <html:hidden name="form" property="id"/>
          <input type="hidden" name="product" value="${form.product}" />	
		
		<span id="subform">
		<c:if test="${!empty error}">
			<font color="red">
				<st:error key="error"/>
			</font>	
		</c:if>

	<div class="cartTxt clearfix">
	<h2 class="txt"><strong>バリエーション編集</strong></h2>
	</div>

<table class="formArea">
	
	<tr>
		<td>
		バリエーション名
		</td>
		<td>
			<html:text   name="form" property="name" styleClass="shortForm"/>
		</td>
	</tr>
	
	<%--<tr>
		<td>
		名前
		</td>
		<td>
			<html:text   name="form" property="name" styleClass="shortForm"/>
		</td>
	</tr>--%>
	
	<tr>
		<td>
			商品No
		</td>
		<td>
			<html:text   name="form" property="no" styleClass="shortForm"/>
		</td>
	</tr>
	
	<tr>
		<td>
			価格
		</td>
		<td>
			<html:text   name="form" property="pricewithtax" styleClass="shortForm"/>
		</td>
	</tr>
	
	<tr>
		<td>
			サイズ	
		</td>
		<td>
			<html:textarea styleClass="longFormEx" name="form" property="size" styleId="textfield">${form.size}</html:textarea><%--${form.size}--%>
		</td>
	</tr>

	<tr>
		<td>
			マテリアル	
		</td>
		<td>
			<html:textarea styleClass="longFormEx" name="form" property="material" styleId="textfield"></html:textarea><%--${form.size}--%>
		</td>
	</tr>
	
	<%--<tr>
		<td>
			素材
	   </td>
		<td>
			<html:text   name="form" property="material" styleClass="shortForm"/><br />
		</td>
	</tr>--%>
	
	
		
	<tr>
		<td>
			キャッチコピー
		</td>
		<td>
			<html:text   name="form" property="catchcopy" styleClass="shortForm"/>
		</td>
	</tr>
	
	<tr>
		<td>
			本文
		</td>
		<td>
			<html:textarea   name="form" property="description" styleClass="longFormEx" styleId="textfield"/>
		</td>
	</tr>
	
	<tr>
		<td>
			注釈
		</td>
		<td>
			<html:textarea   name="form" property="note" styleClass="longFormEx" styleId="textfield"/>
		</td>
	</tr>

	<%--<tr>
		<td>
			注釈
		</td>
		<td>	
			<textarea>${form.size}</textarea>
		</td>
	</tr>--%>
	
	<tr>
		<td>
	在庫
		</td>
		<td>	
			<html:text    name="form"  property="stocknum" styleClass="shortForm" />
		</td>
	</tr>
	 
	
	
	
	<%--<tr>
		<td>
			説明
			</td>
		<td>	
			<html:text   name="form" property="description" styleClass="shortForm"/>
		</td>
	</tr>	--%>
				<c:if test="${empty param.id}">	
	
						<tr>
							<td>
	                            送料
	                           </td>
	                           <td>
	                                <c:choose>
	                                    <c:when test="${empty Carriages}">
	                                         <select name="carriage" disabled="disabled"/>
	                                    </c:when>
	                                    <c:otherwise>
	                                        <select name="carriage" ><option value=""></option>
	                                            <c:forEach var="valueLabel" items="${Carriages}">
	                                                <c:choose>
	                                                    <c:when test="${valueLabel.id eq model.carriage.id}">
	                                                        <option value="${valueLabel.id}" selected="selected">${valueLabel.name}</option>
	                                                    </c:when>
	                                                    <c:otherwise>
	                                                        <option value="${valueLabel.id}">${valueLabel.name}</option>
	                                                    </c:otherwise>
	                                                </c:choose>
	                                            </c:forEach>
	                                        </select>
	                                    </c:otherwise>
	                                </c:choose>
	                           </td> 
	                      </tr>         
				</c:if>
				
	
	<tr>
		<td colspan="2">
			<div class="action">
			<%--<ul>
			<li></li>--%>
			</ul>
			<p><input name="" type="reset" value="キャンセル" />
			<input type="submit" value="登　録"/>	</p>
			</div>
		</td>
	</tr>
	
<%--	<table align="center">
		<tr>
			<td>
				<input type="button" value="キャンセル"/>
			</td>
			<td>	
				<input type="submit" value="登　録"/>		
			</td>
		</tr>
	</table>
--%>	
	
</html:form>	
		
			<table class="detail">
				
				<tr >
					<td width="19%">
						詳細画像<br />
						（290px×290px）
					</td>
					<td width="81%">
					<table><tr><td>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForDefault.do">
						<input type="hidden" name="asdefault" value="${model.id}"/>
						<input type="hidden" name="from" value="detail" />
<%--						<input type="hidden" name="default" value="true" />
--%>							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<hr />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForDetailed.do">
						<input type="hidden" name="asdetailed" value="${model.id}"/>
						<input type="hidden" name="from" value="detail" />
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
					</td>
						<td>
						<c:if test="${!empty model.defaultattachment}">
						<a href="ShowImage.do?id=${model.defaultattachment.id}" rel="lightbox">
						<img src="ShowImage.do?id=${model.defaultattachment.id}" width="40" />
						</a>
						<a href="DeleteAttachment.do?id=${model.defaultattachment.id}&from=PostItemDetail.do&toid=${model.id}&itemid=${model.id}">削除</a>
						</c:if>
						<c:forEach var="detailed" items="${model.detailed}" >
						<a href="ShowImage.do?id=${detailed.id}"  rel="lightbox">
						<img src="ShowImage.do?id=${detailed.id}" width="40" />
						</a>
						<a href="DeleteAttachment.do?id=${detailed.id}&from=PostItemDetail.do&toid=${model.id}">削除</a>
						</c:forEach>						
						
						</td>
						
						</tr></table>
	
						
					</td>
				</tr>
				</form>
<%--				<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToProductForSlideShow.do">
			
				<tr>
					<td>
						ZOOM・SLIDE SHOW<br />
						（1500px×900px）
					</td>
					<td>
						<input type="file" name="formFiles[0]"/>
						<input type="submit" value="upload"/>
					</td>
				</tr>
				</form>
--%>			</table>
			
			
		</span>
	</tiles:put>

</tiles:insert>

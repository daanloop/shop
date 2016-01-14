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
		
		<c:if test="${!empty error}">
			<font color="red">
				<st:error key="error"/>
			</font>	
		</c:if>
		
<%--		<span id="subform">
--%>			<html:form method="POST" action="/PostProductVP">
			<input type="hidden" name="from" value="detail" />
				<html:hidden name="form" property="id"/>
				<c:set var="mainItem" value='<%= MainItem.Of(request.getAttribute("model"),application)%>' />			
				<table class="formArea">
					<tr>
						<td>
							商品ID
						</td>
						<td>
							${form.id}
						</td>
					</tr>
					<%--<tr>
						<td>
							日付
						</td>
						<td>
							<input class="shortForm" type="text" name="dateAsString" value="<st:date date="${form.date}" />" size="20" />
						</td>
					</tr>--%>
					<tr>
						<td>
							商品No
						</td>
						<td>
						<br />
							<input type="text" size="40" name="no" class="shortForm" value="${mainItem.no}"  /><br />
						</td>
					</tr>
					<tr>
						<td>
							商品名
						</td>
						<td>
							<textarea class="longFormEx" name="name" cols="50" rows="5">${form.name}</textarea>
						</td>
					</tr>
					<tr>
						<td>
					        カテゴリー
						</td>
						<td>
					        <c:choose>
					            <c:when test="${empty Categorys}">
					                 <select class="field" name="category" disabled="disabled"/>
					            </c:when>
					            <c:otherwise>
					                <select class="field" name="category" ><option value=""></option>
					                    <c:forEach var="valueLabel" items="${Categorys}">
					                        <c:choose>
					                            <c:when test="${valueLabel.id eq model.category.id}">
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
					<tr>
						<td>
							日本語名
						</td>
						<td>
							<input class="shortForm" type="text" name="mainitemname" value="${mainItem.name}" size="20" />
						</td>
					</tr>
					<tr>
						<td>
							価格
						</td>
						<td>
							<input class="shortForm" type="text" name="pricewithtax" value="${mainItem.pricewithtax}" size="20" />						
						</td>
					</tr>
					<tr>
						<td>
							サイズ
						</td>
						<td>
							<textarea class="longFormEx"  name="size"  cols="50"  rows="5" >${mainItem.size}</textarea>							
						</td>
					</tr>
					<tr>
						<td>
							マテリアル
						</td>
						<td>
							<textarea class="longFormEx"  name="material" cols="50"  rows="5">${mainItem.material}</textarea>						
						</td>
					</tr>
					<tr>
						<td>
							キャッチコピー
						</td>
						<td>
							<textarea class="longFormEx"  name="catchcopy"  cols="50"  rows="5" >${mainItem.catchcopy}</textarea>						
						</td>
					</tr>
					<tr>
						<td>
							本文
						</td>
						<td>
							<textarea class="longFormEx"  name="description"   cols="50"  rows="5">${mainItem.description}</textarea>								
						</td>
					</tr>
					<tr>
						<td>
							注釈
						</td>
						<td>
							<textarea class="longFormEx"  name="note"  cols="50"  rows="5">${mainItem.note}</textarea>							
						</td>
					</tr>
					<tr>
						<td>
							在庫				
						</td>
						<td>
							<textarea class="longFormEx"  name="stocknum" cols="50"  rows="5" >${mainItem.stocknum}</textarea>					
						</td>
					</tr>
					<tr>
						<td>
							公開
						</td>
						<td>
			                <select name="pub">
		                    	<option value="0" <c:if test="${!form.pub}">selected="selected"</c:if>>非公開</option>
	                            <option value="1" <c:if test="${form.pub}">selected="selected"</c:if>>公開</option>
			                </select>
						</td>
					</tr>
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
	                                        <select name="carriage" >
	                                            <c:forEach var="valueLabel" items="${Carriages}">
	                                                <c:choose>
	                                                    <c:when test="${valueLabel.id eq mainItem.carriage.id}">
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
					
					
				</table>
				<table align="center">
					<tr>
						<td>
							<input type="reset" value="キャンセル"/>
						</td>
						<td>
							<input type="submit" value="登　録"/>					
						</td>
					</tr>
				</table>
			</html:form>
		
			<table class="detail">
				<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToProductForThumnail.do">
				<input type="hidden" name="product" value="${form.id}"/>
				<tr>
					<td>
						トップページサムネイル<br />
						（150px×150px）
					</td>
					<td>
						<input type="file" name="formFiles[0]"/>
						<input type="submit" value="Go"/>
					</td>
				</tr>
				</form>
				<tr>
					<td>
						詳細画像<br />
						（390px×390px）
					</td>
					<td>
					<table><tr><td>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForDefault.do">
						<input type="hidden" name="asdefault" value="${mainItem.id}"/>
<%--						<input type="hidden" name="default" value="true" />
--%>							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<hr />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForDetailed.do">
						<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
<%--						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
						<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
--%>						</td>
						<td>
						<c:if test="${!empty mainItem.defaultattachment}">
						<a href="ShowImage.do?id=${mainItem.defaultattachment.id}" rel="lightbox">
						<img src="ShowImage.do?id=${mainItem.defaultattachment.id}" width="40" />
						</a>
						<a href="DeleteAttachment.do?id=${mainItem.defaultattachment.id}&from=PostProductDetail.do&toid=${model.id}&itemid=${mainItem.id}">削除</a>
						</c:if>
						<c:forEach var="detailed" items="${mainItem.detailed}" >
						<a href="ShowImage.do?id=${detailed.id}"  rel="lightbox">
						<img src="ShowImage.do?id=${detailed.id}" width="40" />
						</a>
						<a href="DeleteAttachment.do?id=${detailed.id}&from=PostProductDetail.do&toid=${model.id}">削除</a>
						
						</c:forEach>						
						
						</td>
						
						</tr></table>
					</td>
				</tr>
				</form>
				<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToProductForSlideShow.do">
				<input type="hidden" name="product" value="${form.id}"/>
				<tr>
					<td>
						ZOOM・SLIDE SHOW<br />
						（1500px×900px）
					</td>
					<td>
						<input type="file" name="formFiles[0]"/>
						<input type="submit" value="Go"/>
					</td>
				</tr>
				</form>
			</table>
			
			<div class="cartTxt clearfix">
				<h2><strong>バリエーション</strong></h2>
			</div>

			<table class="detail">
				<tr>
					<th>
						バリエーション名
					</th>
					<th>
						商品No
					</th>
					<th>
						価格
					</th>
					<th>
						在庫
					</th>
					<th>
						サイズ
					</th>
					<th>
						マテリアル
					</th>
					<th>
						キャッチコピー
					</th>
					<th>
						本文
					</th>
					<th>
						注釈
					</th>
					<th>
						削除
						編集
					</th>
				</tr>
		
			<c:choose>
				<c:when test="${empty model.items}">
					<tr>
						<td colspan="10" class="price">バリエーションは登録されていません</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${model.items}" var="item">
				<c:if test="${!item.main}">
				<tr>
					<td>
						${item.name}			
					</td>
					<td>
						${item.no}			
					</td>
					<td>
						￥<fmt:formatNumber value="${item.pricewithtax}" pattern="###,###,###"/>			
					</td>
					<td>
						${item.stocknum}			
					</td>
					<td>
						${item.size}			
					</td>
					<td>
						${item.material}			
					</td>
					<td>
						${item.catchcopy}			
					</td>
					<td>
						${item.description}			
					</td>
					<td>
						${item.note}			
					</td>
					<td>
					
						
						<input type="submit" name="button" id="button" value="削除" 
						onClick="javascript:if(window.confirm('削除してもよろしいですか？')){location.href='DeleteItem.do?id=${item.id}';}"/>
						<input type="submit" name="button3" id="button3"  onclick="location.href='PostItemDetail.do?id=${item.id}'" value="編集" />
						
					</td>
				</tr>
				</c:if>
				</c:forEach>
				
				
				</c:otherwise>
			</c:choose>
			
			<tr>
				<c:if test="${!empty form.id}">
					<td colspan="10" align="right"><input type="button" onclick="location.href='PostItemDetail.do?product=${model.id}'" name="button6" id="button6" value="バリエーション追加" /></td>
				</c:if>			
			</tr>
			</table>
	</tiles:put>

</tiles:insert>

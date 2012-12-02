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

	<tiles:put name="title" value="製品" direct="true" />

	<tiles:put name="content" direct="true">
		
		<c:if test="${!empty error}">
			<font color="red">
				<st:error key="error"/>
			</font>	
		</c:if>
		
		<span id="subform">
			<html:form method="POST" action="/PostProductVP">
				<html:hidden name="form" property="id"/>
				<c:set var="mainItem" value='<%= MainItem.Of(request.getAttribute("model"))%>' />			
<table class="formArea">
<tbody>
<tr>
<th>商品ID</th>
<td>&nbsp;</td>
</tr>
<tr>
<th>商品No</th>
<td><input type="text" name="addr2" class="shortForm" /></td>
</tr>
<tr>
<th>商品名</th>

<td><textarea name="textfield" class="longFormEx" id="textfield"></textarea></td>
</tr>
<tr>
<th>カテゴリー</th>
<td><select name="category">
<option value="BROACH" selected="selected">BROACH</option>
<option value="RING">RING</option>
<option value="NECKLACE">NECKLACE</option>
<option value="CLOTHES">CLOTHES</option>
<option value="OTHERS">OTHERS</option>

</select></td>
</tr>
<tr>
<th>バリエーション</th>
<td><input type="text" name="addr2" class="shortForm" /></td>
</tr>
<tr>
<th>価格</th>
<td><input type="text" name="addr" class="shortForm" /></td>
</tr>
<tr>
<th>サイズ</th>
<td><textarea name="textfield2" class="longFormEx" id="textfield2"></textarea></td>

</tr>
<tr>
<th>マテリアル</th>
<td><textarea name="textfield3" class="longFormEx" id="textfield3"></textarea></td>
</tr>
<tr>
<th>キャッチコピー</th>
<td><input type="text" name="textfield4" id="textfield4" class="shortForm" /></td>
</tr>
<tr>
<th>本文</th>
<td><textarea name="textfield5" class="longFormEx" id="textfield5"></textarea></td>

</tr>
<tr>
<th>注釈</th>
<td><textarea name="textfield6" class="longFormEx" id="textfield6"></textarea></td>
</tr>
<tr>
<th>在庫</th>
<td><input type="text" name="textfield9" id="textfield9" class="shortForm" /></td>
</tr>
<tr>
<th>公開</th>
<td><select name="day2">
<option value="非公開" selected="selected">非公開</option>

<option value="公開">公開</option>
</select></td>
</tr>
</tbody>
</table>
				<table align="center">
					<tr>
						<td>
							<input type="button" value="キャンセル"/>
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
						（60px×60px）
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
						（290px×290px）
					</td>
					<td>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForDefault.do">
						<input type="hidden" name="asdefault" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
						<h2></h2>
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
						<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form><br />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form><br />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form><br />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form><br />
						<form method="post" enctype="multipart/form-data" action="AttachmentFormFileUploadAddingToItemForSubDetailed.do">
							<input type="hidden" name="asdetailed" value="${mainItem.id}"/>
							<input type="file" name="formFiles[0]"/>
							<input type="submit" value="Go"/>
						</form>
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
			
			<h3>バリエーション</h3><br />
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
				<tr>
					<td>
						${mainItem.name}			
					</td>
				</tr>
			</table>
		</span>
	</tiles:put>

</tiles:insert>

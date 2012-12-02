<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="product.page.title"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/layout/default-manageable.css"/>"></link>
        <link rel="stylesheet" type="text/css" media="all" href="<html:rewrite page="/layout/default-calendar.css"/>"/>
    </tiles:put>

    <tiles:put name="javascript" type="string">
        <script type="text/javascript" src="<html:rewrite action="/calendar"/>"></script>
        <script type="text/javascript">
        //<!--
            function setSelect(multi, form, name, value)
            {
                var select = form.elements[name];
                var options = select.options;

                // for browser compatibility's sake we go through the options ourselves
                for (var i=0; i<options.length; i++)
                {
                    if (multi)
                    {
                        // Array.indexOf is defined in Javascript 1.5, not before
                        options[i].selected = arrayContainsElement(value,options[i].value);
                    }
                    else
                    {
                        if (options[i].value == value)
                        {
                            select.selectedIndex = i;
                            break;
                        }
                    }

                }
            }

            function arrayContainsElement(array, element)
            {
              var containsElement = false;
              for (var i=0; i<array.length && !containsElement; i++) containsElement = (array[i] == element);
              return containsElement;
            }

            function setAction(crud) { document.forms['manageProductForm'].elements['crud'].value = crud; }

            function enableUpdate(enabled) { document.getElementById("updateButton").disabled = !enabled; }

            var selectionCount = 0;

            function verifyEnableDelete(checkbox)
            {
                if (checkbox.checked) selectionCount++; else selectionCount--;
                document.getElementById("deleteButton").disabled = (selectionCount < 1);
            }

            function clearFields(form)
            {
                form.reset();
                enableUpdate(false);
                setFields("","","","",false,"","","","","","","",false,"","","[]","","","",form);
            }

            function setFields(id,no,name,date,pub,pricewithtax,size,material,catchcopy,description,note,stocknum,removed,mainitemname,english,items,category,thumnail,slideshow,form)
            {
                form.elements["id"].value = id;
                form.elements["no"].value = no;
                form.elements["name"].value = name;
                form.elements["dateAsString"].value = date;
                form.elements["pub"].checked = pub;
                form.elements["pricewithtax"].value = pricewithtax;
                form.elements["size"].value = size;
                form.elements["material"].value = material;
                form.elements["catchcopy"].value = catchcopy;
                form.elements["description"].value = description;
                form.elements["note"].value = note;
                form.elements["stocknum"].value = stocknum;
                form.elements["removed"].checked = removed;
                form.elements["mainitemname"].value = mainitemname;
                form.elements["english"].value = english;
                setSelect(true,form,"items",items.substring(1,items.length-1).split(", "));
                setSelect(false,form,"category",category);
                setSelect(false,form,"thumnail",thumnail);
                setSelect(false,form,"slideshow",slideshow);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="product.page.title"/></h1>
        </div>

        <html:form styleId="manageProductForm" action="/Product/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="product.no"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="no" styleClass="criteriaField" styleId="no"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.name"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="name" styleClass="criteriaField" styleId="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.date"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="dateAsString" styleClass="criteriaField" styleId="date"/>
                                <html:img page="/layout/calendar/calendar.gif" styleId="date_trigger" styleClass="calendar"/>
                                <script type="text/javascript">
                                //<!--
                                    Calendar.setup({
                                        inputField     :    "date",
                                        ifFormat       :    "%Y/%m/%d",
                                        daFormat       :    "%Y/%m/%d",
                                        showsTime      :    false,
                                        button         :    "date_trigger",
                                        singleClick    :    true
                                    });
                                //-->
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="product.pub"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="pub" styleClass="criteriaField" styleId="pub"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.pricewithtax"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="pricewithtax" styleClass="criteriaField" styleId="pricewithtax"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.size"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="size" styleClass="criteriaField" styleId="size"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.material"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="material" styleClass="criteriaField" styleId="material"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.catchcopy"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="catchcopy" styleClass="criteriaField" styleId="catchcopy"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.description"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="description" styleClass="criteriaField" styleId="description"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.note"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="note" styleClass="criteriaField" styleId="note"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.stocknum"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="stocknum" styleClass="criteriaField" styleId="stocknum"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="product.removed"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="removed" styleClass="criteriaField" styleId="removed"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.mainitemname"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="mainitemname" styleClass="criteriaField" styleId="mainitemname"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="product.english"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="english" styleClass="criteriaField" styleId="english"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Item/Manage"><bean:message key="product.items"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.itemsBackingList}">
                                        <select name="items" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="items" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.itemsBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.items}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Category/Manage"><bean:message key="product.category"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.categoryBackingList}">
                                        <select name="category" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="category">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.categoryBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.category}">
                                                        <option value="${valueLabel[0]}" selected="selected">${valueLabel[1]}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel[0]}">${valueLabel[1]}</option>
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
                                    <html:link action="/Attachment/Manage"><bean:message key="product.thumnail"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.thumnailBackingList}">
                                        <select name="thumnail" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="thumnail">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.thumnailBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.thumnail}">
                                                        <option value="${valueLabel[0]}" selected="selected">${valueLabel[1]}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel[0]}">${valueLabel[1]}</option>
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
                                    <html:link action="/Attachment/Manage"><bean:message key="product.slideshow"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.slideshowBackingList}">
                                        <select name="slideshow" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="slideshow">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.slideshowBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.slideshow}">
                                                        <option value="${valueLabel[0]}" selected="selected">${valueLabel[1]}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${valueLabel[0]}">${valueLabel[1]}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>

                    <input type="submit" id="readButton" class="button" value="<bean:message key="button.read"/>" onclick="this.form.elements['id'].value='';setAction('read');"/>
                    <input type="submit" id="createButton" class="button" value="<bean:message key="button.create"/>" onclick="setAction('create');"/>
                    <input type="submit" id="deleteButton" class="button" value="<bean:message key="button.delete"/>" disabled="disabled" onclick="setAction('delete');"/>
                    <input type="submit" id="updateButton" class="button" value="<bean:message key="button.update"/>" disabled="disabled" onclick="setAction('update');return validateUpdate();"/>
                    <input type="button" id="clearButton" class="button" value="<bean:message key="button.clear"/>" onclick="clearFields(this.form);"/>
                </c:if>

<div id="entitySwitcher">
    <nobr>
        <bean:message key="select.other.entity"/>
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_Product='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/></option>
            <option selected="selected" value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
            <option value="<html:rewrite page="/PublicUser/Manage.do"/>"><bean:message key="public.user"/></option>
            <option value="<html:rewrite page="/Purchase/Manage.do"/>"><bean:message key="purchase"/></option>
            <option value="<html:rewrite page="/StaticData/Manage.do"/>"><bean:message key="static.data"/></option>
        </select>
    </nobr>
</div>

            </div>

            <div id="manageableList" class="table">
                <c:if test="${!empty manageableForm.manageableList}">
                    <display:table name="${manageableForm.manageableList}" id="row" requestURI="${pageContext.request.requestURI}"
                            requestURIcontext="false"
                            export="true" pagesize="15" sort="list">
                        <display:column media="html" sortable="false">
                            <fmt:formatDate var="dateFormatted" value="${row.date}" pattern="yyyy/MM/dd"/>
                            <nobr>
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.no}</formatting:escape>','<formatting:escape language="javascript">${row.name}</formatting:escape>','<formatting:escape language="javascript">${dateFormatted}</formatting:escape>',${row.pub},'<formatting:escape language="javascript">${row.pricewithtax}</formatting:escape>','<formatting:escape language="javascript">${row.size}</formatting:escape>','<formatting:escape language="javascript">${row.material}</formatting:escape>','<formatting:escape language="javascript">${row.catchcopy}</formatting:escape>','<formatting:escape language="javascript">${row.description}</formatting:escape>','<formatting:escape language="javascript">${row.note}</formatting:escape>','<formatting:escape language="javascript">${row.stocknum}</formatting:escape>',${row.removed},'<formatting:escape language="javascript">${row.mainitemname}</formatting:escape>','<formatting:escape language="javascript">${row.english}</formatting:escape>','<formatting:escape language="javascript">${row.items}</formatting:escape>','<formatting:escape language="javascript">${row.category}</formatting:escape>','<formatting:escape language="javascript">${row.thumnail}</formatting:escape>','<formatting:escape language="javascript">${row.slideshow}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="no"
                            titleKey="product.no"/>
                        <display:column media="html"
                            headerClass="no" paramId="no" maxLength="36"
                            sortProperty="no" sortable="true"
                            titleKey="product.no"><nobr><formatting:escape language="javascript,html">${row.no}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="name"
                            titleKey="product.name"/>
                        <display:column media="html"
                            headerClass="name" paramId="name" maxLength="36"
                            sortProperty="name" sortable="true"
                            titleKey="product.name"><nobr><formatting:escape language="javascript,html">${row.name}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf" titleKey="product.date">${dateFormatted}</display:column>
                        <display:column media="html"
                            headerClass="date" paramId="date" maxLength="36"
                            sortProperty="date" sortable="true"
                            titleKey="product.date"><nobr>${dateFormatted}</nobr></display:column>
                        <display:column media="html" headerClass="pub" titleKey="product.pub">
                            <c:choose>
                                <c:when test="${row.pub}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="pub" titleKey="product.pub"/>
                        <display:column media="xml csv excel pdf"
                            property="pricewithtax"
                            titleKey="product.pricewithtax"/>
                        <display:column media="html"
                            headerClass="pricewithtax" paramId="pricewithtax" maxLength="36"
                            sortProperty="pricewithtax" sortable="true"
                            titleKey="product.pricewithtax"><nobr><formatting:escape language="javascript,html">${row.pricewithtax}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="size"
                            titleKey="product.size"/>
                        <display:column media="html"
                            headerClass="size" paramId="size" maxLength="36"
                            sortProperty="size" sortable="true"
                            titleKey="product.size"><nobr><formatting:escape language="javascript,html">${row.size}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="material"
                            titleKey="product.material"/>
                        <display:column media="html"
                            headerClass="material" paramId="material" maxLength="36"
                            sortProperty="material" sortable="true"
                            titleKey="product.material"><nobr><formatting:escape language="javascript,html">${row.material}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="catchcopy"
                            titleKey="product.catchcopy"/>
                        <display:column media="html"
                            headerClass="catchcopy" paramId="catchcopy" maxLength="36"
                            sortProperty="catchcopy" sortable="true"
                            titleKey="product.catchcopy"><nobr><formatting:escape language="javascript,html">${row.catchcopy}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="description"
                            titleKey="product.description"/>
                        <display:column media="html"
                            headerClass="description" paramId="description" maxLength="36"
                            sortProperty="description" sortable="true"
                            titleKey="product.description"><nobr><formatting:escape language="javascript,html">${row.description}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="note"
                            titleKey="product.note"/>
                        <display:column media="html"
                            headerClass="note" paramId="note" maxLength="36"
                            sortProperty="note" sortable="true"
                            titleKey="product.note"><nobr><formatting:escape language="javascript,html">${row.note}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="stocknum"
                            titleKey="product.stocknum"/>
                        <display:column media="html"
                            headerClass="stocknum" paramId="stocknum" maxLength="36"
                            sortProperty="stocknum" sortable="true"
                            titleKey="product.stocknum"><nobr><formatting:escape language="javascript,html">${row.stocknum}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="removed" titleKey="product.removed">
                            <c:choose>
                                <c:when test="${row.removed}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="removed" titleKey="product.removed"/>
                        <display:column media="xml csv excel pdf"
                            property="mainitemname"
                            titleKey="product.mainitemname"/>
                        <display:column media="html"
                            headerClass="mainitemname" paramId="mainitemname" maxLength="36"
                            sortProperty="mainitemname" sortable="true"
                            titleKey="product.mainitemname"><nobr><formatting:escape language="javascript,html">${row.mainitemname}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="english"
                            titleKey="product.english"/>
                        <display:column media="html"
                            headerClass="english" paramId="english" maxLength="36"
                            sortProperty="english" sortable="true"
                            titleKey="product.english"><nobr><formatting:escape language="javascript,html">${row.english}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="items"
                            titleKey="product.items"/>
                        <display:column media="html"
                            headerClass="items" paramId="items" maxLength="36"
                            sortProperty="items" sortable="true"
                            titleKey="product.items"><nobr><formatting:escape language="javascript,html">${row.items}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="category"
                            titleKey="product.category"/>
                        <display:column media="html"
                            headerClass="category" paramId="category" maxLength="36"
                            sortProperty="category" sortable="true"
                            titleKey="product.category"><nobr><formatting:escape language="javascript,html">${row.category}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="thumnail"
                            titleKey="product.thumnail"/>
                        <display:column media="html"
                            headerClass="thumnail" paramId="thumnail" maxLength="36"
                            sortProperty="thumnail" sortable="true"
                            titleKey="product.thumnail"><nobr><formatting:escape language="javascript,html">${row.thumnail}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="slideshow"
                            titleKey="product.slideshow"/>
                        <display:column media="html"
                            headerClass="slideshow" paramId="slideshow" maxLength="36"
                            sortProperty="slideshow" sortable="true"
                            titleKey="product.slideshow"><nobr><formatting:escape language="javascript,html">${row.slideshow}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/Product/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


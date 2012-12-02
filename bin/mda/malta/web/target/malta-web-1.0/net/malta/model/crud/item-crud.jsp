<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="item.page.title"/>
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

            function setAction(crud) { document.forms['manageItemForm'].elements['crud'].value = crud; }

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
                setFields("","","","","","","","","","",false,"","[]","","","[]","",form);
            }

            function setFields(id,no,name,pricewithtax,size,material,catchcopy,description,note,stocknum,main,product,choises,carriage,zoom,detailed,defaultattachment,form)
            {
                form.elements["id"].value = id;
                form.elements["no"].value = no;
                form.elements["name"].value = name;
                form.elements["pricewithtax"].value = pricewithtax;
                form.elements["size"].value = size;
                form.elements["material"].value = material;
                form.elements["catchcopy"].value = catchcopy;
                form.elements["description"].value = description;
                form.elements["note"].value = note;
                form.elements["stocknum"].value = stocknum;
                form.elements["main"].checked = main;
                setSelect(false,form,"product",product);
                setSelect(true,form,"choises",choises.substring(1,choises.length-1).split(", "));
                setSelect(false,form,"carriage",carriage);
                setSelect(false,form,"zoom",zoom);
                setSelect(true,form,"detailed",detailed.substring(1,detailed.length-1).split(", "));
                setSelect(false,form,"defaultattachment",defaultattachment);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="item.page.title"/></h1>
        </div>

        <html:form styleId="manageItemForm" action="/Item/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="item.no"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="no" styleClass="criteriaField" styleId="no"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.name"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="name" styleClass="criteriaField" styleId="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.pricewithtax"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="pricewithtax" styleClass="criteriaField" styleId="pricewithtax"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.size"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="size" styleClass="criteriaField" styleId="size"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.material"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="material" styleClass="criteriaField" styleId="material"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.catchcopy"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="catchcopy" styleClass="criteriaField" styleId="catchcopy"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.description"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="description" styleClass="criteriaField" styleId="description"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.note"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="note" styleClass="criteriaField" styleId="note"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="item.stocknum"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="stocknum" styleClass="criteriaField" styleId="stocknum"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="item.main"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="main" styleClass="criteriaField" styleId="main"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <nobr><html:link action="/Product/Manage"><bean:message key="item.product"/></html:link> <div class="important">*</div></nobr>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.productBackingList}">
                                        <select name="product" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="product">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.productBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.product}">
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
                                    <html:link action="/Choise/Manage"><bean:message key="item.choises"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.choisesBackingList}">
                                        <select name="choises" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="choises" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.choisesBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.choises}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Carriage/Manage"><bean:message key="item.carriage"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.carriageBackingList}">
                                        <select name="carriage" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="carriage">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.carriageBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.carriage}">
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
                                    <html:link action="/Attachment/Manage"><bean:message key="item.zoom"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.zoomBackingList}">
                                        <select name="zoom" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="zoom">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.zoomBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.zoom}">
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
                                    <html:link action="/Attachment/Manage"><bean:message key="item.detailed"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.detailedBackingList}">
                                        <select name="detailed" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="detailed" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.detailedBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.detailed}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Attachment/Manage"><bean:message key="item.defaultattachment"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.defaultattachmentBackingList}">
                                        <select name="defaultattachment" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="defaultattachment">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.defaultattachmentBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.defaultattachment}">
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_Item='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option selected="selected" value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/><bean:message key="referencing.entity.marker"/></option>
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
                            <nobr>
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.no}</formatting:escape>','<formatting:escape language="javascript">${row.name}</formatting:escape>','<formatting:escape language="javascript">${row.pricewithtax}</formatting:escape>','<formatting:escape language="javascript">${row.size}</formatting:escape>','<formatting:escape language="javascript">${row.material}</formatting:escape>','<formatting:escape language="javascript">${row.catchcopy}</formatting:escape>','<formatting:escape language="javascript">${row.description}</formatting:escape>','<formatting:escape language="javascript">${row.note}</formatting:escape>','<formatting:escape language="javascript">${row.stocknum}</formatting:escape>',${row.main},'<formatting:escape language="javascript">${row.product}</formatting:escape>','<formatting:escape language="javascript">${row.choises}</formatting:escape>','<formatting:escape language="javascript">${row.carriage}</formatting:escape>','<formatting:escape language="javascript">${row.zoom}</formatting:escape>','<formatting:escape language="javascript">${row.detailed}</formatting:escape>','<formatting:escape language="javascript">${row.defaultattachment}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="no"
                            titleKey="item.no"/>
                        <display:column media="html"
                            headerClass="no" paramId="no" maxLength="36"
                            sortProperty="no" sortable="true"
                            titleKey="item.no"><nobr><formatting:escape language="javascript,html">${row.no}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="name"
                            titleKey="item.name"/>
                        <display:column media="html"
                            headerClass="name" paramId="name" maxLength="36"
                            sortProperty="name" sortable="true"
                            titleKey="item.name"><nobr><formatting:escape language="javascript,html">${row.name}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="pricewithtax"
                            titleKey="item.pricewithtax"/>
                        <display:column media="html"
                            headerClass="pricewithtax" paramId="pricewithtax" maxLength="36"
                            sortProperty="pricewithtax" sortable="true"
                            titleKey="item.pricewithtax"><nobr><formatting:escape language="javascript,html">${row.pricewithtax}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="size"
                            titleKey="item.size"/>
                        <display:column media="html"
                            headerClass="size" paramId="size" maxLength="36"
                            sortProperty="size" sortable="true"
                            titleKey="item.size"><nobr><formatting:escape language="javascript,html">${row.size}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="material"
                            titleKey="item.material"/>
                        <display:column media="html"
                            headerClass="material" paramId="material" maxLength="36"
                            sortProperty="material" sortable="true"
                            titleKey="item.material"><nobr><formatting:escape language="javascript,html">${row.material}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="catchcopy"
                            titleKey="item.catchcopy"/>
                        <display:column media="html"
                            headerClass="catchcopy" paramId="catchcopy" maxLength="36"
                            sortProperty="catchcopy" sortable="true"
                            titleKey="item.catchcopy"><nobr><formatting:escape language="javascript,html">${row.catchcopy}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="description"
                            titleKey="item.description"/>
                        <display:column media="html"
                            headerClass="description" paramId="description" maxLength="36"
                            sortProperty="description" sortable="true"
                            titleKey="item.description"><nobr><formatting:escape language="javascript,html">${row.description}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="note"
                            titleKey="item.note"/>
                        <display:column media="html"
                            headerClass="note" paramId="note" maxLength="36"
                            sortProperty="note" sortable="true"
                            titleKey="item.note"><nobr><formatting:escape language="javascript,html">${row.note}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="stocknum"
                            titleKey="item.stocknum"/>
                        <display:column media="html"
                            headerClass="stocknum" paramId="stocknum" maxLength="36"
                            sortProperty="stocknum" sortable="true"
                            titleKey="item.stocknum"><nobr><formatting:escape language="javascript,html">${row.stocknum}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="main" titleKey="item.main">
                            <c:choose>
                                <c:when test="${row.main}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="main" titleKey="item.main"/>
                        <display:column media="xml csv excel pdf"
                            property="product"
                            titleKey="item.product"/>
                        <display:column media="html"
                            headerClass="product" paramId="product" maxLength="36"
                            sortProperty="product" sortable="true"
                            titleKey="item.product"><nobr><formatting:escape language="javascript,html">${row.product}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="choises"
                            titleKey="item.choises"/>
                        <display:column media="html"
                            headerClass="choises" paramId="choises" maxLength="36"
                            sortProperty="choises" sortable="true"
                            titleKey="item.choises"><nobr><formatting:escape language="javascript,html">${row.choises}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="carriage"
                            titleKey="item.carriage"/>
                        <display:column media="html"
                            headerClass="carriage" paramId="carriage" maxLength="36"
                            sortProperty="carriage" sortable="true"
                            titleKey="item.carriage"><nobr><formatting:escape language="javascript,html">${row.carriage}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="zoom"
                            titleKey="item.zoom"/>
                        <display:column media="html"
                            headerClass="zoom" paramId="zoom" maxLength="36"
                            sortProperty="zoom" sortable="true"
                            titleKey="item.zoom"><nobr><formatting:escape language="javascript,html">${row.zoom}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="detailed"
                            titleKey="item.detailed"/>
                        <display:column media="html"
                            headerClass="detailed" paramId="detailed" maxLength="36"
                            sortProperty="detailed" sortable="true"
                            titleKey="item.detailed"><nobr><formatting:escape language="javascript,html">${row.detailed}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="defaultattachment"
                            titleKey="item.defaultattachment"/>
                        <display:column media="html"
                            headerClass="defaultattachment" paramId="defaultattachment" maxLength="36"
                            sortProperty="defaultattachment" sortable="true"
                            titleKey="item.defaultattachment"><nobr><formatting:escape language="javascript,html">${row.defaultattachment}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/Item/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


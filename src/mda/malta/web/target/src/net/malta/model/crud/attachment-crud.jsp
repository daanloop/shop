<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="attachment.page.title"/>
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

            function setAction(crud) { document.forms['manageAttachmentForm'].elements['crud'].value = crud; }

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
                setFields("","","","",false,"","","","",form);
            }

            function setFields(id,filetype,width,height,wide,dbFile,aszoom,asdetailed,asdefault,form)
            {
                form.elements["id"].value = id;
                form.elements["filetype"].value = filetype;
                form.elements["width"].value = width;
                form.elements["height"].value = height;
                form.elements["wide"].checked = wide;
                setSelect(false,form,"dbFile",dbFile);
                setSelect(false,form,"aszoom",aszoom);
                setSelect(false,form,"asdetailed",asdetailed);
                setSelect(false,form,"asdefault",asdefault);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="attachment.page.title"/></h1>
        </div>

        <html:form styleId="manageAttachmentForm" action="/Attachment/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="attachment.filetype"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="filetype" styleClass="criteriaField" styleId="filetype"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="attachment.width"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="width" styleClass="criteriaField" styleId="width"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="attachment.height"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="height" styleClass="criteriaField" styleId="height"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="attachment.wide"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="wide" styleClass="criteriaField" styleId="wide"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/DbFile/Manage"><bean:message key="attachment.db.file"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.dbFileBackingList}">
                                        <select name="dbFile" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="dbFile">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.dbFileBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.dbFile}">
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
                                    <html:link action="/Item/Manage"><bean:message key="attachment.aszoom"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.aszoomBackingList}">
                                        <select name="aszoom" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="aszoom">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.aszoomBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.aszoom}">
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
                                    <html:link action="/Item/Manage"><bean:message key="attachment.asdetailed"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.asdetailedBackingList}">
                                        <select name="asdetailed" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="asdetailed">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.asdetailedBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.asdetailed}">
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
                                    <html:link action="/Item/Manage"><bean:message key="attachment.asdefault"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.asdefaultBackingList}">
                                        <select name="asdefault" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="asdefault">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.asdefaultBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.asdefault}">
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_Attachment='+this.form.elements['id'].value;">
            <option selected="selected" value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.filetype}</formatting:escape>','<formatting:escape language="javascript">${row.width}</formatting:escape>','<formatting:escape language="javascript">${row.height}</formatting:escape>',${row.wide},'<formatting:escape language="javascript">${row.dbFile}</formatting:escape>','<formatting:escape language="javascript">${row.aszoom}</formatting:escape>','<formatting:escape language="javascript">${row.asdetailed}</formatting:escape>','<formatting:escape language="javascript">${row.asdefault}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="filetype"
                            titleKey="attachment.filetype"/>
                        <display:column media="html"
                            headerClass="filetype" paramId="filetype" maxLength="36"
                            sortProperty="filetype" sortable="true"
                            titleKey="attachment.filetype"><nobr><formatting:escape language="javascript,html">${row.filetype}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="width"
                            titleKey="attachment.width"/>
                        <display:column media="html"
                            headerClass="width" paramId="width" maxLength="36"
                            sortProperty="width" sortable="true"
                            titleKey="attachment.width"><nobr><formatting:escape language="javascript,html">${row.width}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="height"
                            titleKey="attachment.height"/>
                        <display:column media="html"
                            headerClass="height" paramId="height" maxLength="36"
                            sortProperty="height" sortable="true"
                            titleKey="attachment.height"><nobr><formatting:escape language="javascript,html">${row.height}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="wide" titleKey="attachment.wide">
                            <c:choose>
                                <c:when test="${row.wide}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="wide" titleKey="attachment.wide"/>
                        <display:column media="xml csv excel pdf"
                            property="dbFile"
                            titleKey="attachment.db.file"/>
                        <display:column media="html"
                            headerClass="dbFile" paramId="dbFile" maxLength="36"
                            sortProperty="dbFile" sortable="true"
                            titleKey="attachment.db.file"><nobr><formatting:escape language="javascript,html">${row.dbFile}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="aszoom"
                            titleKey="attachment.aszoom"/>
                        <display:column media="html"
                            headerClass="aszoom" paramId="aszoom" maxLength="36"
                            sortProperty="aszoom" sortable="true"
                            titleKey="attachment.aszoom"><nobr><formatting:escape language="javascript,html">${row.aszoom}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="asdetailed"
                            titleKey="attachment.asdetailed"/>
                        <display:column media="html"
                            headerClass="asdetailed" paramId="asdetailed" maxLength="36"
                            sortProperty="asdetailed" sortable="true"
                            titleKey="attachment.asdetailed"><nobr><formatting:escape language="javascript,html">${row.asdetailed}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="asdefault"
                            titleKey="attachment.asdefault"/>
                        <display:column media="html"
                            headerClass="asdefault" paramId="asdefault" maxLength="36"
                            sortProperty="asdefault" sortable="true"
                            titleKey="attachment.asdefault"><nobr><formatting:escape language="javascript,html">${row.asdefault}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/Attachment/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


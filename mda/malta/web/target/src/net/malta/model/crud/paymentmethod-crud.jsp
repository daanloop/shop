<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="payment.method.page.title"/>
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

            function setAction(crud) { document.forms['managePaymentMethodForm'].elements['crud'].value = crud; }

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
                setFields("","","","[]",form);
            }

            function setFields(id,name,note,purchases,form)
            {
                form.elements["id"].value = id;
                form.elements["name"].value = name;
                form.elements["note"].value = note;
                setSelect(true,form,"purchases",purchases.substring(1,purchases.length-1).split(", "));
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="payment.method.page.title"/></h1>
        </div>

        <html:form styleId="managePaymentMethodForm" action="/PaymentMethod/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="payment.method.name"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="name" styleClass="criteriaField" styleId="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="payment.method.note"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="note" styleClass="criteriaField" styleId="note"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Purchase/Manage"><bean:message key="payment.method.purchases"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.purchasesBackingList}">
                                        <select name="purchases" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="purchases" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.purchasesBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.purchases}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_PaymentMethod='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option selected="selected" value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.name}</formatting:escape>','<formatting:escape language="javascript">${row.note}</formatting:escape>','<formatting:escape language="javascript">${row.purchases}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="name"
                            titleKey="payment.method.name"/>
                        <display:column media="html"
                            headerClass="name" paramId="name" maxLength="36"
                            sortProperty="name" sortable="true"
                            titleKey="payment.method.name"><nobr><formatting:escape language="javascript,html">${row.name}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="note"
                            titleKey="payment.method.note"/>
                        <display:column media="html"
                            headerClass="note" paramId="note" maxLength="36"
                            sortProperty="note" sortable="true"
                            titleKey="payment.method.note"><nobr><formatting:escape language="javascript,html">${row.note}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="purchases"
                            titleKey="payment.method.purchases"/>
                        <display:column media="html"
                            headerClass="purchases" paramId="purchases" maxLength="36"
                            sortProperty="purchases" sortable="true"
                            titleKey="payment.method.purchases"><nobr><formatting:escape language="javascript,html">${row.purchases}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/PaymentMethod/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


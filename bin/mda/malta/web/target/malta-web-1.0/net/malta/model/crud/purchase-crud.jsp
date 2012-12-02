<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="purchase.page.title"/>
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

            function setAction(crud) { document.forms['managePurchaseForm'].elements['crud'].value = crud; }

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
                setFields("","","","",false,"",false,false,false,"","[]","",form);
            }

            function setFields(id,total,carriage,totalordernum,shipped,date,temp,cancelled,removed,publicUser,choises,paymentMethod,form)
            {
                form.elements["id"].value = id;
                form.elements["total"].value = total;
                form.elements["carriage"].value = carriage;
                form.elements["totalordernum"].value = totalordernum;
                form.elements["shipped"].checked = shipped;
                form.elements["dateAsString"].value = date;
                form.elements["temp"].checked = temp;
                form.elements["cancelled"].checked = cancelled;
                form.elements["removed"].checked = removed;
                setSelect(false,form,"publicUser",publicUser);
                setSelect(true,form,"choises",choises.substring(1,choises.length-1).split(", "));
                setSelect(false,form,"paymentMethod",paymentMethod);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="purchase.page.title"/></h1>
        </div>

        <html:form styleId="managePurchaseForm" action="/Purchase/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="purchase.total"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="total" styleClass="criteriaField" styleId="total"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="purchase.carriage"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="carriage" styleClass="criteriaField" styleId="carriage"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="purchase.totalordernum"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="totalordernum" styleClass="criteriaField" styleId="totalordernum"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="purchase.shipped"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="shipped" styleClass="criteriaField" styleId="shipped"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="purchase.date"/> <div class="important">*</div></nobr></td>
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
                            <td><bean:message key="purchase.temp"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="temp" styleClass="criteriaField" styleId="temp"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="purchase.cancelled"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="cancelled" styleClass="criteriaField" styleId="cancelled"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="purchase.removed"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="removed" styleClass="criteriaField" styleId="removed"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/PublicUser/Manage"><bean:message key="purchase.public.user"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.publicUserBackingList}">
                                        <select name="publicUser" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="publicUser">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.publicUserBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.publicUser}">
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
                                    <html:link action="/Choise/Manage"><bean:message key="purchase.choises"/></html:link>
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
                                    <html:link action="/PaymentMethod/Manage"><bean:message key="purchase.payment.method"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.paymentMethodBackingList}">
                                        <select name="paymentMethod" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="paymentMethod">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.paymentMethodBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.paymentMethod}">
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_Purchase='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
            <option value="<html:rewrite page="/PublicUser/Manage.do"/>"><bean:message key="public.user"/><bean:message key="referencing.entity.marker"/></option>
            <option selected="selected" value="<html:rewrite page="/Purchase/Manage.do"/>"><bean:message key="purchase"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.total}</formatting:escape>','<formatting:escape language="javascript">${row.carriage}</formatting:escape>','<formatting:escape language="javascript">${row.totalordernum}</formatting:escape>',${row.shipped},'<formatting:escape language="javascript">${dateFormatted}</formatting:escape>',${row.temp},${row.cancelled},${row.removed},'<formatting:escape language="javascript">${row.publicUser}</formatting:escape>','<formatting:escape language="javascript">${row.choises}</formatting:escape>','<formatting:escape language="javascript">${row.paymentMethod}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="total"
                            titleKey="purchase.total"/>
                        <display:column media="html"
                            headerClass="total" paramId="total" maxLength="36"
                            sortProperty="total" sortable="true"
                            titleKey="purchase.total"><nobr><formatting:escape language="javascript,html">${row.total}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="carriage"
                            titleKey="purchase.carriage"/>
                        <display:column media="html"
                            headerClass="carriage" paramId="carriage" maxLength="36"
                            sortProperty="carriage" sortable="true"
                            titleKey="purchase.carriage"><nobr><formatting:escape language="javascript,html">${row.carriage}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="totalordernum"
                            titleKey="purchase.totalordernum"/>
                        <display:column media="html"
                            headerClass="totalordernum" paramId="totalordernum" maxLength="36"
                            sortProperty="totalordernum" sortable="true"
                            titleKey="purchase.totalordernum"><nobr><formatting:escape language="javascript,html">${row.totalordernum}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="shipped" titleKey="purchase.shipped">
                            <c:choose>
                                <c:when test="${row.shipped}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="shipped" titleKey="purchase.shipped"/>
                        <display:column media="xml csv excel pdf" titleKey="purchase.date">${dateFormatted}</display:column>
                        <display:column media="html"
                            headerClass="date" paramId="date" maxLength="36"
                            sortProperty="date" sortable="true"
                            titleKey="purchase.date"><nobr>${dateFormatted}</nobr></display:column>
                        <display:column media="html" headerClass="temp" titleKey="purchase.temp">
                            <c:choose>
                                <c:when test="${row.temp}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="temp" titleKey="purchase.temp"/>
                        <display:column media="html" headerClass="cancelled" titleKey="purchase.cancelled">
                            <c:choose>
                                <c:when test="${row.cancelled}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="cancelled" titleKey="purchase.cancelled"/>
                        <display:column media="html" headerClass="removed" titleKey="purchase.removed">
                            <c:choose>
                                <c:when test="${row.removed}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="removed" titleKey="purchase.removed"/>
                        <display:column media="xml csv excel pdf"
                            property="publicUser"
                            titleKey="purchase.public.user"/>
                        <display:column media="html"
                            headerClass="publicUser" paramId="publicUser" maxLength="36"
                            sortProperty="publicUser" sortable="true"
                            titleKey="purchase.public.user"><nobr><formatting:escape language="javascript,html">${row.publicUser}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="choises"
                            titleKey="purchase.choises"/>
                        <display:column media="html"
                            headerClass="choises" paramId="choises" maxLength="36"
                            sortProperty="choises" sortable="true"
                            titleKey="purchase.choises"><nobr><formatting:escape language="javascript,html">${row.choises}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="paymentMethod"
                            titleKey="purchase.payment.method"/>
                        <display:column media="html"
                            headerClass="paymentMethod" paramId="paymentMethod" maxLength="36"
                            sortProperty="paymentMethod" sortable="true"
                            titleKey="purchase.payment.method"><nobr><formatting:escape language="javascript,html">${row.paymentMethod}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/Purchase/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


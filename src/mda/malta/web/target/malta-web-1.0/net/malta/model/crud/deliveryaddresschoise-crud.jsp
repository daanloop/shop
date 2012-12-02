<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="delivery.address.choise.page.title"/>
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

            function setAction(crud) { document.forms['manageDeliveryAddressChoiseForm'].elements['crud'].value = crud; }

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
                setFields("","","","","","","",form);
            }

            function setFields(id,ordernum,preferreddate,preferredtime,deliveryAddress,choise,giftCard,form)
            {
                form.elements["id"].value = id;
                form.elements["ordernum"].value = ordernum;
                form.elements["preferreddate"].value = preferreddate;
                form.elements["preferredtime"].value = preferredtime;
                setSelect(false,form,"deliveryAddress",deliveryAddress);
                setSelect(false,form,"choise",choise);
                setSelect(false,form,"giftCard",giftCard);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="delivery.address.choise.page.title"/></h1>
        </div>

        <html:form styleId="manageDeliveryAddressChoiseForm" action="/DeliveryAddressChoise/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.choise.ordernum"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="ordernum" styleClass="criteriaField" styleId="ordernum"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.choise.preferreddate"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="preferreddate" styleClass="criteriaField" styleId="preferreddate"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.choise.preferredtime"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="preferredtime" styleClass="criteriaField" styleId="preferredtime"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <nobr><html:link action="/DeliveryAddress/Manage"><bean:message key="delivery.address.choise.delivery.address"/></html:link> <div class="important">*</div></nobr>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.deliveryAddressBackingList}">
                                        <select name="deliveryAddress" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="deliveryAddress">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.deliveryAddressBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.deliveryAddress}">
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
                                    <nobr><html:link action="/Choise/Manage"><bean:message key="delivery.address.choise.choise"/></html:link> <div class="important">*</div></nobr>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.choiseBackingList}">
                                        <select name="choise" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="choise">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.choiseBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.choise}">
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
                                    <html:link action="/GiftCard/Manage"><bean:message key="delivery.address.choise.gift.card"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.giftCardBackingList}">
                                        <select name="giftCard" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="giftCard">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.giftCardBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.giftCard}">
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_DeliveryAddressChoise='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/><bean:message key="referencing.entity.marker"/></option>
            <option selected="selected" value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.ordernum}</formatting:escape>','<formatting:escape language="javascript">${row.preferreddate}</formatting:escape>','<formatting:escape language="javascript">${row.preferredtime}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryAddress}</formatting:escape>','<formatting:escape language="javascript">${row.choise}</formatting:escape>','<formatting:escape language="javascript">${row.giftCard}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="ordernum"
                            titleKey="delivery.address.choise.ordernum"/>
                        <display:column media="html"
                            headerClass="ordernum" paramId="ordernum" maxLength="36"
                            sortProperty="ordernum" sortable="true"
                            titleKey="delivery.address.choise.ordernum"><nobr><formatting:escape language="javascript,html">${row.ordernum}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="preferreddate"
                            titleKey="delivery.address.choise.preferreddate"/>
                        <display:column media="html"
                            headerClass="preferreddate" paramId="preferreddate" maxLength="36"
                            sortProperty="preferreddate" sortable="true"
                            titleKey="delivery.address.choise.preferreddate"><nobr><formatting:escape language="javascript,html">${row.preferreddate}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="preferredtime"
                            titleKey="delivery.address.choise.preferredtime"/>
                        <display:column media="html"
                            headerClass="preferredtime" paramId="preferredtime" maxLength="36"
                            sortProperty="preferredtime" sortable="true"
                            titleKey="delivery.address.choise.preferredtime"><nobr><formatting:escape language="javascript,html">${row.preferredtime}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryAddress"
                            titleKey="delivery.address.choise.delivery.address"/>
                        <display:column media="html"
                            headerClass="deliveryAddress" paramId="deliveryAddress" maxLength="36"
                            sortProperty="deliveryAddress" sortable="true"
                            titleKey="delivery.address.choise.delivery.address"><nobr><formatting:escape language="javascript,html">${row.deliveryAddress}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="choise"
                            titleKey="delivery.address.choise.choise"/>
                        <display:column media="html"
                            headerClass="choise" paramId="choise" maxLength="36"
                            sortProperty="choise" sortable="true"
                            titleKey="delivery.address.choise.choise"><nobr><formatting:escape language="javascript,html">${row.choise}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="giftCard"
                            titleKey="delivery.address.choise.gift.card"/>
                        <display:column media="html"
                            headerClass="giftCard" paramId="giftCard" maxLength="36"
                            sortProperty="giftCard" sortable="true"
                            titleKey="delivery.address.choise.gift.card"><nobr><formatting:escape language="javascript,html">${row.giftCard}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/DeliveryAddressChoise/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


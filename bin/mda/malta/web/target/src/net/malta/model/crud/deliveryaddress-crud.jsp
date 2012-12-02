<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="delivery.address.page.title"/>
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

            function setAction(crud) { document.forms['manageDeliveryAddressForm'].elements['crud'].value = crud; }

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
                setFields("","","","","","","","","","","",false,"[]","","","",form);
            }

            function setFields(id,name,kana,zipthree,zipfour,phone,address,buildingname,pref,preferreddate,preferredtime,hasgiftcard,deliveryAddressChoises,publicUser,giftCard,prefecture,form)
            {
                form.elements["id"].value = id;
                form.elements["name"].value = name;
                form.elements["kana"].value = kana;
                form.elements["zipthree"].value = zipthree;
                form.elements["zipfour"].value = zipfour;
                form.elements["phone"].value = phone;
                form.elements["address"].value = address;
                form.elements["buildingname"].value = buildingname;
                form.elements["pref"].value = pref;
                form.elements["preferreddate"].value = preferreddate;
                form.elements["preferredtime"].value = preferredtime;
                form.elements["hasgiftcard"].checked = hasgiftcard;
                setSelect(true,form,"deliveryAddressChoises",deliveryAddressChoises.substring(1,deliveryAddressChoises.length-1).split(", "));
                setSelect(false,form,"publicUser",publicUser);
                setSelect(false,form,"giftCard",giftCard);
                setSelect(false,form,"prefecture",prefecture);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="delivery.address.page.title"/></h1>
        </div>

        <html:form styleId="manageDeliveryAddressForm" action="/DeliveryAddress/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.name"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="name" styleClass="criteriaField" styleId="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.kana"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="kana" styleClass="criteriaField" styleId="kana"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.zipthree"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="zipthree" styleClass="criteriaField" styleId="zipthree"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.zipfour"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="zipfour" styleClass="criteriaField" styleId="zipfour"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.phone"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="phone" styleClass="criteriaField" styleId="phone"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.address"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="address" styleClass="criteriaField" styleId="address"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.buildingname"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="buildingname" styleClass="criteriaField" styleId="buildingname"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.pref"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="pref" styleClass="criteriaField" styleId="pref"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.preferreddate"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="preferreddate" styleClass="criteriaField" styleId="preferreddate"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="delivery.address.preferredtime"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="preferredtime" styleClass="criteriaField" styleId="preferredtime"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="delivery.address.hasgiftcard"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="hasgiftcard" styleClass="criteriaField" styleId="hasgiftcard"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/DeliveryAddressChoise/Manage"><bean:message key="delivery.address.delivery.address.choises"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.deliveryAddressChoisesBackingList}">
                                        <select name="deliveryAddressChoises" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="deliveryAddressChoises" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.deliveryAddressChoisesBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.deliveryAddressChoises}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <nobr><html:link action="/PublicUser/Manage"><bean:message key="delivery.address.public.user"/></html:link> <div class="important">*</div></nobr>
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
                                    <html:link action="/GiftCard/Manage"><bean:message key="delivery.address.gift.card"/></html:link>
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
                        <tr>
                            <td>
                                    <html:link action="/Prefecture/Manage"><bean:message key="delivery.address.prefecture"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.prefectureBackingList}">
                                        <select name="prefecture" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="prefecture">
                                            <option value=""><bean:message key="select.option.blank"/></option>
                                            <c:forEach var="valueLabel" items="${manageableForm.prefectureBackingList}">
                                                <c:choose>
                                                    <c:when test="${valueLabel[0] eq manageableForm.prefecture}">
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_DeliveryAddress='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option selected="selected" value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
            <option value="<html:rewrite page="/PublicUser/Manage.do"/>"><bean:message key="public.user"/><bean:message key="referencing.entity.marker"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.name}</formatting:escape>','<formatting:escape language="javascript">${row.kana}</formatting:escape>','<formatting:escape language="javascript">${row.zipthree}</formatting:escape>','<formatting:escape language="javascript">${row.zipfour}</formatting:escape>','<formatting:escape language="javascript">${row.phone}</formatting:escape>','<formatting:escape language="javascript">${row.address}</formatting:escape>','<formatting:escape language="javascript">${row.buildingname}</formatting:escape>','<formatting:escape language="javascript">${row.pref}</formatting:escape>','<formatting:escape language="javascript">${row.preferreddate}</formatting:escape>','<formatting:escape language="javascript">${row.preferredtime}</formatting:escape>',${row.hasgiftcard},'<formatting:escape language="javascript">${row.deliveryAddressChoises}</formatting:escape>','<formatting:escape language="javascript">${row.publicUser}</formatting:escape>','<formatting:escape language="javascript">${row.giftCard}</formatting:escape>','<formatting:escape language="javascript">${row.prefecture}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="name"
                            titleKey="delivery.address.name"/>
                        <display:column media="html"
                            headerClass="name" paramId="name" maxLength="36"
                            sortProperty="name" sortable="true"
                            titleKey="delivery.address.name"><nobr><formatting:escape language="javascript,html">${row.name}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="kana"
                            titleKey="delivery.address.kana"/>
                        <display:column media="html"
                            headerClass="kana" paramId="kana" maxLength="36"
                            sortProperty="kana" sortable="true"
                            titleKey="delivery.address.kana"><nobr><formatting:escape language="javascript,html">${row.kana}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="zipthree"
                            titleKey="delivery.address.zipthree"/>
                        <display:column media="html"
                            headerClass="zipthree" paramId="zipthree" maxLength="36"
                            sortProperty="zipthree" sortable="true"
                            titleKey="delivery.address.zipthree"><nobr><formatting:escape language="javascript,html">${row.zipthree}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="zipfour"
                            titleKey="delivery.address.zipfour"/>
                        <display:column media="html"
                            headerClass="zipfour" paramId="zipfour" maxLength="36"
                            sortProperty="zipfour" sortable="true"
                            titleKey="delivery.address.zipfour"><nobr><formatting:escape language="javascript,html">${row.zipfour}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="phone"
                            titleKey="delivery.address.phone"/>
                        <display:column media="html"
                            headerClass="phone" paramId="phone" maxLength="36"
                            sortProperty="phone" sortable="true"
                            titleKey="delivery.address.phone"><nobr><formatting:escape language="javascript,html">${row.phone}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="address"
                            titleKey="delivery.address.address"/>
                        <display:column media="html"
                            headerClass="address" paramId="address" maxLength="36"
                            sortProperty="address" sortable="true"
                            titleKey="delivery.address.address"><nobr><formatting:escape language="javascript,html">${row.address}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="buildingname"
                            titleKey="delivery.address.buildingname"/>
                        <display:column media="html"
                            headerClass="buildingname" paramId="buildingname" maxLength="36"
                            sortProperty="buildingname" sortable="true"
                            titleKey="delivery.address.buildingname"><nobr><formatting:escape language="javascript,html">${row.buildingname}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="pref"
                            titleKey="delivery.address.pref"/>
                        <display:column media="html"
                            headerClass="pref" paramId="pref" maxLength="36"
                            sortProperty="pref" sortable="true"
                            titleKey="delivery.address.pref"><nobr><formatting:escape language="javascript,html">${row.pref}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="preferreddate"
                            titleKey="delivery.address.preferreddate"/>
                        <display:column media="html"
                            headerClass="preferreddate" paramId="preferreddate" maxLength="36"
                            sortProperty="preferreddate" sortable="true"
                            titleKey="delivery.address.preferreddate"><nobr><formatting:escape language="javascript,html">${row.preferreddate}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="preferredtime"
                            titleKey="delivery.address.preferredtime"/>
                        <display:column media="html"
                            headerClass="preferredtime" paramId="preferredtime" maxLength="36"
                            sortProperty="preferredtime" sortable="true"
                            titleKey="delivery.address.preferredtime"><nobr><formatting:escape language="javascript,html">${row.preferredtime}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="hasgiftcard" titleKey="delivery.address.hasgiftcard">
                            <c:choose>
                                <c:when test="${row.hasgiftcard}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="hasgiftcard" titleKey="delivery.address.hasgiftcard"/>
                        <display:column media="xml csv excel pdf"
                            property="deliveryAddressChoises"
                            titleKey="delivery.address.delivery.address.choises"/>
                        <display:column media="html"
                            headerClass="deliveryAddressChoises" paramId="deliveryAddressChoises" maxLength="36"
                            sortProperty="deliveryAddressChoises" sortable="true"
                            titleKey="delivery.address.delivery.address.choises"><nobr><formatting:escape language="javascript,html">${row.deliveryAddressChoises}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="publicUser"
                            titleKey="delivery.address.public.user"/>
                        <display:column media="html"
                            headerClass="publicUser" paramId="publicUser" maxLength="36"
                            sortProperty="publicUser" sortable="true"
                            titleKey="delivery.address.public.user"><nobr><formatting:escape language="javascript,html">${row.publicUser}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="giftCard"
                            titleKey="delivery.address.gift.card"/>
                        <display:column media="html"
                            headerClass="giftCard" paramId="giftCard" maxLength="36"
                            sortProperty="giftCard" sortable="true"
                            titleKey="delivery.address.gift.card"><nobr><formatting:escape language="javascript,html">${row.giftCard}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="prefecture"
                            titleKey="delivery.address.prefecture"/>
                        <display:column media="html"
                            headerClass="prefecture" paramId="prefecture" maxLength="36"
                            sortProperty="prefecture" sortable="true"
                            titleKey="delivery.address.prefecture"><nobr><formatting:escape language="javascript,html">${row.prefecture}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/DeliveryAddress/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


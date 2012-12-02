<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="public.user.page.title"/>
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

            function setAction(crud) { document.forms['managePublicUserForm'].elements['crud'].value = crud; }

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
                setFields("","","","","","","","","","","","","","","","","","","","","",false,false,"","","","","",false,"","",false,false,"","[]","[]","",form);
            }

            function setFields(id,name,kana,zipthree,zipfour,pref,address,buildingname,mail,mailforconfirm,phone,devliveryhour,deliverydate,deliveryphone,deliverykana,deliveryblocknumber,deliveryaddress,deliveryname,deliveryzipfour,deliveryzipthree,deliverypref,delivertodifferentaddress,male,brithday,birthmonth,municipality,birthyear,keitai,removed,password,fax,registed,temp,passwordonetimehash,purchases,deliveryAddresses,prefecture,form)
            {
                form.elements["id"].value = id;
                form.elements["name"].value = name;
                form.elements["kana"].value = kana;
                form.elements["zipthree"].value = zipthree;
                form.elements["zipfour"].value = zipfour;
                form.elements["pref"].value = pref;
                form.elements["address"].value = address;
                form.elements["buildingname"].value = buildingname;
                form.elements["mail"].value = mail;
                form.elements["mailforconfirm"].value = mailforconfirm;
                form.elements["phone"].value = phone;
                form.elements["devliveryhour"].value = devliveryhour;
                form.elements["deliverydate"].value = deliverydate;
                form.elements["deliveryphone"].value = deliveryphone;
                form.elements["deliverykana"].value = deliverykana;
                form.elements["deliveryblocknumber"].value = deliveryblocknumber;
                form.elements["deliveryaddress"].value = deliveryaddress;
                form.elements["deliveryname"].value = deliveryname;
                form.elements["deliveryzipfour"].value = deliveryzipfour;
                form.elements["deliveryzipthree"].value = deliveryzipthree;
                form.elements["deliverypref"].value = deliverypref;
                form.elements["delivertodifferentaddress"].checked = delivertodifferentaddress;
                form.elements["male"].checked = male;
                form.elements["brithday"].value = brithday;
                form.elements["birthmonth"].value = birthmonth;
                form.elements["municipality"].value = municipality;
                form.elements["birthyear"].value = birthyear;
                form.elements["keitai"].value = keitai;
                form.elements["removed"].checked = removed;
                form.elements["password"].value = password;
                form.elements["fax"].value = fax;
                form.elements["registed"].checked = registed;
                form.elements["temp"].checked = temp;
                form.elements["passwordonetimehash"].value = passwordonetimehash;
                setSelect(true,form,"purchases",purchases.substring(1,purchases.length-1).split(", "));
                setSelect(true,form,"deliveryAddresses",deliveryAddresses.substring(1,deliveryAddresses.length-1).split(", "));
                setSelect(false,form,"prefecture",prefecture);
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="public.user.page.title"/></h1>
        </div>

        <html:form styleId="managePublicUserForm" action="/PublicUser/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="public.user.name"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="name" styleClass="criteriaField" styleId="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.kana"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="kana" styleClass="criteriaField" styleId="kana"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.zipthree"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="zipthree" styleClass="criteriaField" styleId="zipthree"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.zipfour"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="zipfour" styleClass="criteriaField" styleId="zipfour"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.pref"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="pref" styleClass="criteriaField" styleId="pref"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.address"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="address" styleClass="criteriaField" styleId="address"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.buildingname"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="buildingname" styleClass="criteriaField" styleId="buildingname"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.mail"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="mail" styleClass="criteriaField" styleId="mail"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.mailforconfirm"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="mailforconfirm" styleClass="criteriaField" styleId="mailforconfirm"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.phone"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="phone" styleClass="criteriaField" styleId="phone"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.devliveryhour"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="devliveryhour" styleClass="criteriaField" styleId="devliveryhour"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliverydate"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliverydate" styleClass="criteriaField" styleId="deliverydate"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryphone"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryphone" styleClass="criteriaField" styleId="deliveryphone"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliverykana"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliverykana" styleClass="criteriaField" styleId="deliverykana"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryblocknumber"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryblocknumber" styleClass="criteriaField" styleId="deliveryblocknumber"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryaddress"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryaddress" styleClass="criteriaField" styleId="deliveryaddress"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryname"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryname" styleClass="criteriaField" styleId="deliveryname"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryzipfour"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryzipfour" styleClass="criteriaField" styleId="deliveryzipfour"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliveryzipthree"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliveryzipthree" styleClass="criteriaField" styleId="deliveryzipthree"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.deliverypref"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="deliverypref" styleClass="criteriaField" styleId="deliverypref"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="public.user.delivertodifferentaddress"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="delivertodifferentaddress" styleClass="criteriaField" styleId="delivertodifferentaddress"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="public.user.male"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="male" styleClass="criteriaField" styleId="male"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.brithday"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="brithday" styleClass="criteriaField" styleId="brithday"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.birthmonth"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="birthmonth" styleClass="criteriaField" styleId="birthmonth"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.municipality"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="municipality" styleClass="criteriaField" styleId="municipality"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.birthyear"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="birthyear" styleClass="criteriaField" styleId="birthyear"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.keitai"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="keitai" styleClass="criteriaField" styleId="keitai"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="public.user.removed"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="removed" styleClass="criteriaField" styleId="removed"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.password"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="password" styleClass="criteriaField" styleId="password"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.fax"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="fax" styleClass="criteriaField" styleId="fax"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="public.user.registed"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="registed" styleClass="criteriaField" styleId="registed"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="public.user.temp"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="temp" styleClass="criteriaField" styleId="temp"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="public.user.passwordonetimehash"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="passwordonetimehash" styleClass="criteriaField" styleId="passwordonetimehash"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Purchase/Manage"><bean:message key="public.user.purchases"/></html:link>
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
                        <tr>
                            <td>
                                    <html:link action="/DeliveryAddress/Manage"><bean:message key="public.user.delivery.addresses"/></html:link>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${empty manageableForm.deliveryAddressesBackingList}">
                                        <select name="deliveryAddresses" disabled="disabled"/>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="deliveryAddresses" multiple="multiple">
                                            <c:forEach var="valueLabel" items="${manageableForm.deliveryAddressesBackingList}">
                        <option value="${valueLabel[0]}"<collections:contains item="${valueLabel}" array="${manageableForm.deliveryAddresses}"> selected="selected"</collections:contains>>${valueLabel[1]}</option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                    <html:link action="/Prefecture/Manage"><bean:message key="public.user.prefecture"/></html:link>
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_PublicUser='+this.form.elements['id'].value;">
            <option value="<html:rewrite page="/Attachment/Manage.do"/>"><bean:message key="attachment"/></option>
            <option value="<html:rewrite page="/Carriage/Manage.do"/>"><bean:message key="carriage"/></option>
            <option value="<html:rewrite page="/Category/Manage.do"/>"><bean:message key="category"/></option>
            <option value="<html:rewrite page="/Choise/Manage.do"/>"><bean:message key="choise"/></option>
            <option value="<html:rewrite page="/DbFile/Manage.do"/>"><bean:message key="db.file"/></option>
            <option value="<html:rewrite page="/DeliveryAddress/Manage.do"/>"><bean:message key="delivery.address"/></option>
            <option value="<html:rewrite page="/DeliveryAddressChoise/Manage.do"/>"><bean:message key="delivery.address.choise"/></option>
            <option value="<html:rewrite page="/GiftCard/Manage.do"/>"><bean:message key="gift.card"/></option>
            <option value="<html:rewrite page="/Item/Manage.do"/>"><bean:message key="item"/></option>
            <option value="<html:rewrite page="/PaymentMethod/Manage.do"/>"><bean:message key="payment.method"/></option>
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/><bean:message key="referencing.entity.marker"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
            <option selected="selected" value="<html:rewrite page="/PublicUser/Manage.do"/>"><bean:message key="public.user"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.name}</formatting:escape>','<formatting:escape language="javascript">${row.kana}</formatting:escape>','<formatting:escape language="javascript">${row.zipthree}</formatting:escape>','<formatting:escape language="javascript">${row.zipfour}</formatting:escape>','<formatting:escape language="javascript">${row.pref}</formatting:escape>','<formatting:escape language="javascript">${row.address}</formatting:escape>','<formatting:escape language="javascript">${row.buildingname}</formatting:escape>','<formatting:escape language="javascript">${row.mail}</formatting:escape>','<formatting:escape language="javascript">${row.mailforconfirm}</formatting:escape>','<formatting:escape language="javascript">${row.phone}</formatting:escape>','<formatting:escape language="javascript">${row.devliveryhour}</formatting:escape>','<formatting:escape language="javascript">${row.deliverydate}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryphone}</formatting:escape>','<formatting:escape language="javascript">${row.deliverykana}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryblocknumber}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryaddress}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryname}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryzipfour}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryzipthree}</formatting:escape>','<formatting:escape language="javascript">${row.deliverypref}</formatting:escape>',${row.delivertodifferentaddress},${row.male},'<formatting:escape language="javascript">${row.brithday}</formatting:escape>','<formatting:escape language="javascript">${row.birthmonth}</formatting:escape>','<formatting:escape language="javascript">${row.municipality}</formatting:escape>','<formatting:escape language="javascript">${row.birthyear}</formatting:escape>','<formatting:escape language="javascript">${row.keitai}</formatting:escape>',${row.removed},'<formatting:escape language="javascript">${row.password}</formatting:escape>','<formatting:escape language="javascript">${row.fax}</formatting:escape>',${row.registed},${row.temp},'<formatting:escape language="javascript">${row.passwordonetimehash}</formatting:escape>','<formatting:escape language="javascript">${row.purchases}</formatting:escape>','<formatting:escape language="javascript">${row.deliveryAddresses}</formatting:escape>','<formatting:escape language="javascript">${row.prefecture}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="name"
                            titleKey="public.user.name"/>
                        <display:column media="html"
                            headerClass="name" paramId="name" maxLength="36"
                            sortProperty="name" sortable="true"
                            titleKey="public.user.name"><nobr><formatting:escape language="javascript,html">${row.name}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="kana"
                            titleKey="public.user.kana"/>
                        <display:column media="html"
                            headerClass="kana" paramId="kana" maxLength="36"
                            sortProperty="kana" sortable="true"
                            titleKey="public.user.kana"><nobr><formatting:escape language="javascript,html">${row.kana}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="zipthree"
                            titleKey="public.user.zipthree"/>
                        <display:column media="html"
                            headerClass="zipthree" paramId="zipthree" maxLength="36"
                            sortProperty="zipthree" sortable="true"
                            titleKey="public.user.zipthree"><nobr><formatting:escape language="javascript,html">${row.zipthree}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="zipfour"
                            titleKey="public.user.zipfour"/>
                        <display:column media="html"
                            headerClass="zipfour" paramId="zipfour" maxLength="36"
                            sortProperty="zipfour" sortable="true"
                            titleKey="public.user.zipfour"><nobr><formatting:escape language="javascript,html">${row.zipfour}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="pref"
                            titleKey="public.user.pref"/>
                        <display:column media="html"
                            headerClass="pref" paramId="pref" maxLength="36"
                            sortProperty="pref" sortable="true"
                            titleKey="public.user.pref"><nobr><formatting:escape language="javascript,html">${row.pref}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="address"
                            titleKey="public.user.address"/>
                        <display:column media="html"
                            headerClass="address" paramId="address" maxLength="36"
                            sortProperty="address" sortable="true"
                            titleKey="public.user.address"><nobr><formatting:escape language="javascript,html">${row.address}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="buildingname"
                            titleKey="public.user.buildingname"/>
                        <display:column media="html"
                            headerClass="buildingname" paramId="buildingname" maxLength="36"
                            sortProperty="buildingname" sortable="true"
                            titleKey="public.user.buildingname"><nobr><formatting:escape language="javascript,html">${row.buildingname}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="mail"
                            titleKey="public.user.mail"/>
                        <display:column media="html"
                            headerClass="mail" paramId="mail" maxLength="36"
                            sortProperty="mail" sortable="true"
                            titleKey="public.user.mail"><nobr><formatting:escape language="javascript,html">${row.mail}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="mailforconfirm"
                            titleKey="public.user.mailforconfirm"/>
                        <display:column media="html"
                            headerClass="mailforconfirm" paramId="mailforconfirm" maxLength="36"
                            sortProperty="mailforconfirm" sortable="true"
                            titleKey="public.user.mailforconfirm"><nobr><formatting:escape language="javascript,html">${row.mailforconfirm}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="phone"
                            titleKey="public.user.phone"/>
                        <display:column media="html"
                            headerClass="phone" paramId="phone" maxLength="36"
                            sortProperty="phone" sortable="true"
                            titleKey="public.user.phone"><nobr><formatting:escape language="javascript,html">${row.phone}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="devliveryhour"
                            titleKey="public.user.devliveryhour"/>
                        <display:column media="html"
                            headerClass="devliveryhour" paramId="devliveryhour" maxLength="36"
                            sortProperty="devliveryhour" sortable="true"
                            titleKey="public.user.devliveryhour"><nobr><formatting:escape language="javascript,html">${row.devliveryhour}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliverydate"
                            titleKey="public.user.deliverydate"/>
                        <display:column media="html"
                            headerClass="deliverydate" paramId="deliverydate" maxLength="36"
                            sortProperty="deliverydate" sortable="true"
                            titleKey="public.user.deliverydate"><nobr><formatting:escape language="javascript,html">${row.deliverydate}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryphone"
                            titleKey="public.user.deliveryphone"/>
                        <display:column media="html"
                            headerClass="deliveryphone" paramId="deliveryphone" maxLength="36"
                            sortProperty="deliveryphone" sortable="true"
                            titleKey="public.user.deliveryphone"><nobr><formatting:escape language="javascript,html">${row.deliveryphone}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliverykana"
                            titleKey="public.user.deliverykana"/>
                        <display:column media="html"
                            headerClass="deliverykana" paramId="deliverykana" maxLength="36"
                            sortProperty="deliverykana" sortable="true"
                            titleKey="public.user.deliverykana"><nobr><formatting:escape language="javascript,html">${row.deliverykana}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryblocknumber"
                            titleKey="public.user.deliveryblocknumber"/>
                        <display:column media="html"
                            headerClass="deliveryblocknumber" paramId="deliveryblocknumber" maxLength="36"
                            sortProperty="deliveryblocknumber" sortable="true"
                            titleKey="public.user.deliveryblocknumber"><nobr><formatting:escape language="javascript,html">${row.deliveryblocknumber}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryaddress"
                            titleKey="public.user.deliveryaddress"/>
                        <display:column media="html"
                            headerClass="deliveryaddress" paramId="deliveryaddress" maxLength="36"
                            sortProperty="deliveryaddress" sortable="true"
                            titleKey="public.user.deliveryaddress"><nobr><formatting:escape language="javascript,html">${row.deliveryaddress}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryname"
                            titleKey="public.user.deliveryname"/>
                        <display:column media="html"
                            headerClass="deliveryname" paramId="deliveryname" maxLength="36"
                            sortProperty="deliveryname" sortable="true"
                            titleKey="public.user.deliveryname"><nobr><formatting:escape language="javascript,html">${row.deliveryname}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryzipfour"
                            titleKey="public.user.deliveryzipfour"/>
                        <display:column media="html"
                            headerClass="deliveryzipfour" paramId="deliveryzipfour" maxLength="36"
                            sortProperty="deliveryzipfour" sortable="true"
                            titleKey="public.user.deliveryzipfour"><nobr><formatting:escape language="javascript,html">${row.deliveryzipfour}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryzipthree"
                            titleKey="public.user.deliveryzipthree"/>
                        <display:column media="html"
                            headerClass="deliveryzipthree" paramId="deliveryzipthree" maxLength="36"
                            sortProperty="deliveryzipthree" sortable="true"
                            titleKey="public.user.deliveryzipthree"><nobr><formatting:escape language="javascript,html">${row.deliveryzipthree}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliverypref"
                            titleKey="public.user.deliverypref"/>
                        <display:column media="html"
                            headerClass="deliverypref" paramId="deliverypref" maxLength="36"
                            sortProperty="deliverypref" sortable="true"
                            titleKey="public.user.deliverypref"><nobr><formatting:escape language="javascript,html">${row.deliverypref}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="delivertodifferentaddress" titleKey="public.user.delivertodifferentaddress">
                            <c:choose>
                                <c:when test="${row.delivertodifferentaddress}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="delivertodifferentaddress" titleKey="public.user.delivertodifferentaddress"/>
                        <display:column media="html" headerClass="male" titleKey="public.user.male">
                            <c:choose>
                                <c:when test="${row.male}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="male" titleKey="public.user.male"/>
                        <display:column media="xml csv excel pdf"
                            property="brithday"
                            titleKey="public.user.brithday"/>
                        <display:column media="html"
                            headerClass="brithday" paramId="brithday" maxLength="36"
                            sortProperty="brithday" sortable="true"
                            titleKey="public.user.brithday"><nobr><formatting:escape language="javascript,html">${row.brithday}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="birthmonth"
                            titleKey="public.user.birthmonth"/>
                        <display:column media="html"
                            headerClass="birthmonth" paramId="birthmonth" maxLength="36"
                            sortProperty="birthmonth" sortable="true"
                            titleKey="public.user.birthmonth"><nobr><formatting:escape language="javascript,html">${row.birthmonth}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="municipality"
                            titleKey="public.user.municipality"/>
                        <display:column media="html"
                            headerClass="municipality" paramId="municipality" maxLength="36"
                            sortProperty="municipality" sortable="true"
                            titleKey="public.user.municipality"><nobr><formatting:escape language="javascript,html">${row.municipality}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="birthyear"
                            titleKey="public.user.birthyear"/>
                        <display:column media="html"
                            headerClass="birthyear" paramId="birthyear" maxLength="36"
                            sortProperty="birthyear" sortable="true"
                            titleKey="public.user.birthyear"><nobr><formatting:escape language="javascript,html">${row.birthyear}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="keitai"
                            titleKey="public.user.keitai"/>
                        <display:column media="html"
                            headerClass="keitai" paramId="keitai" maxLength="36"
                            sortProperty="keitai" sortable="true"
                            titleKey="public.user.keitai"><nobr><formatting:escape language="javascript,html">${row.keitai}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="removed" titleKey="public.user.removed">
                            <c:choose>
                                <c:when test="${row.removed}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="removed" titleKey="public.user.removed"/>
                        <display:column media="xml csv excel pdf"
                            property="password"
                            titleKey="public.user.password"/>
                        <display:column media="html"
                            headerClass="password" paramId="password" maxLength="36"
                            sortProperty="password" sortable="true"
                            titleKey="public.user.password"><nobr><formatting:escape language="javascript,html">${row.password}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="fax"
                            titleKey="public.user.fax"/>
                        <display:column media="html"
                            headerClass="fax" paramId="fax" maxLength="36"
                            sortProperty="fax" sortable="true"
                            titleKey="public.user.fax"><nobr><formatting:escape language="javascript,html">${row.fax}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="registed" titleKey="public.user.registed">
                            <c:choose>
                                <c:when test="${row.registed}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="registed" titleKey="public.user.registed"/>
                        <display:column media="html" headerClass="temp" titleKey="public.user.temp">
                            <c:choose>
                                <c:when test="${row.temp}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="temp" titleKey="public.user.temp"/>
                        <display:column media="xml csv excel pdf"
                            property="passwordonetimehash"
                            titleKey="public.user.passwordonetimehash"/>
                        <display:column media="html"
                            headerClass="passwordonetimehash" paramId="passwordonetimehash" maxLength="36"
                            sortProperty="passwordonetimehash" sortable="true"
                            titleKey="public.user.passwordonetimehash"><nobr><formatting:escape language="javascript,html">${row.passwordonetimehash}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="purchases"
                            titleKey="public.user.purchases"/>
                        <display:column media="html"
                            headerClass="purchases" paramId="purchases" maxLength="36"
                            sortProperty="purchases" sortable="true"
                            titleKey="public.user.purchases"><nobr><formatting:escape language="javascript,html">${row.purchases}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="deliveryAddresses"
                            titleKey="public.user.delivery.addresses"/>
                        <display:column media="html"
                            headerClass="deliveryAddresses" paramId="deliveryAddresses" maxLength="36"
                            sortProperty="deliveryAddresses" sortable="true"
                            titleKey="public.user.delivery.addresses"><nobr><formatting:escape language="javascript,html">${row.deliveryAddresses}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="prefecture"
                            titleKey="public.user.prefecture"/>
                        <display:column media="html"
                            headerClass="prefecture" paramId="prefecture" maxLength="36"
                            sortProperty="prefecture" sortable="true"
                            titleKey="public.user.prefecture"><nobr><formatting:escape language="javascript,html">${row.prefecture}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/PublicUser/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


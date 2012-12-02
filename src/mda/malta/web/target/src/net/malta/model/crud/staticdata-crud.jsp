<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="main.layout">

    <tiles:put name="title" type="string">
        <bean:message key="static.data.page.title"/>
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

            function setAction(crud) { document.forms['manageStaticDataForm'].elements['crud'].value = crud; }

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

            function setFields(id,fromaddress,sitename,basepath,unix,mapeventspan,carriage,creditcardprocesurl,contract_code,form)
            {
                form.elements["id"].value = id;
                form.elements["fromaddress"].value = fromaddress;
                form.elements["sitename"].value = sitename;
                form.elements["basepath"].value = basepath;
                form.elements["unix"].checked = unix;
                form.elements["mapeventspan"].value = mapeventspan;
                form.elements["carriage"].value = carriage;
                form.elements["creditcardprocesurl"].value = creditcardprocesurl;
                form.elements["contract_code"].value = contract_code;
            }
        //-->
        </script>
    </tiles:put>

    <tiles:put name="body" type="string">

        <div>
            <h1><bean:message key="static.data.page.title"/></h1>
        </div>

        <html:form styleId="manageStaticDataForm" action="/StaticData/Manage" method="post">
            <input type="hidden" name="crud" value=""/>
            <div id="criteria">
                <c:if test="${!empty manageableForm}">
                    <table>
                    <html:hidden name="manageableForm" property="id"/>
                        <tr>
                            <td><nobr><bean:message key="static.data.fromaddress"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="fromaddress" styleClass="criteriaField" styleId="fromaddress"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.sitename"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="sitename" styleClass="criteriaField" styleId="sitename"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.basepath"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="basepath" styleClass="criteriaField" styleId="basepath"/>
                            </td>
                        </tr>
                        <tr>
                            <td><bean:message key="static.data.unix"/></td>
                            <td>
                                <html:checkbox name="manageableForm" property="unix" styleClass="criteriaField" styleId="unix"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.mapeventspan"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="mapeventspan" styleClass="criteriaField" styleId="mapeventspan"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.noimage"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:file name="manageableForm" property="noimage" styleClass="criteriaField" styleId="noimage"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.carriage"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="carriage" styleClass="criteriaField" styleId="carriage"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.creditcardprocesurl"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="creditcardprocesurl" styleClass="criteriaField" styleId="creditcardprocesurl"/>
                            </td>
                        </tr>
                        <tr>
                            <td><nobr><bean:message key="static.data.contract.code"/> <div class="important">*</div></nobr></td>
                            <td>
                                <html:text name="manageableForm" property="contract_code" styleClass="criteriaField" styleId="contract_code"/>
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
        <select onchange="document.location=this.options[this.selectedIndex].value+'?ref_StaticData='+this.form.elements['id'].value;">
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
            <option value="<html:rewrite page="/Prefecture/Manage.do"/>"><bean:message key="prefecture"/></option>
            <option value="<html:rewrite page="/Product/Manage.do"/>"><bean:message key="product"/></option>
            <option value="<html:rewrite page="/PublicUser/Manage.do"/>"><bean:message key="public.user"/></option>
            <option value="<html:rewrite page="/Purchase/Manage.do"/>"><bean:message key="purchase"/></option>
            <option selected="selected" value="<html:rewrite page="/StaticData/Manage.do"/>"><bean:message key="static.data"/></option>
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
                                <input type="radio" name="_copy" onclick="enableUpdate(true);setFields('<formatting:escape language="javascript">${row.id}</formatting:escape>','<formatting:escape language="javascript">${row.fromaddress}</formatting:escape>','<formatting:escape language="javascript">${row.sitename}</formatting:escape>','<formatting:escape language="javascript">${row.basepath}</formatting:escape>',${row.unix},'<formatting:escape language="javascript">${row.mapeventspan}</formatting:escape>','<formatting:escape language="javascript">${row.carriage}</formatting:escape>','<formatting:escape language="javascript">${row.creditcardprocesurl}</formatting:escape>','<formatting:escape language="javascript">${row.contract_code}</formatting:escape>',this.form);"/>
                                <input type="checkbox" name="selectedRows" value="${row.id}" onclick="verifyEnableDelete(this);"/>
                            </nobr>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="fromaddress"
                            titleKey="static.data.fromaddress"/>
                        <display:column media="html"
                            headerClass="fromaddress" paramId="fromaddress" maxLength="36"
                            sortProperty="fromaddress" sortable="true"
                            titleKey="static.data.fromaddress"><nobr><formatting:escape language="javascript,html">${row.fromaddress}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="sitename"
                            titleKey="static.data.sitename"/>
                        <display:column media="html"
                            headerClass="sitename" paramId="sitename" maxLength="36"
                            sortProperty="sitename" sortable="true"
                            titleKey="static.data.sitename"><nobr><formatting:escape language="javascript,html">${row.sitename}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="basepath"
                            titleKey="static.data.basepath"/>
                        <display:column media="html"
                            headerClass="basepath" paramId="basepath" maxLength="36"
                            sortProperty="basepath" sortable="true"
                            titleKey="static.data.basepath"><nobr><formatting:escape language="javascript,html">${row.basepath}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="unix" titleKey="static.data.unix">
                            <c:choose>
                                <c:when test="${row.unix}"><input type="checkbox" checked="checked" disabled="disabled"/></c:when>
                                <c:otherwise><input type="checkbox" disabled="disabled"/></c:otherwise>
                            </c:choose>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="unix" titleKey="static.data.unix"/>
                        <display:column media="xml csv excel pdf"
                            property="mapeventspan"
                            titleKey="static.data.mapeventspan"/>
                        <display:column media="html"
                            headerClass="mapeventspan" paramId="mapeventspan" maxLength="36"
                            sortProperty="mapeventspan" sortable="true"
                            titleKey="static.data.mapeventspan"><nobr><formatting:escape language="javascript,html">${row.mapeventspan}</formatting:escape></nobr></display:column>
                        <display:column media="html" headerClass="noimage" paramId="noimage" titleKey="static.data.noimage">
                            <c:if test="${!empty row.noimage}"><html:link action="/StaticData/Manage?crud=getNoimage&id=${row.id}"><div class="binaryData"><nobr><bean:message key="binary.data"/></nobr></div></html:link></c:if>
                        </display:column>
                        <display:column media="xml csv excel pdf"
                            property="carriage"
                            titleKey="static.data.carriage"/>
                        <display:column media="html"
                            headerClass="carriage" paramId="carriage" maxLength="36"
                            sortProperty="carriage" sortable="true"
                            titleKey="static.data.carriage"><nobr><formatting:escape language="javascript,html">${row.carriage}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="creditcardprocesurl"
                            titleKey="static.data.creditcardprocesurl"/>
                        <display:column media="html"
                            headerClass="creditcardprocesurl" paramId="creditcardprocesurl" maxLength="36"
                            sortProperty="creditcardprocesurl" sortable="true"
                            titleKey="static.data.creditcardprocesurl"><nobr><formatting:escape language="javascript,html">${row.creditcardprocesurl}</formatting:escape></nobr></display:column>
                        <display:column media="xml csv excel pdf"
                            property="contract_code"
                            titleKey="static.data.contract.code"/>
                        <display:column media="html"
                            headerClass="contract_code" paramId="contract_code" maxLength="36"
                            sortProperty="contract_code" sortable="true"
                            titleKey="static.data.contract.code"><nobr><formatting:escape language="javascript,html">${row.contract_code}</formatting:escape></nobr></display:column>
                    </display:table>
                </c:if>
            </div>

        </html:form>

        <div id="pageHelpSection">
            <blockquote>
                <a href="" id="pageHelp" style="display:inline;" onclick="openWindow('<html:rewrite action="/StaticData/ManageHelp"/>','onlinehelp',true,false,760,540); return false;">
                    <bean:message key="online.help.href"/>
                </a>
                <html:img page="/layout/help.gif" style="display:inline;"/>
            </blockquote>
        </div>

    </tiles:put>

</tiles:insert>


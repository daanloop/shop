<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="carriage"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="carriage"/></h1>
        <p>
            <bean:message key="carriage.online.help"/>
        </p>
        <h2><bean:message key="carriage.name"/></h2>
        <p>
            <bean:message key="carriage.name.online.help"/>
        </p>
        <h2><bean:message key="carriage.value"/></h2>
        <p>
            <bean:message key="carriage.value.online.help"/>
        </p>
        <h2><bean:message key="carriage.items"/></h2>
        <p>
            <bean:message key="carriage.items.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="prefecture"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="prefecture"/></h1>
        <p>
            <bean:message key="prefecture.online.help"/>
        </p>
        <h2><bean:message key="prefecture.name"/></h2>
        <p>
            <bean:message key="prefecture.name.online.help"/>
        </p>
        <h2><bean:message key="prefecture.public.users"/></h2>
        <p>
            <bean:message key="prefecture.public.users.online.help"/>
        </p>
        <h2><bean:message key="prefecture.delivery.addresses"/></h2>
        <p>
            <bean:message key="prefecture.delivery.addresses.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


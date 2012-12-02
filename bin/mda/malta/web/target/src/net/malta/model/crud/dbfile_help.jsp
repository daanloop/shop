<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="db.file"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="db.file"/></h1>
        <p>
            <bean:message key="db.file.online.help"/>
        </p>
        <h2><bean:message key="db.file.data"/></h2>
        <p>
            <bean:message key="db.file.data.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


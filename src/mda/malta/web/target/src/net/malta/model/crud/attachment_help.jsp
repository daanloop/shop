<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="attachment"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="attachment"/></h1>
        <p>
            <bean:message key="attachment.online.help"/>
        </p>
        <h2><bean:message key="attachment.filetype"/></h2>
        <p>
            <bean:message key="attachment.filetype.online.help"/>
        </p>
        <h2><bean:message key="attachment.width"/></h2>
        <p>
            <bean:message key="attachment.width.online.help"/>
        </p>
        <h2><bean:message key="attachment.height"/></h2>
        <p>
            <bean:message key="attachment.height.online.help"/>
        </p>
        <h2><bean:message key="attachment.wide"/></h2>
        <p>
            <bean:message key="attachment.wide.online.help"/>
        </p>
        <h2><bean:message key="attachment.db.file"/></h2>
        <p>
            <bean:message key="attachment.db.file.online.help"/>
        </p>
        <h2><bean:message key="attachment.aszoom"/></h2>
        <p>
            <bean:message key="attachment.aszoom.online.help"/>
        </p>
        <h2><bean:message key="attachment.asdetailed"/></h2>
        <p>
            <bean:message key="attachment.asdetailed.online.help"/>
        </p>
        <h2><bean:message key="attachment.asdefault"/></h2>
        <p>
            <bean:message key="attachment.asdefault.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


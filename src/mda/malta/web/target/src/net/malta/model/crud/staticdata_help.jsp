<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="static.data"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="static.data"/></h1>
        <p>
            <bean:message key="static.data.online.help"/>
        </p>
        <h2><bean:message key="static.data.fromaddress"/></h2>
        <p>
            <bean:message key="static.data.fromaddress.online.help"/>
        </p>
        <h2><bean:message key="static.data.sitename"/></h2>
        <p>
            <bean:message key="static.data.sitename.online.help"/>
        </p>
        <h2><bean:message key="static.data.basepath"/></h2>
        <p>
            <bean:message key="static.data.basepath.online.help"/>
        </p>
        <h2><bean:message key="static.data.unix"/></h2>
        <p>
            <bean:message key="static.data.unix.online.help"/>
        </p>
        <h2><bean:message key="static.data.mapeventspan"/></h2>
        <p>
            <bean:message key="static.data.mapeventspan.online.help"/>
        </p>
        <h2><bean:message key="static.data.noimage"/></h2>
        <p>
            <bean:message key="static.data.noimage.online.help"/>
        </p>
        <h2><bean:message key="static.data.carriage"/></h2>
        <p>
            <bean:message key="static.data.carriage.online.help"/>
        </p>
        <h2><bean:message key="static.data.creditcardprocesurl"/></h2>
        <p>
            <bean:message key="static.data.creditcardprocesurl.online.help"/>
        </p>
        <h2><bean:message key="static.data.contract.code"/></h2>
        <p>
            <bean:message key="static.data.contract.code.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


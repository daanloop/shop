<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="payment.method"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="payment.method"/></h1>
        <p>
            <bean:message key="payment.method.online.help"/>
        </p>
        <h2><bean:message key="payment.method.name"/></h2>
        <p>
            <bean:message key="payment.method.name.online.help"/>
        </p>
        <h2><bean:message key="payment.method.note"/></h2>
        <p>
            <bean:message key="payment.method.note.online.help"/>
        </p>
        <h2><bean:message key="payment.method.purchases"/></h2>
        <p>
            <bean:message key="payment.method.purchases.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="purchase"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="purchase"/></h1>
        <p>
            <bean:message key="purchase.online.help"/>
        </p>
        <h2><bean:message key="purchase.total"/></h2>
        <p>
            <bean:message key="purchase.total.online.help"/>
        </p>
        <h2><bean:message key="purchase.carriage"/></h2>
        <p>
            <bean:message key="purchase.carriage.online.help"/>
        </p>
        <h2><bean:message key="purchase.totalordernum"/></h2>
        <p>
            <bean:message key="purchase.totalordernum.online.help"/>
        </p>
        <h2><bean:message key="purchase.shipped"/></h2>
        <p>
            <bean:message key="purchase.shipped.online.help"/>
        </p>
        <h2><bean:message key="purchase.date"/></h2>
        <p>
            <bean:message key="purchase.date.online.help"/>
        </p>
        <h2><bean:message key="purchase.temp"/></h2>
        <p>
            <bean:message key="purchase.temp.online.help"/>
        </p>
        <h2><bean:message key="purchase.cancelled"/></h2>
        <p>
            <bean:message key="purchase.cancelled.online.help"/>
        </p>
        <h2><bean:message key="purchase.removed"/></h2>
        <p>
            <bean:message key="purchase.removed.online.help"/>
        </p>
        <h2><bean:message key="purchase.public.user"/></h2>
        <p>
            <bean:message key="purchase.public.user.online.help"/>
        </p>
        <h2><bean:message key="purchase.choises"/></h2>
        <p>
            <bean:message key="purchase.choises.online.help"/>
        </p>
        <h2><bean:message key="purchase.payment.method"/></h2>
        <p>
            <bean:message key="purchase.payment.method.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


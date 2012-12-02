<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="choise"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="choise"/></h1>
        <p>
            <bean:message key="choise.online.help"/>
        </p>
        <h2><bean:message key="choise.ordernum"/></h2>
        <p>
            <bean:message key="choise.ordernum.online.help"/>
        </p>
        <h2><bean:message key="choise.pricewithtax"/></h2>
        <p>
            <bean:message key="choise.pricewithtax.online.help"/>
        </p>
        <h2><bean:message key="choise.wrapping"/></h2>
        <p>
            <bean:message key="choise.wrapping.online.help"/>
        </p>
        <h2><bean:message key="choise.purchase"/></h2>
        <p>
            <bean:message key="choise.purchase.online.help"/>
        </p>
        <h2><bean:message key="choise.item"/></h2>
        <p>
            <bean:message key="choise.item.online.help"/>
        </p>
        <h2><bean:message key="choise.delivery.address.choises"/></h2>
        <p>
            <bean:message key="choise.delivery.address.choises.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


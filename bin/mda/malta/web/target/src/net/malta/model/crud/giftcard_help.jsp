<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="gift.card"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="gift.card"/></h1>
        <p>
            <bean:message key="gift.card.online.help"/>
        </p>
        <h2><bean:message key="gift.card.name"/></h2>
        <p>
            <bean:message key="gift.card.name.online.help"/>
        </p>
        <h2><bean:message key="gift.card.delivery.addresses"/></h2>
        <p>
            <bean:message key="gift.card.delivery.addresses.online.help"/>
        </p>
        <h2><bean:message key="gift.card.delivery.address.choises"/></h2>
        <p>
            <bean:message key="gift.card.delivery.address.choises.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


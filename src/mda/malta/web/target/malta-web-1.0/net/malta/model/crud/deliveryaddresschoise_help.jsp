<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="delivery.address.choise"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="delivery.address.choise"/></h1>
        <p>
            <bean:message key="delivery.address.choise.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.ordernum"/></h2>
        <p>
            <bean:message key="delivery.address.choise.ordernum.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.preferreddate"/></h2>
        <p>
            <bean:message key="delivery.address.choise.preferreddate.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.preferredtime"/></h2>
        <p>
            <bean:message key="delivery.address.choise.preferredtime.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.delivery.address"/></h2>
        <p>
            <bean:message key="delivery.address.choise.delivery.address.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.choise"/></h2>
        <p>
            <bean:message key="delivery.address.choise.choise.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.choise.gift.card"/></h2>
        <p>
            <bean:message key="delivery.address.choise.gift.card.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


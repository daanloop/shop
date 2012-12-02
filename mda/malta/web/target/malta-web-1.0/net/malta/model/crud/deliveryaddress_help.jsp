<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="delivery.address"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="delivery.address"/></h1>
        <p>
            <bean:message key="delivery.address.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.name"/></h2>
        <p>
            <bean:message key="delivery.address.name.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.kana"/></h2>
        <p>
            <bean:message key="delivery.address.kana.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.zipthree"/></h2>
        <p>
            <bean:message key="delivery.address.zipthree.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.zipfour"/></h2>
        <p>
            <bean:message key="delivery.address.zipfour.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.phone"/></h2>
        <p>
            <bean:message key="delivery.address.phone.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.address"/></h2>
        <p>
            <bean:message key="delivery.address.address.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.buildingname"/></h2>
        <p>
            <bean:message key="delivery.address.buildingname.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.pref"/></h2>
        <p>
            <bean:message key="delivery.address.pref.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.preferreddate"/></h2>
        <p>
            <bean:message key="delivery.address.preferreddate.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.preferredtime"/></h2>
        <p>
            <bean:message key="delivery.address.preferredtime.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.hasgiftcard"/></h2>
        <p>
            <bean:message key="delivery.address.hasgiftcard.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.delivery.address.choises"/></h2>
        <p>
            <bean:message key="delivery.address.delivery.address.choises.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.public.user"/></h2>
        <p>
            <bean:message key="delivery.address.public.user.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.gift.card"/></h2>
        <p>
            <bean:message key="delivery.address.gift.card.online.help"/>
        </p>
        <h2><bean:message key="delivery.address.prefecture"/></h2>
        <p>
            <bean:message key="delivery.address.prefecture.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


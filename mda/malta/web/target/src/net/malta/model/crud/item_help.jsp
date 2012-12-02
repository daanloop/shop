<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="item"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="item"/></h1>
        <p>
            <bean:message key="item.online.help"/>
        </p>
        <h2><bean:message key="item.no"/></h2>
        <p>
            <bean:message key="item.no.online.help"/>
        </p>
        <h2><bean:message key="item.name"/></h2>
        <p>
            <bean:message key="item.name.online.help"/>
        </p>
        <h2><bean:message key="item.pricewithtax"/></h2>
        <p>
            <bean:message key="item.pricewithtax.online.help"/>
        </p>
        <h2><bean:message key="item.size"/></h2>
        <p>
            <bean:message key="item.size.online.help"/>
        </p>
        <h2><bean:message key="item.material"/></h2>
        <p>
            <bean:message key="item.material.online.help"/>
        </p>
        <h2><bean:message key="item.catchcopy"/></h2>
        <p>
            <bean:message key="item.catchcopy.online.help"/>
        </p>
        <h2><bean:message key="item.description"/></h2>
        <p>
            <bean:message key="item.description.online.help"/>
        </p>
        <h2><bean:message key="item.note"/></h2>
        <p>
            <bean:message key="item.note.online.help"/>
        </p>
        <h2><bean:message key="item.stocknum"/></h2>
        <p>
            <bean:message key="item.stocknum.online.help"/>
        </p>
        <h2><bean:message key="item.main"/></h2>
        <p>
            <bean:message key="item.main.online.help"/>
        </p>
        <h2><bean:message key="item.product"/></h2>
        <p>
            <bean:message key="item.product.online.help"/>
        </p>
        <h2><bean:message key="item.choises"/></h2>
        <p>
            <bean:message key="item.choises.online.help"/>
        </p>
        <h2><bean:message key="item.carriage"/></h2>
        <p>
            <bean:message key="item.carriage.online.help"/>
        </p>
        <h2><bean:message key="item.zoom"/></h2>
        <p>
            <bean:message key="item.zoom.online.help"/>
        </p>
        <h2><bean:message key="item.detailed"/></h2>
        <p>
            <bean:message key="item.detailed.online.help"/>
        </p>
        <h2><bean:message key="item.defaultattachment"/></h2>
        <p>
            <bean:message key="item.defaultattachment.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


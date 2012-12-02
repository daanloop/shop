<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="category"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="category"/></h1>
        <p>
            <bean:message key="category.online.help"/>
        </p>
        <h2><bean:message key="category.name"/></h2>
        <p>
            <bean:message key="category.name.online.help"/>
        </p>
        <h2><bean:message key="category.products"/></h2>
        <p>
            <bean:message key="category.products.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


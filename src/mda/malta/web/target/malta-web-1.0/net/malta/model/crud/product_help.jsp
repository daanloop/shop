<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="product"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="product"/></h1>
        <p>
            <bean:message key="product.online.help"/>
        </p>
        <h2><bean:message key="product.no"/></h2>
        <p>
            <bean:message key="product.no.online.help"/>
        </p>
        <h2><bean:message key="product.name"/></h2>
        <p>
            <bean:message key="product.name.online.help"/>
        </p>
        <h2><bean:message key="product.date"/></h2>
        <p>
            <bean:message key="product.date.online.help"/>
        </p>
        <h2><bean:message key="product.pub"/></h2>
        <p>
            <bean:message key="product.pub.online.help"/>
        </p>
        <h2><bean:message key="product.pricewithtax"/></h2>
        <p>
            <bean:message key="product.pricewithtax.online.help"/>
        </p>
        <h2><bean:message key="product.size"/></h2>
        <p>
            <bean:message key="product.size.online.help"/>
        </p>
        <h2><bean:message key="product.material"/></h2>
        <p>
            <bean:message key="product.material.online.help"/>
        </p>
        <h2><bean:message key="product.catchcopy"/></h2>
        <p>
            <bean:message key="product.catchcopy.online.help"/>
        </p>
        <h2><bean:message key="product.description"/></h2>
        <p>
            <bean:message key="product.description.online.help"/>
        </p>
        <h2><bean:message key="product.note"/></h2>
        <p>
            <bean:message key="product.note.online.help"/>
        </p>
        <h2><bean:message key="product.stocknum"/></h2>
        <p>
            <bean:message key="product.stocknum.online.help"/>
        </p>
        <h2><bean:message key="product.removed"/></h2>
        <p>
            <bean:message key="product.removed.online.help"/>
        </p>
        <h2><bean:message key="product.mainitemname"/></h2>
        <p>
            <bean:message key="product.mainitemname.online.help"/>
        </p>
        <h2><bean:message key="product.english"/></h2>
        <p>
            <bean:message key="product.english.online.help"/>
        </p>
        <h2><bean:message key="product.items"/></h2>
        <p>
            <bean:message key="product.items.online.help"/>
        </p>
        <h2><bean:message key="product.category"/></h2>
        <p>
            <bean:message key="product.category.online.help"/>
        </p>
        <h2><bean:message key="product.thumnail"/></h2>
        <p>
            <bean:message key="product.thumnail.online.help"/>
        </p>
        <h2><bean:message key="product.slideshow"/></h2>
        <p>
            <bean:message key="product.slideshow.online.help"/>
        </p>
    </tiles:put>

</tiles:insert>


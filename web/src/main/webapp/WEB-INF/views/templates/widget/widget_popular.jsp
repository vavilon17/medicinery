<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="widget-popular">
    <p class="h2">Самые популярные</p>
    <ul>
        <jsp:include page="/popular?toWidget=true"/>
    </ul>
</div>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<section class="content-area">
    <p class="h1">Популярные препараты</p>
    <table class="table table-popular-main">
        <tr>
            <th>Название</th>
            <th>Препараты</th>
        </tr>
        <jsp:include page="/popular"/>
        <%--<g:include controller="main" action="mostPopular" params="[toWidget: false]"/>--%>
    </table>
</section>
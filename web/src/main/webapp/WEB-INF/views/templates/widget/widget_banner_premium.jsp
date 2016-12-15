<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fix-zone">
    <div class="banner-premium">
        <%--<a href="#">
            <%@ include file="../banner/300x250.jsp" %>
        </a>--%>
    </div>

    <c:if test="${param['showPrices'] == true}">
        <div class="widget-prices">
            <p class="h2">Цены в аптеках</p>
        </div>
    </c:if>
</div>
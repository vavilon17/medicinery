<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${similarItems.size() > 0}">
    <div class="widget-popular widget-similar">
        <p class="h2">Похожие препараты</p>
        <ul>
            <c:forEach items="${similarItems}" var="item">
                <li><a href="/medicine/${item}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>
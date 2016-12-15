<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${similars != null && similars.size() > 0}">
    <h4>Похожие препараты</h4>
    <div class="content-hidetext-block similar_mob_block">
        <ul>
            <c:forEach items="${similars}" var="item">
                <li><a href="/medicine/${item}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

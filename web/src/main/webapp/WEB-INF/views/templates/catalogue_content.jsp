<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-area">
    <p class="h2">Каталог, буква <span>${letter.toUpperCase()}</span></p>
    <table class="catalog-list">
        <c:forEach items="${items}" var="item" varStatus="loop">
            <c:if test="${loop.index % 2 == 0}">
                <tr>
            </c:if>
            <td>
                <a href="/medicine/${item.title}">${item.title}</a>
            </td>
            <c:if test="${loop.index % 2 != 0}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
</section>
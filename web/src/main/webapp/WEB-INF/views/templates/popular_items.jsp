<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${toWidget}">
        <c:forEach items="${items}" var="item">
            <li><a href="/">${item.key}</a></li>
            <%--<li><a href="${createLink(controller: 'main', action: 'medicine')}/${item.key}">${item.key}</a></li>--%>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><a href="/">${item.key}</a></td>
                <td>${item.value}</td>
            </tr>
        </c:forEach>
    </c:otherwise>
</c:choose>

<%-- from old GSP:
<g:if test="${toWidget}">
    <g:each in="${items}" var="item">
        <li><a href="${createLink(controller: 'main', action: 'medicine')}/${item.key}">${item.key}</a></li>
    </g:each>
</g:if>
<g:else>
    <g:each in="${items}" var="item">
        <tr>
            <td><a href="${createLink(controller: 'main', action: 'medicine')}/${item.key}">${item.key}</a></td>
            <td>${item.value}</td>
        </tr>
    </g:each>
</g:else>--%>

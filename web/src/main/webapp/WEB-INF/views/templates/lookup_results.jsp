<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${results}" var="item">
    <li class="__search-dropdown-item"><a href="/medicine/${item}">${item}</a></li>
</c:forEach>
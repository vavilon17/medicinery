<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<ul class="item-contents">
    <c:forEach items="${anchors.entrySet()}" var="entry">
        <li><a href="#${entry.key}">${entry.value}</a></li>
    </c:forEach>
</ul>
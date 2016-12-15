<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="content-title">
    <span class="content-title__name">${item.title}</span>
    <span class="content-title__brand">
        <c:if test="${item.details.manufacturer != null}">
            <c:choose>
                <c:when test="${item.details.manufacturer.manufacturerName_ru != null}">
                    <span>${item.details.manufacturer.manufacturerName_ru}</span>
                </c:when>
                <c:otherwise>
                    <c:if test="${item.detailsa.manufacturer.manufacturerName_en != null}">
                        <span>${item.details.manufacturer.manufacturerName_en}</span>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:if>
    </span>
</div>
<div class="content-image">
    <c:if test="${fakeFileName != null}">
        <img src="/resources/image/main/${fakeFileName}"
             alt="${item.title} - описание препарата, инструкция по применению"
             title="${item.title} - описание препарата, инструкция по применению">
    </c:if>
</div>
<div class="content-price row">
    <c:if test="${pricesRange.isFilled()}">
        <div class="content-price__price">
            <p>Цена от <span>${pricesRange.lowPrice} ${curr}</span></p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; до <span>${pricesRange.highPrice} ${curr}</span></p>
        </div>
        <a class="btn content-price__btn"  href="/prices/${item.title}" onclick="Conf.BUY_CLICK_HANDLER(this);">Купить</a>
    </c:if>
</div>
<div class="content-hidetext">
    <jsp:include page="similar.jsp">
        <jsp:param name="similars" value="${similars}"/>
    </jsp:include>
    ${item.details.tradeNameManual}
</div>
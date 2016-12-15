<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-area">
    <p class="h3">${item.title}
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
    </p>

    <div class="item-data clearfix">
        <c:if test="${fakeFileName != null}">
            <img src="/resources/image/main/${fakeFileName}"
                 alt="${item.title} - описание препарата, инструкция по применению"
                 title="${item.title} - описание препарата, инструкция по применению">
        </c:if>

        <div class="item-details clearfix">
            <jsp:include page="product_anchors.jsp">
                <jsp:param name="anchors" value="${anchors}"/>
            </jsp:include>
            <c:if test="${pricesRange.isFilled()}">
                <p class="item-price">цена от <span>${pricesRange.lowPrice}</span> до <span>${pricesRange.highPrice}</span> <span>${curr}</span></p>
                <a class="btn-item-action" href="/prices/${item.title}" onclick="Conf.BUY_CLICK_HANDLER(this);">Купить сейчас</a>
            </c:if>
        </div>
    </div>

    <div class="item-description">
        ${item_content}
    </div>
</section>
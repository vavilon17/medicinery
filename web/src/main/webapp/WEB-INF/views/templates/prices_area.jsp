<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="content-area">
    <p class="h3">${item.title}<%--<span>Bayer</span>--%></p>

    <div class="item-data clearfix">
        <c:if test="${fakeFileName != null}">
            <img src="/resources/image/main/${fakeFileName}"
                 alt="${item.title} - описание препарата, инструкция по применению"
                 title="${item.title} - описание препарата, инструкция по применению">
        </c:if>
        <div class="item-details clearfix">
            <c:choose>
                <c:when test="${pricesVals.size() > 0}">
                    <p class="item-price">цена от <span>${pricesVals.firstEntry().getValue()}</span> до <span>${pricesVals.lastEntry().getValue()}</span><span>${curr}</span></p>
                </c:when>
                <c:otherwise>
                    <p class="item-price">На данный момент нету ценовых предложений</p>
                </c:otherwise>
            </c:choose>
            <a class="btn-item-action" href="/medicine/${item.title}">Инструкция</a>
        </div>
    </div>

    <c:forEach items="${prices.keySet()}" var="store">
        <div class="item-shop">
            <p class="item-shop-name">${store.printName}</p>
            <c:if test="${store.extraInfo}">
                <p class="item-shop-details">${store.extraInfo}</p>
            </c:if>
            <p class="item-shop-details">Телефон: ${store.phone}<span>Адрес: ${store.address}</span></p>
            <ul class="item-shop-address">
                <c:forEach items="${prices.get(store)}" var="price">
                    <li onclick="_gaq.push(['_trackEvent','Аптеки','Wer.ru']);">
                        <a rel="nofollow" href="${price.url}${store.urlSuffix != null && store.urlSuffix != "" ? store.urlSuffix : ""}" target="_blank">
                            <span>${price.drugName} ${price.form != null && price.form != "" ? price.form : ""}</span>
                            <span>${price.price} ${curr}</span>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>
</section>
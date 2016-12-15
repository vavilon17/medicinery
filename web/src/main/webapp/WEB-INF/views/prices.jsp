<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html class="footerfix">
<head>
    <title>${item.title}  цена в аптеках, инструкция. Купить ${item.title}</title>
    <link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon">
    <link href="/resources/css/global.css" rel='stylesheet' type='text/css'>
    <link href="/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width"/>
    <meta name="description" content="Стоимость препарата ${item.title}, наличие в аптеках, сравнение цен, похожие препараты. Адреса аптек"/>
    <meta name="keywords" content="${item.title}, цена, наличие, сравнение цен, купить, похожие препараты"/>
    <meta charset="UTF-8"/>
</head>
<body class="prices">
<%--<%@ include file="templates/analysis/ga.jsp"%>--%>
<%@ include file="templates/config.jsp" %>
<div class="root">
    <%@ include file="templates/header.jsp" %>
    <div class="page-container clearfix">
        <%@ include file="templates/search.jsp" %>
        <jsp:include page="templates/prices_area.jsp"/>
        <aside class="widget-area">
            <jsp:include page="/similar">
                <jsp:param name="medicineId" value="${item.id}"/>
                <jsp:param name="innId" value="${item.details.innId}"/>
            </jsp:include>
            <jsp:include page="templates/widget/widget_banner_premium.jsp">
                <jsp:param name="showPrices" value="false"/>
            </jsp:include>
        </aside>
    </div>
</div>
<%@ include file="templates/footer.jsp" %>
<link href="/resources/css/bootstrap-theme.min.css"/>
<link href='http://fonts.googleapis.com/css?family=Ubuntu&subset=cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/common.js"></script>
<%--<%@ include file="templates/analysis/yan_metr.jsp"%>--%>
</body>
</html>
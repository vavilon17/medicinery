<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html class="footerfix">
<head>
    <title>${item.title} | Описание препарата | Инструкция</title>
    <link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon">
    <link href="/resources/css/global.css" rel='stylesheet' type='text/css'>
    <link href="/resources/css/bootstrap.min.css" rel='stylesheet' type='text/css'>
    <link href="/resources/css/bootstrap-theme.min.css" rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width">
    <meta name="description" content="${item.title} - все о препарате, показания, противопоказания, побочные действия, способ применения, похожие препараты, передозировка, беременность, кормление грудью">
    <meta name="keywords" content="${item.title}, инструкция, описание, показания к примменению, дозировка, лекарство, лекарственный препарат, похожие препараты">
    <meta charset="UTF-8"/>
</head>
<body class="medicine">
<%--<%@ include file="templates/analysis/ga.jsp"%>--%>
<%@ include file="templates/config.jsp" %>
<div class="root">
    <%@ include file="templates/header.jsp" %>
    <div class="page-container clearfix">
        <%@ include file="templates/search.jsp" %>
        <jsp:include page="templates/product.jsp"/>
        <aside class="widget-area">
            <jsp:include page="/similar">
                <jsp:param name="medicineId" value="${item.id}"/>
                <jsp:param name="innId" value="${item.details.innId}"/>
            </jsp:include>
            <jsp:include page="templates/widget/widget_banner_premium.jsp">
                <jsp:param name="showPrices" value="${pricesRange.isFilled()}"/>
            </jsp:include>
        </aside>
    </div>
</div>
<%@ include file="templates/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400&subset=cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
<script src="/resources/js/common.js"></script>
<%--<%@ include file="templates/analysis/yan_metr.jsp"%>--%>
</body>
</html>
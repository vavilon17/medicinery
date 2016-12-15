<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html class="footerfix">
<head>
    <title>Справочник лекарств - поиск лекарств по аптекам. Цены на лекарства</title>
    <link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon">
    <link href="/resources/css/global.css" rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width">
    <meta name="description" content="Сервис поиска лекарств и медикаментов в аптеках, инструкции, описание, сравнение цен">
    <meta name="keywords" content="Поиск лекарств в аптеках, сравнение цен, наличие лекарств">
    <meta charset="UTF-8"/>
</head>
<body class="main">
<%--<%@ include file="templates/analysis/ga.jsp"%>--%>
<%@ include file="templates/config.jsp" %>
<div class="root">
    <%@ include file="templates/header.jsp" %>
    <div class="page-container clearfix">
        <%@ include file="templates/search.jsp" %>
        <%@ include file="templates/section_popular.jsp" %>
        <aside class="widget-area">
            <jsp:include page="templates/widget/widget_banner_premium.jsp">
                <jsp:param name="showPrices" value="false"/>
            </jsp:include>
        </aside>
    </div>
</div>
<%@ include file="templates/footer.jsp" %>
<link href='http://fonts.googleapis.com/css?family=Ubuntu&subset=cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="/resources/js/common.js"></script>
<%--<%@ include file="templates/analysis/yan_metr.jsp"%>--%>
</body>
</html>
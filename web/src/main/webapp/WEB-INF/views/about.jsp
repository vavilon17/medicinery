<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<html class="footerfix">
<head>
    <title>О проекте - главная</title>
    <link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon">
    <link href="/resources/css/global.css" rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width">
    <meta charset="UTF-8"/>
</head>
<body>
<%--<%@ include file="templates/analysis/ga.jsp"%>--%>
<%@ include file="templates/config.jsp" %>
<div class="main">
    <%@include file="templates/header.jsp"%>
    <div class="page-container clearfix">
        <%@ include file="templates/search.jsp"%>
        <p class="h1">О проекте</p>
        <p>Справочник лекартсв Medicinery.info разработан с целью облегчить поиск информации о медицинских препаратах, актуальных ценах на лекарства, наличии в аптеках. Инструкции составлены в упрощенной форме для удобства восприятия и не являются руководством к действию.</p>
        <p>Самолечение может быть опасным для здоровья!</p>
        <aside class="widget-area">
            <jsp:include page="templates/widget/widget_banner_premium.jsp">
                <jsp:param name="showPrices" value="false"/>
            </jsp:include>
        </aside>
    </div>
</div>
<%@ include file="templates/footer.jsp"%>
<link href='http://fonts.googleapis.com/css?family=Ubuntu&subset=cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
<script src="/resources/js/common.js"></script>
<%--<%@ include file="templates/analysis/yan_metr.jsp"%>--%>
</body>
</html>
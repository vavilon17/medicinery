<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <title>${item.title} | Описание препарата | Инструкция</title>
    <link href="/resources/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="/resources/css/mobile_new.css" rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <meta name="description" content="${item.title} - все о препарате, показания, противопоказания, побочные действия, способ применения, передозировка, беременность, кормление грудью">
    <meta name="keywords" content="${item.title}, инструкция, описание, показания к примменению, дозировка, лекарство, лекарственный препарат">
    <meta charset="UTF-8"/>
</head>
<body class="medicine">
<%--<%@ include file="templates/analysis/ga.jsp"%>--%>
<%@ include file="templates/config.jsp" %>
<div class="wrapper">
    <%@ include file="templates/mob/header.jsp" %>
    <div class="content">
        <div class="container">
            <jsp:include page="templates/mob/conent_body.jsp"/>
            <%--<%@ include file="templates/mob/footer_banner.jsp"%>--%>
            <%@ include file="templates/mob/footer.jsp" %>
        </div>
    </div>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/resources/js/script_mob.js"></script>
<%--<%@ include file="templates/analysis/yan_metr.jsp"%>--%>
</body>
</html>

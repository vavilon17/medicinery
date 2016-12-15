<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<i class="search-area-mobile"></i>
<aside class="search-area clearfix">
    <p class="__caption">Поиск лекарств</p>
    <ul class="__letters">
        <c:forTokens items="А,Б,В,Г,Д,Е,Ж,З,И,Й,К,Л,М,Н,О,П,Р,С,Т,У,Ф,Х,Ц,Ч,Ш,Э,Ю,Я" delims="," var="letter">
            <li><a href="<c:url value="/catalogue/${letter.toUpperCase()}"/>">${letter}</a></li>
        </c:forTokens>
    </ul>
    <div class="__search-drug">
        <form onsubmit="return false;">
            <input id="searchDrug" type="text" value="" placeholder="" autocomplete="off">
            <input type="submit" value="">
        </form>
        <ul class="__quick-search" style="display: none;">
            <%--lookup results here--%>
        </ul>
    </div>
</aside>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<header>
    <div class="container">
        <a href="/" class="header__logo">
            <img src="/resources/img/med/logo-main-mobile.png" height="28" width="28" alt="" />
        </a>
        <a href="" class="header__search"></a>
        <div class="search-area header-searchblock">
            <div class="header-searchblock-bg">
                <form onsubmit="return false;">
                    <input id="searchDrug" type="text" name="key" class="header-searchblock__inp" autocomplete="off" />
                    <button class="header-searchblock__btn"></button>
                </form>
                <ul class="__quick-search" style="display: none;">
                    <%--lookup results here--%>
                </ul>
            </div>
        </div>
    </div>
</header>
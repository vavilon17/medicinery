 /* --------------------------- search.js ------------------------------------- */
// quick search
$('#searchDrug').on('keyup', function(e) {
    if ([13, 38, 40].indexOf(e.keyCode) == -1) {
        var key = $(this).val();
        var $resultsHolder = $('.search-area .__quick-search');
        if (key.length > 1) {
            $.ajax({
                url: Conf.LOOKUP,
                type: 'POST',
                data: {
                    input: key
                }
            }).done(function(res) {
                $resultsHolder.html(res);
                $resultsHolder.show();
                if ($resultsHolder.children().length < 1) {
                    $resultsHolder.hide();
                }
            });
        } else {
            $resultsHolder.hide();
            $resultsHolder.html('');
        }
    }
});

$(function(){
    $(".search-area-mobile").on("click", function(){
        $(".search-area").toggleClass("__mobile-visible") && $("#searchDrug").focus() && $(this).toggleClass("__active");
        return false;
    });
});

$("#searchDrug").keydown(function(e){
    if ([13, 38, 40].indexOf(e.keyCode) > -1) {
        var $dropdown = $(".__quick-search");
        var hasChildren = $dropdown.children().length > 0;
        if (!$dropdown.hasClass('hidden') && hasChildren) {
            var $focused = $dropdown.children(".__focus");
            switch(e.keyCode) {
                // "up" arrow
                case 38:
                    if ($focused.length == 0) {
                        $dropdown.children().last().addClass('__focus');
                    } else {
                        $focused.removeClass('__focus');
                        if ($focused.prev().length > 0) {
                            $focused.prev().addClass('__focus');
                        } else {
                            $dropdown.children().last().addClass('__focus');
                        }
                    }
                    break;
                // "down" arrow
                case 40:
                    if ($focused.length == 0) {
                        $dropdown.children().first().addClass('__focus');
                    } else {
                        $focused.removeClass('__focus');
                        if ($focused.next().length > 0) {
                            $focused.next().addClass('__focus');
                        } else {
                            $dropdown.children().first().addClass('__focus');
                        }
                    }
                    break;
                // "enter"
                case 13:
                    var url;
                    if ($focused.length == 0) {
                        url = $dropdown.find('a:first').attr('href');
                    } else {
                        url = $focused.find('a').attr('href');
                    }
                    window.location = url;
                    break;
            }
        }
    }
});
/* ------------------------------ end search.js ---------------------------------- */

/* -------------------------------- fix-block.js -------------------------------- */
; window.show_fix_block = function(selector, offsetBottom, selfHeight){

    var offsetBottom = Number(offsetBottom) || 50;

    var fix_block = $(selector);

    //if(! fix_block.size() || fix_block.size() > 1) return;
    if(! fix_block.size()) return;

    var fix_block_width = fix_block.width();

    var sidebar = $('.widget-area');
    if(! sidebar.size()) return ;

    var selfHeight = Number(selfHeight) || sidebar.outerHeight() || 600;

    if( $(window).width() < 1000 || $(window).height() < selfHeight || screen.width < 1000) return;
    if ( $('.content-area').height() - sidebar.height() < 2 * selfHeight ) return;

    var show_fix_block = false;

    $(window).bind('scroll resize', function () {

        var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

        if(show_fix_block == false){
            var last_sidebar_item_bottom = sidebar.offset().top + sidebar.outerHeight()
        }else{
            var last_sidebar_item_bottom = sidebar.offset().top + sidebar.outerHeight() + fix_block.outerHeight() + 20
        }

        if( $(window).width() < 1000 || $(window).height() < selfHeight || screen.width < 1000) {
            if(show_fix_block == true){
                fix_block.removeClass('fix-block');
                fix_block.hide();
            }
            show_fix_block = false;
            return;
        }

        if( scrollTop > last_sidebar_item_bottom) {
            if(show_fix_block == false){
                fix_block.addClass('fix-block').animate({ opacity: 0 }, 0, function() {
                    fix_block.show();
                    fix_block.animate({ opacity: 1 }, 500)
                })
            }
            show_fix_block = true
        }else{
            if(show_fix_block == true){
                fix_block.removeClass('fix-block');
                fix_block.hide();
            }
            show_fix_block = false
        }
        if( (fix_block.outerHeight() + scrollTop) > $('footer').offset().top - offsetBottom  ){
            if(show_fix_block == true){
                fix_block.removeClass('fix-block');
                fix_block.hide();
            }
            show_fix_block = false
        }
    })
};
/* ----------------------------- end fix-block.js -------------------------------- */

/* ------------------------------- test-js.js ---------------------------------- */
// descriptions are not available yet
/*$(function(){
    $( ".catalog-list" ).find( "a" ).tooltip();
});*/

$(function(){
    show_fix_block(".fix-zone", 10, 10);

    if ($(".item-price").length) {
        $(".item-price").clone().appendTo(".widget-prices");
        $(".btn-item-action").clone().appendTo(".widget-prices");
    }

    if (window.matchMedia("(max-width:640px)").matches) {
        $(".btn-item-action").eq(0).clone().appendTo("header");
    }

    $(".__search-dropdown-item").click(function(e){
        e.stopPropagation();
    });

    $("body").click(function(){
        $(".__quick-search").hide();
    });
});
/* ------------------------------- end test-js.js ---------------------------------- */

Conf.BUY_CLICK_HANDLER = function(elem) {
    if ($('header .btn-item-action').length > 0) {
        _gaq.push(['_trackEvent','Buy' , 'mobile']);
    } else if ($('.widget-popular').width() == 0) {
        _gaq.push(['_trackEvent','Buy' , 'tablet']);
    } else {
        _gaq.push(['_trackEvent','Buy' , 'desktop']);
    }
};
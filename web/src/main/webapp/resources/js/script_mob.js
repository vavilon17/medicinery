$(document).ready(function() {
    $('.content-hidetext h4').click(function(event) {
        $(this).toggleClass('active');
        $(this).next().slideToggle(300);
    });

    $('.header__search').click(function(event) {
        $(this).toggleClass('active');
        $('.header-searchblock').slideToggle(100);
        return false;
    });

    function forms(){
        $('input,textarea').focus(function(){
            if($(this).val() == $(this).attr('data-value')){
                $(this).addClass('focus');
                if($(this).attr('data-type')=='pass'){
                    $(this).attr('type','password');
                };
                $(this).val('');
            };
        });
        $('input[data-value], textarea[data-value]').each(function() {
            if (this.value == '' || this.value == $(this).attr('data-value')) {
                this.value = $(this).attr('data-value');
            }
            $(this).click(function() {
                if (this.value == $(this).attr('data-value')) {
                    if($(this).attr('data-type')=='pass'){
                        $(this).attr('type','password');
                    };
                    this.value = '';
                };
            });
            $(this).blur(function() {
                if (this.value == '') {
                    this.value = $(this).attr('data-value');
                    $(this).removeClass('focus');
                    if($(this).attr('data-type')=='pass'){
                        $(this).attr('type','text');
                    };
                };
            });
        });
    }
    forms();
});

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
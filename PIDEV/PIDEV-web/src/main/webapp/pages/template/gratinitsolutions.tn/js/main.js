// Hello.
//
// This is The Scripts used for ___________ Theme
//
//

function main() {

(function () {
   'use strict';

   /* ==============================================
  	Testimonial Slider
  	=============================================== */ 

  	$('a.page-scroll').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
          if (target.length) {
            $('html,body').animate({
              scrollTop: target.offset().top - 40
            }, 900);
            return false;
          }
        }
      });

    /*====================================
    Show Menu on Book
    ======================================*/
    $(window).bind('scroll', function() {
        var navHeight = $(window).height() - 440;
                
        if($(window).height() < 500)
            navHeight = 120;
        else if($(window).height() >= 500 && $(window).height() < 800)
            navHeight = 230;
        else if($(window).height() > 800 && $(window).height() < 1000)
            navHeight = 200;
        else if($(window).height() >= 1000 && $(window).height() < 1500)
            navHeight = 150;
        else if($(window).height() >= 1500 && $(window).height() < 2000)
            navHeight = 140;
        else if($(window).height() >= 2000)
            navHeight = 120;
        if(navHeight < 0)
            navHeight = 0;
        if ($(window).scrollTop() > navHeight) {
            $('.navbar-default').addClass('on');
        } else {
            $('.navbar-default').removeClass('on');
        }
    });
    
    $(window).load(function(){imagesLoaded("body",function(){$(".page-loader div").fadeOut(),$(".page-loader").delay(200).fadeOut("slow")})});

	$(window).load(function(){
		$(".flexslider").flexslider({
			animation:"fade",easing:"swing",controlNav:!1
		})
		imagesLoaded("body",function(){$(".lightbox-gallery").magnificPopup({delegate:"a",gallery:{enabled:!0},
		type:"image",zoom:{enabled:!0,duration:300,opener:function(e){return e.find("img")}}})})
	})

    $('body').scrollspy({ 
        target: '.navbar-default',
        offset: 80
    })	

  	$(document).ready(function() {
		$(".main-navigation a[href*=#]:not([href=#]), .onPageNav").click(function(){if(location.pathname.replace(/^\//,"")===this.pathname.replace(/^\//,"")&&location.hostname===this.hostname)
{var e=$(this.hash);if(e=e.length?e:$("[name="+this.hash.slice(1)+"]"),e.length)
return $(".navbar-collapse.collapse.in").removeClass("in"),$("html,body").animate({scrollTop:e.offset().top-55},1e3,
function(){}),!1}}),
$("#main-nav-collapse").on("activate.bs.scrollspy",function(){$(".navbar-nav > li[class='active'] > a").focus()}),
  	  $("#team").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 4],
				        [1200, 4],
				        [1400, 4],
				        [1600, 4]
				      ],
  	  });
          $("#equipe").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 4],
				        [1200, 4],
				        [1400, 4],
				        [1600, 4]
				      ],
  	  });

  	  $("#clients").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 4],
				        [1200, 5],
				        [1400, 5],
				        [1600, 5]
				      ],
  	  });

      $("#testimonial").owlCarousel({
        navigation : false, // Show next and prev buttons
        slideSpeed : 300,
        paginationSpeed : 400,
        singleItem:true
        });

  	});

  	/*====================================
    Portfolio Isotope Filter
    ======================================*/
    $(window).load(function() {
        var $container = $('#lightbox');
        $container.isotope({
            filter: '*',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.cat a').click(function() {
            $('.cat .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });

    });
    
    /*----------------------------------------------------*/
	/*	Animation Progress Bars
	/*----------------------------------------------------*/
	
	$("[data-progress-animation]").each(function() {
		
		var $this = $(this);
		
		$this.appear(function() {
			
			var delay = ($this.attr("data-appear-animation-delay") ? $this.attr("data-appear-animation-delay") : 1);
			
			if(delay > 1) $this.css("animation-delay", delay + "ms");
			
			setTimeout(function() { $this.animate({width: $this.attr("data-progress-animation")}, 800);}, delay);

		}, {accX: 0, accY: -50});

	});



}(),
function(){function e(e){var t=$("#header");if(t.length>0){var i=t.height(),s=$(document).scrollTop();
if(t.hasClass("home-parallax")&&$(e).scrollTop()<=i&&t.css("top",.55*s),t.hasClass("home-fade")&&$(e).scrollTop()<=i)
{var n=$(".intro"),o=$("#header .color-overlay");o.css("opacity",.3+s/t.height()*1),n.css("opacity",1-s/t.height()*1)}}}
$(window).scroll(function(t){t.preventDefault(),e(this)})}()),
$(window).scroll(function(){var e=$("#totop");$(this).scrollTop()>100?e.fadeIn():e.fadeOut()}),
$("a[href='#totop']").click(function(){return $("html, body").animate({scrollTop:0},"slow"),!1});


}
main();
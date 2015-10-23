$(document).ready(function(e) {
	var isHoverNav = false;
	var menuName = 'undefined';
	$(document).on('mouseenter','.navbar-default .navbar-custom>li',function(e) {
		e.stopPropagation();
		e.stopImmediatePropagation();
		if (!isHoverNav) {
			$('.sub-content').hide();
			menuName = $(this).data('menu-name');
			$('.sub-content[data-menu-name='+menuName+']').css('opacity',1).show();
			$('.sub').slideDown(270);
			isHoverNav = true;
		} else {
			if ($(this).data('menu-name')!==menuName) {
				var oldName = menuName;
				menuName = $(this).data('menu-name');

				$('.sub-content[data-menu-name='+oldName+']').animate({opacity:0},400,function(e){
					$(this).hide();
					$('.sub-content[data-menu-name='+menuName+']').show().animate({opacity:1},900);
				});
			}
		}
		$(this).find('a').addClass('open');
		e.stopPropagation();
	});
	$(document).on('mouseleave','.navbar-default .navbar-custom>li',function(e) {
		e.stopPropagation();
		e.stopImmediatePropagation();
		if (isHoverNav) {
			if (!$('.navbar-default .navbar-custom').is(':hover') && !$('.sub').is(':hover')) {
				$('.sub').slideUp(50);
				isHoverNav = false;
				$('.sub-content').css('opacity',0);

			}
			if (!$('.sub').is(':hover')) {
				$('.navbar-default .navbar-custom>li>a').removeClass('open');
			}
		} else {
			if (!$('.sub').is(':hover')) {
				$('.sub').slideUp(50);
				$('.navbar-default .navbar-custom>li>a').removeClass('open');
				isHoverNav = false;
				$('.sub-content').css('opacity',0);
			}
		}
	});
	$(document).on('mouseleave','.sub',function(e) {
		e.stopPropagation();
		e.stopImmediatePropagation();
		if (!$('.navbar-default .navbar-custom').is(':hover')) {
			$(this).slideUp(50);
			$('.navbar-default .navbar-custom>li>a').removeClass('open');
			isHoverNav = false;
			$('.sub-content').css('opacity',0);
		}
		$('.navbar-default .navbar-custom>li>a').removeClass('open');
	});
});
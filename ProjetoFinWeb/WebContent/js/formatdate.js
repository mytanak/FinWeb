jQuery.noConflict();
(function($) {
$(function() {
$('.mask-data').mask('99/99/9999'); //data
$('.mask-hora').mask('99:99'); //hora
$('.mask-number').decimalMask({
	  separator: ".",
	  decSize: 2,
	  intSize: 18
	});

});
})(jQuery);
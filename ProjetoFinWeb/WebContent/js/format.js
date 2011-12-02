$(function(){
	
	$('#example1').priceFormat();
	
	$('#mask-number').priceFormat({
		prefix: '',
		centsSeparator: ',',
		thousandsSeparator: '.'
	});
	
	$('#mask-number1').priceFormat({
		prefix: '',
		centsSeparator: ',',
		thousandsSeparator: '.'
	});

	$('#example3').priceFormat({
		prefix: '',
		thousandsSeparator: ''
	});
	
	$('#example4').priceFormat({
		limit: 5,
		centsLimit: 3
	});
	
	$('#example5').priceFormat({
		clearPrefix: true
	});
	
	$('#example6').priceFormat({
		allowNegative: true
	});

        $('.language').click(function(){
            var language = this.lang;

            $.get('index.php/changeLanguage', {language : language}, function(data){
                if(data > 0)
                    window.location = '/';
            });

        });

});

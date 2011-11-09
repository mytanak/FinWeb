$(function(){
	$('#numero').iMask({
				 type : 'number'
		, decDigits   : 2
		, decSymbol   : ','
		, groupSymbol : '.'
	});

	$('#inteiro').iMask({
		       type   : 'number'
		, decDigits   : 0
		, decSymbol   : ','
		, groupSymbol : '.'
	});
	
	
});
